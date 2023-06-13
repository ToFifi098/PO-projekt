package com.example.poprojekt;

public class Energia {
    public int energia;
    private int maxEnergia;

    public Energia(int maxEnergia) {
        this.maxEnergia = maxEnergia;
        this.energia = maxEnergia;
    }

    public void regeneruj() {
        this.energia = maxEnergia;
    }
}
