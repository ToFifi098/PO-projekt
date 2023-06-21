package com.example.poprojekt;

import com.example.poprojekt.FXController.GridPane;
import com.example.poprojekt.FXController.MainFrame;
import javafx.application.Platform;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Główna pętla odpowiadająca za symulację
 */

public class Rozgrywka extends Thread {
    int numer = 0;
    boolean stop = false;

    /**
     * Rozpoczyna symulację, wywoływana poprzez .start()
     */
    @Override
    public void run()  {
        PrintWriter zapis;

        try {
            zapis = new PrintWriter("zapis.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        zapis.println("Numer,Owca,Wilk");

        do {
            numer++;
            MainFrame.gCount.setText(String.valueOf(numer));
            Mapa.ruch();
                Platform.runLater(() -> GridPane.gridPane.update(Mapa.getgMap()));

            //zapis.println("\nnumer partii: " + numer + "\nilość owiec: " + Owca.getOwca() + "\nilość wilków: " + Wilk.getWilk());
            zapis.println(numer + "," + Owca.getOwca() + "," + Wilk.getWilk());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while ( (Owca.getOwca() > 0 && Wilk.getWilk() > 0) && !stop);
        zapis.close();
    }

    /**
     * Wywołana zatrzymuje symulację
     */
    public void setStop(){
        this.stop = !stop;
    }

    /**
     * Tworzy nowy obiekt Rozgrywka
     */
    public Rozgrywka(){

    }
}
