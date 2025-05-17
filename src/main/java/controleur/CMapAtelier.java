/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;  // Package du contrôleur

import javafx.stage.Stage;           // Fenêtre principale
import Vue.VMapAtelier;              // Vue de la carte atelier
import Modele.Machine;               // Modèle Machine
import Modele.Stockage;              // Modèle Stockage
import java.util.List;               // Liste java
import Repertoire.GrandEcran;        // Utilitaire plein écran

/**
 * Contrôleur pour la carte de l'atelier affichant les machines
 * @author chloe
 */
public class CMapAtelier {
    
    private Stage primaryStage;       // Fenêtre principale
    private VMapAtelier vueMap;       // Vue de la carte atelier
    private String utilisateur;       // Nom utilisateur (pas utilisé ici mais à passer)
    private String atelier;           // Nom atelier (idem)
    private Stockage stockage;        // Modèle Stockage
    
    /**
     * Constructeur
     * @param primaryStage fenêtre principale
     * @param stockage modèle des données
     */
    public CMapAtelier(Stage primaryStage, Stockage stockage) {
        this.primaryStage = primaryStage;           // Stockage de la fenêtre
        this.stockage = stockage;                    // Stockage du modèle
        List<Machine> machines = stockage.getListeMachines(); // Récupération des machines
        this.vueMap = new VMapAtelier(machines);    // Création de la vue avec les machines
        
        // Action clic sur bouton retour, ici on doit avoir utilisateur et atelier
        actionClic(utilisateur, atelier);
    }
    
    /**
     * Définit l'action sur le bouton retour
     * @param utilisateur nom utilisateur
     * @param atelier nom atelier
     */
    private void actionClic(String utilisateur, String atelier){
        vueMap.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); // Création du contrôleur accueil
            controleurAcc.afficherAccueil();  // Affichage accueil
        });
    }
    
    /**
     * Affiche la vue carte atelier en plein écran
     */
    public void afficher() {
        primaryStage.setTitle("Carte de l'Atelier");         // Titre de la fenêtre
        primaryStage.setScene(vueMap.getScene());            // Affectation de la scène
        GrandEcran.afficherPleinEcran(primaryStage, vueMap.getScene()); // Plein écran via utilitaire
    }
}