package com.example.poprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Główna klasa aplikacji
 */

public class Main extends Application {

    /**
     * Main
     * @param args argumenty startowe
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Java FX
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainFrame.fxml")));


            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css.css")).toExternalForm());

            primaryStage.setResizable(true);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ignored){
        }
    }

}
