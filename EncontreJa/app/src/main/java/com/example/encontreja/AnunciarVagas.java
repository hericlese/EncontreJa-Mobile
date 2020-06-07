package com.example.encontreja;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AnunciarVagas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    EditText editCargoVaga,editEmpresaVaga,editCompetencia1Vaga;
    CheckBox comp1N1Vaga,comp1N2Vaga,comp1N3Vaga;
    LinearLayout btnRegistrar;
    String competencianivel1;


    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_vagas);
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação

        editCargoVaga = findViewById(R.id.editTextCargoVaga);
        editEmpresaVaga = findViewById(R.id.editTextEmpresaVaga);
        editCompetencia1Vaga = findViewById(R.id.editTextCompetencia1Vaga);
        btnRegistrar = findViewById(R.id.btnRegistrarVaga);





        comp1N1Vaga =(CheckBox) findViewById(R.id.comp1N1Vaga);
        comp1N2Vaga =(CheckBox) findViewById(R.id.comp1N2Vaga);
        comp1N3Vaga =(CheckBox) findViewById(R.id.comp1N3Vaga);


        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Event de click em checkbox Competencia1 Nivel1

        comp1N1Vaga.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                comp1N2Vaga.setChecked(false);
                comp1N3Vaga.setChecked(false);
                competencianivel1 = "1";
            }
        });

//        checkCompetencia1nivel2vaga.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                checkCompetencia1nivel1vaga.setChecked(false);
//                checkCompetencia1nivel3vaga.setChecked(false);
//                competencianivel1 = "2";
//            }
//        });
//        checkCompetencia1nivel3vaga.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                checkCompetencia1nivel1vaga.setChecked(false);
//                checkCompetencia1nivel2vaga.setChecked(false);
//                competencianivel1 = "3";
//            }
//        });






        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String vaga = editCargoVaga.getText().toString();
               String competencia = editCompetencia1Vaga.getText().toString();
               String empresa = editEmpresaVaga.getText().toString();

                Log.d("LOG","Teste get activies:" +vaga+ " - " +competencia+ " - "+empresa+ " - "+ competencianivel1);
                Log.d("LOG","Teste get activies:" + competencianivel1);

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    // opções do menu






}
