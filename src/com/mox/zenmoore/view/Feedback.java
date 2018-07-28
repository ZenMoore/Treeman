package com.mox.zenmoore.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Feedback extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("feedback.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("Feedback");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
