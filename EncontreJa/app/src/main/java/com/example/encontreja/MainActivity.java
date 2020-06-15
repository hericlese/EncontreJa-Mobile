package com.example.encontreja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    String aEmpresa[] = { "UNINOVE","UNIVERSIDADE 9 JULHO","UNINOVE LCTS"};
    String aVagas[] = {"2 Vagas","3 Vagas","5 Vagas"};
    String aContrato[] = {"CTL","PJ","Temporário"};
    String aCargo[] = {"Analista","Tecnico","ESpecialista"};
    String aCompetencia1[]= {"Excel","PowerPoint","Word"};
    String aCompetencia2[]= {"Excel","PowerPoint","Word"};
    String aCompetencia3[]= {"Excel","PowerPoint","Word"};
    String aCompetencia1nivel[]= {"Avançado","basico","intermediario"};
    String aCompetencia2nivel[]= {"Avançado","basico","intermediario"};
    String aCompetencia3nivel[]= {"Avançado","basico","intermediario"};


    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @SuppressLint({"RestrictedApi", "WrongViewCast"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_vagas);


        VagaAdapter adapter = new VagaAdapter( this, aEmpresa,aVagas,aContrato,aCargo,
                aCompetencia1,aCompetencia1nivel,aCompetencia2,aCompetencia2nivel,aCompetencia3,aCompetencia3nivel);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  1) {
                    Toast.makeText(MainActivity.this, "Primeiro", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(MainActivity.this, "Segundo", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }//Fim Budle

    class VagaAdapter extends ArrayAdapter<String>{
                Context context;
                String vEmpresa[] ;
                String vVagas[] ;
                String vContrato[];
                String vCargo[] ;
                String vCompetencia1[];
                String vCompetencia2[];
                String vCompetencia3[];
                String vCompetencia1nivel[];
                String vCompetencia2nivel[];
                String vCompetencia3nivel[];

            VagaAdapter(Context c, String empresa[], String vagas[], String contrato[],String cargo[], String competencia1[],
                        String competencia1nivel[], String competencia2[], String competencia2nivel[],
                        String competencia3[], String competencia3nivel[]){

            super(c,R.layout.layout_anunciosvagas,R.id.cargoanuncio,cargo);
            this.context = c;

            this.vCargo = cargo;
            this.vEmpresa = empresa;
            this.vVagas = vagas;
            this.vContrato = contrato;
            this.vCompetencia1 = competencia1;
            this.vCompetencia1nivel = competencia1nivel;
            this.vCompetencia2 = competencia2;
            this.vCompetencia2nivel = competencia2nivel;
            this.vCompetencia3 = competencia3;
            this.vCompetencia3nivel = competencia3nivel;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View vagas = layoutInflater.inflate(R.layout.layout_anunciosvagas,parent,false);

            TextView aEmpresa = vagas.findViewById(R.id.empresanomevagaanuncio);
            TextView aVagas = vagas.findViewById(R.id.numerovagaanuncio);
            TextView aContrato = vagas.findViewById(R.id.contratovaga);
            TextView aCargo = vagas.findViewById(R.id.cargoanuncio);
            TextView aCompetencia1 = vagas.findViewById(R.id.competencia1anuncio);
            TextView aCompetencia1nivel = vagas.findViewById(R.id.competencia1nivel);
            TextView aCompetencia2 = vagas.findViewById(R.id.competencia2anuncio);
            TextView aCompetencia2nivel = vagas.findViewById(R.id.competencia2nivel);
            TextView aCompetencia3 = vagas.findViewById(R.id.competencia3anuncio);
            TextView aCompetencia3nivel = vagas.findViewById(R.id.competencia3nivel);


            //atribuindo novos recursos da view
            aEmpresa.setText(vEmpresa[position]);
            aVagas.setText(vVagas[position]);
            aContrato.setText(vContrato[position]);
            aCargo.setText(vCargo[position]);
            aCompetencia1.setText(vCompetencia1[position]);
            aCompetencia1nivel.setText(vCompetencia1nivel[position]);
            aCompetencia2.setText(vCompetencia2[position]);
            aCompetencia2nivel.setText(vCompetencia2nivel[position]);
            aCompetencia3.setText(vCompetencia3[position]);
            aCompetencia3nivel.setText(vCompetencia3nivel[position]);

            return vagas;
        }
    }

}