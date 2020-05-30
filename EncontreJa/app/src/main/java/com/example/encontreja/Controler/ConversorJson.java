package com.example.encontreja.Controler;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ConversorJson implements Serializable {
    String resultado;

    //metodo construtor
    public ConversorJson(String resultado) {
        try {
            JSONObject jsonLogin = new JSONObject(resultado);
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
