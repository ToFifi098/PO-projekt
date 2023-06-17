package com.example.poprojekt;

/**
 * Klasa abstrakcyjna zwierze
 */

public abstract class Zwierze {
    public Energia energia;
    public String nazwa;
    public boolean moved;

    /**
     * Sprawdza czy zwierze może zjeść na danym polu
     * @param pole pole dla którego wykonywana jest operacja
     * @return true jeżeli zjadło pokarm
     */
    public abstract boolean zjedz(Pole pole);

    /**
     * @return nowe Zwierze
     */
    public abstract Zwierze rozmnoz();
}
