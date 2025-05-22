/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VEvenement;
import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Fiabilite;

public class CEvenement {
    
    private Stage primaryStage;
    private VEvenement vue;
    private String utilisateur;
    private String atelier;
    private String cheminFichierEvenements;
    private Stockage stockage;
    private Fiabilite fiabilite;
    private String role; // rôle de l'utilisateur
    
    public CEvenement(Stage primaryStage, String utilisateur, String atelier, String cheminFichierEvenements, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.cheminFichierEvenements = cheminFichierEvenements;
        this.stockage = stockage;
        this.role = stockage.getRole(utilisateur); // récupération du rôle
        vue = new VEvenement();
        appliquerRestrictions();
        actionClic();
    }
    
    private void appliquerRestrictions() {
        switch (role) {
            case "operateur":
                // Opérateur a accès aux deux boutons, on ne désactive rien
                break;
            case "maintenance":
                // Maintenance n'a PAS accès à Ajouter
                vue.getAjouterButton().setDisable(true);
                break;
            case "chef":
                // Chef a accès à tout, ne rien faire
                break;
            default:
                // Autres rôles : désactiver Ajouter par sécurité
                vue.getAjouterButton().setDisable(true);
                break;
        }
    }
    
    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> {
            CAjouterEvenement controleurAjout = new CAjouterEvenement(primaryStage, utilisateur, atelier, "suivie_maintenance.txt", stockage);
            controleurAjout.afficher();
        });
        vue.getFiabiliteButton().setOnAction(e -> {
            System.out.println("Calcul de fiabilité : en cours de développement");
            CAfficherFiabilite cFiabilite = new CAfficherFiabilite(primaryStage, utilisateur, atelier, stockage, "suivie_maintenance.txt");
            cFiabilite.afficher();
        });
        vue.getRetourButton().setOnAction(e -> {
            CAcceuil controleurAccueil = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAccueil.afficherAccueil();
        });
    }
    
    public void afficherSectionEvenements() {
        primaryStage.setTitle("Gestion des Événements");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}