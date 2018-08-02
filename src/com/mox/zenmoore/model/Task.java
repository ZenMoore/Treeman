package com.mox.zenmoore.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Task extends Model{

//    private boolean isFinished;
    private String content;

    public Task(String filename,String content){
        try{
//            this.isFinished=false;
            this.content=content;
            this.filename=filename;
            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.taskDirs+this.filename)));
            ){
                output.writeObject(this);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void refresh(){
        new File(Directories.taskDirs+filename).delete();
    }

}
