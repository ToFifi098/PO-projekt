package com.example.poprojekt;

/**
 * Klasa odpowiadająca za operacje na trawie
 */
public class Trawa {
    boolean czyJest = false;
    int licznik = 0;

    /**
     * Regeneruje trawę po upływie odpowiedniej ilości ruchów na bazie Settings.grassRate
     */
    public void regeneruj() {
        if(!czyJest) {
            licznik++;
        }
        if(licznik==Settings.getGrassRate()) {
            czyJest = true;
            licznik=0;
        }
    }

    /**
     * Zeruje licznik rund trawy oraz usuwa ją z pola
     */
    public void zjedz(){
        czyJest = false;
        licznik = 0;
    }

    /**
     * @return true jeżli istnieje na polu
     */
    public boolean isCzyJest(){
        return czyJest;
    }
}
