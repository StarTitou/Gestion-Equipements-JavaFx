package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Fournisseur;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class  Controller_modif_fourn implements Initializable {
    public static String Nom,Prenom,Telephone,Adresse,Ville,Mail;
    public static Integer Id_Four;
    @FXML
    private  Button close_w;
    @FXML
    private  JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField telephone;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField ville;
    @FXML
    private JFXTextField mail;
    @FXML
    private ImageView imageV;
    BufferedImage image=null;
    InputStream fis=null;


    @FXML
    public void close_warning(){
        Stage stage=(Stage) close_w.getScene().getWindow();
        stage.close();
        stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML public void modifier() throws Exception{
        Fournisseur f = new Fournisseur(Id_Four,nom.getText(), prenom.getText(), mail.getText(), adresse.getText(), telephone.getText(), ville.getText());
        f.ModifyDataBase();
        close_warning();

    }


    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            nom.setText(Nom);
            prenom.setText(Prenom);
            telephone.setText(Telephone);
            adresse.setText(Adresse);
            ville.setText(Ville);
            mail.setText(Mail);
            /*
            try {
                Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
                Statement Mystat = Myconn.createStatement();
                ResultSet MyRe = Mystat.executeQuery("SELECT photo FROM IMAGE WHERE IDvSSEUR=10" );
                fis=MyRe.getBinaryStream(0);
                image=javax.imageio.ImageIO.read(fis);
                Image foto= SwingFXUtils.toFXImage(image,null);
                imageV.setImage(foto);
            }catch(Exception e){
                new Alert(Alert.AlertType.WARNING);
            }
            */

        }
        );

    }
}
