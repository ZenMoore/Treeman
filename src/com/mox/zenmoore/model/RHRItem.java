package com.mox.zenmoore.model;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Calendar;

public class RHRItem extends Item {

//    private boolean isDeveloped;
    /**
     * 说的是什么时候养成一个 RHR
     */
    private Calendar calendar;

    public RHRItem(String content,Calendar calendar,int priority,String filename){
        this.setContent(content);
        this.setCalendar(calendar);
        this.setPriority(priority);
        this.setFilename(filename);
        this.autoSetFile();
    }

    public RHRItem(File file){
        this.setFile(file);

       try{
           try(
                   ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.getFile())))
           ){
                RHRItem item = (RHRItem) inputStream.readObject();
                this.setFilename(item.getFilename());
                this.setContent(item.getContent());
                this.setPriority(item.getPriority());
                this.calendar = item.getCalendar();
           }
       }catch (Exception ex){
           new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
       }
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void autoSetFile(){
        File dir=new File(Directories.rhrDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try{
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.rhrDirs+this.getFilename()+Suffixs.rhrfix)))
            ){
                output.writeObject(this);
                this.setFile(new File(Directories.rhrDirs+this.getFilename()+Suffixs.rhrfix));
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,"IOException.").showAndWait();
        }
    }
}
