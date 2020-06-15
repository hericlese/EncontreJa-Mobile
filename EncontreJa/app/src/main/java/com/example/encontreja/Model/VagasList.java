package com.example.encontreja.Model;

public class VagasList {

    String[] id,fk_empresa,cargo,empresa,competencia_1,competencia_2,competencia_3,vagas,description,contrato,estado;

    public VagasList() {
    }


    public VagasList(String[] id, String[] fk_empresa, String[] cargo, String[] empresa, String[] competencia_1,
                     String[] competencia_2, String[] competencia_3,String[] vagas, String[] description,
                     String[] contrato, String[] estado) {
        this.id = id;
        this.fk_empresa = fk_empresa;
        this.cargo = cargo;
        this.empresa = empresa;
        this.competencia_1 = competencia_1;
        this.competencia_2 = competencia_2;
        this.competencia_3 = competencia_3;
        this.vagas = vagas;
        this.description = description;
        this.contrato = contrato;
        this.estado = estado;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String[] getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(String[] fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String[] getCargo() {
        return cargo;
    }

    public void setCargo(String[] cargo) {
        this.cargo = cargo;
    }

    public String[] getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String[] empresa) {
        this.empresa = empresa;
    }

    public String[] getCompetencia_1() {
        return competencia_1;
    }

    public String[] getCompetencia_2() {
        return competencia_2;
    }

    public void setCompetencia_2(String[] competencia_2) {
        this.competencia_2 = competencia_2;
    }

    public String[] getCompetencia_3() {
        return competencia_3;
    }

    public void setCompetencia_3(String[] competencia_3) {
        this.competencia_3 = competencia_3;
    }

    public String[] getVagas() {
        return vagas;
    }

    public void setVagas(String[] vagas) {
        this.vagas = vagas;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String[] getContrato() {
        return contrato;
    }

    public void setContrato(String[] contrato) {
        this.contrato = contrato;
    }

    public String[] getEstado() {
        return estado;
    }

    public void setEstado(String[] estado) {
        this.estado = estado;
    }


}
