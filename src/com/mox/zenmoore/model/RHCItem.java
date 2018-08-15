package com.mox.zenmoore.model;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Calendar;

public class RHCItem extends Item {

//    private boolean isDeveloped;
    /**
     * 说的是什么时候养成一个 RHC
     */
    private Calendar calendar;

    public RHCItem(String content, Calendar calendar, int priority, String filename, String information){
        this.setContent(content);
        this.setCalendar(calendar);
        this.setPriority(priority);
        this.setFilename(filename);
        this.setInformation(information);
        this.autoSetFile();
    }

    public RHCItem(File file){
        this.setFile(file);

       try{
           try(
                   ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.getFile())))
           ){
                RHCItem item = (RHCItem) inputStream.readObject();
                this.setFilename(item.getFilename());
                this.setContent(item.getContent());
                this.setPriority(item.getPriority());
                this.calendar = item.getCalendar();
                this.setInformation(item.getInformation());
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
        File dir=new File(Directories.rhcDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try{
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.rhcDirs +this.getFilename()+Suffixs.rhcfix)))
            ){
                output.writeObject(this);
                this.setFile(new File(Directories.rhcDirs +this.getFilename()+Suffixs.rhcfix));
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,"IOException.").showAndWait();
        }
    }
}
