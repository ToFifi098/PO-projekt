package com.example.poprojekt;

public class Pole {
    int x;
    int y;
    Zwierze zwierze;
    Trawa trawa;

    public Pole(int x, int y) {
        this.x = x;
        this.y = y;
        this.trawa = new Trawa();
    }
}
