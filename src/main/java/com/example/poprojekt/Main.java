package com.example.poprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));


            Scene scene = new Scene(root);
            primaryStage.setResizable(true);


            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
