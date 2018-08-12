package com.mox.zenmoore.view.left;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class addTod extends Stage {
    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("addTod.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("AddTod");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
