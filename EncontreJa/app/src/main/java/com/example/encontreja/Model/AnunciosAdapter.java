package com.example.encontreja.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

    public void add(Anuncios object) {
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
            row = layoutInflater.inflate(R.layout.layout_anunciosprofissionais,parent,false);

            anunciosHolder = new AnunciosHolder();

            anunciosHolder.txt_Nome = (TextView) row.findViewById(R.id.nomeanuncio);
            anunciosHolder.txt_idade = (TextView) row.findViewById(R.id.idadeanuncio);
            anunciosHolder.txt_aCompetencia1 = (TextView) row.findViewById(R.id.competencia1anunciopro);
            anunciosHolder.txt_aCompetencia1nivel = (TextView) row.findViewById(R.id.competencia1nivelpro);
            anunciosHolder.txt_aCompetencia2 = (TextView) row.findViewById(R.id.competencia2anunciopro);
            anunciosHolder.txt_aCompetencia2nivel = (TextView) row.findViewById(R.id.competencia2nivelpro);
            anunciosHolder.txt_aCompetencia3 = (TextView) row.findViewById(R.id.competencia3anunciopro);
            anunciosHolder.txt_aCompetencia3nivel = (TextView) row.findViewById(R.id.competencia3nivelpro);
            anunciosHolder.txt_aCidadeEstado = (TextView) row.findViewById(R.id.competenciacidadeestado);

            // anunciosHolder.img = (ImageView) row.findViewById(R.id.imgprofissional);


            row.setTag(anunciosHolder);
        }
        else
        {
            anunciosHolder = (AnunciosHolder)row.getTag();
        }

        Anuncios anunciosClass = (Anuncios)this.getItem(position);
        anunciosHolder.txt_Nome.setText(anunciosClass.getName());
        anunciosHolder.txt_idade.setText(anunciosClass.getIdade()+" Anos");
        anunciosHolder.txt_aCompetencia1.setText(anunciosClass.getCompetencia1());
        anunciosHolder.txt_aCompetencia1nivel.setText(anunciosClass.getNivel1());
        anunciosHolder.txt_aCompetencia2.setText(anunciosClass.getCompetencia2());
        anunciosHolder.txt_aCompetencia2nivel.setText(anunciosClass.getNivel2());
        anunciosHolder.txt_aCompetencia3.setText(anunciosClass.getCompetencia3());
        anunciosHolder.txt_aCompetencia3nivel.setText(anunciosClass.getNivel3());
        anunciosHolder.txt_aCidadeEstado.setText(anunciosClass.getCidade_curriculo()+"-"+anunciosClass.getEstado_curriculo());

        return row;
    }


    static class AnunciosHolder{

        TextView txt_Nome,txt_idade, txt_aCompetencia1 ,txt_aCompetencia1nivel ,txt_aCompetencia2, txt_aCompetencia2nivel,txt_aCompetencia3 ,txt_aCompetencia3nivel,txt_aCidadeEstado;
    }
}
