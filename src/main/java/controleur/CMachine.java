/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VMachine;
import javafx.stage.Stage;
/**
 *
 * @author chloe
 */
public class CMachine {
    private Stage primaryStage;
    private VMachine vueMachine;
    

    public CMachine(Stage primaryStage, String utilisateur, String atelier) {
        
        this.primaryStage = primaryStage;
        this.vueMachine = new VMachine();
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vueMachine.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier); //crée un objet de CAcceuil afin de pouvoir appeler la methode AfficherAccueil
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
    }

    public void afficherSectionMachine() {
        primaryStage.setTitle("Section Machine");
        primaryStage.setScene(vueMachine.getScene());
        primaryStage.show();
    }
}
