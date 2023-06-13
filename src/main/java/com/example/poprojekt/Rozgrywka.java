package com.example.poprojekt;
import com.example.poprojekt.FXController.GridPane;
import javafx.application.Platform;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Rozgrywka extends Thread {
    int numer = 0;

    @Override
    public void run()  {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("zapis.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        do {
            numer++;
            Mapa.ruch();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GridPane.gridPane.update(Mapa.getgMap());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });


            //Zapis
            zapis.println("\nnumer partii: " + numer + "\nilość owiec: " + Owca.getOwca() + "\nilość wilków: " + Wilk.getWilk());

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (Owca.getOwca() > 0 && Wilk.getWilk() > 0);// warunki koncowe
        zapis.close();
    }

    public Rozgrywka(){

//        if (Wilk.getWilk()>Owca.getOwca()){
//            zapis.println("Wilki wygrały");}
//        else {
//            zapis.println("Owce wygrały");}
//        }

    }
}
