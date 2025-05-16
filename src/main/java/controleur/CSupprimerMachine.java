/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VSupprimerMachine;
import Modele.Stockage;
import Modele.Machine;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerMachine {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VSupprimerMachine vue;

    public CSupprimerMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.vue = new VSupprimerMachine();

        initialiserListe();
        actionClic();
    }

    private void initialiserListe() {
        for (Machine m : stockage.getListeMachines()) {
            vue.getListeMachine().getItems().add(m.getRefmachine());
        }
    }

    private void actionClic() {
        vue.getSupprimerButton().setOnAction(e -> {
            String refSelectionnee = vue.getListeMachine().getSelectionModel().getSelectedItem();
            if (refSelectionnee != null) {
                stockage.supprimerMachine(refSelectionnee);
                vue.getListeMachine().getItems().remove(refSelectionnee);
                vue.afficherMessage("Machine supprimée !");
            } else {
                vue.afficherMessage("Veuillez sélectionner une Machine.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            CMachine cMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            cMachine.afficherSectionMachine();
        });
    }


    public void afficher() {
        primaryStage.setTitle("Supprimer Machine");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
