package com.example.poprojekt.FXController;

import com.example.poprojekt.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GridPane extends javafx.scene.layout.GridPane {

    static GridPane gridPane;
    public GridPane(int x) {
        this.setGridLinesVisible(true);
        for (int i = 0; i < Settings.getSize(); i++){
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0/x);
            columnConstraints.setHgrow(Priority.ALWAYS);
            columnConstraints.setFillWidth(true);
            this.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < Settings.getSize(); i++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0/x);
            rowConstraints.setVgrow(Priority.ALWAYS);
            rowConstraints.setFillHeight(true);
            this.getRowConstraints().add(rowConstraints);
        }
    }

    public void update(Mapa mapa) throws IOException {
        int x = Settings.getSize();



        for (int i = 0; i < mapa.getMapa().size(); i++){
            for(int j = 0; j < mapa.getMapa().get(i).size(); j++){
                Pane tile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tile.fxml")));
                tile.setMaxHeight(Double.MAX_VALUE);
                tile.setMaxWidth(Double.MAX_VALUE);

                if(mapa.getMapa().get(i).get(j).getTrawa().isCzyJest()){
                    tile.setStyle("-fx-background-color: green");
                }
                if(mapa.getMapa().get(i).get(j).getZwierze() != null){
                    if(mapa.getMapa().get(i).get(j).getZwierze().nazwa.equals("Owca")){
                        tile.setStyle("-fx-background-color: white");
                    }
                    else if (mapa.getMapa().get(i).get(j).getZwierze().nazwa.equals("Wilk")){
                        tile.setStyle("-fx-background-color: gray");
                    }
                }

                gridPane.add(tile, i , j);
            }
        }
    }

}
