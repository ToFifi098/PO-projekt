package com.example.poprojekt;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa odpowiadająca za operacje na mapie
 */

public class Mapa {

    private static Mapa gMap;

    private final ArrayList<ArrayList<Pole>> mapa;

    /**
     * Tworzy instancję obiektu mapa
     */

    public Mapa(){
        this.mapa = new ArrayList<>();
    }

    /**
     * Metoda ustawiająca globalną mapę
     * @param gMap Mapa globalna
     */

    public static void setgMap(Mapa gMap) {
        Mapa.gMap = gMap;
    }

    /**
     * Metoda generująca nową mapę
     * @param rozmiar romzmiar nowej mapy
     */

    public void generujMape(int rozmiar) {
        Owca.clear();
        Wilk.clear();

        Random random = new Random();

        for (int i = 0; i < rozmiar; i++) {
            this.mapa.add(new ArrayList<>());
            for (int j = 0; j < rozmiar; j++) {
                int losowaLiczba = random.nextInt(2);
                this.mapa.get(i).add(new Pole(i,j));
                if (losowaLiczba==0) {
                    this.mapa.get(i).get(j).trawa.czyJest = true;
                }

                }
            }
        for (int m = 0; m<Settings.getWolfs();m++){
            int x = random.nextInt(rozmiar);
            int y = random.nextInt(rozmiar);
            if (this.mapa.get(x).get(y).zwierze==null) {
                this.mapa.get(x).get(y).zwierze = new Wilk();
            }
            else {
                m--;
            }
        }

        for (int m = 0; m<Settings.getSheep();m++){
            int x = random.nextInt(rozmiar);
            int y = random.nextInt(rozmiar);
            if (this.mapa.get(x).get(y).zwierze==null) {
                this.mapa.get(x).get(y).zwierze = new Owca();
            }
            else {
                m--;
            }
        }

        }

    /**
     * Metoda wykonująca ruch zwierząt na mapie globalnej
      */
    public static void ruch() {

        for(int i = 0; i < Settings.getSize(); i++){
            for (int j = 0; j < Settings.getSize(); j++){
                Pole pole = Mapa.getgMap().getMapa().get(i).get(j);
                pole.getTrawa().regeneruj();

                if(pole.getZwierze() != null) checkOkolica(i, j, pole);
            }
        }

    }

    private static final int[][] checkOrder =
            {{-1, 0, 1}, {0, -1, 1}, {0, 1, -1}, {-1, 1, 0}, {1, 0, -1}, {1,-1,0}};

    /**
     * Metoda sprawdzająca najbliższą okolicę Pola oraz zmienająca pozycję zwierząt
     * @param i Współrzędna X pola na mapie
     * @param j Współrzędna Y pola na mapie
     * @param pole Pole z którego zwierzę ma się poruszyć
     */

    private static void checkOkolica(int i, int j, Pole pole){

        if(pole.getZwierze().moved){
            pole.getZwierze().moved = false;
            return;
        }

        Random random = new Random();

        int[] checkOrderX = checkOrder[random.nextInt(6)];
        int[] checkOrderY = checkOrder[random.nextInt(6)];

        for(int k = 0; k < 3; k++){
            int x = Math.min(Math.max(0, i + checkOrderX[k]), Settings.getSize()-1);
            for(int l =0; l < 3; l++){
                int y = Math.min(Math.max(0, j + checkOrderY[l]), Settings.getSize()-1);

                if(x == i && y == j) continue;

                Pole wanted = gMap.getMapa().get(x).get(y);
                boolean state = pole.getZwierze().zjedz(wanted);

                if(state){
                    if(wanted.getZwierze() == null){
                        if(
                                (x == i && y > j) ||
                                (x > i)

                        ){
                            pole.getZwierze().moved = true;
                        }
                        wanted.setZwierze(pole.getZwierze());
                        pole.setZwierze(null);

                        if(random.nextInt(100) < Settings.getMultiplyChance()){
                            multiply(x, y, wanted.zwierze.rozmnoz(), i, j);
                        }


                        return;
                    }
                }
            }
        }

        if(pole.getZwierze().energia.energia <= 1){
            if(pole.getZwierze().getClass() == Owca.class) Owca.zmniejsz_ilosc();
            if(pole.getZwierze().getClass() == Wilk.class) Wilk.zmniejsz_ilosc();

            pole.setZwierze(null);
            return;
        }



        int[] ints = generateRandom(i, j);
        int x = ints[0];
        int y = ints[1];

        Pole gPole = gMap.getMapa().get(x).get(y);
        if(gPole.getZwierze() == null){
            if(
                    (x == i && y > j) ||
                            (x > i)

            ){
                pole.getZwierze().moved = true;
            }

            pole.getZwierze().energia.energia--;
            gPole.setZwierze(pole.getZwierze());
            pole.setZwierze(null);
        }
    }

    /**
     * Wygeneruj losowe współrzędne x, y w okolicy pola i, j
     * @param i współrzędna X pola
     * @param j współrzędna Y pola
     * @return losowe współrzędne x,y
     */
    private static int[] generateRandom(int i, int j){
        Random random = new Random();
        int directionX;
        int directionY;
        do {
            directionX = random.nextInt(3) - 1;
            directionY = random.nextInt(3) - 1;
        }while (directionY == 0 && directionX == 0);

        int x = Math.min(Math.max(0, i + directionX), Settings.getSize()-1);
        int y = Math.min(Math.max(0, j + directionY), Settings.getSize()-1);

        return new int[]{x, y};
    }

    /**
     * Metoda rozmnażająca zwierzę, tylko po wcześniejszym ruchu zwierzęcia
     * @param i Aktualny współrzędna X Zwierzęcia na mapie globalnej
     * @param j Aktualny współrzędna Y Zwierzęcia na mapie globalnej
     * @param zwierze Zwierze które ma być rozmnożone
     * @param a Współrzędna X pola z którego zwierze zostało przeniesione
     * @param b Współrzędna Y pola z którego zwierze zostało przeniesione
     */
    private static void multiply(int i, int j, Zwierze zwierze, int a, int b){
        int[] ints = generateRandom(i, j);
        int x = ints[0];
        int y = ints[1];

        if(gMap.getMapa().get(x).get(y).getZwierze() == null){
            if(
                    (x == a && y > b) ||
                            (x > a)
            ){
                zwierze.moved = true;

            }
            gMap.getMapa().get(x).get(y).setZwierze(zwierze);
        }
        else {
            if(zwierze.getClass() == Owca.class) Owca.zmniejsz_ilosc();
            if(zwierze.getClass() == Wilk.class) Wilk.zmniejsz_ilosc();
        }
    }

    /**
     * Metoda zwracająca mapę globalną
     * @return Mapa Globalna gMap
     */

    public static Mapa getgMap() {
        return gMap;
    }

    /**
     * Metoda zwracająca mapę obiektu
     * @return mapa obiektu
     */

    public ArrayList<ArrayList<Pole>> getMapa() {
        return mapa;
    }
}
