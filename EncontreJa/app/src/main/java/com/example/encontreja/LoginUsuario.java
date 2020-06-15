package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.encontreja.Controler.NodeJS;
import com.example.encontreja.Controler.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class LoginUsuario extends AppCompatActivity{

    LinearLayout btnRegistrarE, btnRegistrarP,btnLogar;
    EditText edit_email_login,edit_password_login;
    NodeJS myAPI;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }


    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);

        //associação itens view
        btnLogar = (LinearLayout)findViewById(R.id.btnEntrar);
        edit_email_login = (EditText) findViewById((R.id.editTextEmailLogin));
        edit_password_login = (EditText)findViewById((R.id.editTextSenhaEntrar));
        btnRegistrarE = findViewById(R.id.card_registrarE); //Botão RegistrarEmpresa
        btnRegistrarP = findViewById(R.id.card_registrarP); //Botão RegistrarProfissional

        //Login automatico SharedPreferences
        //Recuperando instancia
        SharedPreferences preferencesUsuario = getSharedPreferences(
                "UsuarioSharedPreferences",
                Context.MODE_PRIVATE);
        //coletando valores
        final String password = preferencesUsuario.getString("id","");
        String email = preferencesUsuario.getString("email","");

        if(email != null){
            edit_email_login.setText(email);
            //Event de click
            Log.d("LOG", "Teste2:" + email +"-" +password);
        }

        //Botoes para novas activies
        btnRegistrarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Registrar Profissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itCadastroProfissional = new Intent(
                        LoginUsuario.this,
                        CadastrarProfissional.class
                );
                // chamar a outra Activity
                startActivity(itCadastroProfissional);
            }
        });
        btnRegistrarE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Registrar Empresa
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itCadastroEmpresa = new Intent(
                        LoginUsuario.this,
                        CadastrarEmpresa.class
                );
                // chamar a outra Activity
                startActivity(itCadastroEmpresa);
            }
        });


        //Event de click
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logarUsuario(edit_email_login.getText().toString(),edit_password_login.getText().toString());

            }
        });


        //iniciando API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(NodeJS.class);

    }

    private void  logarUsuario(final String email, String password) {
        compositeDisposable.add(myAPI.logarUsuario(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                        if (s.contains("encrypted_password")) {
                            try {
                                //chamando a função para manipulação de Json e atribuindo a vareavel que recebera o tratamento
                                JSONObject jsonLogin = new JSONObject(s);

                                String id = jsonLogin.getString("id");
                                String name = jsonLogin.getString("name");
                                String email = jsonLogin.getString("email");
                                String email_contato = jsonLogin.getString("email_contato");
                                String empresa = jsonLogin.getString("empresa");
                                String login = "1";

                                // verificando se no objeto json tem a vareavel ID se sim coletando as informações do login e atibuindo a class Usuario
                                if (jsonLogin.has("encrypted_password")) {

                                    //Recuperando instancia
                                    SharedPreferences preferencesUsuario = getSharedPreferences(
                                            "UsuarioSharedPreferences",
                                            Context.MODE_PRIVATE);

                                    //Gravando na instancia
                                    SharedPreferences.Editor UsuarioShared = preferencesUsuario.edit();


                                    //Setando valor na instancia
                                    UsuarioShared.putString("id", id);
                                    UsuarioShared.putString("name", name);
                                    UsuarioShared.putString("email", email);
                                    UsuarioShared.putString("email_contato", email_contato);
                                    UsuarioShared.putString("empresa", empresa);
                                    UsuarioShared.putString("login", login);
                                    // commit valores
                                    UsuarioShared.commit();

                                if(empresa.equals("1")) {

                                 Log.d("LOG", "Teste ID: Empresa Logando");
//                                    // passar os dados para outra View (activity_resultado.xml)
//                                    // Intent(classe origem, classe destino.class)

                                    Intent itEmpresa = new Intent(
                                            LoginUsuario.this,
                                            MainActivityEmpresa.class
                                    );
                                    // chamar a outra Activity
                                    startActivity(itEmpresa);
//
                                }
                                else
                                {
                                    Log.d("LOG", "Teste ID: Usuario Logando");
                                    Intent itUsuario = new Intent(
                                            LoginUsuario.this,
                                            MainActivityProfissional.class
                                    );

                                    startActivity(itUsuario);
                                }

//                                    Testando parcialmete o que foi coletado
                                Log.d("LOG", "Teste ID: " +id);
                                Log.d("LOG", "Teste NOME: " +name);
                                Log.d("LOG", "Teste EMAIL: " +email);
                                Log.d("LOG", "Teste EMAIL CONTATO: " +email_contato);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        if (s.contains("encrypted_password"))

                            Toast.makeText(LoginUsuario.this, "Seja bem vindo !", Toast.LENGTH_SHORT).show();

                        else
                            Toast.makeText(LoginUsuario.this, "" + s, Toast.LENGTH_SHORT).show(); // caso de erro retorna erro da API

                    }
                })
        );
    }
}
