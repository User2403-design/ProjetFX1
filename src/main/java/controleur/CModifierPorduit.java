/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import javafx.stage.Stage;
import Modele.Produit;
import Modele.Stockage;
import Vue.VModifierPoduit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Modele.Gamme;       // Import pour la classe Gamme
import java.util.ArrayList;  // Import pour ArrayList

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
        initialiserListe();
        lancerActions();
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }

    private void initialiserListe() {
        ObservableList<String> codesProduits = FXCollections.observableArrayList();
        for (Produit produit : stockage.getListeProduits()) {
            codesProduits.add(produit.getCodeProduit());
        }
        vueModifier.getComboBoxGamme().getItems().clear(); // Clear previous selections
        vueModifier.getComboBoxGamme().getItems().addAll(codesProduits);
    }

    private void lancerActions() {
        vueModifier.getComboBoxGamme().getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                for (Produit produit : stockage.getListeProduits()) {
                    if (produit.getCodeProduit().equals(newVal)) {
                        vueModifier.getNouveauCodeField().setText(produit.getCodeProduit());
                        vueModifier.getNouvelleDesignationField().setText(produit.getdProduit());
                        
                        // Charger les gammes associées au produit sélectionné
                        ObservableList<String> gammes = FXCollections.observableArrayList();
                        for (Gamme gamme : produit.getListeGamme()) {
                            gammes.add(gamme.getRefGamme());
                        }
                        vueModifier.getComboBoxGamme().setItems(gammes);
                        break;
                    }
                }
            }
        });

        vueModifier.getModifierButton().setOnAction(e -> {
            String ancienCode = vueModifier.getCodeRechercheField().getText();
            if (ancienCode.isEmpty()) {
                vueModifier.afficherMessage("Veuillez entrer le code du produit.");
                return;
            }

            for (Produit produit : stockage.getListeProduits()) {
                if (produit.getCodeProduit().equals(ancienCode)) {
                    produit.setCodeProduit(vueModifier.getNouveauCodeField().getText());
                    produit.setdProduit(vueModifier.getNouvelleDesignationField().getText());
                    
                    // Mettre à jour la gamme sélectionnée
                    String nouvelleGamme = vueModifier.getComboBoxGamme().getSelectionModel().getSelectedItem();
                    if (nouvelleGamme != null) {
                        // Mettre à jour la gamme dans le produit
                        ArrayList<Gamme> nouvellesGammes = new ArrayList<>(produit.getListeGamme());

                         //nouvellesGammes.add(new Gamme(nouvelleGamme));
                        produit.setListeGamme(nouvellesGammes);
                    }
                    vueModifier.afficherMessage("Produit modifié avec succès.");
                    initialiserListe(); // Rafraîchir la liste des produits
                    break;
                }
            }
        });

        vueModifier.getRetourButton().setOnAction(e -> {
            CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
            controleurProduit.afficherSectionProduit();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier un produit");
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }
}