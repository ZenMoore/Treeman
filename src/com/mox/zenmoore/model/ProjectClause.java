package com.mox.zenmoore.model;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ProjectClause extends Model implements Serializable {

    private String name;
    private int level;
    private Calendar startDate;
    private Calendar endDate;
    private ProjectType type;
    private String digest;
    private String content;
    private transient File file;

    public ProjectClause(String name,int level,Calendar startDate,Calendar endDate,ProjectType type,String digest,String content){
        this.name = name;
        this.level = level;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.digest = digest;
        this.content = content;
        this.autosetfile();
    }

    public ProjectClause(File file){
        this.file = file;

        try{
            try(
                    ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.file)))
            ){
                ProjectClause temp = (ProjectClause) inputStream.readObject();
                this.name = temp.name;
                this.level = temp.level;
                this.startDate = temp.startDate;
                this.endDate = temp.endDate;
                this.type = temp.type;
                this.digest = temp.digest;
                this.content = temp.content;
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
        }
    }

    public Calendar getEndDate() {
        return endDate;
    }

    @Override
    public void delete(){
        this.file.delete();

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

    public void autosetfile(){
        File dir=new File(Directories.projectDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try{
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.projectDirs +this.name+Suffixs.projectfix)))
            ){
                output.writeObject(this);
                this.file = new File(Directories.projectDirs +this.name+Suffixs.projectfix);
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,"IOException.").showAndWait();
        }
    }
}
