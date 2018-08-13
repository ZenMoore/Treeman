package com.mox.zenmoore.model;

import java.io.File;

public abstract class Item extends Model{

    private String content;

    private int priority;

    private transient File file;

    private String filename;

    private String information;

    public String getInformation(){
        return information;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }

    public String getFilename(){
        return filename;
    }

    public File getFile(){
        return file;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public void setFile(File file){
        this.file = file;
    }

    public void setInformation(String information){
        this.information = information;
    }

    public abstract void autoSetFile();

    @Override
    public void delete(){
        this.file.delete();
    }
}
