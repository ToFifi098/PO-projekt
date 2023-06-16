package com.example.poprojekt.FXController;

import com.example.poprojekt.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GridPane extends javafx.scene.layout.GridPane {

    static public GridPane gridPane;
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

    public void generate(Mapa mapa) throws IOException {
        for (int i = 0; i < mapa.getMapa().size(); i++){
            for(int j = 0; j < mapa.getMapa().get(i).size(); j++){
                Pane tile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tile.fxml")));
                tile.setMaxHeight(Double.MAX_VALUE);
                tile.setMaxWidth(Double.MAX_VALUE);

                String color = whatColor(mapa.getMapa().get(i).get(j));
                tile.setStyle("-fx-background-color: " + color + ";");

                gridPane.add(tile, i , j);
            }
        }
    }


    public void update(Mapa mapa){
        List<Node> nodeList = gridPane.getChildren();
        int k = 1;


        for(int i = 0; i < mapa.getMapa().size(); i++){
            for(int j = 0; j < mapa.getMapa().size(); j++){



                Node tile = nodeList.get(k);

                String color = whatColor(mapa.getMapa().get(i).get(j));

                tile.setStyle("-fx-background-color: " + color + ";");

                k++;

            }
        }
    }

    private String whatColor(Pole pole){
        if(pole.getZwierze() != null){
            if(pole.getZwierze().getClass() == Owca.class) return "white";
            else if(pole.getZwierze().getClass() == Wilk.class) return "gray";
        }
        else {
            if(pole.getTrawa() .isCzyJest()) return "green";
        }
        return "#a64a1c";
    }




}
