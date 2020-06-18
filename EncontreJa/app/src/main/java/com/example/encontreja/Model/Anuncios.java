package com.example.encontreja.Model;

import java.io.Serializable;

public class Anuncios implements Serializable {
    String id, nome, idade,sexo,email_contato,data,objetivo,formacao,experiencai1,experiencai2,experiencai3,cursos,links,competenciasextras, competencia1, competencia1nivel,competencia2, competencia2nivel, competencia3, competencia3nivel, cidade, estado,fk_profissinal;


    public Anuncios(String id, String nome, String idade, String sexo, String email_contato, String data, String objetivo, String formacao, String experiencai1, String experiencai2, String experiencai3, String cursos, String links, String competenciasextras, String competencia1, String competencia1nivel, String competencia2, String competencia2nivel, String competencia3, String competencia3nivel, String cidade, String estado, String fk_profissinal) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.email_contato = email_contato;
        this.data = data;
        this.objetivo = objetivo;
        this.formacao = formacao;
        this.experiencai1 = experiencai1;
        this.experiencai2 = experiencai2;
        this.experiencai3 = experiencai3;
        this.cursos = cursos;
        this.links = links;
        this.competenciasextras = competenciasextras;
        this.competencia1 = competencia1;
        this.competencia1nivel = competencia1nivel;
        this.competencia2 = competencia2;
        this.competencia2nivel = competencia2nivel;
        this.competencia3 = competencia3;
        this.competencia3nivel = competencia3nivel;
        this.cidade = cidade;
        this.estado = estado;
        this.fk_profissinal = fk_profissinal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail_contato() {
        return email_contato;
    }

    public void setEmail_contato(String email_contato) {
        this.email_contato = email_contato;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getExperiencai1() {
        return experiencai1;
    }

    public void setExperiencai1(String experiencai1) {
        this.experiencai1 = experiencai1;
    }

    public String getExperiencai2() {
        return experiencai2;
    }

    public void setExperiencai2(String experiencai2) {
        this.experiencai2 = experiencai2;
    }

    public String getExperiencai3() {
        return experiencai3;
    }

    public void setExperiencai3(String experiencai3) {
        this.experiencai3 = experiencai3;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getCompetenciasextras() {
        return competenciasextras;
    }

    public void setCompetenciasextras(String competenciasextras) {
        this.competenciasextras = competenciasextras;
    }

    public String getCompetencia1() {
        return competencia1;
    }

    public void setCompetencia1(String competencia1) {
        this.competencia1 = competencia1;
    }

    public String getCompetencia1nivel() {
        return competencia1nivel;
    }

    public void setCompetencia1nivel(String competencia1nivel) {
        this.competencia1nivel = competencia1nivel;
    }

    public String getCompetencia2() {
        return competencia2;
    }

    public void setCompetencia2(String competencia2) {
        this.competencia2 = competencia2;
    }

    public String getCompetencia2nivel() {
        return competencia2nivel;
    }

    public void setCompetencia2nivel(String competencia2nivel) {
        this.competencia2nivel = competencia2nivel;
    }

    public String getCompetencia3() {
        return competencia3;
    }

    public void setCompetencia3(String competencia3) {
        this.competencia3 = competencia3;
    }

    public String getCompetencia3nivel() {
        return competencia3nivel;
    }

    public void setCompetencia3nivel(String competencia3nivel) {
        this.competencia3nivel = competencia3nivel;
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

    public String getFk_profissinal() {
        return fk_profissinal;
    }

    public void setFk_profissinal(String fk_profissinal) {
        this.fk_profissinal = fk_profissinal;
    }
}
