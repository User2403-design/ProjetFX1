/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VSupprimerPoste;
import Modele.Stockage;
import Modele.Poste;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerPoste {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VSupprimerPoste vue;

    public CSupprimerPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.vue = new VSupprimerPoste();

        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Poste p : stockage.getListePostes()) {
            vue.getListePostes().getItems().add(p.getRefEquipement());
        }
    }

    private void actionClic() {
        
        vue.getSupprimerButton().setOnAction(e -> {
            String refSelectionnee = vue.getListePostes().getSelectionModel().getSelectedItem();
            if (refSelectionnee != null) {
                stockage.supprimerPoste(refSelectionnee);
                vue.getListePostes().getItems().remove(refSelectionnee);
                vue.afficherMessage("Poste supprimé !");
            } else {
                vue.afficherMessage("Veuillez sélectionner un poste.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            Cposte cPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);
            cPoste.afficherSectionPoste();
        });
    }


    public void afficher() {
        primaryStage.setTitle("Supprimer Poste");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
