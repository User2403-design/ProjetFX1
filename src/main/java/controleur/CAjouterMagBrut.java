/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VAjouterMagBrut;
import javafx.stage.Stage;

/**
 * author chloe
 */

public class CAjouterMagBrut {

    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VAjouterMagBrut vue;

    public CAjouterMagBrut(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VAjouterMagBrut();

        configurerActions();
    }

    private void configurerActions() {
        vue.getAjouterButton().setOnAction(e -> ajouterMatiere());
        vue.getRetourButton().setOnAction(e -> retourner());
    }

    private void ajouterMatiere() {
        String matiere = vue.getMatiereField().getText().trim();
        String quantiteText = vue.getQuantiteField().getText().trim();

        if (matiere.isEmpty() || quantiteText.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez remplir tous les champs.");
            return;
        }

        try {
            int quantite = Integer.parseInt(quantiteText);
            //verification du signe la quantité 
            if (quantite < 0) {
                    vue.getMessageLabel().setText("Erreur: Entrez une quantité positive.");
                    vue.getMessageLabel().setStyle("-fx-text-fill: red;");
                    return; 
                }
            stockage.ajouterStockBrut(matiere, quantite);
            vue.getMessageLabel().setText("Matière ajoutée avec succès !");
            vue.getMatiereField().clear();
            vue.getQuantiteField().clear();
        } catch (NumberFormatException ex) { //verification du bon format de la quantité entré 
            vue.getMessageLabel().setText("Erreur : La quantité doit être un nombre entier.");
            vue.getMessageLabel().setStyle("-fx-text-fill: red;");
        }
    }

    private void retourner() {
        new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter au Stock Brut");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
    }
}