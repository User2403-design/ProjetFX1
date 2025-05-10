/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*package controleur;

import javafx.stage.Stage;
import Modele.Produit;
import Modele.Stockage;
import Vue.VModifierPoduit;

public class CModifierPorduit {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VModifierPoduit vueModifier;

    public CModifierPorduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueModifier = new VModifierPoduit();
        lancerActions();
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }

    private void lancerActions() {
        vueModifier.getModifierButton().setOnAction(e -> {
            String codeRecherche = vueModifier.getCodeProduitField().getText();
            Produit produitTrouve = null;

            for (Produit produit : stockage.getListeProduits()) {
                if (produit.getCodeProduit().equalsIgnoreCase(codeRecherche)) {
                    produitTrouve = produit;
                    break;
                }
            }

            if (produitTrouve != null) {
                String nouveauCode = vueModifier.getCodeProduitField().getText();
                String nouvelleDesignation = vueModifier.getDesignationProduitField().getText();

                if (!nouvelleDesignation.isEmpty()) {
                    produitTrouve.setdProduit(nouvelleDesignation);
                }

                System.out.println("Produit modifié avec succès.");
            } else {
                System.out.println("Produit non trouvé !");
            }
        });

        vueModifier.getRetourButton().setOnAction(e -> {
            CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
            controleurProduit.afficherSectionProduit();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier un Produit");
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }
}*/
