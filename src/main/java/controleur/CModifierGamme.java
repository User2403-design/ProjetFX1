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
import java.util.List;

public class CModifierGamme {

    private Stage primaryStage;
    private Stockage stockage;
    private Gamme gammeAModifier;
    private VModifierGamme vue;

    public CModifierGamme(Stage primaryStage, Stockage stockage, Gamme gammeAModifier) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.gammeAModifier = gammeAModifier;
        this.vue = new VModifierGamme();
        remplirChamps();
        remplirListes();
        actionClic();
    }

    // Remplir les champs de la fenêtre de modification
    private void remplirChamps() {
        vue.getRefField().setText(gammeAModifier.getRefGamme());
    }

    // Remplir les listes : opérations de la gamme et opérations disponibles
    private void remplirListes() {
        // Remplir la liste des opérations déjà associées à la gamme
        for (Operation op : gammeAModifier.getOperations()) {
            vue.getListeOperationsGamme().getItems().add(op.getRefOperation());
        }

        // Remplir la liste des opérations disponibles
        for (Operation op : stockage.getListeOperations()) {
            if (!gammeAModifier.getOperations().contains(op)) {
                vue.getListeOperationsDisponibles().getItems().add(op.getRefOperation());
            }
        }
    }

    // Gérer les actions des boutons
    private void actionClic() {
        // Ajouter une opération à la gamme
        vue.getAjouterOperationButton().setOnAction(e -> {
            String selected = vue.getListeOperationsDisponibles().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeOperationsDisponibles().getItems().remove(selected);
                vue.getListeOperationsGamme().getItems().add(selected);
            }
        });

        // Retirer une opération de la gamme
        vue.getRetirerOperationButton().setOnAction(e -> {
            String selected = vue.getListeOperationsGamme().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeOperationsGamme().getItems().remove(selected);
                vue.getListeOperationsDisponibles().getItems().add(selected);
            }
        });

        // Enregistrer les modifications
        vue.getEnregistrerButton().setOnAction(e -> {
            appliquerModifications();
            new CChoisirGamme(primaryStage, stockage).afficher();
        });

        // Retourner à la fenêtre précédente sans enregistrer
        vue.getRetourButton().setOnAction(e -> {
            new CChoisirGamme(primaryStage, stockage).afficher();
        });
    }

    // Appliquer les modifications effectuées
    private void appliquerModifications() {
        // Modifier la référence de la gamme
        String nouvelleRef = vue.getRefField().getText();
        gammeAModifier.setRefGamme(nouvelleRef);
        
        // Modifier les opérations associées à la gamme
        gammeAModifier.getOperations().clear();
        for (String refOp : vue.getListeOperationsGamme().getItems()) {
            Operation op = stockage.rechercherOperationParRef(refOp);
            if (op != null) {
                gammeAModifier.ajouterOperation(op);
            }
        }
    }

    // Afficher la fenêtre de modification
    public void afficher() {
        primaryStage.setTitle("Modifier Gamme");
        primaryStage.setScene(vue.getScene());
        
        primaryStage.show();
    }
}