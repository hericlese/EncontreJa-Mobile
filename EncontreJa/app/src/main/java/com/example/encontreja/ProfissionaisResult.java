package com.example.encontreja;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.encontreja.Model.Anuncios;
import com.example.encontreja.Model.AnunciosAdapter;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.reactivex.disposables.CompositeDisposable;


public class ProfissionaisResult extends AppCompatActivity {

    ListView listView;
    Gson gson = new Gson();
    AnunciosAdapter anunciosAdapter;


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
        setContentView(R.layout.activity_profissionais_result);

        listView =(ListView) findViewById(R.id.list_vagas_profi);
        anunciosAdapter = new AnunciosAdapter(this,R.layout.layout_anunciosprofissionais);
        listView.setAdapter(anunciosAdapter);


        final String buscaResult = getIntent().getExtras().getString("JsonBusca");

        Toast.makeText(ProfissionaisResult.this, buscaResult, Toast.LENGTH_SHORT).show(); //

        try {

        JSONArray jsonArray = new JSONArray(buscaResult);
        String id, name, objetivo, formacao, experiencia_1, experiencia_2, experiencia_3, cursos, links, competencia_extras, fk_profissional, competencia1, nivel1, competencia2, nivel2, competencia3, nivel3, cidade_curriculo, estado_curriculo, sexo_curriculo, idade;

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject  json = jsonArray.getJSONObject(i);

                id = json.getString("id");
                name = json.getString("name");
                objetivo = json.getString("objetivo");
                formacao = json.getString("formacao");
                experiencia_1 = json.getString("experiencia_1");
                experiencia_2 = json.getString("experiencia_2");
                experiencia_3 = json.getString("experiencia_3");
                cursos = json.getString("cursos");
                links = json.getString("links");
                competencia_extras = json.getString("competencia_extra");
                fk_profissional = json.getString("fk_profissional");
                competencia1 = json.getString("competencia1");
                nivel1 = json.getString("nivel1");
                competencia2 = json.getString("competencia2");
                nivel2 = json.getString("nivel2");
                competencia3 = json.getString("competencia3");
                nivel3 = json.getString("nivel3");
                cidade_curriculo  = json.getString("cidade_curriculo");
                estado_curriculo  = json.getString("estado_curriculo");
                sexo_curriculo  = json.getString("sexo_curriculo");
                idade  = json.getString("idade");

                Anuncios anuncioslist = new Anuncios(id, name, objetivo, formacao, experiencia_1, experiencia_2, experiencia_3, cursos, links, competencia_extras, fk_profissional, competencia1, nivel1,
                        competencia2, nivel2, competencia3, nivel3, cidade_curriculo, estado_curriculo, sexo_curriculo, idade);

                anunciosAdapter.add(anuncioslist);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }





                
            }

    }//Fim Budle


