package com.example.poprojekt;

public class Owca extends Zwierze {
    private static int ilosc = 0;
    public Owca() {
        ilosc++;
        id++;
        nazwa = "Owca";
    }

    public void zmniejsz_ilosc() {
        ilosc--;
    }
    public void zjedz() {

    }

    public void rozmnoz() {

    }
}
