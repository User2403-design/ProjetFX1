/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAfficherProduit;
import javafx.stage.Stage;
import Modele.Stockage;

public class CAfficherProduit {
    private Stage primaryStage;
    private VAfficherProduit vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CAfficherProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        // Récupération de la liste des produits sous forme de texte
        String produits = stockage.afficherTousLesProduits(); 
        this.vueAfficher = new VAfficherProduit(produits);

        lancerActions();
    }

    private void lancerActions() {
        vueAfficher.getRetourButton().setOnAction(e -> {
            CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
            controleurProduit.afficherSectionProduit();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Produits");
        primaryStage.setScene(vueAfficher.getSceneListeProduits());
        primaryStage.show();
    }
}