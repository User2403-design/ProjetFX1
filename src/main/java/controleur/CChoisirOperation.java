/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Operation;
import Modele.Stockage;
import Vue.VChoisirOperation;
import javafx.stage.Stage;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

public class CChoisirOperation {
    private Stage primaryStage;
    private VChoisirOperation vue;
    private Stockage stockage;
    private String utilisateur, atelier;

    public CChoisirOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirOperation();

        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Operation op : stockage.getListeOperations()) {
            vue.getListeOperations().getItems().add(op.getRefOperation());
        }
    }

    private void actionClic() {
        vue.getValiderButton().setOnAction(e -> {
            String refChoisie = vue.getListeOperations().getSelectionModel().getSelectedItem();
            if (refChoisie != null) {
                Operation op = stockage.rechercherOperationParRef(refChoisie);
                if (op != null) {
                    new CModifierOperation(primaryStage, utilisateur, atelier, stockage, op).afficher();
                }
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir une opération à modifier");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
       GrandEcran.afficherPleinEcran(primaryStage, vue.getScene());
    }
}
