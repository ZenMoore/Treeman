package com.mox.zenmoore.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Home extends Application{

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
            primaryStage.getIcons().add(new Image("file://image/groot.png"));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
