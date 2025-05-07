/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VInitialisation;
import Vue.VAccueil;
import javafx.stage.Stage;

/**
 *
 * @author Elève
 */
public class CInitialisation {
    private Stage primaryStage;
    private VInitialisation vueInit;

    public CInitialisation(Stage stage) {
        this.primaryStage = stage;
        this.vueInit = new VInitialisation(this);
    }

    public void afficherConnexion() {
        primaryStage.setScene(vueInit.getScene());
        primaryStage.show();
    }

    /*public void connexionReussie(String utilisateur, String atelier) {
        ControleurPrincipal controleurPrincipal = new ControleurPrincipal(stage, utilisateur, atelier);
        controleurPrincipal.afficherPrincipale();
    }*/
    
    /*public void ValiderButton() {
        
            String utilisateur = this.vueInit.getUtilisateurField().getText();
            String atelier = this.vueInit.getAtelierField().getText();
            System.out.println("Nom de l'utilisateur : " + utilisateur);
            System.out.println("Nom de l'Atelier : " + atelier);
            
            if (!utilisateur.isEmpty() && !atelier.isEmpty()) {
                
                // Ouvrir la nouvelle fenêtre
                //afficherFenetrePrincipale(utilisateur, atelier);
                Vaccueil vueAccueil = new Vaccueil();
                primaryStage.setScene(VAccueil.getScene());//faire le getScene dans Vaccueil
            }
}*/       
}
