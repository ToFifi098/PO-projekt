package com.example.poprojekt.FXController;

import com.example.poprojekt.Main;
import com.example.poprojekt.Mapa;
import com.example.poprojekt.Rozgrywka;
import com.example.poprojekt.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import static com.example.poprojekt.FXController.GridPane.gridPane;

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

    public void generate(ActionEvent event){
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

                gridPane = new GridPane(size);
                borderPane.setCenter(gridPane);

                Mapa.setgMap(new Mapa());
                Mapa.getgMap().generujMape(Settings.getSize());

                gridPane.update(Mapa.getgMap());
            }

        }catch (NumberFormatException n){
            error.setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    Rozgrywka rozgrywka = null;
    public void start(ActionEvent e) throws IOException, InterruptedException {

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
