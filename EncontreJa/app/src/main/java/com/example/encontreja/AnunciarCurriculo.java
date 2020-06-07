package com.example.encontreja;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.encontreja.Controler.Usuario;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AnunciarCurriculo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("dados");


    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_curriculo);
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



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    // opções do menu






}
