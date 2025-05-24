/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;


import Modele.Stockage;
import javafx.stage.Stage;
import Vue.VAfficherFiabilite;
import java.util.Map;
import Modele.Fiabilite;

/**
 *
 * @author Elève
 */
public class CAfficherFiabilite {

    private Stage primaryStage;
    private String cheminFichier;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VAfficherFiabilite vue;

    public CAfficherFiabilite(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, String cheminFichier) {
        this.primaryStage = primaryStage;
        this.cheminFichier = cheminFichier;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        Map<String, Double> fiabilites = Fiabilite.calculerFiabiliteMachines(cheminFichier); //calcule les fiabilités et remplit la map

        this.vue = new VAfficherFiabilite(fiabilites, stockage); //affiche les fiabilité de chaque machine de l'atelier dans la vue 
        ActionClic();
    }

    private void ActionClic() {
       
        vue.getRetourButton().setOnAction(e -> {
            CEvenement cEvenement = new CEvenement(primaryStage,utilisateur, atelier,"suivie_maintenance.txt", stockage); // adapter selon besoin
            cEvenement.afficherSectionEvenements();
        });
    }

    public void afficher() {
        primaryStage.setScene(vue.getScene());
        primaryStage.setTitle("Fiabilité des machines");
        primaryStage.setMaximized(true); 
        primaryStage.show();
        
    }
}
 

    

