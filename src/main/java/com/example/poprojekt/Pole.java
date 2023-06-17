package com.example.poprojekt;

/**
 * Pole posiadające Zwierzę oraz Trawę
 */
public class Pole {
    Zwierze zwierze;
    Trawa trawa;

    /**
     * Tworzy nowe pole wraz z trawą
     */
    public Pole() {
        this.trawa = new Trawa();
    }

    /**
     * @return Zwraca trawę z pola
     */
    public Trawa getTrawa(){
        return trawa;
    }

    /**
     * @return Zwraca zwierzę z pola
     */
    public Zwierze getZwierze(){
        return zwierze;
    }

    /**
     * Ustawia zwierzę na polu
     * @param zwierze zwierze
     */
    public void setZwierze(Zwierze zwierze) {
        this.zwierze = zwierze;
    }
}
