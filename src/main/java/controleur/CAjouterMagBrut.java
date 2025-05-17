/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VAjouterMagBrut;
import javafx.stage.Stage;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

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
            stockage.ajouterStockBrut(matiere, quantite);
            vue.getMessageLabel().setText("Matière ajoutée avec succès !");
            vue.getMatiereField().clear();
            vue.getQuantiteField().clear();
        } catch (NumberFormatException ex) {
            vue.getMessageLabel().setText("Erreur : La quantité doit être un nombre entier.");
        }
    }

    private void retourner() {
        new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter au Stock Brut");
        primaryStage.setScene(vue.getScene());
       GrandEcran.afficherPleinEcran(primaryStage, vue.getScene());
    }
}