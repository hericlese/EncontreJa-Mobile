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
    String aCargo[] = {"Analista", "Auxiliar"};
    String aCompetencia[]= {"Ingles","Excel","AutoCard"};

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

        VagaAdapter adapter = new VagaAdapter( this, aCargo,aCompetencia);
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
            String vCargo[];
            String vCompetencia[];

            VagaAdapter(Context c, String cargo[], String competencia[]){
            super(c,R.layout.layout_anunciosvagas,R.id.cargoanuncio,cargo);
            this.context = c;
            this.vCargo = cargo;
            this.vCompetencia = competencia;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View vagas = layoutInflater.inflate(R.layout.layout_anunciosvagas,parent,false);
            TextView aCargo = vagas.findViewById(R.id.cargoanuncio);
            TextView aCompetencia = vagas.findViewById(R.id.competencia1anuncio);

            //atribuindo novos recursos da view
            aCargo.setText(vCargo[position]);
            aCompetencia.setText(vCompetencia[position]);

            return vagas;
        }
    }

}