package com.example.poprojekt;

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

    public void ruch(Zwierze zwierze) {

    }

    public static Mapa getgMap() {
        return gMap;
    }

    public ArrayList<ArrayList<Pole>> getMapa() {
        return mapa;
    }
}
