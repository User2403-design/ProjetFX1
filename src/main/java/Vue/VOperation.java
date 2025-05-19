/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VOperation {
    private Button retour, afficher, modifier, ajouter, supprimer;
    private VBox layoutPrincipal;
    private Scene scene;

    public VOperation() {
        // Utilisation de Style pour créer le titre
        var titre = Style.creerTitre("Section Operation");

        // Boutons stylés avec Style
        afficher = Style.creerBouton("Afficher");
        modifier = Style.creerBouton("Modifier");
        ajouter = Style.creerBouton("Ajouter");
        supprimer = Style.creerBouton("Supprimer");
        retour = Style.creerBoutonRetour();

        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER);

        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);
        layoutPrincipal.setAlignment(Pos.CENTER);

        // Cadre avec ombre grâce à Style
        StackPane cadre = Style.creerCadreCentre(layoutPrincipal);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public void desactiver() {
        modifier.setDisable(true);
        ajouter.setDisable(true);
        supprimer.setDisable(true);
    }

    // Getters
    public Scene getScene() { return scene; }
    public Button getRetour() { return retour; }
    public Button getAfficher() { return afficher; }
    public Button getModifier() { return modifier; }
    public Button getAjouter() { return ajouter; }
    public Button getSupprimer() { return supprimer; }
}