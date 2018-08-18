package com.mox.zenmoore.view.right;

import com.mox.zenmoore.model.NotionArticle;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Notion extends Stage {

    public void start(){
        try{
            Desktop.getDesktop().open(NotionArticle.getFile());
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,"Cannot find the file \"notion.docx\".").showAndWait();
        }
    }
}
