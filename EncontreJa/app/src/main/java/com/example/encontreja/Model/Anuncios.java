package com.example.encontreja.Model;

import java.io.Serializable;

public class Anuncios implements Serializable {
    String id, name, objetivo, formacao, experiencia_1, experiencia_2, experiencia_3, cursos, links, competencia_extras, fk_profissional,
            competencia1, nivel1, competencia2, nivel2, competencia3, nivel3, cidade_curriculo, estado_curriculo, sexo_curriculo, idade;


    public Anuncios(String id, String name, String objetivo, String formacao, String experiencia_1, String experiencia_2, String experiencia_3, String cursos,
                    String links, String competencia_extras, String fk_profissional, String competencia1, String nivel1, String competencia2, String nivel2,
                    String competencia3, String nivel3, String cidade_curriculo, String estado_curriculo, String sexo_curriculo, String idade) {
        this.id = id;
        this.name = name;
        this.objetivo = objetivo;
        this.formacao = formacao;
        this.experiencia_1 = experiencia_1;
        this.experiencia_2 = experiencia_2;
        this.experiencia_3 = experiencia_3;
        this.cursos = cursos;
        this.links = links;
        this.competencia_extras = competencia_extras;
        this.fk_profissional = fk_profissional;
        this.competencia1 = competencia1;
        this.nivel1 = nivel1;
        this.competencia2 = competencia2;
        this.nivel2 = nivel2;
        this.competencia3 = competencia3;
        this.nivel3 = nivel3;
        this.cidade_curriculo = cidade_curriculo;
        this.estado_curriculo = estado_curriculo;
        this.sexo_curriculo = sexo_curriculo;
        this.idade = idade;
    }


    public Anuncios() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExperiencia_1() {
        return experiencia_1;
    }

    public void setExperiencia_1(String experiencia_1) {
        this.experiencia_1 = experiencia_1;
    }

    public String getExperiencia_2() {
        return experiencia_2;
    }

    public void setExperiencia_2(String experiencia_2) {
        this.experiencia_2 = experiencia_2;
    }

    public String getExperiencia_3() {
        return experiencia_3;
    }

    public void setExperiencia_3(String experiencia_3) {
        this.experiencia_3 = experiencia_3;
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

    public String getCompetencia_extras() {
        return competencia_extras;
    }

    public void setCompetencia_extras(String competencia_extras) {
        this.competencia_extras = competencia_extras;
    }

    public String getFk_profissional() {
        return fk_profissional;
    }

    public void setFk_profissional(String fk_profissional) {
        this.fk_profissional = fk_profissional;
    }

    public String getCompetencia1() {
        return competencia1;
    }

    public void setCompetencia1(String competencia1) {
        this.competencia1 = competencia1;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getCompetencia2() {
        return competencia2;
    }

    public void setCompetencia2(String competencia2) {
        this.competencia2 = competencia2;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getCompetencia3() {
        return competencia3;
    }

    public void setCompetencia3(String competencia3) {
        this.competencia3 = competencia3;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    public String getCidade_curriculo() {
        return cidade_curriculo;
    }

    public void setCidade_curriculo(String cidade_curriculo) {
        this.cidade_curriculo = cidade_curriculo;
    }

    public String getEstado_curriculo() {
        return estado_curriculo;
    }

    public void setEstado_curriculo(String estado_curriculo) {
        this.estado_curriculo = estado_curriculo;
    }

    public String getSexo_curriculo() {
        return sexo_curriculo;
    }

    public void setSexo_curriculo(String sexo_curriculo) {
        this.sexo_curriculo = sexo_curriculo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}