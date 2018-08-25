/**
 * Sample Skeleton for 'addpro.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;

public class Controller_addpro {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="htmltext"
    private HTMLEditor htmltext; // Value injected by FXMLLoader

    @FXML // fx:id="typebox"
    private ChoiceBox<?> typebox; // Value injected by FXMLLoader

    @FXML // fx:id="namefield"
    private TextField namefield; // Value injected by FXMLLoader

    @FXML // fx:id="startdatebox"
    private DatePicker startdatebox; // Value injected by FXMLLoader

    @FXML // fx:id="enddatebox"
    private DatePicker enddatebox; // Value injected by FXMLLoader

    @FXML // fx:id="pribox"
    private ChoiceBox<?> pribox; // Value injected by FXMLLoader

    @FXML // fx:id="digestarea"
    private TextArea digestarea; // Value injected by FXMLLoader

    @FXML // fx:id="editbtn"
    private Button editbtn; // Value injected by FXMLLoader

    @FXML // fx:id="deletebtn"
    private Button deletebtn; // Value injected by FXMLLoader

    @FXML // fx:id="addbtn"
    private Button addbtn; // Value injected by FXMLLoader

    @FXML // fx:id="conbtn"
    private Button conbtn; // Value injected by FXMLLoader

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void confirm(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'addpro.fxml'.";
        assert htmltext != null : "fx:id=\"htmltext\" was not injected: check your FXML file 'addpro.fxml'.";
        assert typebox != null : "fx:id=\"typebox\" was not injected: check your FXML file 'addpro.fxml'.";
        assert namefield != null : "fx:id=\"namefield\" was not injected: check your FXML file 'addpro.fxml'.";
        assert startdatebox != null : "fx:id=\"startdatebox\" was not injected: check your FXML file 'addpro.fxml'.";
        assert enddatebox != null : "fx:id=\"enddatebox\" was not injected: check your FXML file 'addpro.fxml'.";
        assert pribox != null : "fx:id=\"pribox\" was not injected: check your FXML file 'addpro.fxml'.";
        assert digestarea != null : "fx:id=\"digestarea\" was not injected: check your FXML file 'addpro.fxml'.";
        assert editbtn != null : "fx:id=\"editbtn\" was not injected: check your FXML file 'addpro.fxml'.";
        assert deletebtn != null : "fx:id=\"deletebtn\" was not injected: check your FXML file 'addpro.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'addpro.fxml'.";
        assert conbtn != null : "fx:id=\"conbtn\" was not injected: check your FXML file 'addpro.fxml'.";

    }
}
