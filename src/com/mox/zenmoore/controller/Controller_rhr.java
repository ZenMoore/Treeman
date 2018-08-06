/**
 * Sample Skeleton for 'rhr.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.RHRItem;
import com.mox.zenmoore.view.right.RhR_plus.AddRhR;
import com.mox.zenmoore.view.right.RhR_plus.RHRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        new AddRhR().start();
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

        srp_rhr.setPannable(true);
        srp_rhr.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        srp_rhr.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        loadItems();

    }

    void loadItems(){

        File dir=new File(Directories.rhrDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File[] files=new File(Directories.rhrDirs).listFiles();

        for(File file : files){
            RHRadioButton radioButton=new RHRadioButton(new RHRItem(file));
            srp_rhr.setContent(radioButton);
        }
    }

    /**
     * 另有在 Controller_addrhr 中获取 this Stage 的目的。
     * @return
     */
    public Pane getPane(){
        return pane;
    }
}
