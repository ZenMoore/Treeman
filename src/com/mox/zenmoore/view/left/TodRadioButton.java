package com.mox.zenmoore.view.left;

import com.mox.zenmoore.model.Congratulations;
import com.mox.zenmoore.model.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

import java.util.Calendar;
import java.util.Optional;

public class TodRadioButton extends RadioButton implements Cloneable {
    private Task task;
    
    public TodRadioButton(Task task){
        super();
        this.task=task;
        this.setText(this.task.getContent());

        this.setFont(Font.font(16));

        switch (this.task.getPriority()){
            case 1:this.setStyle("-fx-background-color: #FFFAFA;");break;
            case 2:this.setStyle("-fx-background-color: #FFF5EE;");break;
            case 3:this.setStyle("-fx-background-color: #FFEBCD");break;
            case 4:this.setStyle("-fx-background-color: #FFDAB9;");break;
            case 5:this.setStyle("-fx-background-color: #FFC0CB;");break;
        }

        setOnAction(e->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure it's finished?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                this.setText(Congratulations.taskFinish);
                this.setDisable(true);
                this.task.delete();
            }else{
                this.setSelected(false);
            }
        });

        setOnMouseClicked(e->{
            if(e.getButton().equals(MouseButton.SECONDARY)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,this.task.getFilename()
                        +": "+ "\n"+this.task.getInformation());
                alert.setHeaderText("信息");
                alert.setTitle("信息");
                alert.showAndWait();
            }
        });
    }

    public Task getTask() {
        return task;
    }
}
