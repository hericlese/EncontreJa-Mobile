package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.encontreja.Controler.NodeJS;
import com.example.encontreja.Controler.Usuario;
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivityProfissional extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NodeJS myAPI;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    LinearLayout  btnProcurarV,btnAnunciarC;


    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profissional);
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação
        btnProcurarV = findViewById(R.id.card_vagasMain); //Botão ProcurarVagas
        btnAnunciarC = findViewById(R.id.card_AnunciarCurriculoMain); //Botão ProcurarVagas

        btnProcurarV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Procurar Vaga
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itProcurarVagas = new Intent(
                        MainActivityProfissional.this,
                        AnunciosVagas.class
                );
                // chamar a outra Activity
                startActivity(itProcurarVagas);
            }
        });


        btnAnunciarC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Anunciar Curriculo
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itAnunciarCurriculo = new Intent(
                        MainActivityProfissional.this,
                        AnunciarCurriculo.class
                );
                // chamar a outra Activity
                startActivity(itAnunciarCurriculo);
            }
        });



        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

  ;

                //Coletando valores Intent
                ArrayList<Usuario> usuarios = (ArrayList<Usuario>)
                getIntent().getSerializableExtra("listaUsuario");
        String list = new String(); //Variael string vazia que ira percorrer o list Intent.
        String login = new String();
        String id = new String();
        String empresa = new String();
        String name = new String();
        String email_contato = new String();
        String email = new String();

        //loop foreach
       for (Usuario usuario : usuarios){
            list = list + 1;
                    if(list != null ){
                     usuario.getLogin();
                        login = usuario.getLogin();

                     usuario.getId();
                        id = usuario.getId();

                     usuario.getEmpresa();
                        empresa = usuario.getEmpresa();

                     usuario.getName();
                         name = usuario.getName();

                     usuario.getEmail_contato();
                        email_contato= usuario.getEmail_contato();

                     usuario.getEmail();
                        email= usuario.getEmail();
                    }
        }
        Log.d("LOG", "Teste intent GET2: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)
                getIntent().getSerializableExtra("listaUsuario");
        String list = new String(); //Variael string vazia que ira percorrer o list Intent.
        String login = new String();
        String id = new String();
        String empresa = new String();
        String name = new String();
        String email_contato = new String();
        String email = new String();

        //loop foreach
        for (Usuario usuario : usuarios){
            list = list + 1;
            if(list != null ){
                usuario.getLogin();
                login = usuario.getLogin();

                usuario.getId();
                id = usuario.getId();

                usuario.getEmpresa();
                empresa = usuario.getEmpresa();

                usuario.getName();
                name = usuario.getName();

                usuario.getEmail_contato();
                email_contato= usuario.getEmail_contato();

                usuario.getEmail();
                email= usuario.getEmail();
            }
        }

        usuarios.add(
                new Usuario(
                        id.toString(),
                        name.toString(),
                        email.toString(),
                        email_contato.toString(),
                        empresa.toString(),
                        login.toString()
                )
        );

        switch(menuItem.getItemId()) {

            case R.id.menu_perfil: //// pendente
                Intent intentperfil = new Intent(MainActivityProfissional.this, LoginUsuario.class);
                intentperfil.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentperfil);
                break;

            case R.id.menu_logout: //Ok
                //Recuperando instancia
                SharedPreferences preferencesUsuario = getSharedPreferences(
                        "UsuarioSharedPreferences",
                        Context.MODE_PRIVATE);

                //Gravando na instancia
                SharedPreferences.Editor UsuarioShared = preferencesUsuario.edit();
                UsuarioShared.clear();
                UsuarioShared.commit();
                break;

            case R.id.menu_procurarvagas: //Pendente
                Intent intentprocurarvagas = new Intent(MainActivityProfissional.this, LoginUsuario.class);
                intentprocurarvagas.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentprocurarvagas);
                break;

            case R.id.menu_adicionarcurriculo:
                Intent intentadicionarcurriculo = new Intent(MainActivityProfissional.this, AnunciarCurriculo.class);
                intentadicionarcurriculo.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentadicionarcurriculo);
                break;
            case R.id.menu_procurarprofissional: //pendente
                Intent intentprocurarprofissional = new Intent(MainActivityProfissional.this, LoginUsuario.class);
                intentprocurarprofissional.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentprocurarprofissional);
                break;

            case R.id.menu_adicionarvagas:
                Intent intentadicionarvagas = new Intent(MainActivityProfissional.this, AnunciarVagas.class);
                intentadicionarvagas.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentadicionarvagas);
                break;

            case R.id.menu_sobre: // pendente
                Intent intentsobre = new Intent(MainActivityProfissional.this, LoginUsuario.class);
                intentsobre.putExtra("listaUsuario",usuarios);
                Log.d("LOG", "Teste intent Menu: " + id+ "-" +name+ "-" +email+ "-" +email_contato+ "-" +empresa+ "-" +login);
                this.startActivity(intentsobre);
                break;

            case R.id.menu_sair: //ok
                Intent intentsair = new Intent(MainActivityProfissional.this, LoginUsuario.class);
                intentsair.putExtra("listaUsuario","");
                onDestroy();
                finishAffinity();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
        return true;
            }

        }



