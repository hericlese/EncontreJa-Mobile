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

public class VagasAdapter extends ArrayAdapter {
    List list = new ArrayList<>();

    public VagasAdapter(@NonNull Context context, int resource) {
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
        VagasHolder vagasHolder;

        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.layout_anunciosvagas,parent,false);

            vagasHolder = new VagasHolder();

            vagasHolder.txt_Empresa = (TextView) row.findViewById(R.id.empresanomevagaanuncio);
            vagasHolder.txt_aVagas = (TextView) row.findViewById(R.id.numerovagaanuncio);
            vagasHolder.txt_aContrato = (TextView) row.findViewById(R.id.contratovaga);
            vagasHolder.txt_aCargo = (TextView) row.findViewById(R.id.cargoanuncio);
            vagasHolder.txt_aCompetencia1 = (TextView) row.findViewById(R.id.competencia1anuncio);
            vagasHolder.txt_aCompetencia1nivel = (TextView) row.findViewById(R.id.competencia1nivel);
            vagasHolder.txt_aCompetencia2 = (TextView) row.findViewById(R.id.competencia2anuncio);
            vagasHolder.txt_aCompetencia2nivel = (TextView) row.findViewById(R.id.competencia2nivel);
            vagasHolder.txt_aCompetencia3 = (TextView) row.findViewById(R.id.competencia3anuncio);
            vagasHolder.txt_aCompetencia3nivel = (TextView) row.findViewById(R.id.competencia3nivel);
            vagasHolder.txt_aCidadeEstado = (TextView) row.findViewById(R.id.competenciacidadeestado);


            row.setTag(vagasHolder);
        }
        else
        {
            vagasHolder = (VagasHolder)row.getTag();
        }

        Vagas vagasClass = (Vagas)this.getItem(position);
        vagasHolder.txt_Empresa.setText(vagasClass.getEmpresa());
        vagasHolder.txt_aVagas.setText(" "+vagasClass.getVagas()+" Vagas");
        vagasHolder.txt_aContrato.setText(vagasClass.getContrato());
        vagasHolder.txt_aCargo.setText(vagasClass.getCargo());
        vagasHolder.txt_aCompetencia1.setText(vagasClass.getCompetencia_1());
        vagasHolder.txt_aCompetencia1nivel.setText(vagasClass.getCompetencia_1_nivel());
        vagasHolder.txt_aCompetencia2.setText(vagasClass.getCompetencia_2());
        vagasHolder.txt_aCompetencia2nivel.setText(vagasClass.getCompetencia_2_nivel());
        vagasHolder.txt_aCompetencia3.setText(vagasClass.getCompetencia_3());
        vagasHolder.txt_aCompetencia3nivel.setText(vagasClass.getCompetencia_3_nivel());
        vagasHolder.txt_aCidadeEstado.setText(vagasClass.getCidade()+"-"+vagasClass.getEstado());

        return row;
    }


    static class VagasHolder{

        TextView txt_Empresa,txt_aVagas,txt_aContrato,txt_aCargo, txt_aCompetencia1 ,txt_aCompetencia1nivel ,txt_aCompetencia2,
                txt_aCompetencia2nivel,txt_aCompetencia3 ,txt_aCompetencia3nivel,txt_aCidadeEstado;
    }
}
