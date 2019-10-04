/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class config2 {
    public static Stage glbl_st=null;
    //define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;

    public config2() {
    }

    public static void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    public void newStage(Stage stage, Label lb, String load, String judul, boolean resize, StageStyle style, boolean maximized) {
        try {

            Stage st = new Stage();
            stage = (Stage) lb.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(load));
            Scene scene = new Scene(root);
            glbl_st=st;
            st.initStyle(style);
            st.setResizable(resize);
            st.setMaximized(maximized);
            st.setTitle(judul);
            st.setScene(scene);
            st.show();
            stage.close();
        } catch (Exception e) {
        }
    }

    public void newStage2(Stage stage, ImageView lb, String load, String judul, boolean resize, StageStyle style, boolean maximized) {
        try {
            Stage st = new Stage();
            stage = (Stage) lb.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(load));
            Scene scene = new Scene(root);
            st.initStyle(style);
            st.setResizable(resize);
            st.setMaximized(maximized);
            st.setTitle(judul);

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    st.setX(event.getScreenX() - xOffset);
                    st.setY(event.getScreenY() - yOffset);
                }
            });
            st.setScene(scene);
            //st.setMaximized(true);
            st.show();
            stage.close();
        } catch (Exception e) {
        }
    }

    public void loadAnchorPane(StackPane ap, String a) {
        try {
            AnchorPane p = FXMLLoader.load(getClass().getResource("/views/" + a));
            ap.getChildren().setAll(p);
        } catch (IOException e) {
        }
    }

    public static void setModelColumn(TableColumn tb, String a) {
        tb.setCellValueFactory(new PropertyValueFactory(a));
    }
}
