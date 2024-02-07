package com.example._13rsz1_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvidencijaProfita {
    private Map<String, Poslovnica> poslovnice;

    public EvidencijaProfita() {
        this.poslovnice = new HashMap<>();
    }

    public void dodajPoslovnicu(String imePoslovnice, List<Double> profitPoMjesecima) {
        Poslovnica poslovnica = new Poslovnica(imePoslovnice, profitPoMjesecima);
        poslovnice.put(imePoslovnice, poslovnica);
    }

    public Poslovnica getPoslovnica(String imePoslovnice) {
        return poslovnice.get(imePoslovnice);
    }

    public void unesiProfit(String imePoslovnice, int mjesec, double profit) {
        Poslovnica poslovnica = poslovnice.get(imePoslovnice);
        List<Double> profitPoMjesecima = poslovnica.getProfitPoMjesecima();
        profitPoMjesecima.set(mjesec - 1, profit);
    }
}

