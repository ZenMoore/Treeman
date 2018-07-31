package com.mox.zenmoore.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ad extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("ad.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("Ad");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
