package com.example.poprojekt;

public class Owca extends Zwierze {
    private static int ilosc = 0;

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
        if(pole.getTrawa().isCzyJest()) {
            if(pole.zwierze==null) {
                pole.trawa.zjedz();
                energia.regeneruj();
                return true;
            }
        }
        return false;
    }

    public Zwierze rozmnoz() {
        return new Owca();
    }

    public static int getOwca(){
        return ilosc;
    }

    public static void setIlosc(int ilosc) {
        Owca.ilosc = ilosc;
    }
}
