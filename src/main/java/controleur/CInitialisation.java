/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VInitialisation;
import javafx.stage.Stage;
import Modele.Stockage;

/**
 *
 * @author Elève
 */
public class CInitialisation {
    private Stage primaryStage; //fenetre principale dont on va changer l'affichage 
    private VInitialisation vueInit; //vue que le controleur gère
    private Stockage stockage; //nécessaire pour pouvoir appeler le constructeur CAcceuil qui par la suite utilise le constructeur CMachine qui a besoin du stockage

    public CInitialisation(Stage stage, Stockage stockage) {
        this.primaryStage = stage;
        this.vueInit = new VInitialisation(this);
        this.stockage = stockage; 
    }

    public void afficherConnexion() {
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(vueInit.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    public void ValiderButton() {
        
            String utilisateur = this.vueInit.getUtilisateurField().getText();
            String atelier = this.vueInit.getAtelierField().getText();
            System.out.println("Nom de l'utilisateur : " + utilisateur);
            System.out.println("Nom de l'Atelier : " + atelier);
            
            if (!utilisateur.isEmpty() && !atelier.isEmpty()) {
                
                // crée un controleur de type CAcceuil pour pouvoir appeler afficherAccueil et afficher la nouvelle fenètre 
                CAcceuil controleurAccueil = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
                controleurAccueil.afficherAccueil();
            }
}       
}
