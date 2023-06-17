package com.example.poprojekt;

/**
 * Klasa odpowiadająca za energię zwierzęcia
 */
public class Energia {

    /**
     * Aktualna energia
     */
    public int energia;
    private final int maxEnergia;

    /**
     * Tworzy obiekt energia
     * @param maxEnergia maksymalna energia zwierzęcia
     */

    public Energia(int maxEnergia) {
        this.maxEnergia = maxEnergia;
        this.energia = maxEnergia;
    }

    /**
     * Przywraca energię zwierzęcia
     */
    public void regeneruj() {
        this.energia = maxEnergia;
    }
}
