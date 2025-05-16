/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package controleur;

import Modele.Stockage;
import Vue.VPoste;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
/**
 *
 * @author chloe
 */ 
public class Cposte {
    // La fenêtre principale de l'application
    private Stage primaryStage;
    // La vue associée à la section Poste
    private VPoste vuePoste;
    // Le modèle de données partagé
    private Stockage stockage;
    
    // Constantes pour la taille fixe de la fenêtre
    private final double LARGEUR_FENETRE = 1200;
    private final double HAUTEUR_FENETRE = 800;
    
    /**
     * Constructeur du contrôleur Cposte.
     * @param primaryStage la fenêtre principale
     * @param utilisateur l'utilisateur connecté
     * @param atelier l'atelier sélectionné
     * @param stockage le modèle de stockage partagé
     */
    public Cposte(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        // Initialisation de la fenêtre principale
        this.primaryStage = primaryStage;
        // Création d'une nouvelle vue Poste
        this.vuePoste = new VPoste();
        // Référence au stockage des données
        this.stockage = stockage;
        // Configuration des actions des boutons
        actionClic(utilisateur, atelier);
    }
    
    /**
     * Définit les actions à effectuer lors des clics sur les boutons de la vue.
     * @param utilisateur l'utilisateur connecté
     * @param atelier l'atelier sélectionné
     */
    private void actionClic(String utilisateur, String atelier) {
        // Bouton Retour : revient à l'accueil
        vuePoste.getRetour().setOnAction(e -> {
            // Création du contrôleur accueil
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            // Affichage de la vue accueil
            controleurAcc.afficherAccueil();
        });
        
        // Bouton Afficher : affiche les postes
        vuePoste.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            // Création et affichage du contrôleur d'affichage des postes
            CAfficherPoste controleurAff = new CAfficherPoste(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });
        
        // Bouton Modifier : permet de modifier un poste
        vuePoste.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            // Création et affichage du contrôleur de modification des postes
            CChoisirPoste controleurChoisir = new CChoisirPoste(primaryStage, utilisateur, atelier, stockage);
            controleurChoisir.afficher();
        });
        
        // Bouton Ajouter : ajoute un nouveau poste
        vuePoste.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            // Création et affichage du contrôleur d'ajout de poste
            CAjouterPoste controleurAjout = new CAjouterPoste(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });
        
        // Bouton Supprimer : supprime un poste
        vuePoste.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            // Création et affichage du contrôleur de suppression de poste
            CSupprimerPoste controleurSup = new CSupprimerPoste(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }
    
    /**
     * Affiche la section Poste avec une taille fixe et position centrée.
     */
    public void afficherSectionPoste() {
        // Titre de la fenêtre
        primaryStage.setTitle("Section Poste");
        // Application de la scène correspondant à la vue Poste
        primaryStage.setScene(vuePoste.getScene());
        primaryStage.setMaximized(true);
      
    }
}