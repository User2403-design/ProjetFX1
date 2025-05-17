/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAfficherMagBrut;
import javafx.stage.Stage;
import Modele.Stockage;

/**
 * Contrôleur pour l'affichage du magasin de matières brutes.
 * @author chloe
 */
public class CAfficherMagBrut {

    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VAfficherMagBrut vueAfficher;

    public CAfficherMagBrut(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        // Récupère les données du magasin de brut depuis le modèle
        String contenu = stockage.afficherMagasinDeBrut();

        // Initialise la vue avec les données
        this.vueAfficher = new VAfficherMagBrut(contenu);

        // Active la gestion des clics
        actionClic();
    }

    private void actionClic() {
        vueAfficher.getRetourButton().setOnAction(e -> {
            CMagBrut controleurRetour = new CMagBrut(primaryStage, utilisateur, atelier, stockage);
            controleurRetour.afficherSectionMagBrut(); // Appelle la méthode afficher() si elle existe
        });
    }

    public void afficher() {
        primaryStage.setTitle("Affichage du stock brut");
        primaryStage.setScene(vueAfficher.getScene()); // getScene() doit renvoyer la Scene associée
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}