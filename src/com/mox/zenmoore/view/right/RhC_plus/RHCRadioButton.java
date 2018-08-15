package com.mox.zenmoore.view.right.RhC_plus;

import com.mox.zenmoore.model.Congratulations;
import com.mox.zenmoore.model.RHCItem;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

import java.util.Calendar;

public class RHCRadioButton extends RadioButton implements Cloneable{

    private RHCItem RHCItem;

    public RHCRadioButton(RHCItem RHCItem){
        super();
        this.RHCItem = RHCItem;
        this.setText(this.RHCItem.getContent());

        this.setFont(Font.font(16));

        switch (this.RHCItem.getPriority()){
            case 1:this.setStyle("-fx-background-color: #FFFAFA;");break;
            case 2:this.setStyle("-fx-background-color: #FFF5EE;");break;
            case 3:this.setStyle("-fx-background-color: #FFEBCD");break;
            case 4:this.setStyle("-fx-background-color: #FFDAB9;");break;
            case 5:this.setStyle("-fx-background-color: #FFC0CB;");break;
        }

        setOnAction(e->{
               this.setText(Congratulations.RHCdeveloped);
               this.setDisable(true);
               this.RHCItem.delete();
        });

        setOnMouseClicked(e->{
            if(e.getButton().equals(MouseButton.SECONDARY)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,this.RHCItem.getFilename()
                +": "+this.RHCItem.getCalendar().get(Calendar.YEAR)+"-"+this.RHCItem.getCalendar().get(Calendar.MONTH)
                        +"-"+this.RHCItem.getCalendar().get(Calendar.DATE)+
                        "\n"+this.RHCItem.getInformation());
                alert.setHeaderText("信息");
                alert.setTitle("信息");
                alert.showAndWait();
            }
        });
    }

    public RHCItem getRHCItem() {
        return RHCItem;
    }
}
