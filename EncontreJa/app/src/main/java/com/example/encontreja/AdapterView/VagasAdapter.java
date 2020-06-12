package com.example.encontreja.AdapterView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encontreja.Model.VagasList;
import com.example.encontreja.R;

import java.util.List;

public class VagasAdapter extends RecyclerView.Adapter<VagasAdapter.MyViewVagas> {

    List<VagasList> vagasList;
    public VagasAdapter(List<VagasList> vagasList) {
        this.vagasList = vagasList;
    }

    @NonNull
    @Override
    public MyViewVagas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_anunciosvagas,parent,false);
        return new MyViewVagas(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewVagas myViewVagas, int position) {
        myViewVagas.cargo.setText(vagasList.get(position).getCargo());
        myViewVagas.empresa.setText(vagasList.get(position).getCargo());
        myViewVagas.competencia1.setText(vagasList.get(position).getCompetencia_1());
        myViewVagas.competencia2.setText(vagasList.get(position).getCompetencia_2());
        myViewVagas.competencia3.setText(vagasList.get(position).getCompetencia_3());
        myViewVagas.competencia4.setText(vagasList.get(position).getCompetencia_4());
        myViewVagas.competencia5.setText(vagasList.get(position).getCompetencia_5());
        myViewVagas.contrato.setText(vagasList.get(position).getContrato());
        myViewVagas.vagas.setText(vagasList.get(position).getVagas());
    }

    @Override
    public int getItemCount() {
        return vagasList.size();
    }

    public class MyViewVagas extends RecyclerView.ViewHolder {
    CardView root_vagas;
    TextView cargo,empresa,competencia1,competencia2,competencia3,competencia4,competencia5,contrato,vagas;

        public MyViewVagas(@NonNull View itemView) {
            super(itemView);
            root_vagas = (CardView) itemView.findViewById(R.id.root_vagas);

            cargo = (TextView) itemView.findViewById(R.id.cargoanuncio);
            empresa = (TextView) itemView.findViewById(R.id.empresavagaanuncio);
            competencia1 = (TextView) itemView.findViewById(R.id.competencia1vaga);
            competencia2 = (TextView) itemView.findViewById(R.id.competencia2vaga);
            competencia3 = (TextView) itemView.findViewById(R.id.competencia3vaga);
            competencia4 = (TextView) itemView.findViewById(R.id.competencia4vaga);
            competencia5 = (TextView) itemView.findViewById(R.id.competencia5vaga);
            contrato = (TextView) itemView.findViewById(R.id.contratovaga);
            vagas = (TextView) itemView.findViewById(R.id.numerovagaanuncio);
        }
    }
}
