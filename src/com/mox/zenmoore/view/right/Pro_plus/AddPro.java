package com.mox.zenmoore.view.right.Pro_plus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddPro extends Stage {

    public void start(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("addpro.fxml"));

            Scene scene = new Scene(root);

            this.setResizable(false);
            this.setScene(scene);
            this.setTitle("Add Project");
            this.show();
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
        }
    }
}
