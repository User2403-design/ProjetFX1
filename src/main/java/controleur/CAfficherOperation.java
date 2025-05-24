/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VAfficherOperation;
import javafx.stage.Stage;
import Modele.Stockage; 

/**
 *
 * @author chloe
 */
public class CAfficherOperation {
    
    
   
    private Stage primaryStage;
    private VAfficherOperation vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage; 

    public CAfficherOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        // Récupérer l'affichage des operations depuis stockage
        String operations = stockage.afficherToutesLesOperations();
        
        this.vueAfficher = new VAfficherOperation(operations);
        
        actionClic();
    }

    private void actionClic() {
        
        vueAfficher.getRetourButton().setOnAction(e -> {
            
            COperation controleurOperation = new COperation(primaryStage, utilisateur, atelier, stockage);
            controleurOperation.afficherSectionOperation();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Opérations");
        primaryStage.setScene(vueAfficher.getSceneListeOperations());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }

    
}

