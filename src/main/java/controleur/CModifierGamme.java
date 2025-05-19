/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import Modele.Operation;
import Modele.Gamme;
import Modele.Stockage;
import Vue.VModifierGamme;
import javafx.stage.Stage;

public class CModifierGamme {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Gamme gammeAModifier;
    private VModifierGamme vue;

    public CModifierGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Gamme gammeAModifier) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.gammeAModifier = gammeAModifier;
        this.vue = new VModifierGamme();
        remplirChamps();
        remplirListes();
        actionClic();
    }

    private void remplirChamps() {
        vue.getRefField().setText(gammeAModifier.getRefGamme());
    }

    private void remplirListes() {
        // Opérations déjà dans la gamme
        for (Operation op : gammeAModifier.getOperations()) {
            vue.getListeOperationsGamme().getItems().add(op.getRefOperation());
        }
        // Opérations disponibles (pas dans la gamme)
        for (Operation op : stockage.getListeOperations()) {
            if (!gammeAModifier.getOperations().contains(op)) {
                vue.getListeOperationsDisponibles().getItems().add(op.getRefOperation());
            }
        }
    }

    private void actionClic() {
        vue.getAjouterOperationButton().setOnAction(e -> {
            String selected = vue.getListeOperationsDisponibles().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeOperationsDisponibles().getItems().remove(selected);
                vue.getListeOperationsGamme().getItems().add(selected);
            }
        });

        vue.getRetirerOperationButton().setOnAction(e -> {
            String selected = vue.getListeOperationsGamme().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeOperationsGamme().getItems().remove(selected);
                vue.getListeOperationsDisponibles().getItems().add(selected);
            }
        });

        vue.getEnregistrerButton().setOnAction(e -> {
            appliquerModifications();
            new CGamme(primaryStage, utilisateur, atelier, stockage).afficherSectionGamme();
        });

        vue.getRetourButton().setOnAction(e -> {
            new CGamme(primaryStage, utilisateur, atelier, stockage).afficherSectionGamme();
        });
    }

    private void appliquerModifications() {
        // Modifier la référence de la gamme
        String nouvelleRef = vue.getRefField().getText();
        gammeAModifier.setRefGamme(nouvelleRef);

        // Modifier les opérations associées
        gammeAModifier.getOperations().clear();
        for (String refOp : vue.getListeOperationsGamme().getItems()) {
            Operation op = stockage.rechercherOperationParRef(refOp);
            if (op != null) {
                gammeAModifier.ajouterOperation(op);
            }
        }
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Gamme");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}