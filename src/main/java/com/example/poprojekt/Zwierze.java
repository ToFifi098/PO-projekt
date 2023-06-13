package com.example.poprojekt;

public abstract class Zwierze {
    public int id = 0;
    public Energia energia;
    public String nazwa;

    public static void zmniejsz_ilosc() {

    }

    public abstract boolean zjedz(Pole pole);
    public abstract void rozmnoz();
}
