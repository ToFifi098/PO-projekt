package com.example.poprojekt.FXController;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class GridPane extends javafx.scene.layout.GridPane {
    public GridPane(int x) {
        this.setGridLinesVisible(true);
        for (int i = 0; i < x; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0/x);
            this.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < x; i++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0/x);
            this.getRowConstraints().add(rowConstraints);
        }
    }
}
