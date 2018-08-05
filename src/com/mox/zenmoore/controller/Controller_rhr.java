/**
 * Sample Skeleton for 'rhr.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_rhr extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="motionImage"
    private ImageView motionImage; // Value injected by FXMLLoader

    @FXML // fx:id="srp_rhr"
    private ScrollPane srp_rhr; // Value injected by FXMLLoader

    @FXML // fx:id="addRhR"
    private Button addRhR; // Value injected by FXMLLoader

    @FXML
    void showAddDialog(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete

    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'rhr.fxml'.";
        assert motionImage != null : "fx:id=\"motionImage\" was not injected: check your FXML file 'rhr.fxml'.";
        assert srp_rhr != null : "fx:id=\"srp_rhr\" was not injected: check your FXML file 'rhr.fxml'.";
        assert addRhR != null : "fx:id=\"addRhR\" was not injected: check your FXML file 'rhr.fxml'.";

    }
}
