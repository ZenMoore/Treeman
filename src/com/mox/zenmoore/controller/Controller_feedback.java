/**
 * Sample Skeleton for 'feedback.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;

import javax.net.ssl.SSLSession;

public class Controller_feedback extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="htmltext"
    private HTMLEditor htmltext; // Value injected by FXMLLoader

    @FXML // fx:id="btn_send"
    private Button btn_send; // Value injected by FXMLLoader

    @FXML // fx:id="imageview"
    private ImageView imageview; // Value injected by FXMLLoader

    @FXML
    void sendFeedback(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Alert");
        alert.setHeaderText("HaHaHa...");
        alert.setContentText("Sorry sir...We failed to develop this function...");

        alert.showAndWait();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'feedback.fxml'.";
        assert htmltext != null : "fx:id=\"htmltext\" was not injected: check your FXML file 'feedback.fxml'.";
        assert btn_send != null : "fx:id=\"btn_send\" was not injected: check your FXML file 'feedback.fxml'.";
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'feedback.fxml'.";

    }
}
