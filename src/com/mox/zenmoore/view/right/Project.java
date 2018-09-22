package com.mox.zenmoore.view.right;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Project extends Stage {

    public void start(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("project.fxml"));

            Scene scene = new Scene(root);

            this.setScene(scene);
            this.setTitle("Project");
            this.getIcons().add(new Image("file:image/logo/logo.PNG"));
            this.setResizable(false);
            this.show();
        }catch (Exception ex ){
            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
//            ex.printStackTrace();
        }
    }
}
