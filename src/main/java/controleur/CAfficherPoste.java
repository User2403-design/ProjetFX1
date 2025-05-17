/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VAfficherMachine;
import javafx.stage.Stage;
import Vue.VAfficherPoste;
import javafx.stage.Stage;
import Modele.Stockage; 

/**
 *
 * @author chloe
 */
public class CAfficherPoste {
  
    private Stage primaryStage;
    private VAfficherPoste vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage; // pour récupérer les machines stocker 

    public CAfficherPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        // Récupérer le texte des machines depuis stockage
        String postes = stockage.afficherTousLesPostes();
        
        this.vueAfficher = new VAfficherPoste(postes);
        
        actionClic();
    }

    private void actionClic() {
        
        vueAfficher.getRetourButton().setOnAction(e -> {
            
           Cposte controleurPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);
           controleurPoste.afficherSectionPoste();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Postes");
        primaryStage.setScene(vueAfficher.getSceneListePostes());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }

}

