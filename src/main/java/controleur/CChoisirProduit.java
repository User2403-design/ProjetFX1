/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Produit;
import Modele.Stockage;
import Vue.VChoisirProduit;
import javafx.stage.Stage;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

public class CChoisirProduit {
    private Stage primaryStage;
    private VChoisirProduit vue;
    private Stockage stockage;
    private String utilisateur, atelier;

    public CChoisirProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirProduit();

        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Produit p : stockage.getListeProduits()) {
            vue.getListeProduits().getItems().add(p.getCodeProduit());
        }
    }

    private void actionClic() {
        vue.getValiderButton().setOnAction(e -> {
            String codeChoisi = vue.getListeProduits().getSelectionModel().getSelectedItem();
            if (codeChoisi != null) {
                Produit produit = stockage.rechercherProduitParCode(codeChoisi);
                if (produit != null) {
                    CModifierProduit modif = new CModifierProduit(primaryStage, utilisateur, atelier, stockage, produit);
                    modif.afficher();
                }
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CProduit(primaryStage, utilisateur, atelier, stockage).afficherSectionProduit();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir un Produit à Modifier");
        primaryStage.setScene(vue.getScene());
        GrandEcran.afficherPleinEcran(primaryStage, vue.getScene());
    }
}
