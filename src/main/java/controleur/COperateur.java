/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VOperateur;
import javafx.stage.Stage;
import Modele.Stockage;


public class COperateur {
    
    private Stage primaryStage;
    private VOperateur vueOperateur;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private String role;
    
    public COperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vueOperateur = new VOperateur();
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.role = stockage.getRole(utilisateur); // On récupère le rôle
        actionClic();
        appliquerRestrictions(); //Désactive les boutons selon le rôle
    }
    
    private void actionClic() {
        vueOperateur.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });

        vueOperateur.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher!");
            CAfficherOperateur controleurModif = new CAfficherOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();  
        });

        vueOperateur.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CChoisirOperateur controleurModif = new CChoisirOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vueOperateur.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            CAjouterOperateur controleurAjout = new CAjouterOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueOperateur.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerOperateur controleursup = new CSupprimerOperateur(primaryStage, utilisateur, atelier, stockage);
            controleursup.afficher();
        });
    }

    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vueOperateur.desactiver(); // Empêche l'accès à l'ajout, modif, suppression
        }
    }

    public void afficherSectionOperateur() {
        primaryStage.setTitle("Section Operateur");
        primaryStage.setScene(vueOperateur.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}