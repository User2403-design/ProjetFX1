/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import Vue.VMagBrut;
import Modele.Stockage;
import javafx.stage.Stage;
import Repertoire.GrandEcran;

public class CMagBrut {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur, atelier, role;
    private VMagBrut vue;

    public CMagBrut(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VMagBrut();
        this.role = stockage.getRole(utilisateur); // 👈 Récupération du rôle
        actionclic();
        appliquerRestrictions(); // 👈 Application des restrictions si besoin
    }

    private void actionclic() {
        vue.getAfficherButton().setOnAction(e -> {
            System.out.println("Affichage du stock matière première");
            CAfficherMagBrut controleurAcc = new CAfficherMagBrut(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficher();
        });

        vue.getModifierButton().setOnAction(e -> {
            System.out.println("Modification du stock matière première");
            CChoisirMatiere controleurAcc = new CChoisirMatiere(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficher();
        });

        vue.getSupprimerButton().setOnAction(e -> {
            System.out.println("Suppression de matière du stock");
            CSupprimerMagBrut controleurAcc = new CSupprimerMagBrut(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficher();
        });

        vue.getAjouterButton().setOnAction(e -> {
            System.out.println("Ajout de matière au stock");
            CAjouterMagBrut controleurAcc = new CAjouterMagBrut(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficher();
        });

        vue.getRetourButton().setOnAction(e -> {
            System.out.println("Retour au menu principal");
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });
    }

    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vue.desactiver(); // 🔒 Restriction appliquée
        }
    }

    public void afficherSectionMagBrut() {
        primaryStage.setTitle("Gestion du Magasin de Brut");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}