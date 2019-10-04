package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Erreur_Dialog {
    @FXML
    private Button close_w;
    static double xOffset = 0;
    static double yOffset = 0;
    public static void Erreur()throws Exception {
        //define your offsets here

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Erreur_Dialog.class.getResource("../views/Erreur.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void close_erreur(){
        Stage stage=(Stage) close_w.getScene().getWindow();
        stage.close();
    }

}
