package com.example.poprojekt;

public class Owca extends Zwierze {
    private static int ilosc = 0;
    private String nazwa = "owca";
    public Owca() {
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
