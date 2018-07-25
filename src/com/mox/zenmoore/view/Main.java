package com.mox.zenmoore.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root=FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene=new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Treeman");
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch(IOException exio){
            exio.printStackTrace();
        }
    }
}
