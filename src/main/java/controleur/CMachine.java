/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VMachine;
import javafx.stage.Stage;
import Modele.Stockage;
import Modele.FichierMachine;
import java.util.ArrayList;
import Modele.Machine;
/**
 *
 * @author chloe
 */
public class CMachine {
    private Stage primaryStage;
    private VMachine vueMachine;
    private Stockage stockage;
    

    public CMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.vueMachine = new VMachine();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vueMachine.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); //crée un objet de CAcceuil afin de pouvoir appeler la methode AfficherAccueil
            controleurAcc.afficherAccueil();
        });

        vueMachine.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            
            CAfficherMachine controleurAff = new CAfficherMachine(primaryStage, utilisateur, atelier, stockage );
            controleurAff.afficher();
        });

        vueMachine.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CModifierMachine controleurModif = new CModifierMachine(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vueMachine.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            
            CAjouterMachine controleurAjout = new CAjouterMachine(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueMachine.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerMachine controleurSup = new CSupprimerMachine(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    public void afficherSectionMachine() {
        primaryStage.setTitle("Section Machine");
        primaryStage.setScene(vueMachine.getScene());
        primaryStage.show();
    }
}
