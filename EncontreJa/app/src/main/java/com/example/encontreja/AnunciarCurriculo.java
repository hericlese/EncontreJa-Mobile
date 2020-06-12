package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AnunciarCurriculo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    EditText editname, editobjetivo,editformacao,editTextexperiencia1,editTextexperiencia2,editTextexperiencia3,editTextcursos,
            editTextlinks,editTextcompetenciaextra, editTextcompetencia1,editTextcompetencia2,editTextcompetencia3;

    CheckBox checkBoxComp1N1Curriculo,checkBoxComp1N2Curriculo,checkBoxComp1N3Curriculo,checkBoxComp2N1Curriculo,
            checkBoxComp2N2Curriculo,checkBoxComp2N3Curriculo,checkBoxComp3N1Curriculo,checkBoxComp3N2Curriculo,
            checkBoxComp3N3Curriculo;

    String competencia1result , competencia2result, competencia3result;
    LinearLayout registrarCurriculo;
    NodeJS myAPI;

    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_curriculo);
        drawerLayout= findViewById(R.id.drawer); //pagina toolbar escondida
        toolbar = findViewById(R.id.toolbar);  // toolbar
        navigationView = findViewById(R.id.navigationView); //barra de navegação
            //checkbox competencias
        checkBoxComp1N1Curriculo = findViewById(R.id.checkBoxComp1N1Curriculo);
        checkBoxComp1N2Curriculo = findViewById(R.id.checkBoxComp1N2Curriculo);
        checkBoxComp1N3Curriculo = findViewById(R.id.checkBoxComp1N3Curriculo);

        checkBoxComp2N1Curriculo = findViewById(R.id.checkBoxComp2N1Curriculo);
        checkBoxComp2N2Curriculo = findViewById(R.id.checkBoxComp2N2Curriculo);
        checkBoxComp2N3Curriculo = findViewById(R.id.checkBoxComp2N3Curriculo);

        checkBoxComp3N1Curriculo = findViewById(R.id.checkBoxComp3N1Curriculo);
        checkBoxComp3N2Curriculo = findViewById(R.id.checkBoxComp3N2Curriculo);
        checkBoxComp3N3Curriculo = findViewById(R.id.checkBoxComp3N3Curriculo);

        editname = findViewById(R.id.editTextNomeCurriculo);
        editobjetivo = findViewById(R.id.editTextObjetivoCurriculo);
        editformacao = findViewById(R.id.editTextFormacaoCurriculo);
        editTextexperiencia1 = findViewById(R.id.editTextExperiencias1Curriculo);
        editTextexperiencia2 = findViewById(R.id.editTextExperiencias2Curriculo);
        editTextexperiencia3 = findViewById(R.id.editTextExperiencias3Curriculo);
        editTextcursos = findViewById(R.id.editTextCursosCurriculo);
        editTextlinks = findViewById(R.id.editTextLinksCurriculo);
        editTextcompetenciaextra = findViewById(R.id.editTextCompetenciaExtCurriculo);
        editTextcompetencia1 = findViewById(R.id.editTextCompetencia1Curriculo);
        editTextcompetencia2 = findViewById(R.id.editTextCompetencia2Curriculo);
        editTextcompetencia3 = findViewById(R.id.editTextCompetencia3Curriculo);


        registrarCurriculo = findViewById(R.id.btnRegistrarCurriculo);

        setSupportActionBar(toolbar); // declarando ação da barra de navegação
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Event de click em checkbox Competencia1
        checkBoxComp1N1Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp1N2Curriculo.setChecked(false);
                checkBoxComp1N3Curriculo.setChecked(false);
                competencia1result = "1";
            }
        });
        checkBoxComp1N2Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp1N1Curriculo.setChecked(false);
                checkBoxComp1N3Curriculo.setChecked(false);
                competencia1result = "2";
            }
        });
        checkBoxComp1N3Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp1N1Curriculo.setChecked(false);
                checkBoxComp1N2Curriculo.setChecked(false);
                competencia1result = "3";
            }
        });

        //Event de click em checkbox Competencia2
        checkBoxComp2N1Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp2N2Curriculo.setChecked(false);
                checkBoxComp2N3Curriculo.setChecked(false);
                competencia2result = "1";
            }
        });
        checkBoxComp2N2Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp2N1Curriculo.setChecked(false);
                checkBoxComp2N3Curriculo.setChecked(false);
                competencia2result = "2";
            }
        });
        checkBoxComp2N3Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp2N1Curriculo.setChecked(false);
                checkBoxComp2N2Curriculo.setChecked(false);
                competencia2result = "3";
            }
        });

        //Event de click em checkbox Competencia3
        checkBoxComp3N1Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp3N2Curriculo.setChecked(false);
                checkBoxComp3N3Curriculo.setChecked(false);
                competencia3result = "1";
            }
        });
        checkBoxComp3N2Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp3N1Curriculo.setChecked(false);
                checkBoxComp3N3Curriculo.setChecked(false);
                competencia3result = "2";
            }
        });
        checkBoxComp3N3Curriculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxComp3N1Curriculo.setChecked(false);
                checkBoxComp3N2Curriculo.setChecked(false);
                competencia3result = "3";
            }
        });


        registrarCurriculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Coletando Id do usuario no SharedPreferences
                SharedPreferences preferencesUsuario = getSharedPreferences(
                        "UsuarioSharedPreferences",
                        Context.MODE_PRIVATE);
                String id_usuario = preferencesUsuario.getString("id","");

                   cadastrarCurriculo(editname.getText().toString(),editobjetivo.getText().toString(),editformacao.getText().toString(),
                           editTextexperiencia1.getText().toString(),editTextexperiencia2.getText().toString(),
                           editTextexperiencia3.getText().toString(),editTextcursos.getText().toString(),editTextlinks.getText().toString(),
                           editTextcompetenciaextra.getText().toString(),id_usuario.toString(),editTextcompetencia1.getText().toString(),competencia1result.toString(),
                           editTextcompetencia2.getText().toString(),competencia2result.toString(),
                           editTextcompetencia3.getText().toString(),competencia3result.toString());
            }
        });

            //iniciando API
        Retrofit retrofit = new RetrofitClient().getInstance();
        myAPI = retrofit.create(NodeJS.class);
        
    }

    //atribuindo informação ao metodo cadastrarCurriculo para API
    private void cadastrarCurriculo(String name, String objetivo, String formacao, String experiencia1 , String experiencia2,
                                    String experiencia3, String cursos, String links, String competenciaextra, String id_usuario,
            String competencia1, String nivel1, String competencia2, String nivel2, String competencia3, String nivel3) {

        compositeDisposable.add(myAPI.cadastrarCurriculo( name,objetivo,formacao,experiencia1,experiencia2,experiencia3,
                cursos,links,competenciaextra,id_usuario,competencia1,nivel1,competencia2,nivel2,competencia3,nivel3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(AnunciarCurriculo.this, "" + s, Toast.LENGTH_SHORT).show();
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
