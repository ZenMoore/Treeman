/**
 * Sample Skeleton for 'project.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mox.zenmoore.view.right.Pro_plus.AddPro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
        new AddPro().start();
    }

    @FXML
    void refresh(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'project.fxml'.";
        assert srp != null : "fx:id=\"srp\" was not injected: check your FXML file 'project.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'project.fxml'.";
        assert refbtn != null : "fx:id=\"refbtn\" was not injected: check your FXML file 'project.fxml'.";
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'project.fxml'.";

    }

    void loadItems(){

    }
}
