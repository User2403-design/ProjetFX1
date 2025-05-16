/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class VAfficherProduit {
    private TextArea zoneAffichage;
    private Button retourButton;
    private VBox vbox;
    private Scene sceneListeProduits;

    public VAfficherProduit(String produits) {
        vbox = new VBox(10);

        zoneAffichage = new TextArea(produits);
        zoneAffichage.setEditable(false); // Lecture seule

        retourButton = new Button("Retour");

        vbox.getChildren().addAll(zoneAffichage, retourButton);
        sceneListeProduits = new Scene(vbox);
    }

    public Scene getSceneListeProduits() {
        return sceneListeProduits;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}