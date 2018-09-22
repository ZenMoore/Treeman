package com.mox.zenmoore.view.left;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class addTod extends Stage {
    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("addTod.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.getIcons().add(new Image("file:image/logo/logo.PNG"));
            this.setTitle("AddTod");
            this.setResizable(false);
            this.getIcons().add(new Image("file:image/logo/logo.PNG"));
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
