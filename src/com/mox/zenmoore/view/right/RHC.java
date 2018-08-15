package com.mox.zenmoore.view.right;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RHC extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("rhc.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("RHC");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
