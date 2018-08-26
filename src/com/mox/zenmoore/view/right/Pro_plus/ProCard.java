package com.mox.zenmoore.view.right.Pro_plus;


import com.mox.zenmoore.model.ProjectClause;
import javafx.scene.control.TextArea;

import java.io.File;
import java.util.Calendar;

public class ProCard extends TextArea {

    private ProjectClause projectClause;

    public ProCard(ProjectClause projectClause){
        super();

        this.setEditable(false);
        this.setWrapText(true);
        this.setOnMouseClicked(e->{
            SharedState.isInfor = true;
            SharedState.isAdd = false;
            SharedState.projectClause = this.projectClause;
            new ProInfor().start();
        });

        this.projectClause = projectClause;
        String name = projectClause.getName();
        int level = projectClause.getLevel();
        Calendar startDate = projectClause.getStartDate();
        Calendar endDate = projectClause.getEndDate();
        ProjectClause.ProjectType type = projectClause.getType();
        String digest = projectClause.getDigest();
        this.setText(name+"\n"+"Level "+level+"\tType "+type.name()+
                "\tStart_Date "+startDate.get(Calendar.YEAR)+"-"+startDate.get(Calendar.MONTH)+"-"+startDate.get(Calendar.DAY_OF_MONTH)
            +"\tEnd_Date "+endDate.get(Calendar.YEAR)+"-"+endDate.get(Calendar.MONTH)+"-"+endDate.get(Calendar.DAY_OF_MONTH)
            +"\nDigest: "+digest);

    }

    public ProjectClause getProjectClause() {
        return projectClause;
    }


}
