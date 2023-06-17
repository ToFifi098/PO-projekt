package com.example.poprojekt;

/**
 * Wilk, rozszerza Zwierze
 * Zwierze biorące udział w symulacji
 */
public class Wilk extends Zwierze {
    private static int ilosc = 0;

    /**
     * Tworzy obiekt Wilka wraz z obiektem Energia oraz maksymalną energią na bazie ustawień
     */
    public Wilk() {
        ilosc++;
        nazwa = "Wilk";
        this.moved = false;
        this.energia = new Energia(Settings.getMaxEnergyWolf());
    }

    /**
     * @return Aktualny stan licznika Wilków
     */
    public static int getWilk(){
        return ilosc;
    }

    /**
     * Zeruje licznik Wilków
     */
    public static void clear() {
        Wilk.ilosc = 0;
    }

    /**
     * Zmniejsza statyczny licznik Wilków na planszy
     */
    public static void zmniejsz_ilosc() {
        ilosc--;
    }

    /**
     * Sprawdza czy na polu znajduje się Owca oraz ją zjada
     * @param pole pole na którym jest wykonywana operacja
     * @return true jeżeli Owca została zjedzona
     */
    public boolean zjedz(Pole pole) {
        if(pole.getZwierze() != null){
            if(pole.getZwierze().getClass()==Owca.class) {
                pole.zwierze=null;
                Owca.zmniejsz_ilosc();
                energia.regeneruj();
                return true;
            }
        }
        return false;
    }

    /**
     * @return nowy Wilk
     */
    public Zwierze rozmnoz() {
        return new Wilk();
    }
}
