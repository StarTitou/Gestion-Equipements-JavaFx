package controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Warning_Dialog implements Initializable {
    @FXML
    private Button close_w;
    static double xOffset = 0;
    static double yOffset = 0;
    public static Integer Id_Four;
    Controller_fournisseur controller;
    public static void Warning()throws Exception {
        //define your offsets here

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Warning_Dialog.class.getResource("../views/Warning.fxml"));
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
    public void close_warning(){
        Stage stage=(Stage) close_w.getScene().getWindow();
        stage.close();
        stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
    }
    @FXML public void supprimer() throws Exception{
        Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
        Statement Mystat = Myconn.createStatement();
        Mystat.executeQuery("DELETE FROM FOURNISSEUR WHERE ID_FOURNISSEUR="+String.valueOf(Id_Four));
        close_warning();


    }

    public void initialize(URL url, ResourceBundle rb) {
    }
}
