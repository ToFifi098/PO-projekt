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
    public boolean zjedz(Pole pole) {
        //sprawdza czy jest trawa
        //jeżeli tak, czy jest tam coś inneg (zwierze != null), zjedz, return true
        //jeżeli nie return false
        return false;
    }

    public void rozmnoz() {

    }
}
