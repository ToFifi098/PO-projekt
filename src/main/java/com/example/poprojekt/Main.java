package com.example.poprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Random;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainFrame.fxml")));


            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css.css")).toExternalForm());

            primaryStage.setResizable(true);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
