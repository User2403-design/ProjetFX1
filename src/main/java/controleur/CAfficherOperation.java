/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VAfficherOperation;
import javafx.stage.Stage;
import Vue.VAfficherOperation;
import javafx.stage.Stage;
import Modele.Stockage; // Si ton stockage est dans package Modele

/**
 *
 * @author chloe
 */
public class CAfficherOperation {
    
    
   
    private Stage primaryStage;
    private VAfficherOperation vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage; // pour récupérer les machines stocker 

    public CAfficherOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        // Récupérer le texte des machines depuis stockage
        String operations = stockage.afficherToutesLesOperations();
        
        this.vueAfficher = new VAfficherOperation(operations);
        
        lancerActions();
    }

    private void lancerActions() {
        
        vueAfficher.getRetourButton().setOnAction(e -> {
            
            COperation controleurOperation = new COperation(primaryStage, utilisateur, atelier, stockage);
            controleurOperation.afficherSectionOperation();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Machines");
        primaryStage.setScene(vueAfficher.getSceneListeOperations());
        primaryStage.show();
    }

    
}

