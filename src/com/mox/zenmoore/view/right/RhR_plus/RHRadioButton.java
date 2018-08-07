package com.mox.zenmoore.view.right.RhR_plus;

import com.mox.zenmoore.model.Congratulations;
import com.mox.zenmoore.model.RHRItem;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

public class RHRadioButton extends RadioButton implements Cloneable{

    private RHRItem rhrItem;

    public RHRadioButton(RHRItem rhrItem){
        super();
        this.rhrItem=rhrItem;
        this.setText(this.rhrItem.getContent());

        this.setFont(Font.font(16));

        switch (this.rhrItem.getPriority()){
            case 1:this.setStyle("-fx-background-color: #FFFAFA;");break;
            case 2:this.setStyle("-fx-background-color: #FFF5EE;");break;
            case 3:this.setStyle("-fx-background-color: #FFEBCD");break;
            case 4:this.setStyle("-fx-background-color: #FFDAB9;");break;
            case 5:this.setStyle("-fx-background-color: #FFC0CB;");break;
        }

        setOnAction(e->{
            this.setText(Congratulations.RHRdeveloped);
            this.setDisable(true);
            this.rhrItem.delete();
        });
    }

    public RHRItem getRhrItem() {
        return rhrItem;
    }

}
