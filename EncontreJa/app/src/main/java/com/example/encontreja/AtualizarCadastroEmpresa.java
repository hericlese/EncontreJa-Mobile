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

import com.example.encontreja.Controler.NodeJS;
import com.example.encontreja.Controler.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AtualizarCadastroEmpresa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    EditText edit_name,edit_email,edit_responsavel,edit_password,edit_emailcontato,edit_description;
    LinearLayout btnRegistrar_empresa;
    NodeJS myAPI;
    String empresa;

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
        setContentView(R.layout.activity_atualizar_cadastro_empresa);
        drawerLayout = findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação

        //iten view cadastrar
        edit_name = findViewById(R.id.editTextNomeEmpresa);
        edit_email = findViewById(R.id.editTextEmailEmpresa);
        edit_responsavel = findViewById(R.id.editTextResponsavel);
        edit_password = findViewById(R.id.editTextSenhaEmpresa);
        edit_emailcontato = findViewById(R.id.editTextEmailEmpresaContato);
        edit_description = findViewById(R.id.editTextDescricao);
        btnRegistrar_empresa = findViewById(R.id.btnRegistrarProfissional);



        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //iniciando API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(NodeJS.class);

        //Event de click em registrar
        btnRegistrar_empresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrarEmpresa(edit_name.getText().toString(),edit_email.getText().toString(), edit_password.getText().toString(),
                        empresa , edit_responsavel.getText().toString() , edit_description.getText().toString(),
                        edit_emailcontato.getText().toString());
                empresa = "1"; // cadastro "0" = a anunciante e "1" = empresa no banco
         }
        });


    }
        private void registrarEmpresa(String name,String email,String password,String empresa, String responsavel, String description,
                                      String email_contato){
            compositeDisposable.add((Disposable) myAPI.registrarEmpresa(name,email,password,empresa,responsavel,description,email_contato)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            Toast.makeText(AtualizarCadastroEmpresa.this, ""+s, Toast.LENGTH_SHORT).show();

                        }
                    })
            );


        }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    // opções do menu

}