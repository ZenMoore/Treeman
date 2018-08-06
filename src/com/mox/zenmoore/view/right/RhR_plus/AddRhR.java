package com.mox.zenmoore.view.right.RhR_plus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddRhR extends Stage {

    public void start(){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("addrhr.fxml"));

            Scene scene=new Scene(root);

            this.setScene(scene);
            this.setTitle("AddRhR");
            this.setResizable(false);
            this.show();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
