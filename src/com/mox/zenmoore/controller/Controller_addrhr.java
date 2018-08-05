/**
 * Sample Skeleton for 'addrhr.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller_addrhr {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="text_1"
    private TextField text_1; // Value injected by FXMLLoader

    @FXML // fx:id="label_con"
    private Label label_con; // Value injected by FXMLLoader

    @FXML // fx:id="label_pri"
    private Label label_pri; // Value injected by FXMLLoader

    @FXML // fx:id="group"
    private ToggleButtonGroup group; // Value injected by FXMLLoader

    @FXML // fx:id="rb_1"
    private RadioButton rb_1; // Value injected by FXMLLoader

    @FXML // fx:id="rb_2"
    private RadioButton rb_2; // Value injected by FXMLLoader

    @FXML // fx:id="rb_3"
    private RadioButton rb_3; // Value injected by FXMLLoader

    @FXML // fx:id="rb_4"
    private RadioButton rb_4; // Value injected by FXMLLoader

    @FXML // fx:id="rb_5"
    private RadioButton rb_5; // Value injected by FXMLLoader

    @FXML // fx:id="label_nam"
    private Label label_nam; // Value injected by FXMLLoader

    @FXML // fx:id="text_2"
    private TextField text_2; // Value injected by FXMLLoader

    @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML
    void add(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert text_1 != null : "fx:id=\"text_1\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert label_con != null : "fx:id=\"label_con\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert label_pri != null : "fx:id=\"label_pri\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert group != null : "fx:id=\"group\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert rb_1 != null : "fx:id=\"rb_1\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert rb_2 != null : "fx:id=\"rb_2\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert rb_3 != null : "fx:id=\"rb_3\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert rb_4 != null : "fx:id=\"rb_4\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert rb_5 != null : "fx:id=\"rb_5\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert label_nam != null : "fx:id=\"label_nam\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert text_2 != null : "fx:id=\"text_2\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'addrhr.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'addrhr.fxml'.";

    }
}
