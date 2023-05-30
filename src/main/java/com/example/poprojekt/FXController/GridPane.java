package com.example.poprojekt.FXController;

import com.example.poprojekt.Settings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Objects;

public class GridPane extends javafx.scene.layout.GridPane {

    static GridPane gridPane;
    public GridPane(int x) {
        this.setGridLinesVisible(true);
        for (int i = 0; i < x; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0/x);
            columnConstraints.setHgrow(Priority.ALWAYS);
            columnConstraints.setFillWidth(true);
            this.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < x; i++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0/x);
            rowConstraints.setVgrow(Priority.ALWAYS);
            rowConstraints.setFillHeight(true);
            this.getRowConstraints().add(rowConstraints);
        }
    }

    public void update() throws IOException {
        int x = Settings.getSize();

        for (int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                Pane tile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tile.fxml")));
                tile.setMaxHeight(Double.MAX_VALUE);
                tile.setMaxWidth(Double.MAX_VALUE);
                gridPane.add(tile, i , j);
            }
        }
    }
}
