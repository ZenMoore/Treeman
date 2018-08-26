/**
 * Sample Skeleton for 'project.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.ProjectClause;
import com.mox.zenmoore.view.right.Pro_plus.ProInfor;
import com.mox.zenmoore.view.right.Pro_plus.ProCard;
import com.mox.zenmoore.view.right.Pro_plus.SharedState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Controller_project {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="srp"
    private ScrollPane srp; // Value injected by FXMLLoader

    @FXML // fx:id="addbtn"
    private Button addbtn; // Value injected by FXMLLoader

    @FXML // fx:id="refbtn"
    private Button refbtn; // Value injected by FXMLLoader

    @FXML // fx:id="imageview"
    private ImageView imageview; // Value injected by FXMLLoader

    @FXML
    void addPro(ActionEvent event) {
        SharedState.isAdd = true;
        new ProInfor().start();
    }

    @FXML
    void refresh(ActionEvent event) {
        loadItems();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'project.fxml'.";
        assert srp != null : "fx:id=\"srp\" was not injected: check your FXML file 'project.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'project.fxml'.";
        assert refbtn != null : "fx:id=\"refbtn\" was not injected: check your FXML file 'project.fxml'.";
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'project.fxml'.";

        setAddbtnStyle();
        setRefbtnStyle();
        loadItems();
    }

    private void loadItems(){
        File dir=new File(Directories.projectDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File[] files=new File(Directories.projectDirs).listFiles();
        VBox group = new VBox();
        group.setSpacing(10);
        group.setStyle("-fx-background-color: #F5F5F5;");

        int quan = 0;
        for(File file : files){
            ProCard card = new ProCard(new ProjectClause(file));
            if(card.getProjectClause().getEndDate().getTimeInMillis()-System.currentTimeMillis()<=4320000000L){
                card.setStyle("-fx-border-color: #FF6A6A");
            }

            group.getChildren().add(card);
        }

        srp.setContent(group);
    }

    private void setAddbtnStyle(){
        addbtn.setOnMouseEntered(e->{
            addbtn.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        addbtn.setOnMouseExited(e->{
            addbtn.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });

        addbtn.setOnMousePressed(e->{
            addbtn.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        addbtn.setOnMouseReleased(e->{
            addbtn.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });
    }

    private void setRefbtnStyle(){
        refbtn.setOnMouseEntered(e->{
            refbtn.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        refbtn.setOnMouseExited(e->{
            refbtn.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });

        refbtn.setOnMousePressed(e->{
            refbtn.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        refbtn.setOnMouseReleased(e->{
            refbtn.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });
    }
}
