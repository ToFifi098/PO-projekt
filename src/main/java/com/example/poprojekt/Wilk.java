package com.example.poprojekt;

public class Wilk extends Zwierze {
    private static int ilosc = 0;
    private String nazwa = "wilk";
    public Wilk() {
        ilosc++;
        id++;
    }

    public void zmniejsz_ilosc() {
        ilosc--;
    }
    public void zjedz() {

    }

    public void rozmnoz() {

    }
}
