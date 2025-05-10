/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chloe
 */
/*package controleur;

import Modele.Stockage;
import Vue.VSupprimerProduit;
import javafx.stage.Stage;
import Modele.Produit;


public class CSupprimerProduit {
    private Stage primaryStage;
    private VSupprimerProduit vueSupprimer;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueSupprimer = new VSupprimerProduit();
        lancerActions();
    }

    private void lancerActions() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
            controleurProduit.afficherSectionProduit();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String nom = vueSupprimer.getNomProduitField().getText();
            if (stockage.supprimerProduit(nom)) {
                vueSupprimer.afficherMessage("Produit supprimé avec succès !");
            } else {
                vueSupprimer.afficherMessage("Produit non trouvé.");
            }
        });
    }

    public void afficher() {
        primaryStage.setTitle("Supprimer un Produit");
        primaryStage.setScene(vueSupprimer.getScene());
        primaryStage.show();
    }
}*/