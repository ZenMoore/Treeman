package com.mox.zenmoore.view.right.RhR_plus;

import com.mox.zenmoore.model.Congratulations;
import com.mox.zenmoore.model.RHRItem;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

import java.io.File;

public class RHRadioButton extends RadioButton implements Cloneable{

    private RHRItem rhrItem;

    public RHRadioButton(RHRItem rhrItem){
        super();
        this.rhrItem=rhrItem;
        this.setText(this.rhrItem.getContent());

        this.setFont(Font.font(20));
        this.setStyle("-fx-background-color: #FFFAFA;");

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
