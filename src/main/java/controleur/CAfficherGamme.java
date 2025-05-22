/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAfficherGamme;
import Modele.Stockage;
import javafx.stage.Stage;

public class CAfficherGamme {

    private Stage primaryStage;
    private VAfficherGamme vue;
    private Stockage stockage;

    public CAfficherGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.vue = new VAfficherGamme();

        // Appel de la méthode pour remplir la zone d'affichage
        String texteAffichage = stockage.afficherToutesLesGammesDisponibles();
        vue.getZoneAffichage().setText(texteAffichage);

        // Bouton retour
        vue.getRetour().setOnAction(e -> {
            CGamme controleurGamme = new CGamme(primaryStage, utilisateur, atelier, stockage);
            controleurGamme.afficherSectionGamme();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Afficher les Gammes");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}