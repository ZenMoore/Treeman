package com.mox.zenmoore.model;

import javafx.scene.control.Alert;

import java.io.*;

public class Task extends Item{

    public Task(String filename,String content,int priority){
            this.setContent(content);
            this.setFilename(filename);
            this.setPriority(priority);
            this.autoSetFile();
    }

    public Task(File file){
        this.setFile(file);

        try{
            try(
                    ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.getFile())))
            ){
                Task item = (Task) inputStream.readObject();
                this.setFilename(item.getFilename());
                this.setContent(item.getContent());
                this.setPriority(item.getPriority());
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
        }
    }

    @Override
    public void autoSetFile(){
        try{
            File dir=new File(Directories.taskDirs);
            if(!dir.exists()){
                dir.mkdirs();
            }

            try(
                    ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Directories.taskDirs+this.getFilename()+Suffixs.taskfix)));
            ){
                output.writeObject(this);
                this.setFile(new File(Directories.taskDirs+this.getFilename()+Suffixs.taskfix));
            }
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,"IOException.").showAndWait();
        }
    }

}
