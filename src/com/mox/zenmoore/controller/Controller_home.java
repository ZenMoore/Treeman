/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.Task;
import com.mox.zenmoore.view.left.TodRadioButton;
import com.mox.zenmoore.view.tool.Ad;
import com.mox.zenmoore.view.tool.Feedback;
import com.mox.zenmoore.view.right.RHR;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import com.mox.zenmoore.view.left.addTod;

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
    private ScrollPane srp_tod;

    @FXML
    void setToday(MouseEvent event){

    }

    @FXML
    void showAds(ActionEvent event) {
        new Ad().start();
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
        new RHR().start();
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
        assert srb != null : "fx:id=\"srb\" was not injected: check your FXML file 'home.fxml'.";
        assert notionImage != null : "fx:id=\"notionImage\" was not injected: check your FXML file 'home.fxml'.";
        assert projectImage != null : "fx:id=\"projectImage\" was not injected: check your FXML file 'home.fxml'.";
        assert RHRImage != null : "fx:id=\"RHRImage\" was not injected: check your FXML file 'home.fxml'.";
        assert PluginImage != null : "fx:id=\"PluginImage\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_setting != null : "fx:id=\"btn_setting\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_direction != null : "fx:id=\"btn_direction\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_advertisement != null : "fx:id=\"btn_advertisement\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_feedback != null : "fx:id=\"btn_feedback\" was not injected: check your FXML file 'home.fxml'.";

        setButtonStyle(btn_advertisement,btn_direction,btn_display,btn_feedback,btn_setting);
        loadTodays();
    }

    private void setButtonStyle(Button... buttons){

        for(Button temp: buttons){
            temp.setOnMouseEntered(e->{
                temp.setStyle("-fx-backgrond-color: #FFFAF0; -fx-border-color: #000000; -fx-border-radius: 5px;");
            });

            temp.setOnMouseExited(e->{
                temp.setStyle("-fx-background-color: #FFFAFA; -fx-border-color: #000000; -fx-border-radius: 5px;");
            });
        }

    }

    private void loadTodays(){

        File dir=new File(Directories.taskDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File[] files=new File(Directories.taskDirs).listFiles();
        VBox group = new VBox();
        group.setSpacing(10);
        group.setStyle("-fx-background-color: #F5F5F5;");

        ToolBar toolBar = new ToolBar(buttonAdd(),buttonFresh());
        toolBar.setStyle("-fx-background-color: #F5F5F5;");
        group.getChildren().add(toolBar);

        for(File file : files){
            TodRadioButton todRadioButton = new TodRadioButton(new Task(file));
            group.getChildren().add(todRadioButton);
        }

        srp_tod.setContent(group);
    }

    private Button buttonAdd(){
        Button button = new Button("+...");
        button.setStyle("-fx-background-color: #F7F7F7;");
        button.setOnAction(e->{
            new addTod().start();
        });
        button.setOnMouseEntered(e->{
            button.setStyle("-fx-background-color: #F5F5DC; -fx-border-radius: 5px;");
        });

        button.setOnMouseExited(e->{
            button.setStyle("-fx-background-color: #F7F7F7; -fx-border-radius: 5px;");
        });

        button.setOnMousePressed(e->{
            button.setStyle("-fx-background-color: #F5F5DC; -fx-border-radius: 5px;");
        });

        button.setOnMouseReleased(e->{
            button.setStyle("-fx-background-color: #F7F7F7; -fx-border-radius: 5px;");
        });

        return button;
    }

    private Button buttonFresh(){
        Button button = new Button("⇵");
        button.setStyle("-fx-background-color: #F7F7F7;");
        button.setOnAction(e->{
            loadTodays();
        });
        button.setOnMouseEntered(e->{
            button.setStyle("-fx-background-color: #F5F5DC; -fx-border-radius: 5px;");
        });
        button.setOnMouseExited(e->{
            button.setStyle("-fx-background-color: #F7F7F7; -fx-border-radius: 5px;");
        });

        button.setOnMousePressed(e->{
            button.setStyle("-fx-background-color: #F5F5DC; -fx-border-radius: 5px;");
        });

        button.setOnMouseReleased(e->{
            button.setStyle("-fx-background-color: #F7F7F7; -fx-border-radius: 5px;");
        });
        return button;
    }
}
