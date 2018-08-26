package com.mox.zenmoore.view.right;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Plugin extends Stage {
    public void start(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("plugin.fxml"));

            Scene scene = new Scene(root);

            this.setScene(scene);
            this.setTitle("Plugin");
            this.setResizable(false);
            this.show();
        }catch (Exception ex ){
            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
        }
    }
}
