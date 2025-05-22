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
import javafx.scene.text.Text;

public class VMachine {
    private Button retour, afficher, modifier, ajouter, supprimer;
    private VBox layoutPrincipal;
    private Scene scene;

    public VMachine() {
        // Titre avec Style
        Text titre = Style.creerTitre("Section Machine");

        // Boutons avec Style
        retour = Style.creerBoutonRetour();
        afficher = Style.creerBouton("Afficher");
        modifier = Style.creerBouton("Modifier");
        ajouter = Style.creerBouton("Ajouter");
        supprimer = Style.creerBouton("Supprimer");

        // VBox pour boutons sauf retour
        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER);

        // VBox principal
        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);
        layoutPrincipal.setAlignment(Pos.CENTER);

        // Cadre centré avec ombre via Style
        StackPane cadre = Style.creerCadreCentre(layoutPrincipal);

        // Conteneur racine avec fond gris clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        // Scène avec taille 2000x1000 (tu peux ajuster si besoin)
        scene = new Scene(root, 1570,800);
    }

    public void desactiver() {
        modifier.setDisable(true);
        ajouter.setDisable(true);
        supprimer.setDisable(true);
    }

    public Scene getScene() { return scene; }
    public Button getRetour() { return retour; }
    public Button getAfficher() { return afficher; }
    public Button getModifier() { return modifier; }
    public Button getAjouter() { return ajouter; }
    public Button getSupprimer() { return supprimer; }
}