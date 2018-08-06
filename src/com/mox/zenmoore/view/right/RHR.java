package com.mox.zenmoore.view.right;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RHR extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("rhr.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("RHR");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
