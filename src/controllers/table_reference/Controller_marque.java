package controllers.table_reference;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller_marque implements Initializable {
    @FXML
    private JFXButton close;
    @FXML
    private JFXListView designation_view;
    @FXML
    private JFXTextField designation;
    final ObservableList<String> liste = FXCollections.observableArrayList();
    @FXML
    public void fermer_fenetre(){
        Stage stage=(Stage) close.getScene().getWindow();
        stage.close();
        stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));

    }
    @FXML
    public void supprimer(){
        String S= String.valueOf(designation_view.getFocusModel().getFocusedItem());
        try {
            Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
            Statement Mystat = Myconn.createStatement();
            Mystat.executeQuery("DELETE from MARQUE WHERE designation='"+S+"'");
        }catch (Exception e){
            designation.setText("Erreur");
        }
        fill_list();
    }

    public void fill_list(){
        designation_view.getItems().clear();
        try {
            Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
            Statement Mystat = Myconn.createStatement();
            ResultSet MyRe = Mystat.executeQuery("select * from MARQUE ORDER BY ID DESC ");
            while (MyRe.next()) {
                liste.add(MyRe.getString("designation"));
            }
            designation_view.setItems(liste);
        } catch (Exception e) {

        }
    }


    @FXML
    public void inserer() throws SQLException,Exception {
        String S=designation.getText();
        if(S.equals("")){
            designation.setUnFocusColor(Paint.valueOf("red"));
        }else {
            designation.setUnFocusColor(Paint.valueOf("black"));
            Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
            Statement Mystat = Myconn.createStatement();
            String sql = "INSERT INTO EQUIPEMENT.MARQUE(DESIGNATION) VALUES\n" +
                    "('"+S+"')";
            Mystat.executeQuery(sql);
        }
        fill_list();
        designation.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fill_list();
    }
}

