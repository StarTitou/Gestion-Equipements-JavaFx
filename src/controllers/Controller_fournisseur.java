package controllers;

import animations.FadeInRightTransition;
import config.config2;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import models.Fournisseur;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;


import javafx.scene.layout.AnchorPane;

public class Controller_fournisseur implements Initializable {
    @FXML
    private AnchorPane paneTabel;
    @FXML
    private AnchorPane paneCrud;
    @FXML
    private AnchorPane paneCrud1;
    @FXML
    private Button btnNew1;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField ville;
    @FXML
    private TextField mail;
    @FXML
    private TextField adresse;
    @FXML
    public TableView<Fournisseur> tableData;
    @FXML
    private TableColumn<Fournisseur, String> Nom;
    @FXML
    private TableColumn<Fournisseur, String> Prenom;
    @FXML
    private TableColumn<Fournisseur, String> Mail;
    @FXML
    private TableColumn<Fournisseur, String> Ville;
    @FXML
    private TableColumn<Fournisseur, String> Adresse;
    @FXML
    private TableColumn<Fournisseur, Integer> id_fourn;
    @FXML
    private ListView liste_fournisseur;
    @FXML
    private TableColumn<Fournisseur, String> Telephone;
    final ObservableList<Fournisseur> fourn = FXCollections.observableArrayList();
    @FXML
    private Button close_w;
    @FXML
    private Label label;
    @FXML
    private void show_add_fournisseur() {
        new FadeInRightTransition(paneCrud, 1).play();
    }

    @FXML
    private void ajouter_fournisseur() throws SQLException,Exception {
        Fournisseur f = new Fournisseur(nom.getText(), prenom.getText(), mail.getText(), adresse.getText(), telephone.getText(), ville.getText());
        f.sendToDataBase();
        clear();
        new FadeInRightTransition(paneCrud1, 1).play();
        fill_table();
        paneCrud.setOpacity(0);
        paneCrud1.setOpacity(0);
    }

    private void clear() {
        nom.setText("");
        prenom.setText("");
        mail.setText("");
        adresse.setText("");
        telephone.setText("");
        ville.setText("");
    }

    private List<Fournisseur> parseUserList() {
        // parse and construct User datamodel list by looping your ResultSet rs
        // and return the list
        return null;
    }
    private double xOffset = 0;
    private double yOffset = 0;

    public void modifier() throws Exception{

        Fournisseur fourni=tableData.getFocusModel().getFocusedItem();
        Stage st = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/Detail_fournisseur_modif.fxml"));
        Controller_modif_fourn.Nom=fourni.getNom().getValue();
        Controller_modif_fourn.Prenom=fourni.getPrenom().getValue();
        Controller_modif_fourn.Ville=fourni.getVille().getValue();
        Controller_modif_fourn.Adresse=fourni.getAdresse().getValue();
        Controller_modif_fourn.Telephone=fourni.getTelephone().getValue();
        Controller_modif_fourn.Mail=fourni.getMail().getValue();
        Controller_modif_fourn.Id_Four=fourni.getFournisseurID().getValue();
        Scene scene = new Scene(root);
        st.initStyle(StageStyle.TRANSPARENT);
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
                st.setX(event.getScreenX() - xOffset);
                st.setY(event.getScreenY() - yOffset);
            }
        });
        st.setScene(scene);
        st.show();

        st.setOnCloseRequest(event ->{
            this.fill_table();
        });
    }


    @FXML
    public void supprimer_fournisseur() throws Exception{
        Stage st = new Stage();
        Fournisseur FR=tableData.getFocusModel().getFocusedItem();
        Warning_Dialog.Id_Four=FR.getFournisseurID().getValue();
        Parent a = FXMLLoader.load(getClass().getResource("../views/Warning_sup.fxml"));


        st.initModality(Modality.APPLICATION_MODAL);
        st.initOwner(tableData.getScene().getWindow());


        Scene scene = new Scene(a);
        st.initStyle(StageStyle.UNDECORATED);
        st.setScene(scene);
        st.show();
        st.setOnCloseRequest(event ->{
            this.fill_table();
        });

    }



    public void fill_table() {
        this.Nom.setCellValueFactory(cellData -> cellData.getValue().getNom());
        this.Prenom.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
        this.Adresse.setCellValueFactory(cellData -> cellData.getValue().getAdresse());
        this.Mail.setCellValueFactory(cellData -> cellData.getValue().getMail());
        this.Ville.setCellValueFactory(cellData -> cellData.getValue().getVille());
        this.Telephone.setCellValueFactory(cellData -> cellData.getValue().getTelephone());
        this.id_fourn.setCellValueFactory(cellData -> cellData.getValue().getFournisseurID().asObject());
        this.tableData.getItems().clear();
        Fournisseur fournisseur = null;
        try {
           Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");

            Statement Mystat = Myconn.createStatement(); 
            ResultSet MyRe = Mystat.executeQuery("select * from fournisseur ORDER BY id_fournisseur ASC");
            while (MyRe.next()) {
                fournisseur = new Fournisseur(
                        MyRe.getInt("id_fournisseur"),
                        MyRe.getString("nom"),
                        MyRe.getString("prenom"),
                        MyRe.getString("mail"),
                        MyRe.getString("adresse"),
                        MyRe.getString("telephone"),
                        MyRe.getString("ville")

                );
                fourn.add(fournisseur);
                //liste_fournisseur.getItems().add(fournisseur.toString());

            }
            this.tableData.setItems(fourn);
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        fill_table();

        tableData.setRowFactory(tv->{
            TableRow<Fournisseur> row =new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    try {
                        modifier();
                    }catch(Exception e){

                    }
                }
                    }

            );

       return row; });
    }
}
