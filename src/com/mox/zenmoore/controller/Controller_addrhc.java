/**
 * Sample Skeleton for 'addrhc.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import com.mox.zenmoore.model.Directories;
import com.mox.zenmoore.model.RHCItem;
import com.mox.zenmoore.model.Suffixs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class Controller_addrhc extends Controller{

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

    @FXML // fx:id="label_dea"
    private Label label_dea; // Value injected by FXMLLoader

    @FXML // fx:id="label_pri"
    private Label label_pri; // Value injected by FXMLLoader

    @FXML // fx:id="label_nam"
    private Label label_nam; // Value injected by FXMLLoader

    @FXML // fx:id="text_2"
    private TextField text_2; // Value injected by FXMLLoader

    @FXML // fx:id="datepicker"
    private DatePicker datepicker; // Value injected by FXMLLoader

    @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader

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

    @FXML
    private TextArea information;

    private int priority=0;

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
            File[] files = new File(Directories.rhcDirs).listFiles();
            for(File temp : files){
                nameList.add(temp.getName());
            }

            if(nameList.contains((text_2.getText()+Suffixs.rhcfix))){
                new Alert(Alert.AlertType.ERROR,"The name already exists.").showAndWait();
                text_2.setText("");
                return;
            }else {
                Calendar calendar=new GregorianCalendar();
                String[] infors=datepicker.getEditor().getText().split("/");
                calendar.set(Integer.parseInt(infors[0]),Integer.parseInt(infors[1]),Integer.parseInt(infors[2]));
                new RHCItem(text_1.getText(),calendar,priority,text_2.getText(),information.getText());
            }

        }

        clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert text_1 != null : "fx:id=\"text_1\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert label_con != null : "fx:id=\"label_con\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert label_pri != null : "fx:id=\"label_pri\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert label_nam != null : "fx:id=\"label_nam\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert label_dea !=null : "fx:id=\"label_dea\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert text_2 != null : "fx:id=\"text_2\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert datepicker != null : "fx:id=\"datepicker\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert rb1 != null : "fx:id=\"rb1\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert group != null : "fx:id=\"group\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert rb3 != null : "fx:id=\"rb3\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert rb2 != null : "fx:id=\"rb2\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert rb4 != null : "fx:id=\"rb4\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert rb5 != null : "fx:id=\"rb5\" was not injected: check your FXML file 'addrhc.fxml'.";
        assert information != null : "fx:id=\"information\" was not injected: check your FXML file 'addrhc.fxml'.";

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

        datepicker.setValue(LocalDate.now().plusDays(21));
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(LocalDate.now().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #EEEEEE;");
                        }
                    }
                };
            }
        };

        datepicker.setDayCellFactory(dayCellFactory);

    }

    void clear(){
        text_1.setText("");
        text_2.setText("");
        if(group.getSelectedToggle()!=null){
            group.getSelectedToggle().setSelected(false);
        }
        datepicker.setValue(LocalDate.now().plusDays(21));
        information.setText("");
    }
}
