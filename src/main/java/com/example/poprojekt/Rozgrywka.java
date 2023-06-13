package com.example.poprojekt;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Rozgrywka {
    int numer = 0;

    Rozgrywka() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("zapis.txt");

        do {
            numer++;
            Mapa.getgMap().ruch();
            //Zapis
            zapis.println("numer partii: " + numer + "\nilość owiec: " + Owca.getOwca() + "\nilość wilków: " + Wilk.getWilk());
            zapis.close();

        } while (Owca.getOwca() > 0 && Wilk.getWilk() > 0);// warunki koncowe
//        if (Wilk.getWilk()>Owca.getOwca()){
//            zapis.println("Wilki wygrały");}
//        else {
//            zapis.println("Owce wygrały");}
//        }

    }
}
