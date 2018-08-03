/**
 * Sample Skeleton for 'ad.fxml' Controller Class
 */

package com.mox.zenmoore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Controller_ad extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private TabPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="matab"
    private Tab matab; // Value injected by FXMLLoader

    @FXML // fx:id="pane_ma"
    private AnchorPane pane_ma; // Value injected by FXMLLoader

    @FXML // fx:id="mediaview"
    private MediaView mediaview; // Value injected by FXMLLoader

    @FXML // fx:id="patab"
    private Tab patab; // Value injected by FXMLLoader

    @FXML // fx:id="pane_pa"
    private AnchorPane pane_pa; // Value injected by FXMLLoader

    @FXML // fx:id="imageview"
    private ImageView imageview; // Value injected by FXMLLoader

    @FXML // fx:id="textarea_pa"
    private TextArea textarea_pa; // Value injected by FXMLLoader

    @FXML // fx:id="tatab"
    private Tab tatab; // Value injected by FXMLLoader

    @FXML // fx:id="pane_ta"
    private AnchorPane pane_ta; // Value injected by FXMLLoader

    @FXML // fx:id="textarea_ta"
    private TextArea textarea_ta; // Value injected by FXMLLoader

    //是找不到视频即视频地址错误的情况
    public static final String errorMedia="file:media/error.flv";

    public static final String normalMedia="file:media/mediaAd.flv";

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'ad.fxml'.";
        assert matab != null : "fx:id=\"matab\" was not injected: check your FXML file 'ad.fxml'.";
        assert pane_ma != null : "fx:id=\"pane_ma\" was not injected: check your FXML file 'ad.fxml'.";
        assert mediaview != null : "fx:id=\"mediaview\" was not injected: check your FXML file 'ad.fxml'.";
        assert patab != null : "fx:id=\"patab\" was not injected: check your FXML file 'ad.fxml'.";
        assert pane_pa != null : "fx:id=\"pane_pa\" was not injected: check your FXML file 'ad.fxml'.";
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'ad.fxml'.";
        assert textarea_pa != null : "fx:id=\"textarea_pa\" was not injected: check your FXML file 'ad.fxml'.";
        assert tatab != null : "fx:id=\"tatab\" was not injected: check your FXML file 'ad.fxml'.";
        assert pane_ta != null : "fx:id=\"pane_ta\" was not injected: check your FXML file 'ad.fxml'.";
        assert textarea_ta != null : "fx:id=\"textarea_ta\" was not injected: check your FXML file 'ad.fxml'.";

        try{
            Media media=new Media(Controller_ad.normalMedia);
            MediaPlayer player=new MediaPlayer(media);
            mediaview.setMediaPlayer(player);
        }catch (Exception ex){
//            mediaview.setMediaPlayer(new MediaPlayer(new Media(Controller_ad.errorMedia)));
            ex.printStackTrace();
        }
    }
}
