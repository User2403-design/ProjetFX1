/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import Vue.VOperation;
import javafx.stage.Stage;
import Modele.Stockage;

/**
 * author chloe
 */

public class COperation {
    
    private Stage primaryStage;
    private VOperation vueOperation;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private String role;
    
    public COperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vueOperation = new VOperation();
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.role = stockage.getRole(utilisateur); //Récupération du rôle
        
        actionClic();
        appliquerRestrictions(); //Restrictions selon le rôle
    }
    
    private void actionClic() {
        vueOperation.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });
        
        vueOperation.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            CAfficherOperation controleurAff = new CAfficherOperation(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });
        
        vueOperation.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CChoisirOperation controleurModif = new CChoisirOperation(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });
        
        vueOperation.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            CAjouterOperation controleurAjout = new CAjouterOperation(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });
        
        vueOperation.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerOperation controleurSup = new CSupprimerOperation(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }
    
    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vueOperation.desactiver(); //Méthode dans la vue qui désactive les boutons Ajouter, Modifier, Supprimer pour les non chefs
        }
    }

    public void afficherSectionOperation() {
        primaryStage.setTitle("Section Operation");
        primaryStage.setScene(vueOperation.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}