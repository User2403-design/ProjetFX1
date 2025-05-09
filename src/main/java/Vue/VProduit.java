/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VProduit {
    
    Scene scene;
    Button afficher;
    Button ajouter;
    Button modifier;
    Button supprimer;
    Button retour;
    VBox vbox;

    public VProduit() {
        this.afficher = new Button("Afficher");
        this.ajouter = new Button("Ajouter");
        this.modifier = new Button("Modifier");
        this.supprimer = new Button("Supprimer");
        this.retour = new Button("Retour");

        this.vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        scene = new Scene(vbox, 600, 300);
    }

    public Scene getScene() {
        return scene;
    }
    public Button getAfficher() {
        return afficher;
    }
    public Button getAjouter() {
        return ajouter;
    }
    public Button getModifier() {
        return modifier;
    }
    public Button getSupprimer() {
        return supprimer;
    }
    public Button getRetour() {
        return retour;
    }
    public VBox getVbox() {
        return vbox;
    }
}