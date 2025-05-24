/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Produit;
import Modele.Gamme;
import Modele.Stockage;
import Vue.VModifierProduit;
import javafx.stage.Stage;

/**
 * author chloe
 */

public class CModifierProduit {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Produit produitAModifier;
    private VModifierProduit vue;

    public CModifierProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Produit produit) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.produitAModifier = produit;
        this.vue = new VModifierProduit();

        remplirChamps();
        remplirListes();
        actionClic();
    }

    private void remplirChamps() {
        vue.getCodeField().setText(produitAModifier.getCodeProduit());
        vue.getDesignationField().setText(produitAModifier.getdProduit());
    }

    private void remplirListes() {
        //remplit la liste des gammes du produit
        for (Gamme g : produitAModifier.getListeGamme()) {
            vue.getListeGammesProduit().getItems().add(g.getRefGamme());
        }

        //remplit la liste des gammes disponibles dans l'atelier 
        for (Gamme g : stockage.getListeGammes()) {
            if (!produitAModifier.getListeGamme().contains(g)) {
                vue.getListeGammesDisponibles().getItems().add(g.getRefGamme());
            }
        }
    }

    private void actionClic() {
        vue.getAjouterGammeButton().setOnAction(e -> {
            String selected = vue.getListeGammesDisponibles().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeGammesDisponibles().getItems().remove(selected);
                vue.getListeGammesProduit().getItems().add(selected);
            }
        });

        vue.getRetirerGammeButton().setOnAction(e -> {
            String selected = vue.getListeGammesProduit().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeGammesProduit().getItems().remove(selected);
                vue.getListeGammesDisponibles().getItems().add(selected);
            }
        });

        vue.getEnregistrerButton().setOnAction(e -> {
             String code = vue.getCodeField().getText().trim();
            String designation = vue.getDesignationField().getText().trim();

            if (code.isEmpty() || designation.isEmpty()) {
                vue.getErreurLabel().setText("Tous les champs doivent être remplis !");
                return;
            }
            appliquerModifications();
            new CProduit(primaryStage, utilisateur, atelier, stockage).afficherSectionProduit();
        });

        vue.getRetourButton().setOnAction(e -> {
            new CProduit(primaryStage, utilisateur, atelier, stockage).afficherSectionProduit();
        });
    }

    //Modification du produit
    private void appliquerModifications() {
        produitAModifier.setCodeProduit(vue.getCodeField().getText());
        produitAModifier.setdProduit(vue.getDesignationField().getText());
        produitAModifier.getListeGamme().clear();

        for (String ref : vue.getListeGammesProduit().getItems()) {
            Gamme g = stockage.rechercherGammeParRef(ref);
            if (g != null) {
                produitAModifier.getListeGamme().add(g);
            }
        }
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Produit");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
