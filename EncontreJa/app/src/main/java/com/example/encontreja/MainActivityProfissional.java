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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.encontreja.Controler.NodeJS;
import com.google.android.material.navigation.NavigationView;

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
                        ProcurarVagas.class
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


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        SharedPreferences preferencesUsuario2 = getSharedPreferences(
                "usuarioSharedPreferences",MODE_PRIVATE);
        String empresa = preferencesUsuario2.getString("empresa","");
        //retornando informação se 1 = empresa se 0 = profissional

        switch(menuItem.getItemId()) {
            case R.id.menu_perfil: //// pendente

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

                Intent itAnunciarVaga = new Intent(
                        MainActivityProfissional.this,
                        LoginUsuario.class
                );
                onDestroy();
                // chamar a outra Activity
                startActivity(itAnunciarVaga);

                break;

            case R.id.menu_procurarvagas:

                if(empresa.equals("1")){
                    Toast.makeText(MainActivityProfissional.this, "Está opção pode ser utilizado somente por cadastro de profissionais", Toast.LENGTH_SHORT).show();

                } else {
                    Intent procuravagas = new Intent(
                            MainActivityProfissional.this,
                            ProcurarVagas.class);
                    startActivity(procuravagas);
                }


                break;

            case R.id.menu_adicionarcurriculo: //Completo

                 if(empresa.equals("1")){
                     Toast.makeText(MainActivityProfissional.this, "Está opção pode ser utilizado somente por cadastro de profissionais", Toast.LENGTH_SHORT).show();

                 } else {
                     Intent adccurriculo = new Intent(
                             MainActivityProfissional.this,
                             AnunciarCurriculo.class);
                     startActivity(adccurriculo);
                 }

                break;
            case R.id.menu_procurarprofissional: //pendente
                Log.d("TESTE", "TESTE EMPRESA :"+empresa);
                if(empresa.equals("0")){
                    Toast.makeText(MainActivityProfissional.this, "Está opção pode ser utilizado somente por cadastro de empresas", Toast.LENGTH_SHORT).show();

                } else {
                    Intent procurarprofi = new Intent(
                            MainActivityProfissional.this,
                            AnunciosProfissionais.class);
                    startActivity(procurarprofi);
                }

                break;

            case R.id.menu_adicionarvagas: //Completo

                if(empresa.equals("0")){
                    Toast.makeText(MainActivityProfissional.this, "Está opção pode ser utilizado somente por cadastro de empresas", Toast.LENGTH_SHORT).show();

                } else {
                    Intent adccurriculo = new Intent(
                            MainActivityProfissional.this,
                            AnunciarVagas.class);
                    startActivity(adccurriculo);
                }


                break;

            case R.id.menu_sobre: // pendente


                break;

            case R.id.menu_sair: //ok

                onDestroy();
                finishAffinity();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
        return true;
            }

        }



