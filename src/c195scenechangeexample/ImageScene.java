/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c195scenechangeexample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amy.antonucci
 */
public class ImageScene implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    private Button btnBack;

    @FXML
    void displayMain(ActionEvent event) {
      Parent main = null;
        try {
            main = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(main);

            Stage stage = C195SceneChangeExample.getStage();
            
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if  (Main.isTrek())
        image.setImage(new Image("c195scenechangeexample/startrek.jpg"));
        else
            image.setImage(new Image("c195scenechangeexample/starwars.jpeg"));
    }

}
