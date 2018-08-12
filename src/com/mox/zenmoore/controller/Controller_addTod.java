/**
 * Sample Skeleton for 'addTod.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.RHRItem;
import com.mox.zenmoore.model.Suffixs;
import com.mox.zenmoore.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class Controller_addTod {

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

    @FXML // fx:id="label_nam"
    private Label label_nam; // Value injected by FXMLLoader

    @FXML // fx:id="text_2"
    private TextField text_2; // Value injected by FXMLLoader

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML // fx:id="rb1"
    private RadioButton rb1; // Value injected by FXMLLoader

    @FXML // fx:id="group"
    private ToggleGroup group; // Value injected by FXMLLoader

    @FXML // fx:id="rb3"
    private RadioButton rb3; // Value injected by FXMLLoader

    @FXML // fx:id="rb2"
    private RadioButton rb2; // Value injected by FXMLLoader

    @FXML // fx:id="rb4"
    private RadioButton rb4; // Value injected by FXMLLoader

    @FXML // fx:id="rb5"
    private RadioButton rb5; // Value injected by FXMLLoader

    private int priority  = 0;

    @FXML
    void add(ActionEvent event) {
        if(text_1.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Content cannot be null.").showAndWait();
        }else if(text_2.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Filename cannot be null.").showAndWait();
        }else if(priority==0){
            new Alert(Alert.AlertType.ERROR,"Priority is not set.").showAndWait();
        }else{
            ArrayList<String> nameList = new ArrayList<>();
            File[] files = new File(Directories.taskDirs).listFiles();
            for(File temp : files){
                nameList.add(temp.getName());
            }

            if(nameList.contains((text_2.getText()+Suffixs.taskfix))){
                new Alert(Alert.AlertType.ERROR,"The name already exists.").showAndWait();
                text_2.setText("");
                return;
            }else {
                new Task(text_2.getText(),text_1.getText(),priority);
            }

        }

        clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'addTod.fxml'.";
        assert text_1 != null : "fx:id=\"text_1\" was not injected: check your FXML file 'addTod.fxml'.";
        assert label_con != null : "fx:id=\"label_con\" was not injected: check your FXML file 'addTod.fxml'.";
        assert label_pri != null : "fx:id=\"label_pri\" was not injected: check your FXML file 'addTod.fxml'.";
        assert label_nam != null : "fx:id=\"label_nam\" was not injected: check your FXML file 'addTod.fxml'.";
        assert text_2 != null : "fx:id=\"text_2\" was not injected: check your FXML file 'addTod.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'addTod.fxml'.";
        assert rb1 != null : "fx:id=\"rb1\" was not injected: check your FXML file 'addTod.fxml'.";
        assert group != null : "fx:id=\"group\" was not injected: check your FXML file 'addTod.fxml'.";
        assert rb3 != null : "fx:id=\"rb3\" was not injected: check your FXML file 'addTod.fxml'.";
        assert rb2 != null : "fx:id=\"rb2\" was not injected: check your FXML file 'addTod.fxml'.";
        assert rb4 != null : "fx:id=\"rb4\" was not injected: check your FXML file 'addTod.fxml'.";
        assert rb5 != null : "fx:id=\"rb5\" was not injected: check your FXML file 'addTod.fxml'.";

        button.setOnMouseEntered(e->{
            button.setStyle("-fx-background-color: #FFF5EE; -fx-border-color: #FFF5EE; -fx-border-radius: 5px");
        });

        button.setOnMouseExited(e->{
            button.setStyle("-fx-background-color: #FFFAF0; -fx-border-color: #FFFAF0; -fx-border-radius: 5px");
        });

        button.setOnMousePressed(e->{
            button.setStyle("-fx-background-color: #FFF0F5; -fx-border-color: #FFF0F5; -fx-border-radius: 5px");
        });

        button.setOnMouseReleased(e->{
            button.setStyle("-fx-background-color: #FFF5EE; border-fx-border-color: #FFF5EE;-fx-border-radius: 5px");
        });

        rb1.setOnAction(e->{
            priority=1;
        });

        rb2.setOnAction(e->{
            priority=2;
        });

        rb3.setOnAction(e->{
            priority=3;
        });

        rb4.setOnAction(e->{
            priority=4;
        });

        rb5.setOnAction(e->{
            priority=5;
        });
    }

    void clear(){
        text_1.setText("");
        text_2.setText("");
        if(group.getSelectedToggle()!=null){
            group.getSelectedToggle().setSelected(false);
        }
    }
}
