/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VSupprimerOperation;
import Modele.Stockage;
import Modele.Operation;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerOperation {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VSupprimerOperation vue;

    public CSupprimerOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.vue = new VSupprimerOperation();

        initialiserListe();
        lancerActions();
    }

    private void initialiserListe() {
        for (Operation o : stockage.getListeOperations()) {
            vue.getListeOperation().getItems().add(o.getRefOperation());
        }
    }

    private void lancerActions() {
        vue.getSupprimerButton().setOnAction(e -> {
            String refSelectionnee = vue.getListeOperation().getSelectionModel().getSelectedItem();
            if (refSelectionnee != null) {
                stockage.supprimerOperation(refSelectionnee);
                vue.getListeOperation().getItems().remove(refSelectionnee);
                vue.afficherMessage("Operation supprimée !");
            } else {
                vue.afficherMessage("Veuillez sélectionner une opération.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            COperation cOperation = new COperation(primaryStage, utilisateur, atelier, stockage);
            cOperation.afficherSectionOperation();
        });
    }


    public void afficher() {
        primaryStage.setTitle("Supprimer Poste");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}



