package com.mox.zenmoore.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class RHRItem extends Model {

    private String content;

//    private boolean isDeveloped;

    private Calendar calendar;

    private int priority;

    public RHRItem(String content,Calendar calendar,int priority,String filename){
        this.content=content;
//        this.isDeveloped=false;
        this.calendar=calendar;
        this.priority=priority;
        this.filename=filename;
        
        try{
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.rhrDirs+this.filename)));
            ){
                output.writeObject(this);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
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
    public void refresh(){
        new File(Directories.rhrDirs+filename).delete();
    }
}
