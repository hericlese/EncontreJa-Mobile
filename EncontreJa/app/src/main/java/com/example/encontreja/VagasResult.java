package com.example.encontreja;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.encontreja.Model.Vagas;
import com.example.encontreja.Model.VagasAdapter;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.reactivex.disposables.CompositeDisposable;


public class VagasResult extends AppCompatActivity {

    ListView listView;
    Gson gson = new Gson();
    VagasAdapter vagasAdapter;


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
        setContentView(R.layout.activity_vagas_result);


        listView =(ListView) findViewById(R.id.list_vagas);
        vagasAdapter = new VagasAdapter(this,R.layout.layout_anunciosvagas);
        listView.setAdapter(vagasAdapter);


        final String buscaResult = getIntent().getExtras().getString("JsonBusca");

        try {

            JSONArray jsonArray = new JSONArray(buscaResult);
        String cargo,empresa,competencia_1,competencia_2,competencia_3,id,fk_empresa,vagas,description,
                contrato,cidade,estado,competencia_1_nivel,competencia_2_nivel,competencia_3_nivel;

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject  json = jsonArray.getJSONObject(i);

                cargo = json.getString("cargo");
                empresa = json.getString("empresa");
                competencia_1 = json.getString("competencia_1");
                competencia_2 = json.getString("competencia_2");
                competencia_3= json.getString("competencia_3");
                id = json.getString("id");
                fk_empresa = json.getString("fk_empresa");
                vagas = json.getString("vagas");
                description = json.getString("description");
                contrato = json.getString("contrato");
                cidade = json.getString("cidade");
                estado = json.getString("estado");
                competencia_1_nivel = json.getString("competencia_1_nivel");
                competencia_2_nivel = json.getString("competencia_2_nivel");
                competencia_3_nivel = json.getString("competencia_3_nivel");

                Log.d("LOG", "Teste array "+cargo + " - " + empresa);

                Vagas vagaslist = new Vagas(cargo,empresa,competencia_1,competencia_2,competencia_3,id,
                        fk_empresa,vagas,description,contrato,cidade,estado,competencia_1_nivel,competencia_2_nivel,competencia_3_nivel);

                vagasAdapter.add(vagaslist);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




    }//Fim Budle




}