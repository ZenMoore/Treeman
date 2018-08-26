/**
 * Sample Skeleton for 'plugin.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller_plugin {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="imageview"
    private ImageView imageview; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'plugin.fxml'.";
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'plugin.fxml'.";

    }
}
