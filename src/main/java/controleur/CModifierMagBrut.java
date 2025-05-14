/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Magasindebrut;
import Modele.Stockage;
import Vue.VModifierMagBrut;
import javafx.stage.Stage;

public class CModifierMagBrut {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Magasindebrut matiere;
    private VModifierMagBrut vue;

    public CModifierMagBrut(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Magasindebrut matiere) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.matiere = matiere;
        this.vue = new VModifierMagBrut();
        remplirChamps();
        actionClic();
    }

    private void remplirChamps() {
        vue.getNomField().setText(matiere.getMatiere());
        vue.getQuantiteField().setText(String.valueOf(matiere.getQuantite()));
    }

    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
            matiere.setMatiere(vue.getNomField().getText());
            try {
                int quantite = Integer.parseInt(vue.getQuantiteField().getText());
                matiere.setQuantite(quantite);
            } catch (NumberFormatException ex) {
                // Gérer l’erreur proprement (popup, couleur rouge, etc.)
            }
            new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
        });

        vue.getRetourButton().setOnAction(e -> {
            new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Matière Première");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}