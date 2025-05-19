/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import javafx.stage.Stage;
import Modele.Gamme;
import Modele.Produit;
import Modele.Stockage;
import Vue.VAjouterProduit;
import javafx.scene.control.SelectionMode;
import java.util.ArrayList;
import java.util.stream.Collectors;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

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
        // Remplir la liste des gammes dans la vue
        for (Gamme g : stockage.getListeGammes()) {
            vue.getListeGammesView().getItems().add(g.getRefGamme());
        }
        actionClic();
    }

    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> {
            String code = vue.getCodeField().getText();
            String designation = vue.getDesignationField().getText();

            // Vérification si tous les champs sont remplis
            if (code.isEmpty() || designation.isEmpty() || vue.getListeGammesView().getSelectionModel().getSelectedItems().isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }

            // Récupération des gammes sélectionnées
            ArrayList<String> gammesSelectionnees = new ArrayList<>(vue.getListeGammesView().getSelectionModel().getSelectedItems());
            ArrayList<Gamme> listeGammes = stockage.getListeGammes().stream()
                .filter(g -> gammesSelectionnees.contains(g.getRefGamme()))
                .collect(Collectors.toCollection(ArrayList::new));

            // Création et ajout du produit
            Produit produit = new Produit(code, designation, listeGammes);
            stockage.getListeProduits().add(produit);
            System.out.println("Produit ajouté avec succès !");
            retour();
        });

        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
        // Retour à la section produit
        CProduit controleurProduit = new CProduit(primaryStage, utilisateur, atelier, stockage);
        controleurProduit.afficherSectionProduit();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Produit");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        GrandEcran.afficherPleinEcran(primaryStage, vue.getScene());
    }
}