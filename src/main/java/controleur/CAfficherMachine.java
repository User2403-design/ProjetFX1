/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAfficherMachine;
import javafx.stage.Stage;
import Modele.Stockage; // Si ton stockage est dans package Modele



/**
 *
 * @author chloe
 */
public class CAfficherMachine {
   
    private Stage primaryStage;
    private VAfficherMachine vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage; // pour récupérer les machines stocker 

    public CAfficherMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        // Récupérer le texte des machines depuis stockage
        String machines = stockage.afficherToutesLesMachines();
        
        this.vueAfficher = new VAfficherMachine(machines);
        
        actionClic();
    }

    private void actionClic() {
        
        vueAfficher.getRetourButton().setOnAction(e -> {
            
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Machines");
        primaryStage.setScene(vueAfficher.getSceneListeMachines());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }

}
