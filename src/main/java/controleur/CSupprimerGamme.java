/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VSupprimerGamme;
import Modele.Stockage;
import Modele.Gamme;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerGamme {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VSupprimerGamme vue;

    public CSupprimerGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.vue = new VSupprimerGamme();

        initialiserListe();
        actionClic();
    }

    private void initialiserListe() {
        //remplit la liste avec les gammes présents dans l'atelier (stockage)
        for (Gamme g : stockage.getListeGammes()) {
            vue.getListeGamme().getItems().add(g.getRefGamme());
        }
    }

    private void actionClic() {
        vue.getSupprimerButton().setOnAction(e -> {
            String refSelectionnee = vue.getListeGamme().getSelectionModel().getSelectedItem();
            if (refSelectionnee != null) {
                stockage.supprimerGamme(refSelectionnee);//suppression réel dans le stockage
                vue.getListeGamme().getItems().remove(refSelectionnee);//suppression dans la liste afficher à l'écran
                vue.afficherMessage("Gamme supprimée !");
            } else {
                vue.afficherMessage("Veuillez sélectionner une Gamme.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            CGamme cGamme = new CGamme(primaryStage, utilisateur, atelier, stockage);
            cGamme.afficherSectionGamme();
        });
    }


    public void afficher() {
        primaryStage.setTitle("Supprimer Gamme");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}




