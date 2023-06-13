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

    public Trawa getTrawa(){
        return trawa;
    }

    public Zwierze getZwierze(){
        return zwierze;
    }

    public void setZwierze(Zwierze zwierze) {
        this.zwierze = zwierze;
    }
}
