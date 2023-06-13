package com.example.poprojekt;

public class Energia {
    public int energia;
    private int maxEnergia = 15;

    public Energia() {
        this.energia = maxEnergia;
    }

    public void regeneruj() {
        this.energia = maxEnergia;
    }
}
