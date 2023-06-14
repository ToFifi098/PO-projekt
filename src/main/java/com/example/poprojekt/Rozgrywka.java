package com.example.poprojekt;

import com.example.poprojekt.FXController.GridPane;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Rozgrywka extends Thread {
    int numer = 0;
    boolean stop = false;

    @Override
    public void run()  {
        PrintWriter zapis;
        try {
            zapis = new PrintWriter("zapis.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        do {
            numer++;
            Mapa.ruch();
                Platform.runLater(() -> {
                    try {
                        GridPane.gridPane.update(Mapa.getgMap());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            zapis.println("\nnumer partii: " + numer + "\nilość owiec: " + Owca.getOwca() + "\nilość wilków: " + Wilk.getWilk());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while ( (Owca.getOwca() > 0 && Wilk.getWilk() > 0) && !stop);
        zapis.close();
    }

    public void setStop(){
        this.stop = !stop;
    }


    public Rozgrywka(){

//        if (Wilk.getWilk()>Owca.getOwca()){
//            zapis.println("Wilki wygrały");}
//        else {
//            zapis.println("Owce wygrały");}
//        }

    }
}
