package com.mox.zenmoore.view.right.Pro_plus;


import com.mox.zenmoore.model.ProjectClause;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

import java.io.File;
import java.util.Calendar;

public class ProCard extends TextArea {

    private ProjectClause projectClause;

    public ProCard(ProjectClause projectClause){
        super();

        this.setEditable(false);
        this.setWrapText(true);
        this.setCardStyle();
        this.setOnMouseClicked(e->{
            SharedState.isInfor = true;
            SharedState.isAdd = false;
            SharedState.projectClause = this.projectClause;
            new ProInfor().start();
        });

        this.projectClause = projectClause;
        String name = projectClause.getName();
        int level0 = projectClause.getLevel();
        String level = "null";
        switch (level0){
            case 1:level = "轻";break;
            case 2:level = "缓";break;
            case 3:level = "重";break;
            case 4:level = "急";break;
            case 5:level = "生死攸关";break;
        }
        Calendar startDate = projectClause.getStartDate();
        Calendar endDate = projectClause.getEndDate();
        ProjectClause.ProjectType type = projectClause.getType();
        String digest = projectClause.getDigest();
        this.setText(name+"\n"+"Level "+level+"  Type "+type.name()+
                "\nStart "+startDate.get(Calendar.YEAR)+"-"+startDate.get(Calendar.MONTH)+"-"+startDate.get(Calendar.DAY_OF_MONTH)
            +"  End "+endDate.get(Calendar.YEAR)+"-"+endDate.get(Calendar.MONTH)+"-"+endDate.get(Calendar.DAY_OF_MONTH)
            +"\nDigest: "+digest);

    }

    public ProjectClause getProjectClause() {
        return projectClause;
    }

    private void setCardStyle(){
        this.setFont(new Font("Consolas",15));
        this.setPrefHeight(150);
        this.setPrefWidth(575);
    }
}
