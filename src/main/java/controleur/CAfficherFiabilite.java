/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;



import Modele.Machine;

import Vue.VAfficherFiabilite;

import Modele.Stockage;
import javafx.stage.Stage;

import java.util.Map;
import Modele.Fiabilite;

/**
 *
 * @author Elève
 */
public class CAfficherFiabilite {

    private Stage primaryStage;
    private VAfficherFiabilite vue;
    private Fiabilite fiabilite; // ton objet Fiabilite existant
    private long tempsObservation; // en minutes
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CAfficherFiabilite(Stage primaryStage, Fiabilite fiabilite, long tempsObservation) {
        this.primaryStage = primaryStage;
        this.fiabilite = fiabilite;
        this.tempsObservation = tempsObservation;
        vue = new VAfficherFiabilite();
        afficherFiabilites();
        lancerActions();
    }

    private void afficherFiabilites() {
        // On appelle ta méthode existante correctement
        Map<String, Double> fiabilites = fiabilite.calculerFiabilites(tempsObservation);

        // On affiche proprement chaque machine et son pourcentage
        for (Map.Entry<String, Double> entry : fiabilites.entrySet()) {
            String machine = entry.getKey();
            double pourcentage = entry.getValue() * 100.0;
            vue.getListeFiabilite().getItems().add(machine + " : " + String.format("%.2f", pourcentage) + "%");
        }
    }

    private void lancerActions() {
        vue.getRetourButton().setOnAction(e -> {
            CEvenement cEvenement = new CEvenement(primaryStage, utilisateur, atelier, "machine.txt", stockage);
            cEvenement.afficherSectionEvenements();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Fiabilité des Machines");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
 

    

