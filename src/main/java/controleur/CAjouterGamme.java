/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Operation;
import Modele.Stockage;
import Modele.Gamme;
import Vue.VAjouterGamme;
import javafx.stage.Stage;  

import java.util.ArrayList;
import java.util.List;

public class CAjouterGamme {

    private Stage primaryStage;
    private String utilisateur, atelier;
    private Stockage stockage;
    private VAjouterGamme vue;

    public CAjouterGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VAjouterGamme();

        initialiserListeOperations();
        configurerActions();
    }

    private void initialiserListeOperations() {
        vue.getListeOperations().getItems().clear();
        for (Operation op : stockage.getListeOperations()) {
            vue.getListeOperations().getItems().add(op.getRefOperation());
        }
    }

    private void configurerActions() {
        vue.getEnregistrerButton().setOnAction(e -> enregistrerGamme());
        vue.getRetourButton().setOnAction(e -> retourner());
    }

    private void enregistrerGamme() {
        String ref = vue.getRefGammeField().getText().trim();
        List<String> refsOp = vue.getListeOperations().getSelectionModel().getSelectedItems();

        if (ref.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez entrer une référence pour la gamme.");
            return;
        }

        if (refsOp.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez sélectionner au moins une opération.");
            return;
        }

        ArrayList<Operation> operations = new ArrayList<>();
        for (String r : refsOp) {
            Operation op = stockage.rechercherOperationParRef(r);
            if (op != null) {
                operations.add(op);
            }
        }

        if (operations.isEmpty()) {
            vue.getMessageLabel().setText("Les opérations sélectionnées sont invalides.");
            return;
        }

        Gamme nouvelleGamme = new Gamme(ref, operations);
        stockage.ajouterGamme(nouvelleGamme);
        vue.getMessageLabel().setText("Gamme ajoutée avec succès !");
        new CGamme(primaryStage, utilisateur, atelier, stockage).afficherSectionGamme();
    }

    private void retourner() {
        CGamme controleurGamme = new CGamme(primaryStage, utilisateur, atelier, stockage);
        controleurGamme.afficherSectionGamme();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter une Gamme");
        primaryStage.setScene(vue.getScene());
        }
}