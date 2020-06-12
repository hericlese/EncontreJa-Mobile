package com.example.encontreja.Model;

public class VagasList {
    int id,fk_empresa;
    String cargo,empresa,competencia_1,competencia_1_nivel,competencia_2,competencia_2_nivel,
            competencia_3,competencia_3_nivel,competencia_4,competencia_4_nivel,competencia_5,
            competencia_5_nivel,vagas,description,contrato,estado;

    public VagasList() {
    }


    public VagasList(int id, int fk_empresa, String cargo, String empresa, String competencia_1, String competencia_1_nivel,
                     String competencia_2, String competencia_2_nivel, String competencia_3, String competencia_3_nivel,
                     String competencia_4, String competencia_4_nivel, String competencia_5, String competencia_5_nivel,
                     String vagas, String description, String contrato, String estado) {
        this.id = id;
        this.fk_empresa = fk_empresa;
        this.cargo = cargo;
        this.empresa = empresa;
        this.competencia_1 = competencia_1;
        this.competencia_1_nivel = competencia_1_nivel;
        this.competencia_2 = competencia_2;
        this.competencia_2_nivel = competencia_2_nivel;
        this.competencia_3 = competencia_3;
        this.competencia_3_nivel = competencia_3_nivel;
        this.competencia_4 = competencia_4;
        this.competencia_4_nivel = competencia_4_nivel;
        this.competencia_5 = competencia_5;
        this.competencia_5_nivel = competencia_5_nivel;
        this.vagas = vagas;
        this.description = description;
        this.contrato = contrato;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(int fk_empresa) {
        this.fk_empresa = fk_empresa;
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

    public String getCompetencia_1_nivel() {
        return competencia_1_nivel;
    }

    public void setCompetencia_1_nivel(String competencia_1_nivel) {
        this.competencia_1_nivel = competencia_1_nivel;
    }

    public String getCompetencia_2() {
        return competencia_2;
    }

    public void setCompetencia_2(String competencia_2) {
        this.competencia_2 = competencia_2;
    }

    public String getCompetencia_2_nivel() {
        return competencia_2_nivel;
    }

    public void setCompetencia_2_nivel(String competencia_2_nivel) {
        this.competencia_2_nivel = competencia_2_nivel;
    }

    public String getCompetencia_3() {
        return competencia_3;
    }

    public void setCompetencia_3(String competencia_3) {
        this.competencia_3 = competencia_3;
    }

    public String getCompetencia_3_nivel() {
        return competencia_3_nivel;
    }

    public void setCompetencia_3_nivel(String competencia_3_nivel) {
        this.competencia_3_nivel = competencia_3_nivel;
    }

    public String getCompetencia_4() {
        return competencia_4;
    }

    public void setCompetencia_4(String competencia_4) {
        this.competencia_4 = competencia_4;
    }

    public String getCompetencia_4_nivel() {
        return competencia_4_nivel;
    }

    public void setCompetencia_4_nivel(String competencia_4_nivel) {
        this.competencia_4_nivel = competencia_4_nivel;
    }

    public String getCompetencia_5() {
        return competencia_5;
    }

    public void setCompetencia_5(String competencia_5) {
        this.competencia_5 = competencia_5;
    }

    public String getCompetencia_5_nivel() {
        return competencia_5_nivel;
    }

    public void setCompetencia_5_nivel(String competencia_5_nivel) {
        this.competencia_5_nivel = competencia_5_nivel;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
