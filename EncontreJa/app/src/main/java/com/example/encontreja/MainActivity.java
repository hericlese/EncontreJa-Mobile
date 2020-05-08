package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    LinearLayout btnRegistrarE, btnRegistrarP, btnProcurarP, btnProcurarV,btnAnunciarC;

    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação
        btnRegistrarE = findViewById(R.id.card_registrarE); //Botão RegistrarEmpresa
        btnRegistrarP = findViewById(R.id.card_registrarP); //Botão RegistrarProfissional
        btnProcurarP = findViewById(R.id.card_anunciosMain); //Botão ProcurarProfissional
        btnProcurarV = findViewById(R.id.card_vagasMain); //Botão ProcurarVagas
        btnAnunciarC = findViewById(R.id.card_AnunciarCurriculoMain); //Botão ProcurarVagas



        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

            //Botoes para novas activies

        btnRegistrarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn RegistrarProfissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itCadastroProfissional = new Intent(
                        MainActivity.this,
                        CadastrarProfissional.class
                );
                // chamar a outra Activity
                startActivity(itCadastroProfissional);
            }
        });

        btnRegistrarE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn RegistrarEmpresa
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itCadastroEmpresa = new Intent(
                        MainActivity.this,
                        CadastrarEmpresa.class
                );
                // chamar a outra Activity
                startActivity(itCadastroEmpresa);
            }
        });

        btnProcurarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn RegistrarProfissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itProcurarProfissional = new Intent(
                        MainActivity.this,
                        AnunciosProfissionais.class
                );
                // chamar a outra Activity
                startActivity(itProcurarProfissional);
            }
        });


        btnProcurarV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn RegistrarProfissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itProcurarVagas = new Intent(
                        MainActivity.this,
                        AnunciosVagas.class
                );
                // chamar a outra Activity
                startActivity(itProcurarVagas);
            }
        });


        btnAnunciarC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //Btn RegistrarProfissional
                // passar os dados para outra View (activity_resultado.xml)
                // Intent(classe origem, classe destino.class)
                Intent itAnunciarCurriculo = new Intent(
                        MainActivity.this,
                        AnunciarCurriculo.class
                );
                // chamar a outra Activity
                startActivity(itAnunciarCurriculo);
            }
        });




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    // opções do menu






}