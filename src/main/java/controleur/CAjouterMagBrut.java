/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VAjouterMagBrut;
import javafx.stage.Stage;

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

        actionClic();
    }

    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> {
            String matiere = vue.getMatiereField().getText().trim();
            String quantiteText = vue.getQuantiteField().getText().trim();

            if (!matiere.isEmpty() && !quantiteText.isEmpty()) {
                try {
                    int quantite = Integer.parseInt(quantiteText);
                    stockage.ajouterStockBrut(matiere, quantite);
                    vue.getMatiereField().clear();
                    vue.getQuantiteField().clear();
                } catch (NumberFormatException ex) {
                    System.out.println("Erreur : La quantité doit être un nombre entier.");
                }
            } else {
                System.out.println("Veuillez remplir tous les champs.");
            }
        });

      vue.getRetourButton().setOnAction(e -> {
            new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter dans le Stock Brut");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}