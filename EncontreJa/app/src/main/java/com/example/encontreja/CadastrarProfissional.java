package com.example.encontreja;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.encontreja.Controler.NodeJS;
import com.example.encontreja.Controler.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class CadastrarProfissional extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    LinearLayout btnRegistrar;
    EditText edit_email,edit_password,edit_name,edit_emailProfissionalContato,edit_nascimento,edit_celular,edit_cep;
    CheckBox check_sexoh, check_sexom;
    NodeJS myAPI;
    String check_result;


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
        setContentView(R.layout.activity_cadastrar_profissionais);

        //iniciando API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(NodeJS.class);

        //associação itens view

        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação

        btnRegistrar = (LinearLayout)findViewById(R.id.btnRegistrarUsuario);
        edit_email = (EditText) findViewById(R.id.editTextEmailProfissional);
        edit_password = (EditText)findViewById(R.id.editTextSenha1);
        edit_name = (EditText)findViewById(R.id.editTextNomeProfissional);
        edit_emailProfissionalContato = (EditText)findViewById(R.id.editTextEmailProfissionalContato);
        edit_nascimento = (EditText)findViewById(R.id.editTextNascimento);
        edit_celular = (EditText)findViewById(R.id.editTextCelular);
        edit_cep = (EditText)findViewById(R.id.editTextCep);
        check_sexoh = (CheckBox)findViewById(R.id.checkBoxHomem);
        check_sexom = (CheckBox)findViewById(R.id.checkBoxMulher);



        //Event de click em checkbox
        check_sexoh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check_sexom.setChecked(false);
                check_result = "1";
            }
        });
        check_sexom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check_sexoh.setChecked(false);
                check_result = "1";

            }
        });


        //Event de click em registrar
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String empresa = "2";// cadastro = 2 = a  anunciante no banco 1 = empresa
                registrarUsuario(edit_email.getText().toString(),edit_password.getText().toString(),edit_name.getText().toString(),edit_emailProfissionalContato.getText().toString(),empresa.toString(),edit_nascimento.getText().toString(),edit_celular.getText().toString(),edit_cep.getText().toString(),check_result.toString());
            }
        });


        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void registrarUsuario(String email, String password,String name,String email_contato,String empresa,String data,String telefone,String cep,String sexo) {

        compositeDisposable.add((Disposable) myAPI.registrarUsuario(email,name,password,email_contato,empresa,data,telefone,cep,sexo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Toast.makeText(CadastrarProfissional.this, ""+s, Toast.LENGTH_SHORT).show();
                }
            })
        );

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }// opções do menu


}