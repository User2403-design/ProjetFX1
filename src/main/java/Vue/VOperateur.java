/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

/**
 *
 * @author chloe
 */

public class VOperateur {

    Button afficher;
    Button modifier;
    Button ajouter;
    Button supprimer;
    Button retour;
    VBox layout;
        
    public VOperateur() {
        afficher = new Button("Afficher les Opérateurs");
        modifier = new Button("Modifier Opérateur");
        ajouter = new Button("Ajouter un Opérateur");
        supprimer = new Button("Supprimer un Opérateur");
        retour = new Button("Retour");

        layout = new VBox(10);
        layout.getChildren().addAll(afficher, modifier, ajouter, supprimer, retour);
    }

    public Button getAfficher() {
        return afficher;
    }

    public Button getModifier() {
        return modifier;
    }

    public Button getAjouter() {
        return ajouter;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public Button getRetour() {
        return retour;
    }

    public Scene getScene() {
        return new Scene(layout, 300, 250); // Simple taille de scène
    }
}