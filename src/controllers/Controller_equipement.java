package controllers;

import animations.FadeInLeftTransition1;
import animations.FadeInRightTransition;
import config.config2;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import models.Fournisseur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller_equipement implements Initializable {

    @FXML
    private AnchorPane paneCrud;
    @FXML
    private AnchorPane paneTabel;

    @FXML
    private Button btnNew1;

    @FXML
    private ComboBox etat;

    @FXML
    private ComboBox model;

    @FXML
    private ComboBox type;

    @FXML
    private ComboBox service;

    @FXML
    private ComboBox categorie;

    @FXML
    private ComboBox systeme;

    @FXML
    private TextField numserie;

    @FXML
    private TextField adressMac;

    @FXML
    private TextField caracteristique;

    @FXML
    private TextField description;

    @FXML
    private ComboBox marque;

    @FXML
    private TextField ipAdress;

    @FXML
    private TextField passerelle;

    @FXML
    private TextField Mask;

    @FXML
    private void show_add_equipement() throws Exception{
        new FadeInRightTransition(paneCrud, 1).play();
        //Erreur_Dialog.Erreur();
    }

    @FXML
    private void ajouter_equipement() throws SQLException {

    }
    double xOffset = 0;
    double yOffset = 0;
    public void fenetre(String chemin) throws Exception{


        Stage st= new Stage();
        Parent a = FXMLLoader.load(getClass().getResource("../views/table_reference/"+chemin+".fxml"));
        Scene scene = new Scene(a);
        st.initStyle(StageStyle.UNDECORATED);
        st.setScene(scene);
        a.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        a.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                st.setX(event.getScreenX() - xOffset);
                st.setY(event.getScreenY() - yOffset);
            }
        });

        st.show();
        st.setOnCloseRequest(event ->{
            init();
        });}
    @FXML
    private void ajouter_etat()throws Exception{
        fenetre("etat");
    }
    @FXML
    private void ajouter_type()throws Exception{
        fenetre("type");
    }
    @FXML
    private void ajouter_model()throws Exception{
     fenetre("model_equipement");
    }
    @FXML
    private void ajouter_systeme()throws Exception{
        fenetre("systeme");
    }
    @FXML
    private void ajouter_categorie()throws Exception{
       fenetre("categorie");
    }
    @FXML
    private void ajouter_marque()throws Exception{
        fenetre("marque");
    }

    public void init(){
        final ObservableList<String> liste_etat = FXCollections.observableArrayList();
        final ObservableList<String> liste_model = FXCollections.observableArrayList();
        final ObservableList<String> liste_type = FXCollections.observableArrayList();
        final ObservableList<String> liste_marque = FXCollections.observableArrayList();
        final ObservableList<String> liste_categorie = FXCollections.observableArrayList();
        final ObservableList<String> liste_systeme = FXCollections.observableArrayList();
        try {
            Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");

            Statement Mystat = Myconn.createStatement();
            ResultSet MyRe_Etat = Mystat.executeQuery("select * from Etat ORDER BY id ASC");
            while (MyRe_Etat.next()) {
                liste_etat.add(MyRe_Etat.getString("designation"));
            }
            ResultSet MyRe_Model = Mystat.executeQuery("select * from Model ORDER BY id ASC");
            while (MyRe_Model.next()) {
                liste_model.add(MyRe_Model.getString("designation"));
            }
            ResultSet MyRe_Type = Mystat.executeQuery("select * from Type ORDER BY id ASC");
            while (MyRe_Type.next()) {
                liste_type.add(MyRe_Type.getString("designation"));
            }
            ResultSet MyRe_Marque = Mystat.executeQuery("select * from Marque ORDER BY id ASC");
            while (MyRe_Marque.next()) {
                liste_marque.add(MyRe_Marque.getString("designation"));
            }
            ResultSet MyRe_Categorie = Mystat.executeQuery("select * from Categorie ORDER BY id ASC");
            while (MyRe_Categorie.next()) {
                liste_categorie.add(MyRe_Categorie.getString("designation"));
            }
            ResultSet MyRe_Systeme = Mystat.executeQuery("select * from Systeme ORDER BY id ASC");
            while (MyRe_Systeme.next()) {
                liste_systeme.add(MyRe_Systeme.getString("designation"));
            }

        } catch (Exception e) {

        }
    model.setItems(liste_model);
    model.getSelectionModel().selectLast();
    type.setItems(liste_type);
    type.getSelectionModel().selectLast();
    systeme.setItems(liste_systeme);
    systeme.getSelectionModel().selectLast();
    marque.setItems(liste_marque);
    marque.getSelectionModel().selectLast();
    categorie.setItems(liste_categorie);
    categorie.getSelectionModel().selectLast();
    etat.setItems(liste_etat);
    etat.getSelectionModel().selectLast();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }


}
