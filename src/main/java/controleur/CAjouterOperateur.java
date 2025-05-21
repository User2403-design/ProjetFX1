/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import javafx.stage.Stage;
import Modele.Operateur;
import Modele.Stockage;
import Vue.VAjouterOperateur;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

public class CAjouterOperateur {

    private Stage primaryStage;
    private VAjouterOperateur vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        this.vue = new VAjouterOperateur();
        ActionClic();
    }

    private void ActionClic() {
        vue.getAjouterButton().setOnAction(e -> ajouterOperateur());
        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void ajouterOperateur() {
        String nom = vue.getNomField().getText().trim();
        String prenom = vue.getPrenomField().getText().trim();
        String code = vue.getCodeField().getText().trim();
        String competences = vue.getCompetencesField().getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || code.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez remplir tous les champs.");
            return;
        }

        Operateur operateur = new Operateur(nom, prenom, code, true, competences);
        stockage.getListeOperateurs().add(operateur);

        vue.getMessageLabel().setStyle("-fx-text-fill: green;");
        vue.getMessageLabel().setText("Opérateur ajouté avec succès !");

        vue.getNomField().clear();
        vue.getPrenomField().clear();
        vue.getCodeField().clear();
        vue.getCompetencesField().clear();
        
        COperateur controleur = new COperateur(primaryStage, utilisateur, atelier, stockage);
    }

    private void retour() {
        COperateur controleur = new COperateur(primaryStage, utilisateur, atelier, stockage);
        controleur.afficherSectionOperateur();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Opérateur");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}