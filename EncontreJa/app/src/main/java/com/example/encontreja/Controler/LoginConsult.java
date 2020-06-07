/*
package com.example.encontreja.Controler;

import android.content.Intent;
import android.util.Log;

import com.example.encontreja.AnunciarCurriculo;
import com.example.encontreja.CadastrarEmpresa;
import com.example.encontreja.LoginUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

public class ConversorJson implements Serializable {
    String resultado;

    //metodo construtor
    public ConversorJson(String resultado) {
        try {
            //chamando a função para manipulação de Json e atribuindo a vareavel que recebera o tratamento
            JSONObject jsonLogin = new JSONObject(resultado);

            // verificando se no objeto json tem a vareavel ID se sim coletando as informações do login e atibuindo a class Usuario
            if (jsonLogin.has("id")) {
                String id = jsonLogin.getString("id");
                String name = jsonLogin.getString("name");
                String email = jsonLogin.getString("email");
                String email_contato = jsonLogin.getString("email_contato");
                String empresa = jsonLogin.getString("empresa");
                String login = "1";

                    // envocando arraylist da classe usuario
                ArrayList<Usuario> usuarios = new ArrayList<>();
                        //Criando novo array Usuario com suas informações
                         usuarios.add(
                                 // adicionando suas informações a classe usuario
                                 new Usuario(
                                         id.toString(),
                                         name.toString(),
                                         email.toString(),
                                         email_contato.toString(),
                                         empresa.toString(),
                                         login.toString()
                                 )
                         );



                         //Testando parcialmete o que foi coletado
                Log.d("LOG", "Teste ID: " + jsonLogin.getString("id"));
                Log.d("LOG", "Teste NOME: " + jsonLogin.getString("name"));
                Log.d("LOG", "Teste EMAIL: " + jsonLogin.getString("email"));
                Log.d("LOG", "Teste EMAIL CONTATO: " + jsonLogin.getString("email_contato"));
                Log.d("LOG", "Teste EMPRESA: " + jsonLogin.getString("empresa"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getResultado() {
        return getResultado();
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return resultado;
    }


}
*/
