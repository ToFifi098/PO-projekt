package com.example.poprojekt;

public class Wilk extends Zwierze {
    private static int ilosc = 0;

    public Wilk() {
        ilosc++;
        id++;
        nazwa = "Wilk";
    }

    public void zmniejsz_ilosc() {
        ilosc--;
    }
    public void zjedz() {

    }

    public void rozmnoz() {

    }
}
