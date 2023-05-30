package com.example.poprojekt;

public abstract class Zwierze {
    public int id = 0;
    public Energia energia;

    public abstract void zmniejsz_ilosc();
    public abstract void zjedz();
    public abstract void rozmnoz();
}
