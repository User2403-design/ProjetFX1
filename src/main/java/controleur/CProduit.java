/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package controleur;

import Vue.VProduit;
import javafx.stage.Stage;
import Modele.Stockage;

/**
 * author chloe
 */

public class CProduit {
    private Stage primaryStage;
    private VProduit vueProduit;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private String role;

    public CProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vueProduit = new VProduit();
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.role = stockage.getRole(utilisateur); //Récupération du rôle
        actionClic();
        appliquerRestrictions();
    }

    private void actionClic() {
        vueProduit.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });
        vueProduit.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher!");
            CAfficherProduit controleurAff = new CAfficherProduit(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });
        vueProduit.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CChoisirProduit controleurModif = new CChoisirProduit(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });
        vueProduit.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            CAjouterProduit controleurAjout = new CAjouterProduit(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });
        vueProduit.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerProduit controleurSup = new CSupprimerProduit(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vueProduit.desactiver(); // Désactive Ajouter, Modifier, Supprimer pour les non chefs
        }
    }

    public void afficherSectionProduit() {
        primaryStage.setTitle("Section Produit");
        primaryStage.setScene(vueProduit.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}