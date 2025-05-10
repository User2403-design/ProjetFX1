/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VOperateur {

    private Button afficher;
    private Button modifier;
    private Button ajouter;
    private Button supprimer;
    private Button retour;
    private VBox layout;
    private Scene scene;

    public VOperateur() {
        // Titre
        Label titre = new Label("Gestion des Opérateurs");
        titre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Boutons
        afficher = new Button("Afficher les Opérateurs");
        modifier = new Button("Modifier un Opérateur");
        ajouter = new Button("Ajouter un Opérateur");
        supprimer = new Button("Supprimer un Opérateur");
        retour = new Button("Retour");

        // Style des boutons
        for (Button btn : new Button[]{afficher, modifier, ajouter, supprimer, retour}) {
            btn.setPrefWidth(250);
            btn.setStyle("-fx-background-color: #2a6592; -fx-text-fill: white; -fx-font-weight: bold;");
        }

        // Layout
        layout = new VBox(15, titre, afficher, modifier, ajouter, supprimer, retour);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        scene = new Scene(layout, 600, 400);
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
        return scene;
    }
}