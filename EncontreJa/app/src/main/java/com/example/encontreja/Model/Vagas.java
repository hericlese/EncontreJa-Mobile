package com.example.encontreja.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vagas implements Serializable {
    String cargo,empresa,competencia_1,competencia_2,competencia_3,id,fk_empresa,vagas,description,contrato,cidade,estado,competencia_1_nivel,competencia_2_nivel,competencia_3_nivel,emailcontato,descricaoempresa;


    public Vagas(String cargo, String empresa, String competencia_1, String competencia_2, String competencia_3,
                 String id, String fk_empresa, String vagas, String description, String contrato,  String cidade,  String estado,String competencia_1_nivel,String competencia_2_nivel, String competencia_3_nivel,String emailcontato,String descricaoempresa) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.competencia_1 = competencia_1;
        this.competencia_2 = competencia_2;
        this.competencia_3 = competencia_3;
        this.competencia_1_nivel = competencia_1_nivel;
        this.competencia_2_nivel = competencia_2_nivel;
        this.competencia_3_nivel = competencia_3_nivel;
        this.id = id;
        this.fk_empresa = fk_empresa;
        this.vagas = vagas;
        this.description = description;
        this.contrato = contrato;
        this.cidade = cidade;
        this.estado = estado;
        this.emailcontato = emailcontato;
        this.descricaoempresa = descricaoempresa;


    }

    public Vagas() {
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCompetencia_1() {
        return competencia_1;
    }

    public void setCompetencia_1(String competencia_1) {
        this.competencia_1 = competencia_1;
    }

    public String getCompetencia_2() {
        return competencia_2;
    }

    public void setCompetencia_2(String competencia_2) {
        this.competencia_2 = competencia_2;
    }

    public String getCompetencia_3() {
        return competencia_3;
    }

    public void setCompetencia_3(String competencia_3) {
        this.competencia_3 = competencia_3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(String fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCompetencia_1_nivel() {
        return competencia_1_nivel;
    }

    public void setCompetencia_1_nivel(String competencia_1_nivel) {
        this.competencia_1_nivel = competencia_1_nivel;
    }

    public String getCompetencia_2_nivel() {
        return competencia_2_nivel;
    }

    public void setCompetencia_2_nivel(String competencia_2_nivel) {
        this.competencia_2_nivel = competencia_2_nivel;
    }

    public String getCompetencia_3_nivel() {
        return competencia_3_nivel;
    }

    public void setCompetencia_3_nivel(String competencia_3_nivel) {
        this.competencia_3_nivel = competencia_3_nivel;
    }

    public String getEmailcontato() {
        return emailcontato;
    }

    public void setEmailcontato(String emailcontato) {
        this.emailcontato = emailcontato;
    }

    public String getDescricaoempresa() {
        return descricaoempresa;
    }

    public void setDescricaoempresa(String descricaoempresa) {
        this.descricaoempresa = descricaoempresa;
    }
}
