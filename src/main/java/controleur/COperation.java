/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VOperation;
import javafx.stage.Stage;
import Modele.Stockage;
import java.util.ArrayList;
import Modele.Operation;
/**
 *
 * @author chloe
 */
public class COperation {
    
    private Stage primaryStage;
    private VOperation vueOperation;
    private Stockage stockage;
    

    public COperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.vueOperation = new VOperation();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }
    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vueOperation.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); //crée un objet de CAcceuil afin de pouvoir appeler la methode AfficherAccueil
            controleurAcc.afficherAccueil();
        });

        vueOperation.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
           
            CAfficherOperation controleurAff = new CAfficherOperation(primaryStage, utilisateur, atelier, stockage );
            controleurAff.afficher();
        });

        /*vueOperation.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CModifierOperation controleurModif = new CModifierOperation(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vueOperateur.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            
            CAjouterOperateur controleurAjout = new CAjouterOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueOperateur.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerOperateur controleurSup = new CSupprimerOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });*/
    }

    public void afficherSectionOperation() {
        primaryStage.setTitle("Section Poste");
        primaryStage.setScene(vueOperation.getScene());
        primaryStage.show();
    }
} 

