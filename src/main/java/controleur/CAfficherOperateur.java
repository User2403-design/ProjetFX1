/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VAfficherOperateur;
import javafx.stage.Stage;
import Modele.Stockage;
/**
 *
 * @author chloe
 */
public class CAfficherOperateur {
       
    private Stage primaryStage;
    private VAfficherOperateur vueAfficher;
    private String utilisateur;
    private String atelier;
    private Stockage stockage; 

    public CAfficherOperateur (Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        
        // Récupérer le texte affichant les operateurs depuis stockage
        String operateurs = stockage.afficherToutesLesOperateurs();
        
        this.vueAfficher = new VAfficherOperateur(operateurs);
        
        actionClic();
    }

    private void actionClic() {
        
        vueAfficher.getRetourButton().setOnAction(e -> {
            
            COperateur controleurOperateur = new COperateur(primaryStage, utilisateur, atelier, stockage);
            controleurOperateur.afficherSectionOperateur();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Liste des Operateurs");
        primaryStage.setScene(vueAfficher.getSceneListeOperateurs());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }

}


