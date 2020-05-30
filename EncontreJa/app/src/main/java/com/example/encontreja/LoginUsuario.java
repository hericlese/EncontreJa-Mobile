package com.example.encontreja;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.encontreja.Controler.ConversorJson;
import com.example.encontreja.Controler.NodeJS;
import com.example.encontreja.Controler.RetrofitClient;
import com.example.encontreja.Controler.Usuario;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit;

public class LoginUsuario extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    LinearLayout btnLogar;
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
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação


        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


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



        //Lista para armazenar dados de resposta Json do usuario ao logar
        ArrayList<Usuario> usuarios = new ArrayList<>();



        ConversorJson string = new ConversorJson("resustado");
        string.getResultado();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(string.getResultado(), Usuario.class);



    }

    private void logarUsuario(String email, String password) {


        compositeDisposable.add(myAPI.logarUsuario(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                        String resultado = s;//atribuindo resultado Json do POST para vareavel resultado

                        ConversorJson string = new ConversorJson(resultado);// invocando metodo de conversão, para converter resultado que esta string em json
                        string.setResultado(resultado);//enviando para o metodo de conversão

                        if (s.contains("encrypted_password"))

                            Toast.makeText(LoginUsuario.this, "Acesso Permitido ", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(LoginUsuario.this, "" + s, Toast.LENGTH_SHORT).show(); // caso de erro retorna erro da API
                    }
                })

        );
    }












        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }// opções do menu

}
