/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import javafx.stage.Stage;
import Modele.Produit;
import Modele.Stockage;
import Modele.Gamme;
import Vue.VAjouterProduit;

public class CAjouterProduit {
    private Stage primaryStage;
    private VAjouterProduit vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterProduit(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        vue = new VAjouterProduit();
        initialiserListeGammes(); // Remplit la liste des gammes dans la vue
        lancerActions();
    }

    private void initialiserListeGammes() {
        for (Gamme g : stockage.getListeGammes()) {
            vue.getListeGammes().getItems().add(g.getRefGamme());
        }
    }

    private void lancerActions() {
        vue.getAjouterButton().setOnAction(e -> {
            String code = vue.getCodeField().getText();
            String designation = vue.getDesignationField().getText();
            String refGammeSelectionnee = vue.getListeGammes().getSelectionModel().getSelectedItem();

            if (code.isEmpty() || designation.isEmpty() || refGammeSelectionnee == null) {
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }

            // Trouver la gamme correspondante à la sélection
            Gamme gammeChoisie = null;
            for (Gamme g : stockage.getListeGammes()) {
                if (g.getRefGamme().equals(refGammeSelectionnee)) {
                    gammeChoisie = g;
                    break;
                }
            }

            if (gammeChoisie == null) {
                System.out.println("Gamme sélectionnée introuvable !");
                return;
            }

            // Création du produit avec la gamme sélectionnée
            Produit produit = new Produit(code, designation, gammeChoisie);
            stockage.getListeProduits().add(produit);
            System.out.println("Produit ajouté avec succès !");
            retour();
        });

        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
        CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
        controleurProduit.afficherSectionProduit();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Produit");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
