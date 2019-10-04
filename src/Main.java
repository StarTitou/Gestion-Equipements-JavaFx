import connection.ConnectionConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
    public static Stage w;
    public static Connection Myconn;
    //define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
        w = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("views/Login.fxml"));
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
                w.setX(event.getScreenX() - xOffset);
                w.setY(event.getScreenY() - yOffset);
            }
        });
        w.setScene(new Scene(root));
        w.initStyle(StageStyle.UNDECORATED);
        w.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
