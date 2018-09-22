package com.mox.zenmoore.view.right.Pro_plus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProInfor extends Stage {

    public void start(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("proinfor.fxml"));

            Scene scene = new Scene(root);

            this.setResizable(false);
            this.setScene(scene);
            this.setTitle("Project Information");
            this.getIcons().add(new Image("file:image/logo/logo.PNG"));
            this.show();
        }catch (Exception ex){
//            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
            ex.printStackTrace();
        }
    }
}
