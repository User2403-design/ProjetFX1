/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VSupprimerProduit;
import javafx.stage.Stage;
import Modele.Produit;
/**
 *
 * @author chloe
 */



public class CSupprimerProduit {
    private Stage primaryStage;
    private VSupprimerProduit vue;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VSupprimerProduit();

        initialiserListe();
        actionClic();
    }

    // Initialiser la liste des produits dans la vue
    private void initialiserListe() {
        // Ajouter les produits à la liste dans la vue
        for (Produit p : stockage.getListeProduits()) {
            vue.getListeProduits().getItems().add(p.getCodeProduit()); // On ajoute le codeProduit à la liste
        }
    }

    // Gérer les actions des boutons
    private void actionClic() {
        // Action retour
        vue.getRetourButton().setOnAction(e -> {
            CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
            controleurProduit.afficherSectionProduit();
        });

        // Action supprimer un produit
        vue.getSupprimerButton().setOnAction(e -> {
            // Récupérer le produit sélectionné
            String refSelectionnee = vue.getListeProduits().getSelectionModel().getSelectedItem();
            if (refSelectionnee != null) {
                // Supprimer le produit
                boolean produitSupprime = stockage.supprimerProduit(refSelectionnee);
                if (produitSupprime) {
                    vue.afficherMessage("Produit supprimé avec succès !");
                    // Retirer le produit de la liste affichée
                    vue.getListeProduits().getItems().remove(refSelectionnee);
                } else {
                    vue.afficherMessage("Produit non trouvé.");
                }
            } else {
                vue.afficherMessage("Veuillez sélectionner un produit.");
            }
        });
    }

    // Afficher la fenêtre
    public void afficher() {
        primaryStage.setTitle("Supprimer un Produit");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}