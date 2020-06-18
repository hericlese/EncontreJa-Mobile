package com.example.encontreja.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.encontreja.R;

import java.util.ArrayList;
import java.util.List;

public class AnunciosAdapter extends ArrayAdapter {
    List list = new ArrayList<>();

    public AnunciosAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(Vagas object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        AnunciosHolder anunciosHolder;

        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.layout_anunciosvagas,parent,false);

            anunciosHolder = new AnunciosHolder();

            anunciosHolder.txt_Empresa = (TextView) row.findViewById(R.id.empresanomevagaanuncio);
            anunciosHolder.txt_aVagas = (TextView) row.findViewById(R.id.numerovagaanuncio);
            anunciosHolder.txt_aContrato = (TextView) row.findViewById(R.id.contratovaga);
            anunciosHolder.txt_aCargo = (TextView) row.findViewById(R.id.cargoanuncio);
            anunciosHolder.txt_aCompetencia1 = (TextView) row.findViewById(R.id.competencia1anuncio);
            anunciosHolder.txt_aCompetencia1nivel = (TextView) row.findViewById(R.id.competencia1nivel);
            anunciosHolder.txt_aCompetencia2 = (TextView) row.findViewById(R.id.competencia2anuncio);
            anunciosHolder.txt_aCompetencia2nivel = (TextView) row.findViewById(R.id.competencia2nivel);
            anunciosHolder.txt_aCompetencia3 = (TextView) row.findViewById(R.id.competencia3anuncio);
            anunciosHolder.txt_aCompetencia3nivel = (TextView) row.findViewById(R.id.competencia3nivel);
            anunciosHolder.txt_aCidadeEstado = (TextView) row.findViewById(R.id.competenciacidadeestado);


            row.setTag(anunciosHolder);
        }
        else
        {
            anunciosHolder = (AnunciosHolder)row.getTag();
        }

        Anuncios anunciosClass = (Anuncios)this.getItem(position);
        anunciosHolder.txt_Empresa.setText(anunciosClass.getEmpresa());
        anunciosHolder.txt_aVagas.setText(anunciosClass.getVagas()+"Vagas");
        anunciosHolder.txt_aContrato.setText(anunciosClass.getContrato());
        anunciosHolder.txt_aCargo.setText(anunciosClass.getCargo());
        anunciosHolder.txt_aCompetencia1.setText(anunciosClass.getCompetencia_1());
        anunciosHolder.txt_aCompetencia1nivel.setText(anunciosClass.getCompetencia_1_nivel());
        anunciosHolder.txt_aCompetencia2.setText(anunciosClass.getCompetencia_2());
        anunciosHolder.txt_aCompetencia2nivel.setText(anunciosClass.getCompetencia_2_nivel());
        anunciosHolder.txt_aCompetencia3.setText(anunciosClass.getCompetencia_3());
        anunciosHolder.txt_aCompetencia3nivel.setText(anunciosClass.getCompetencia_3_nivel());
        anunciosHolder.txt_aCidadeEstado.setText(anunciosClass.getCidade()+"-"+vagasClass.getEstado());

        return row;
    }


    static class AnunciosHolder{

        TextView txt_Empresa,txt_aVagas,txt_aContrato,txt_aCargo, txt_aCompetencia1 ,txt_aCompetencia1nivel ,txt_aCompetencia2,
                txt_aCompetencia2nivel,txt_aCompetencia3 ,txt_aCompetencia3nivel,txt_aCidadeEstado;
    }
}
