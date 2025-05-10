/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chloe
 */

package controleur;

import javafx.stage.Stage;
import Modele.Produit;
import Modele.Stockage;
import Vue.VAjouterProduit;
import javafx.stage.Stage;


public class CAjouterProduit {

    private Stage primaryStage;
    private VAjouterProduit vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        vue = new VAjouterProduit();
        lancerActions();
    }

    private void lancerActions() {
        vue.getAjouterButton().setOnAction(e -> {
            // Récupérer les valeurs des champs de texte
            String nom = vue.getNomField().getText();
            String prenom = vue.getPrenomField().getText();
            String code = vue.getCodeField().getText();

            // Vérification que les champs sont remplis
            if (nom.isEmpty() || prenom.isEmpty() || code.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }

            Produit nouveauProduit = new Produit(nom, prenom, code, true); // Etat initial = true
            stockage.ajouterProduit(nouveauProduit);

            // Création du produit et ajout à la liste des produits
            Produit produit = new Produit(nom, prenom, code, true); // L'état initial est "true" (disponible)
            stockage.getListeProduits().add(produit);
            System.out.println("Produit ajouté avec succès !");

            // Retour à la vue des produits
            retour();
        });

        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
        // Retour à la vue des produits
        CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
        controleurProduit.afficherSectionProduit();
    }

    public void afficher() {
        // Affichage de la vue d'ajout de produit
        primaryStage.setTitle("Ajouter un Produit");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}