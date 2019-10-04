package controllers;

import animations.FadeInRightTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller_service implements Initializable {

    @FXML
    private TreeView<String> service_tree,t1;
    @FXML
    private TextArea area;

    public void show_service() throws SQLException{

        ObservableList<String> Ann_ens_List = FXCollections.observableArrayList();
        String Query= String.format("select   MAX(level) FROM service START WITH cod_ser='100501000000'  CONNECT BY PRIOR cod_ser IN( cod_ser_per )");
        Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "be", "be");
        Statement Mystat = Myconn.createStatement();
        ResultSet MyRe = Mystat.executeQuery(Query);
        while (MyRe.next()) {
            Ann_ens_List.add(MyRe.getString("a"));
        }
        area.setText(String.valueOf(Ann_ens_List));
     }

    public Integer get_number_spaces(String strng,Integer i){
        Integer index =i;
        String st=strng;
        if(!Objects.equals(strng.charAt(index), "a"))return i;
        else return get_number_spaces(st,index++);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        TreeItem<String> root=new TreeItem<>("Ecole Superieure des Technqiues de L'Aeronautique");

        TreeItem<String> node_1=new TreeItem<>("Bureau Informatique");
        TreeItem<String> node_2=new TreeItem<>("Bureau Social");
        TreeItem<String> node_3=new TreeItem<>("Bureau Communication, Information et Orientation");
        TreeItem<String> node_4=new TreeItem<>("Bureau Protection et Securité de l'Armée");
        TreeItem<String> node_5=new TreeItem<>("720 Compagnie F.A");
        TreeItem<String> node_6=new TreeItem<>("Bureau Etude et Prospective");
        TreeItem<String> node_7=new TreeItem<>("Direction d'Administration et Soutien");
        TreeItem<String> node_8=new TreeItem<>("Direction Generale des Etudes");
        TreeItem<String> node_9=new TreeItem<>("Secritariat Générale");


        root.getChildren().addAll(node_1,node_2,node_3,node_4,node_5,node_6,node_7,node_8,node_9);
        node_7.getChildren().addAll(new TreeItem<>("Secritariat DAS"),new TreeItem<>("Servic Protection, Intervention et Sauvetage"),new TreeItem<>("Service Materièle"),new TreeItem<>("Service Générale"),new TreeItem<>("Service Ressources Humainnes"),new TreeItem<>("Service Transmission"),new TreeItem<>("Service Intendance"),new TreeItem<>("Service Santé"));

        TreeItem<String> node_81=new TreeItem<>("Secrétariat DGE");
        TreeItem<String> node_82=new TreeItem<>("Directiopn Planification, Documentation et Moyens Pédagogiques");
        node_82.getChildren().addAll(new TreeItem<>("Département et moyens pédagogiques"),new TreeItem<>("Département documentations"),new TreeItem<>("Département des laboratoires"),new TreeItem<>("Département Etudes et planification"));

        TreeItem<String> node_83=new TreeItem<>("Direction d'Enseignement Militaire");
        node_83.getChildren().addAll(new TreeItem<>("Département d'enseignement specialisé"),new TreeItem<>("Département d'enseignement militaire et sport"),new TreeItem<>("Département d'application et de qualification"));


        TreeItem<String> node_84=new TreeItem<>("Direction d'Enseignements Superieur Universitaire");
        node_84.getChildren().addAll(new TreeItem<>("Département des science humainnes"),new TreeItem<>("Département des science et technologies"));


        TreeItem<String> node_85=new TreeItem<>("Brigade Eleves");



        node_8.getChildren().addAll(node_81,node_82,node_83,node_84,node_85);





        service_tree.setRoot(root);
        root.setExpanded(true);
    }


}
