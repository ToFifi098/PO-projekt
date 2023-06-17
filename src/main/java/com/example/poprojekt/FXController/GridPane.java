package com.example.poprojekt.FXController;

import com.example.poprojekt.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Klasa odpowiadająca za operacje na siatce wyświetlającej postęp symulacji
 */

public class GridPane extends javafx.scene.layout.GridPane {

    /**
     * Globalny grid
     */
    static public GridPane gridPane;

    /**
     * Tworzy nową siatkę o wymiarach x na x
     * @param x rozmiar siatki
     */
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

    /**
     * Metoda generuje z mapy pola siatki oraz dodaje je do statycznej siatki
     * @param mapa mapa z której generowane są pola
     * @throws IOException błąd wejścia, Tile.fxml
     */

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

    /**
     * Metoda aktualizuje aktualną siatkę na bazie mapy
     * @param mapa mapa z której jest aktualizowana siatka
     */

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

    /**
     * Metoda zwracająca kolor w zależności od zwierzęcia oraz trawy
     * @param pole Pole dla którego sprawdzany jest kolor
     * @return kolor dla danego typu pola
     */

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
