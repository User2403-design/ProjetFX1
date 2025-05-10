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

public class VProduit {

    private Scene scene;
    private Button afficher;
    private Button ajouter;
    private Button modifier;
    private Button supprimer;
    private Button retour;
    private VBox vbox;

    public VProduit() {
        // Titre
        Label titre = new Label("Gestion des Produits");
        titre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Boutons
        this.afficher = new Button("Afficher les produits");
        this.ajouter = new Button("Ajouter un produit");
        this.modifier = new Button("Modifier un produit");
        this.supprimer = new Button("Supprimer un produit");
        this.retour = new Button("Retour");

        // Style uniforme pour les boutons
        for (Button btn : new Button[]{afficher, ajouter, modifier, supprimer, retour}) {
            btn.setPrefWidth(250);
            btn.setStyle("-fx-background-color: #336699; -fx-text-fill: white; -fx-font-weight: bold;");
        }

        // Mise en page
        this.vbox = new VBox(15, titre, afficher, ajouter, modifier, supprimer, retour);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-background-color: #f0f0f0;");

        // Scène
        scene = new Scene(vbox, 600, 400);
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