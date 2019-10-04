package models;

import controllers.Warning_Dialog;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;

public class Fournisseur {
    private SimpleIntegerProperty fournisseurID;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty mail;
    private SimpleStringProperty adresse;
    private SimpleStringProperty telephone;
    private SimpleStringProperty ville;

    public SimpleIntegerProperty getFournisseurID() {
        return fournisseurID;
    }

    public void setFournisseurID(Integer fournisseurID) {
        this.fournisseurID = getFournisseurID();
    }

    public SimpleStringProperty getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = getNom();
    }

    public SimpleStringProperty getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = getPrenom();
    }

    public SimpleStringProperty getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = getMail();
    }

    public SimpleStringProperty getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = getAdresse();
    }

    public SimpleStringProperty getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = getTelephone();
    }

    public SimpleStringProperty getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = getVille();
    }

    public Fournisseur(Integer fournisseurID, String nom, String prenom, String mail, String adresse, String telephone, String ville) {
        this.fournisseurID = new SimpleIntegerProperty(fournisseurID);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.mail = new SimpleStringProperty(mail);
        this.adresse = new SimpleStringProperty(adresse);
        this.telephone = new SimpleStringProperty(telephone);
        this.ville = new SimpleStringProperty(ville);
    }

    public Fournisseur(String nom, String prenom, String mail, String adresse, String telephone, String ville) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.mail = new SimpleStringProperty(mail);
        this.adresse = new SimpleStringProperty(adresse);
        this.telephone = new SimpleStringProperty(telephone);
        this.ville = new SimpleStringProperty(ville);
    }

    public Fournisseur() {}
    public Fournisseur(Integer fournisseurID) {
        this.fournisseurID = new SimpleIntegerProperty(fournisseurID);
    }


    @Override
    public String toString() {
        return "Fournisseur{" +
                "fournisseurID=" + fournisseurID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    public void sendToDataBase() throws SQLException,Exception {
        if(getPrenom().getValue().equals("")||getNom().getValue().equals("")||getMail().getValue().equals("")||getVille().getValue().equals("")||getAdresse().getValue().equals("")||getTelephone().getValue().equals("")){
            Warning_Dialog.Warning();
        }else {
            Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
            Statement Mystat = Myconn.createStatement();
            String sql = "INSERT INTO EQUIPEMENT.FOURNISSEUR( NOM, PRENOM, MAIL, VILLE, ADRESSE, TELEPHONE) VALUES" +
                    "('" + getNom().getValue() + "', '" + getPrenom().getValue() + "', '" + getMail().getValue() + "', '" + getVille().getValue() + "', '" + getAdresse().getValue() + "', '" + getTelephone().getValue() + "')";
            Mystat.executeQuery(sql);
        }
    }

    public void deletFromDataBase() throws SQLException,Exception{
        Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
        Statement Mystat = Myconn.createStatement();
        Mystat.executeQuery("DELETE FROM FOURNISSEUR WHERE ID_FOURNISSEUR="+String.valueOf(getFournisseurID().getValue()));
    }
    public void ModifyDataBase() throws SQLException,Exception{
        Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "equipement", "123");
        Statement Mystat = Myconn.createStatement();
        Mystat.executeQuery("UPDATE FOURNISSEUR SET NOM='" + getNom().getValue()
                + "' , PRENOM='"+ getPrenom().getValue()
                + "' ,  MAIL='" + getMail().getValue()
                + "'  , VILLE='" + getVille().getValue()
                + "'  , ADRESSE ='" + getAdresse().getValue()
                + "'  , TELEPHONE='" + getTelephone().getValue()
                + "' WHERE ID_FOURNISSEUR="+getFournisseurID().getValue());
    }
}
