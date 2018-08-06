package com.mox.zenmoore.model;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Calendar;

public class RHRItem extends Model {

    private String content;

//    private boolean isDeveloped;
    /**
     * 说的是什么时候养成一个 RHR
     */
    private Calendar calendar;

    private int priority;

    private transient File rhrFile;

    public RHRItem(String content,Calendar calendar,int priority,String filename){
        this.content=content;
//        this.isDeveloped=false;
        this.calendar=calendar;
        this.priority=priority;
        this.filename=filename;

        File dir=new File(Directories.rhrDirs);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try{
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.rhrDirs+this.filename+Suffixs.rhrfix)))
            ){
                output.writeObject(this);
                this.rhrFile=new File(Directories.rhrDirs+this.filename+Suffixs.rhrfix);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public RHRItem(File rhrFile){
        this.rhrFile=rhrFile;

       try{
           try(
                   ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.rhrFile)))
           ){
                RHRItem item = (RHRItem) inputStream.readObject();
                this. filename= item.filename;
                this.content=item.getContent();
                this.priority = item.getPriority();
                this.calendar = item.getCalendar();
           }
       }catch (Exception ex){
           new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
       }
    }

    public String getContent() {
        return content;
    }

//    public boolean isDeveloped() {
//        return isDeveloped;
//    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getPriority() {
        return priority;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public void setDeveloped(boolean developed) {
//        isDeveloped = developed;
//    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * The former exists.I/O
     */
    @Override
    public void delete(){
        this.rhrFile.delete();
    }
}
