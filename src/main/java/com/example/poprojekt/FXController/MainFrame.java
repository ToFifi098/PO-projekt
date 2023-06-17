package com.example.poprojekt.FXController;

import com.example.poprojekt.Mapa;
import com.example.poprojekt.Rozgrywka;
import com.example.poprojekt.Settings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * Szkielet oraz obsługa I/O
 */
public class MainFrame {

    @FXML
    private TextField tfSize;
    @FXML
    private TextField tfWolfs;
    @FXML
    private TextField tfSheep;
    @FXML
    private Label error;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button start;

    /**
     * Metoda wywoływana przez przycisk Generuj
     */

    public void generate(){
        start.setText("Start");
        try {
            int size = Integer.parseInt(tfSize.getText());
            int wolfs = Integer.parseInt(tfWolfs.getText());
            int sheep = Integer.parseInt(tfSheep.getText());


            if(
                    size <= 0
                    || wolfs <= 0
                    || sheep <= 0
                    || wolfs + sheep > size*size
            ){
                error.setVisible(true);
            }
            else {
                error.setVisible(false);

                Settings.setSize(size);
                Settings.setWolfs(wolfs);
                Settings.setSheep(sheep);

                GridPane.gridPane = new GridPane(size);
                borderPane.setCenter(GridPane.gridPane);

                Mapa.setgMap(new Mapa());
                Mapa.getgMap().generujMape(Settings.getSize());

                GridPane.gridPane.generate(Mapa.getgMap());
            }

        }catch (NumberFormatException n){
            error.setVisible(true);
        }
        catch (Exception ignored){
        }

    }

    Rozgrywka rozgrywka = null;

    /**
     * Metoda wywoływana przez przycisk Start/Stop
     */

    public void start(){

        GridPane.gridPane.update(Mapa.getgMap());
        if(start.getText().equals("Start")){
            rozgrywka = new Rozgrywka();
            rozgrywka.start();
            start.setText("Stop");
        }
        else {
            rozgrywka.setStop();
            start.setText("Start");
        }

    }

}
