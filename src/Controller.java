import animations.FadeInLeftTransition;
import animations.FadeInLeftTransition1;
import animations.FadeInRightTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import animations.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import config.config2;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;


public class Controller implements Initializable {

    @FXML
    ImageView image_droit;
    Stage stage;
    @FXML
    private Circle cercle;
    @FXML
    private JFXTextField username;
    @FXML
    private Button test;
    @FXML
    private JFXPasswordField password;
    static config2 con = new config2();
    @FXML
    private ImageView user_image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            new FadeInLeftTransition1(user_image).play();
            new FadeInLeftTransition1(username).play();
            new FadeInLeftTransition1(password).play();
            new FadeInLeftTransition1(cercle).play();
            new FadeInRightTransition(image_droit, 1).play();
        });
    }

    @FXML
    private void enter(MouseEvent event) {
        config2 config = new config2();
        config.newStage2(stage, image_droit, "/views/formMenu.fxml", "", true, StageStyle.UNDECORATED, false);
    }


}
