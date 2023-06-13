package com.example.poprojekt;

public class Wilk extends Zwierze {
    private static int ilosc = 0;

    public Wilk() {
        ilosc++;
        id++;
        nazwa = "Wilk";
        this.moved = false;
    }

    public static void zmniejsz_ilosc() {
        ilosc--;
    }
    public boolean zjedz(Pole pole) {
        //sprawdza czy jest Owca if(pole.getZwierze().getClass() == Owca.class)
        //jeżeli tak, zjedz (usuwa owce z pola (zwierze = null), regeneruje energie) return true
        //jeżeli nie return false
        if(pole.getZwierze() != null){
            if(pole.getZwierze().getClass()==Owca.class) {
                pole.zwierze=null;
                Owca.zmniejsz_ilosc();
                energia.regeneruj();
                return true;
            }
        }
        return false;
    }

    public void rozmnoz() {

    }
}
