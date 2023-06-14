package com.example.poprojekt;

public abstract class Zwierze {
    public int id = 0;
    public Energia energia;
    public String nazwa;
    public boolean moved;

    public abstract boolean zjedz(Pole pole);
    public abstract Zwierze rozmnoz();
}
