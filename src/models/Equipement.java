package models;

import controllers.Warning_Dialog;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipement {

    private SimpleIntegerProperty equipementID;
    private SimpleStringProperty numSerie;
    private SimpleStringProperty adressMac;
    private SimpleStringProperty model;
    private SimpleStringProperty etat;
    private SimpleStringProperty caracteristique;
    private SimpleStringProperty description;
    private SimpleStringProperty type;
    private SimpleStringProperty service;
    private SimpleStringProperty marque;
    private SimpleStringProperty adressIp;
    private SimpleStringProperty passerellePD;
    private SimpleStringProperty masque;
    private SimpleStringProperty categorie;
    private SimpleStringProperty systeme;

    public Equipement() {
    }

    public Equipement(Integer equipementID, String numSerie, String adressMac, String model, String etat, String caracteristique, String description, String type, String service, String marque, String adressIp, String passerellePD, String masque, String categorie, String systeme) {
        this.equipementID = new SimpleIntegerProperty(equipementID);
        this.numSerie = new SimpleStringProperty(numSerie);
        this.adressMac = new SimpleStringProperty(adressMac);
        this.model = new SimpleStringProperty(model);
        this.etat = new SimpleStringProperty(etat);
        this.caracteristique = new SimpleStringProperty(caracteristique);
        this.description = new SimpleStringProperty(description);
        this.type = new SimpleStringProperty(type);
        this.service = new SimpleStringProperty(service);
        this.marque = new SimpleStringProperty(marque);
        this.adressIp = new SimpleStringProperty(adressIp);
        this.passerellePD = new SimpleStringProperty(passerellePD);
        this.masque = new SimpleStringProperty(masque);
        this.categorie = new SimpleStringProperty(categorie);
        this.systeme = new SimpleStringProperty(systeme);
    }

    public int getEquipementID() {
        return equipementID.get();
    }

    public SimpleIntegerProperty equipementIDProperty() {
        return equipementID;
    }

    public void setEquipementID(int equipementID) {
        this.equipementID.set(equipementID);
    }

    public String getNumSerie() {
        return numSerie.get();
    }

    public SimpleStringProperty numSerieProperty() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie.set(numSerie);
    }

    public String getAdressMac() {
        return adressMac.get();
    }

    public SimpleStringProperty adressMacProperty() {
        return adressMac;
    }

    public void setAdressMac(String adressMac) {
        this.adressMac.set(adressMac);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getEtat() {
        return etat.get();
    }

    public SimpleStringProperty etatProperty() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat.set(etat);
    }

    public String getCaracteristique() {
        return caracteristique.get();
    }

    public SimpleStringProperty caracteristiqueProperty() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique.set(caracteristique);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public String getMarque() {
        return marque.get();
    }

    public SimpleStringProperty marqueProperty() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque.set(marque);
    }

    public String getAdressIp() {
        return adressIp.get();
    }

    public SimpleStringProperty adressIpProperty() {
        return adressIp;
    }

    public void setAdressIp(String adressIp) {
        this.adressIp.set(adressIp);
    }

    public String getPasserellePD() {
        return passerellePD.get();
    }

    public SimpleStringProperty passerellePDProperty() {
        return passerellePD;
    }

    public void setPasserellePD(String passerellePD) {
        this.passerellePD.set(passerellePD);
    }

    public String getMasque() {
        return masque.get();
    }

    public SimpleStringProperty masqueProperty() {
        return masque;
    }

    public void setMasque(String masque) {
        this.masque.set(masque);
    }

    public String getCategorie() {
        return categorie.get();
    }

    public SimpleStringProperty categorieProperty() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie.set(categorie);
    }

    public String getSysteme() {
        return systeme.get();
    }

    public SimpleStringProperty systemeProperty() {
        return systeme;
    }

    public void setSysteme(String systeme) {
        this.systeme.set(systeme);
    }






}
