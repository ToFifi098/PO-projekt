package com.example.poprojekt;

import com.example.poprojekt.FXController.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {

    private static Mapa gMap;

    private ArrayList<ArrayList<Pole>> mapa;
    public Mapa(){
        this.mapa = new ArrayList<>();
    }

    public static void setgMap(Mapa gMap) {
        Mapa.gMap = gMap;
    }

    public void generujMape(int rozmiar) {
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


    public boolean koniec() {
        return false;
    }

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


        int directionX = 0;
        int directionY = 0;
        do {
            directionX = random.nextInt(3) - 1;
            directionY = random.nextInt(3) - 1;
        }while (directionY == 0 && directionX == 0);

        int x = Math.min(Math.max(0, i + directionX), Settings.getSize()-1);
        int y = Math.min(Math.max(0, j + directionY), Settings.getSize()-1);


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



    public static Mapa getgMap() {
        return gMap;
    }

    public ArrayList<ArrayList<Pole>> getMapa() {
        return mapa;
    }
}
