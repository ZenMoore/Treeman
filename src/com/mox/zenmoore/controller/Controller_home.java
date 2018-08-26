/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.Task;
import com.mox.zenmoore.view.Home;
import com.mox.zenmoore.view.left.Display;
import com.mox.zenmoore.view.left.TodRadioButton;
import com.mox.zenmoore.view.right.Notion;
import com.mox.zenmoore.view.right.Plugin;
import com.mox.zenmoore.view.right.Project;
import com.mox.zenmoore.view.right.RHC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import com.mox.zenmoore.view.left.addTod;
import javafx.stage.Stage;

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

    @FXML // fx:id="notionImage"
    private ImageView notionImage; // Value injected by FXMLLoader

    @FXML // fx:id="projectImage"
    private ImageView projectImage; // Value injected by FXMLLoader

    @FXML // fx:id="RHRImage"
    private ImageView RHRImage; // Value injected by FXMLLoader

    @FXML // fx:id="PluginImage"
    private ImageView PluginImage; // Value injected by FXMLLoader

    @FXML
    private ScrollPane srp_tod;

    @FXML
    private Button spring;

    @FXML
    void showDisplay(ActionEvent event) {
        new Display().start();
    }

    @FXML
    void showNotions(MouseEvent event) {
        new Notion().start();
    }

    @FXML
    void showPlugins(MouseEvent event) {
        new Plugin().start();
    }

    @FXML
    void showProjects(MouseEvent event) {
        new Project().start();
    }

    @FXML
    void showRHRs(MouseEvent event) {
        new RHC().start();
    }

    @FXML
    void spring(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Home.spring(stage,button.getText().equals(">"));
        button.setText(button.getText().equals(">") ? "<" : ">");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert homePane != null : "fx:id=\"homePane\" was not injected: check your FXML file 'home.fxml'.";
        assert homelabel != null : "fx:id=\"homelabel\" was not injected: check your FXML file 'home.fxml'.";
        assert btn_display != null : "fx:id=\"btn_display\" was not injected: check your FXML file 'home.fxml'.";
        assert notionImage != null : "fx:id=\"notionImage\" was not injected: check your FXML file 'home.fxml'.";
        assert projectImage != null : "fx:id=\"projectImage\" was not injected: check your FXML file 'home.fxml'.";
        assert RHRImage != null : "fx:id=\"RHRImage\" was not injected: check your FXML file 'home.fxml'.";
        assert PluginImage != null : "fx:id=\"PluginImage\" was not injected: check your FXML file 'home.fxml'.";
        assert srp_tod != null : "fx:id=\"srp_tod\" was not injected: check your FXML file 'home.fxml'.";
        assert spring != null : "fx:id=\"spring\" was not injected: check your FXML file 'home.fxml'.";

        setSpringStyle();
        setDbtnStyle();
        loadTodays();
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

        int quan = 0;
        for(File file : files){
            TodRadioButton todRadioButton = new TodRadioButton(new Task(file));
            group.getChildren().add(todRadioButton);
        }

        srp_tod.setContent(group);
    }

    private Button buttonAdd(){
        Button button = new Button("...");
        button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        button.setOnAction(e->{
            new addTod().start();
        });

        button.setOnMouseEntered(e->{
            button.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        button.setOnMouseExited(e->{
            button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });

        button.setOnMousePressed(e->{
            button.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        button.setOnMouseReleased(e->{
            button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });

        return button;
    }

    private Button buttonFresh(){
        Button button = new Button("⇵");
        button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        button.setOnAction(e->{
            loadTodays();
        });
        button.setOnMouseEntered(e->{
            button.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        button.setOnMouseExited(e->{
            button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });

        button.setOnMousePressed(e->{
            button.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
        });

        button.setOnMouseReleased(e->{
            button.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
        });
        return button;
    }

    private void setSpringStyle(){
            spring.setOnMouseEntered(e->{
                spring.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
            });

            spring.setOnMouseExited(e->{
                spring.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
            });

            spring.setOnMousePressed(e->{
                spring.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 100px;");
            });

            spring.setOnMouseReleased(e->{
                spring.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 100px;");
            });
    }

    private void setDbtnStyle(){
        btn_display.setOnMouseEntered(e->{
            btn_display.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 15px;");
        });

        btn_display.setOnMouseExited(e->{
            btn_display.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 15px;");
        });

        btn_display.setOnMousePressed(e->{
            btn_display.setStyle("-fx-background-color: #4169E1; -fx-background-radius: 15px;");
        });

        btn_display.setOnMouseReleased(e->{
            btn_display.setStyle("-fx-background-color: #A4D3EE; -fx-background-radius: 15px;");
        });
    }
}
