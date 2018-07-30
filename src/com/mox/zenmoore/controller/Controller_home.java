/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mox.zenmoore.view.Feedback;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_home extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="homePane"
    private AnchorPane homePane; // Value injected by FXMLLoader

    @FXML // fx:id="homelabel"
    private Label homelabel; // Value injected by FXMLLoader

    @FXML // fx:id="btn_display"
    private Button btn_display; // Value injected by FXMLLoader

    @FXML // fx:id="task_01"
    private CheckBox task_01; // Value injected by FXMLLoader

    @FXML // fx:id="task_02"
    private CheckBox task_02; // Value injected by FXMLLoader

    @FXML // fx:id="task_03"
    private CheckBox task_03; // Value injected by FXMLLoader

    @FXML // fx:id="task_04"
    private CheckBox task_04; // Value injected by FXMLLoader

    @FXML // fx:id="task_05"
    private CheckBox task_05; // Value injected by FXMLLoader

    @FXML // fx:id="task_06"
    private CheckBox task_06; // Value injected by FXMLLoader

    @FXML // fx:id="task_07"
    private CheckBox task_07; // Value injected by FXMLLoader

    @FXML // fx:id="task_08"
    private CheckBox task_08; // Value injected by FXMLLoader

    @FXML // fx:id="task_09"
    private CheckBox task_09; // Value injected by FXMLLoader

    @FXML // fx:id="task_10"
    private CheckBox task_10; // Value injected by FXMLLoader

    @FXML // fx:id="srb"
    private ComboBox<?> srb; // Value injected by FXMLLoader

    @FXML // fx:id="notionImage"
    private ImageView notionImage; // Value injected by FXMLLoader

    @FXML // fx:id="projectImage"
    private ImageView projectImage; // Value injected by FXMLLoader

    @FXML // fx:id="RHRImage"
    private ImageView RHRImage; // Value injected by FXMLLoader

    @FXML // fx:id="PluginImage"
    private ImageView PluginImage; // Value injected by FXMLLoader

    @FXML // fx:id="btn_setting"
    private Button btn_setting; // Value injected by FXMLLoader

    @FXML // fx:id="btn_direction"
    private Button btn_direction; // Value injected by FXMLLoader

    @FXML // fx:id="btn_advertisement"
    private Button btn_advertisement; // Value injected by FXMLLoader

    @FXML // fx:id="btn_feedback"
    private Button btn_feedback; // Value injected by FXMLLoader

    @FXML
    void deleteTask(ActionEvent event){
        ((CheckBox)event.getSource()).setText("Congratulations and Come-on.");
    }

    @FXML
    void setToday(MouseEvent event){

    }

    @FXML
    void showAds(ActionEvent event) {

    }

    @FXML
    void showDirections(ActionEvent event) {

    }

    @FXML
    void showDisplay(ActionEvent event) {

    }

    @FXML
    void showFeedback(ActionEvent event) {
        new Feedback().start();

    }

    @FXML
    void showNotions(MouseEvent event) {

    }

    @FXML
    void showPlugins(MouseEvent event) {

    }

    @FXML
    void showProjects(MouseEvent event) {

    }

    @FXML
    void showRHRs(MouseEvent event) {

    }

    @FXML
    void showSearchResult(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Alert");
        alert.setHeaderText("HaHaHa...");
        alert.setContentText("Sorry sir...This is truly a fake search box...");

        alert.showAndWait();
    }

    @FXML
    void showSetting(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert homePane != null : "fx:id=\"homePane\" was not injected: check your FXML file 'home.fxml'.";
        assert homelabel != null : "fx:id=\"homelabel\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_display != null : "fx:id=\"btn_display\" was not injected: check your FXML file 'home.fxml'.";
        assert task_01 != null : "fx:id=\"task_01\" was not injected: check your FXML file 'home.fxml'.";
        assert task_02 != null : "fx:id=\"task_02\" was not injected: check your FXML file 'home.fxml'.";
        assert task_03 != null : "fx:id=\"task_03\" was not injected: check your FXML file 'home.fxml'.";
        assert task_04 != null : "fx:id=\"task_04\" was not injected: check your FXML file 'home.fxml'.";
        assert task_05 != null : "fx:id=\"task_05\" was not injected: check your FXML file 'home.fxml'.";
        assert task_06 != null : "fx:id=\"task_06\" was not injected: check your FXML file 'home.fxml'.";
        assert task_07 != null : "fx:id=\"task_07\" was not injected: check your FXML file 'home.fxml'.";
        assert task_08 != null : "fx:id=\"task_08\" was not injected: check your FXML file 'home.fxml'.";
        assert task_09 != null : "fx:id=\"task_09\" was not injected: check your FXML file 'home.fxml'.";
        assert task_10 != null : "fx:id=\"task_10\" was not injected: check your FXML file 'home.fxml'.";
        assert srb != null : "fx:id=\"srb\" was not injected: check your FXML file 'home.fxml'.";
        assert notionImage != null : "fx:id=\"notionImage\" was not injected: check your FXML file 'home.fxml'.";
        assert projectImage != null : "fx:id=\"projectImage\" was not injected: check your FXML file 'home.fxml'.";
        assert RHRImage != null : "fx:id=\"RHRImage\" was not injected: check your FXML file 'home.fxml'.";
        assert PluginImage != null : "fx:id=\"PluginImage\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_setting != null : "fx:id=\"btn_setting\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_direction != null : "fx:id=\"btn_direction\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_advertisement != null : "fx:id=\"btn_advertisement\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_feedback != null : "fx:id=\"btn_feedback\" was not injected: check your FXML file 'home.fxml'.";

    }
}
