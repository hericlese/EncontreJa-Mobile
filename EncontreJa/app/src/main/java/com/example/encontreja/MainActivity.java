package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.encontreja.Controler.NodeJS;
import com.google.android.material.navigation.NavigationView;

public class MainActivityEmpresa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NodeJS myAPI;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    LinearLayout  btnProcurarP, btnProcurarV,btnAnunciarC, btnAnunciarV, btnLogar;


    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_empresa);
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação

        btnProcurarP = findViewById(R.id.card_anunciosMain); //Botão ProcurarProfissional
        btnProcurarV = findViewById(R.id.card_vagasMain); //Botão ProcurarVagas
        btnAnunciarC = findViewById(R.id.card_AnunciarCurriculoMain); //Botão ProcurarVagas
        btnAnunciarV = findViewById(R.id.card_AnunciarVagaMain); //Botão AnunciarVagas
        btnLogar = findViewById(R.id.btnLogin); //Botão login home



        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        btnProcurarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Procurar Profissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itProcurarProfissional = new Intent(
                        MainActivityEmpresa.this,
                        AnunciosProfissionais.class
                );
                // chamar a outra Activity
                startActivity(itProcurarProfissional);
            }
        });


        btnProcurarV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Procurar Vaga
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itProcurarVagas = new Intent(
                        MainActivityEmpresa.this,
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
                        MainActivityEmpresa.this,
                        AnunciarCurriculo.class
                );
                // chamar a outra Activity
                startActivity(itAnunciarCurriculo);
            }
        });


        btnAnunciarV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Anunciar Vaga
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itAnunciarVaga = new Intent(
                        MainActivityEmpresa.this,
                        AnunciarVagas.class
                );
                // chamar a outra Activity
                startActivity(itAnunciarVaga);
            }
        });


        btnLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn Login
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itLogar = new Intent(
                        MainActivityEmpresa.this,
                        LoginUsuario.class
                );
                // chamar a outra Activity
                startActivity(itLogar);
            }
        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }// opções do menu









}
