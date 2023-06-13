package com.example.poprojekt;

public class Wilk extends Zwierze {
    private static int ilosc = 0;
    public static int getWilk(){
        return ilosc;
    }

    public Wilk() {
        ilosc++;
        id++;
        nazwa = "Wilk";
        this.moved = false;
        this.energia = new Energia(Settings.getMaxEnergyWolf());
    }

    public static void zmniejsz_ilosc() {
        ilosc--;
    }
    public boolean zjedz(Pole pole) {
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
