package com.mox.zenmoore.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

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
            primaryStage.getIcons().add(new Image("file:image/logo/logo.PNG"));
            primaryStage.setWidth(505);
            primaryStage.setResizable(false);
            primaryStage.setX(70);
            primaryStage.setY(30);
            primaryStage.setOpacity(0.88);
            primaryStage.show();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void spring(Stage primaryStage,boolean isFold){
        if(isFold){
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(27),e->{
                primaryStage.setWidth(primaryStage.getWidth() + 10);
            }));
            animation.setCycleCount(59);
            animation.play();
        }else {
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(27),e->{
                primaryStage.setWidth(primaryStage.getWidth() - 10);
            }));
            animation.setCycleCount(59);
            animation.play();
        }
    }
}
