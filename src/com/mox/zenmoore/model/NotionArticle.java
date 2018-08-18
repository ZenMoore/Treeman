package com.mox.zenmoore.model;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileOutputStream;

public class NotionArticle extends Model {
    private static File file;

    static {
        file = new File(Directories.notionDirs + "notion.docx");
    }

    public static File getFile() {
        if(!file.exists()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeight(400);
            alert.setContentText("Sorry, your \"notion.docx\" was deleted.\n " +
                    "Please create a \"notion.docx\" and put it in the direcrtory:\n" +
                    file.getAbsolutePath()+
                    "\nWhen you have **created it** and **put it right**, click \"确定\""+
            "\nWe are sorry to cause inconvenience  to you.");
            alert.showAndWait();
        }
        return file;
    }

    @Override
    public void delete(){
        this.file.delete();
    }
}
