package com.example.poprojekt;

public class Trawa {
    boolean czyJest = false;
    int licznik = 0;

    public void regeneruj() {
        if(czyJest==false) {
            licznik++;
        }
        if(licznik==5) {
            czyJest = true;
            licznik=0;
        }
    }

    public boolean isCzyJest(){
        return czyJest;
    }
}
