package com.example.encontreja.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cargo  implements Serializable {
    String[] cargo;


    public Cargo(String[] cargo) {
        this.cargo = cargo;
    }

    public String[] getCargo() {
        return cargo;
    }

    public void setCargo(String[] cargo) {
        this.cargo = cargo;
    }
}
