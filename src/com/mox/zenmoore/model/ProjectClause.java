package com.mox.zenmoore.model;

import javafx.scene.image.Image;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjectClause extends Model implements Serializable {

    private String name;
    private int level;
    private String startDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String endDate;
    private ProjectType type;
    private transient File file;



    @Override
    public void delete(){

    }

    private enum ProjectType{
        R, //RHC Collection
        T, //task or goal deployment
        M, //solution to problems
        O, //self-drive solution
        L, //analysis or evaluation model
        E, //experiment (tentative)
        I  //new thought
    }
}
