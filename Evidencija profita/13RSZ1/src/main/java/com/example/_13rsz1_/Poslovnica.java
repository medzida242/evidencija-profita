package com.example._13rsz1_;

import java.util.List;

public class Poslovnica {
    private String ime;
    private List<Double> profitPoMjesecima;

    public Poslovnica(String ime, List<Double> profitPoMjesecima) {
        this.ime = ime;
        this.profitPoMjesecima = profitPoMjesecima;
    }

    public String getIme() {
        return ime;
    }

    public List<Double> getProfitPoMjesecima() {
        return profitPoMjesecima;
    }
}
