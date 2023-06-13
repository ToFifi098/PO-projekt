package com.example.poprojekt;

public class Trawa {
    boolean czyJest = false;
    int licznik = 0;

    public void regeneruj() {
        if(czyJest==false) {
            licznik++;
        }
        if(licznik==Settings.getGrassRate()) {
            czyJest = true;
            licznik=0;
        }
    }

    public void zjedz(){
        czyJest = false;
        licznik = 0;
    }


    public boolean isCzyJest(){
        return czyJest;
    }
}
