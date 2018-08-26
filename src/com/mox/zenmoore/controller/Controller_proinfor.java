/**
 * Sample Skeleton for 'proinfor.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.ProjectClause;
import com.mox.zenmoore.model.Suffixs;
import com.mox.zenmoore.view.right.Pro_plus.SharedState;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class Controller_proinfor {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="htmltext"
    private HTMLEditor htmltext; // Value injected by FXMLLoader

    @FXML // fx:id="typebox"
    private ChoiceBox<ProjectClause.ProjectType> typebox; // Value injected by FXMLLoader

    @FXML // fx:id="namefield"
    private TextField namefield; // Value injected by FXMLLoader

    @FXML // fx:id="startdatebox"
    private DatePicker startdatebox; // Value injected by FXMLLoader

    @FXML // fx:id="enddatebox"
    private DatePicker enddatebox; // Value injected by FXMLLoader

    @FXML // fx:id="pribox"
    private ChoiceBox<String> pribox; // Value injected by FXMLLoader

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

    private ProjectClause projectClause;

    private ProjectClause former;

    @FXML
    void add(ActionEvent event) {

        if (loadPro()){
            SharedState.isAdd = false;
            Button button = (Button) event.getSource();
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void confirm(ActionEvent event) {
        SharedState.isInfor = false;
        not_editable(loadPro());
    }

    @FXML
    void delete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete it?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            projectClause.delete();
        }else {
            return;
        }
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void edit(ActionEvent event) {
        not_editable(false);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert htmltext != null : "fx:id=\"htmltext\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert typebox != null : "fx:id=\"typebox\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert namefield != null : "fx:id=\"namefield\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert startdatebox != null : "fx:id=\"startdatebox\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert enddatebox != null : "fx:id=\"enddatebox\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert pribox != null : "fx:id=\"pribox\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert digestarea != null : "fx:id=\"digestarea\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert editbtn != null : "fx:id=\"editbtn\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert deletebtn != null : "fx:id=\"deletebtn\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'proinfor.fxml'.";
        assert conbtn != null : "fx:id=\"conbtn\" was not injected: check your FXML file 'proinfor.fxml'.";

        projectClause = SharedState.isInfor ? SharedState.projectClause:null;

        setBoxValue();
        setButtonStyle(editbtn,addbtn,deletebtn,conbtn);

        if(SharedState.isInfor){
            addbtn.setDisable(true);

            this.projectClause = SharedState.projectClause;

            htmltext.setHtmlText(projectClause.getContent());


            typebox.setValue(projectClause.getType());


            namefield.setText(projectClause.getName());


            Calendar start = projectClause.getStartDate();
            startdatebox.setValue(LocalDate.of(start.get(Calendar.YEAR),start.get(Calendar.MONTH),start.get(Calendar.DAY_OF_MONTH)));


            Calendar end = projectClause.getEndDate();
            enddatebox.setValue(LocalDate.of(end.get(Calendar.YEAR),end.get(Calendar.MONTH),end.get(Calendar.DAY_OF_MONTH)));


            String temp = "没有找到等级";
            switch (projectClause.getLevel()){
                case 1:temp = "轻";break;
                case 2:temp = "缓";break;
                case 3:temp = "重";break;
                case 4:temp = "急";break;
                case 5:temp = "生死攸关";break;
            }
            pribox.setValue(temp);


            digestarea.setText(projectClause.getDigest());

            SharedState.isInfor = false;
            not_editable(true);
        }else if(SharedState.isAdd){
            conbtn.setDisable(true);
            editbtn.setDisable(true);
            deletebtn.setDisable(true);
        }else {
            new Alert(Alert.AlertType.ERROR,"Shared state is wrong.").showAndWait();
        }
    }

    void setBoxValue(){
        ObservableList<ProjectClause.ProjectType> typeList = typebox.getItems();
        ObservableList<String> priList = pribox.getItems();
        typeList.addAll(
                ProjectClause.ProjectType.ANALYSIS_OR_EVALUATION_MODEL,
                ProjectClause.ProjectType.EXPERIMENT,
                ProjectClause.ProjectType.NEW_THOUGHT,
                ProjectClause.ProjectType.RHC_COLLECTION,
                ProjectClause.ProjectType.SELF_DRIVE_SOLUTION,
                ProjectClause.ProjectType.SOLUTION_TO_PROBLEMS,
                ProjectClause.ProjectType.TASK_OR_GOAL_DEPLOYMENT
        );
        priList.addAll(
                "轻",
                "缓",
                "重",
                "急",
                "生死攸关"
        );
    }

    void not_editable(boolean is){
        htmltext.setDisable(is);
        typebox.setDisable(is);
        namefield.setDisable(is);
        startdatebox.setDisable(is);
        enddatebox.setDisable(is);
        pribox.setDisable(is);
        digestarea.setDisable(is);

    }

    boolean loadPro(){

        if(htmltext.getHtmlText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Content cannot be null.").showAndWait();
        }else if(typebox.getValue().equals(null)){
            new Alert(Alert.AlertType.WARNING,"Type cannot be null.").showAndWait();
        }else if(namefield.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Name cannot be null.").showAndWait();
        }else if(startdatebox.getEditor().getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Start date cannot be null.").showAndWait();
        }else if(enddatebox.getEditor().getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"End date cannot be null.").showAndWait();
        }else if(pribox.getValue().equals(null)){
            new Alert(Alert.AlertType.WARNING,"Priority cannot be null.").showAndWait();
        }else if(digestarea.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Digest cannot be null.").showAndWait();
        }else{
            ArrayList<String> nameList = new ArrayList<>();
            File[] files = new File(Directories.projectDirs).listFiles();
            for(File temp : files){
                nameList.add(temp.getName());
            }

            if (nameList.contains(namefield.getText()+Suffixs.projectfix)){
                new Alert(Alert.AlertType.WARNING,"The project name already exists.").showAndWait();
            }else{
                Calendar start=new GregorianCalendar();
                String[] inforsstart=startdatebox.getEditor().getText().split("/");
                start.set(Integer.parseInt(inforsstart[0]),Integer.parseInt(inforsstart[1]),Integer.parseInt(inforsstart[2]));

                Calendar end=new GregorianCalendar();
                String[] inforsend=startdatebox.getEditor().getText().split("/");
                end.set(Integer.parseInt(inforsend[0]),Integer.parseInt(inforsend[1]),Integer.parseInt(inforsend[2]));

                int priority = 0;
                switch (pribox.getValue()){
                    case "轻": priority = 1;break;
                    case "缓": priority = 2;break;
                    case "重": priority = 3;break;
                    case "急": priority = 4;break;
                    case "生死攸关": priority = 5;break;
                }
                ProjectClause temp = new ProjectClause(namefield.getText(),priority,start,end,typebox.getValue(),digestarea.getText(),htmltext.getHtmlText());
                if(!SharedState.isAdd&&!namefield.getText().equals(projectClause.getName())){
//                    ArrayList<String> nameList0 = new ArrayList<>();
//                    File[] files0 = new File(Directories.projectDirs).listFiles();
//                    for(File temp0 : files){
//                        nameList.add(temp.getName());
//                    }
//
//                    if(nameList.contains(namefield.getText())){
//                        new Alert(Alert.AlertType.WARNING,"The project name already exists.").showAndWait();
//                    }else {
                        projectClause.delete();
                        projectClause = temp;
//                    }
                }
                return true;
            }
        }
        return false;
    }

    private void setButtonStyle(Button... buttons){
        for(Button button:buttons){
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
        }
    }
}
