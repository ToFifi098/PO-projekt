package com.example.poprojekt;

/**
 * Klasa abstrakcyjna zwierze
 */

public abstract class Zwierze {
    public Energia energia;
    public String nazwa;
    public boolean moved;

    public abstract boolean zjedz(Pole pole);
    public abstract Zwierze rozmnoz();
}
