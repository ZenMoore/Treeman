/**
 * Sample Skeleton for 'rhr.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.RHRItem;
import com.mox.zenmoore.view.right.RhR_plus.AddRhR;
import com.mox.zenmoore.view.right.RhR_plus.RHRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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

    @FXML //fx:id="refresh"
    private Button refresh;// Value injected by FXMLLoader

    @FXML
    void showAddDialog(ActionEvent event) {
        new AddRhR().start();
    }

    @FXML
    void refresh(ActionEvent event){
        loadItems();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'rhr.fxml'.";
        assert motionImage != null : "fx:id=\"motionImage\" was not injected: check your FXML file 'rhr.fxml'.";
        assert srp_rhr != null : "fx:id=\"srp_rhr\" was not injected: check your FXML file 'rhr.fxml'.";
        assert addRhR != null : "fx:id=\"addRhR\" was not injected: check your FXML file 'rhr.fxml'.";

        addRhR.setOnMouseEntered(e->{
            addRhR.setStyle("-fx-background-color: #87CEFA; -fx-border-radius: 5px;");
        });

        addRhR.setOnMouseExited(e->{
            addRhR.setStyle("-fx-background-color: #FFEBCD; -fx-border-radius: 5px;");
        });

        addRhR.setOnMousePressed(e->{
            addRhR.setStyle("-fx-background-color: #FFEBCD; -fx-border-radius: 5px;");
        });

        addRhR.setOnMouseReleased(e->{
            addRhR.setStyle("-fx-background-color: #87CEFA; -fx-border-radius: 5px;");
        });

        refresh.setOnMouseEntered(e->{
            refresh.setStyle("-fx-background-color: #87CEFA; -fx-border-radius: 5px;");
        });

        refresh.setOnMouseExited(e->{
            refresh.setStyle("-fx-background-color: #FFEBCD; -fx-border-radius: 5px;");
        });

        refresh.setOnMousePressed(e->{
            refresh.setStyle("-fx-background-color: #FFEBCD; -fx-border-radius: 5px;");
        });

        refresh.setOnMouseReleased(e->{
            refresh.setStyle("-fx-background-color: #87CEFA; -fx-border-radius: 5px;");
        });

        srp_rhr.setPannable(true);
        srp_rhr.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        srp_rhr.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        loadItems();
    }

    void loadItems(){

        File dir=new File(Directories.rhrDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File[] files=new File(Directories.rhrDirs).listFiles();
        VBox group = new VBox();
        group.setSpacing(10);
        group.setStyle("-fx-background-color: #F5F5F5;");

        int quan = 0;
        for(File file : files){
            RHRadioButton radioButton=new RHRadioButton(new RHRItem(file));
            if(radioButton.getRhrItem().getCalendar().getTimeInMillis()-System.currentTimeMillis()<=4320000000L){
                radioButton.setStyle("-fx-background-color: #BC8F8F;");
            }
            group.getChildren().add(radioButton);
        }

        srp_rhr.setContent(group);
    }

}
