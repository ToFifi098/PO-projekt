package com.example.poprojekt;

public class Owca extends Zwierze {
    private static int ilosc = 0;
    public static int getOwca(){
        return ilosc;
    }
    public Owca() {
        ilosc++;
        id++;
        nazwa = "Owca";
        this.moved = false;
        this.energia = new Energia(Settings.getMaxEnergySheep());
    }

    public static void zmniejsz_ilosc() {
        ilosc--;
    }
    public boolean zjedz(Pole pole) {
        //sprawdza czy jest trawa
        //jeżeli tak, czy jest tam coś inneg (zwierze != null), zjedz, return true
        //jeżeli nie return false
        if(pole.getTrawa().isCzyJest()) {
            if(pole.zwierze==null) {
                pole.trawa.zjedz();
                energia.regeneruj();
                return true;
            }
        }
        return false;
    }

    public void rozmnoz() {

    }
}
