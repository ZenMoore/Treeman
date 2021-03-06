package com.mox.zenmoore.view.right.RhC_plus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AddRhC extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("addrhc.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("AddRhC");
            this.getIcons().add(new Image("file:image/logo/logo.PNG"));
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
