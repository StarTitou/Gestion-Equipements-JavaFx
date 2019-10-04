package models;

public class Personne {
    private String nom;
    private String pre;
    private String mat;
    private String address;

    public Personne(String nom, String pre, String mat, String address) {
        this.nom = nom;
        this.pre = pre;
        this.mat = mat;
        this.address = address;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
