/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VGamme;
import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Gamme; // Supposé modèle
/**
 *
 * @author Justin
 */
public class CGamme {

    private Stage primaryStage;
    private VGamme vueGamme;
    private Stockage stockage;

    public CGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vueGamme = new VGamme();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) {

        vueGamme.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });
        
        vueGamme.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            CAfficherGamme controleurAff = new CAfficherGamme(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });

        vueGamme.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CChoisirGamme controleurModif = new CChoisirGamme(primaryStage, stockage);
            controleurModif.afficher();
        });

        vueGamme.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            CAjouterGamme controleurAjout = new CAjouterGamme(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueGamme.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerGamme controleurSup = new CSupprimerGamme(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    public void afficherSectionGamme() {
        primaryStage.setTitle("Section Gamme");
        primaryStage.setScene(vueGamme.getScene());
        primaryStage.show();
    }
}