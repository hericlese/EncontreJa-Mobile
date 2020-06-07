package com.example.encontreja.Controler;

import android.content.Intent;
import android.text.BoringLayout;
import android.util.Log;

import com.example.encontreja.LoginUsuario;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;



public class Usuario implements Serializable {

    private String id;

    private String name;

    private String email;

    private String email_contato;

    private String empresa;

    private String login;


    //Construtor
    public Usuario(String id, String name, String email, String email_contato, String empresa, String login) {
        this.login = login;
        this.id = id;
        this.name = name;
        this.email = email;
        this.email_contato = email_contato;
        this.empresa = empresa;
    }

    //Getters and Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_contato() {
        return email_contato;
    }

    public void setEmail_contato(String email_contato) {
        this.email_contato = email_contato;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }





    @Override
    public String toString() {

        return name + id + login;


    }


}
