/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAfficherMachine;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CAfficherMachine {
    
    private Stage primaryStage;
    private VAfficherMachine vueMachine;

    public CAfficherMachine(Stage primaryStage, String utilisateur, String atelier) {
        
        this.primaryStage = primaryStage;
        this.vueMachine = new VAfficherMachine(utilisateur, atelier);
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vueMachine.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier);
            controleurAcc.afficherAccueil();
        });

        vueMachine.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
        });

        vueMachine.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
        });

        vueMachine.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
        });

        vueMachine.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
        });


    public void afficherMachine() {
        primaryStage.setTitle("Section Machine");
        primaryStage.setScene(vueMachine.getScene());
        primaryStage.show();
    }
}
