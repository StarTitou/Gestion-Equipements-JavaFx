package controllers;

import animations.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import config.config2;


public class ControllerAcceuil implements Initializable {

    @FXML
    private Label title;

    @FXML
    private Button fullscreen;
    Rectangle2D rec2;
    Double w, h;
    @FXML
    private Button minimize;

    @FXML
    private ImageView image_acceuil;

    @FXML
    private Button maximize;

    @FXML
    private Button close;

    @FXML
    private Button resize;
    config2 con = new config2();
    @FXML
    private ListView<String> listMenu;

    @FXML
    private ListView<String> close_list;
    Stage stage;
    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane DataPane;

    @FXML
    private StackPane paneData;



    @FXML
    void aksiClose() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void aksifullscreen() {
        Stage stage = (Stage) fullscreen.getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        } else {
            stage.setFullScreen(true);
        }
    }

    @FXML
    private void hide_navbar() {
        // new FadeOutLeftTransition(DataPane).play();
        listMenu.getItems().remove(0, 9);
        listMenu.getItems().addAll("  Equipements", "  Fournisseurs","  Catégories", "  Services", "  Entrées", "  Sorties", "  Historique", "  Factures d'Achat","  Statistique" );
        new FadeInLeftTransition1(DataPane).play();
    }

    @FXML
    private void aksiMaximized(ActionEvent event) {
        Stage stage = (Stage) maximize.getScene().getWindow();
        if (stage.isMaximized()) {
            if (w == rec2.getWidth() && h == rec2.getHeight()) {
                stage.setMaximized(false);
                stage.setHeight(600);
                stage.setWidth(800);
                stage.centerOnScreen();
                maximize.getStyleClass().remove("decoration-button-restore");
                resize.setVisible(true);
            } else {
                stage.setMaximized(false);
                maximize.getStyleClass().remove("decoration-button-restore");
                resize.setVisible(true);
            }
        } else {
            stage.setMaximized(true);
            stage.setHeight(rec2.getHeight());
            maximize.getStyleClass().add("decoration-button-restore");
            resize.setVisible(false);
        }
    }

    @FXML
    private void aksiminimize(ActionEvent event) {
        Stage stage = (Stage) minimize.getScene().getWindow();
        if (stage.isMaximized()) {
            w = rec2.getWidth();
            h = rec2.getHeight();
            stage.setMaximized(false);
            stage.setHeight(h);
            stage.setWidth(w);
            stage.centerOnScreen();
            Platform.runLater(() -> {
                stage.setIconified(true);
            });
        } else {
            stage.setIconified(true);
        }
    }

    @FXML
    private void aksiResize(ActionEvent event) {
    }

    @FXML
    private void aksiKlikListMenu(MouseEvent event) {
        switch (listMenu.getSelectionModel().getSelectedIndex()) {
            case 0: {
                con.loadAnchorPane(paneData, "equipement.fxml");
            }
            break;
            case 1: {
                con.loadAnchorPane(paneData, "fournisseur.fxml");
            }
            break;
            case 2: {
                con.loadAnchorPane(paneData, "categorie.fxml");
            }
            break;
            case 3: {
                con.loadAnchorPane(paneData, "service.fxml");
            }
            break;
            case 4: {
                con.loadAnchorPane(paneData, "entree.fxml");
            }
            break;
            case 5: {
                con.loadAnchorPane(paneData, "sortie.fxml");
            }
            break;
            case 6: {
                con.loadAnchorPane(paneData, "historique.fxml");
            }
            break;
            case 7: {
                con.loadAnchorPane(paneData, "facture.fxml");
            }
            break;
            case 8: {
                con.loadAnchorPane(paneData, "statistique.fxml");
            }
            break;


        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rec2 = Screen.getPrimary().getVisualBounds();
        w = 0.1;
        h = 0.1;
        Platform.runLater(() -> {
            new FadeInLeftTransition1(DataPane).play();
            listMenu.getItems().addAll("  Equipements", "  Fournisseurs","  Catégories", "  Services", "  Entrées", "  Sorties", "  Historique", "  Factures d'Achat","  Statistique" );
            close_list.getItems().addAll("  Déconnexion");
            new FadeInRightTransition(image_acceuil, 0.4).play();

            //aksifullscreen();
        });
    }

    public void hide_navbarr() throws SQLException,Exception {
       /* ObservableList<String> Ann_ens_List = FXCollections.observableArrayList();
        Connection Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "be", "be");
        Statement Mystat = Myconn.createStatement();
        ResultSet MyRe = Mystat.executeQuery("select * from GRADE ");
        while (MyRe.next()) {
            Ann_ens_List.add(MyRe.getString("LIB_GRA_FR"));
        }
        listMenu.setItems(Ann_ens_List);

*/
       //config2.dialog(Alert.AlertType.WARNING,"sdfdf");

    }



}
