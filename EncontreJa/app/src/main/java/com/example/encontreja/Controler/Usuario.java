package com.example.encontreja.Controler;

import java.io.Serializable;
import java.util.List;


public class Usuario implements Serializable {

    private String id,nome;
    private Boolean login,empresa;


    public List<Usuario> usuarios;


    //Construtor
    public Usuario(String id, String nome, Boolean login, Boolean empresa) {

        login = false;
        empresa = false;

        this.id = id;
        this.nome = nome;
        this.login = login;
        this.empresa = empresa;

    }


    //Getters and Setters

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

    public Boolean getLogin() {
        return login;
    }

    public void setLogado(Boolean logado) {
        this.login = login;
    }


    public Boolean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Boolean empresa) {
        this.empresa = empresa;
    }


    @Override
    public String toString(){
        return id;

    }

}
