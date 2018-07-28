/**
 * Sample Skeleton for 'feedback.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;

public class Controller_feedback extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="htmltext"
    private HTMLEditor htmltext; // Value injected by FXMLLoader

    @FXML // fx:id="btn_send"
    private Button btn_send; // Value injected by FXMLLoader

    @FXML // fx:id="text"
    private Text text; // Value injected by FXMLLoader

    @FXML
    void sendFeedback(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert htmltext != null : "fx:id=\"htmltext\" was not injected: check your FXML file 'feedback.fxml'.";
        assert btn_send != null : "fx:id=\"btn_send\" was not injected: check your FXML file 'feedback.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'feedback.fxml'.";

    }
}
