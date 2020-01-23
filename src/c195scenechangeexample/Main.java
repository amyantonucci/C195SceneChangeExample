/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c195scenechangeexample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author amy.antonucci
 */
public class Main implements Initializable {

    @FXML
    private RadioButton rdoTrek;

    @FXML
    private RadioButton rdoWars;

    static boolean isTrek = false;

    @FXML
    void handleTrek(ActionEvent event) {
        isTrek = true;
        handleSceneChange();
    }

    @FXML
    void handleWars(ActionEvent event) {
        isTrek = false;
        handleSceneChange();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you ready to answer an important question?", ButtonType.OK);
        alert.showAndWait()
                .filter(res -> res == ButtonType.OK)
                .ifPresent(res -> System.out.println("User reports ready!"));

    }

    private void handleSceneChange() {
        Parent main = null;
        try {
            main = FXMLLoader.load(getClass().getResource("ImageScene.fxml"));
            Scene scene = new Scene(main);

            Stage stage = C195SceneChangeExample.getStage();
            
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isTrek() {
        return isTrek;
    }

}
