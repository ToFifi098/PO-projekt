package com.example.poprojekt;


/**
 * Owca, rozszerza Zwierze
 * Zwierze biorące udział w symulacji
 */
public class Owca extends Zwierze {
    private static int ilosc = 0;

    /**
     * Tworzy obiekt Owcy wraz z obiektem Energia oraz maksymalną energią na bazie ustawień
     */
    public Owca() {
        ilosc++;
        nazwa = "Owca";
        this.moved = false;
        this.energia = new Energia(Settings.getMaxEnergySheep());
    }

    /**
     * Zmniejsza statyczny licznik owiec na planszy
     */
    public static void zmniejsz_ilosc() {
        ilosc--;
    }

    /**
     * Sprawdza czy na polu znajduje się trawa oraz ją zjada
     * @param pole pole na którym jest wykonywana operacja
     * @return true jeżeli trawa została zjedzona
     */
    public boolean zjedz(Pole pole) {
        if(pole.getTrawa().isCzyJest()) {
            if(pole.zwierze==null) {
                pole.trawa.zjedz();
                energia.regeneruj();
                return true;
            }
        }
        return false;
    }

    /**
     * @return nowa Owca
     */
    public Zwierze rozmnoz() {
        return new Owca();
    }

    /**
     * @return Aktualny stan licznika Owiec
     */
    public static int getOwca(){
        return ilosc;
    }

    /**
     * Zeruje licznik Owiec
     */
    public static void clear() {
        Owca.ilosc = 0;
    }
}
