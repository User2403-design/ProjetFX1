/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chloe
 */

/*package controleur;

import Vue.VProduit;
import javafx.stage.Stage;
import Modele.Stockage;
import java.util.ArrayList;
import Modele.Produit;


public class CProduit {
    private Stage primaryStage;
    private VProduit vueProduit;
    private Stockage stockage;
    
    public CProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.vueProduit = new VProduit();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { // définit toutes les actions quand on clique sur un bouton
        
        vueProduit.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); // crée un objet de CAcceuil afin de pouvoir appeler la méthode AfficherAccueil
            controleurAcc.afficherAccueil();
        });
        
        vueProduit.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher!");
            CAfficherProduit controleurModif = new CAfficherProduit(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();  
        });
        
        vueProduit.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CModifierProduit controleurModif = new CModifierProduit(primaryStage, utilisateur, atelier, stockage);
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

    public void afficherSectionProduit() {
        primaryStage.setTitle("Section Produit");
        primaryStage.setScene(vueProduit.getScene());
        primaryStage.show();
    }
}*/