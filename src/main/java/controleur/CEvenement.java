/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VEvenement;
import javafx.stage.Stage;
import Modele.Stockage;
/**
 *
 * @author Elève
 */
/*public class CEvenement {
    
    private Stage primaryStage;
    private VEvenement vue;
    private String utilisateur;
    private String atelier;
    private String cheminFichierEvenements;
    private Stockage stockage; // obliger de l'avoir pour appeler le controleur de Acceuil, même si on s'en sert pas 

    public CEvenement(Stage primaryStage, String utilisateur, String atelier, String cheminFichierEvenements, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.cheminFichierEvenements = cheminFichierEvenements;
        this.stockage = stockage;
        vue = new VEvenement();
        lancerActions();
    }

    private void lancerActions() {
        vue.getAjouterButton().setOnAction(e -> {
            CAjouterEvenement controleurAjout = new CAjouterEvenement(primaryStage, utilisateur, atelier, cheminFichierEvenements);
            controleurAjout.afficher();
        });

        vue.getFiabiliteButton().setOnAction(e -> {
            // ICI on appellera plus tard le contrôleur pour calculer la fiabilité
            System.out.println("Calcul de fiabilité : en cours de développement");
        });

        vue.getRetourButton().setOnAction(e -> {
            CAcceuil controleurAccueil = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAccueil.afficherAccueil();
        });
    }

    public void afficherSectionEvenements() {
        primaryStage.setTitle("Gestion des Événements");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}*/
