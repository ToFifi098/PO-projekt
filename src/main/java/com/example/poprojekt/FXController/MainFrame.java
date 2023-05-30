package com.example.poprojekt.FXController;

import com.example.poprojekt.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

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

    private GridPane gridPane;

    public void generate(ActionEvent event){

        try {
            int size = Integer.parseInt(tfSize.getText());
            int wolfs = Integer.parseInt(tfWolfs.getText());
            int sheep = Integer.parseInt(tfSheep.getText());

            if(
                    size <= 0
                    || wolfs <= 0
                    || sheep <= 0
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

            }

        }catch (NumberFormatException n){
            error.setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void start(ActionEvent e){

    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
