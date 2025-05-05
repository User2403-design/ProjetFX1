/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

/**
 *
 * @author chloe
 */
public class CAcceuil {
    
    validerButton.setOnAction(e -> {
            String utilisateur = utilisateurField.getText();
            String atelier = atelierField.getText();
            System.out.println("Nom de l'utilisateur : " + utilisateur);
            System.out.println("Nom de l'Atelier : " + atelier);
            
            if (!utilisateur.isEmpty() && !atelier.isEmpty()) {
                
                // Ouvrir la nouvelle fenêtre
                afficherFenetrePrincipale(utilisateur, atelier);

                //primaryStage.close(); // fermer la première fenêtre
            }  
    
        });
}
