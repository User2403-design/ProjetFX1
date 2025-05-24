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

/**
 * author chloe
 */

public class VMagBrut {
    private Button afficherButton, modifierButton, ajouterButton, supprimerButton, retourButton;
    private VBox layoutPrincipal;
    private Scene scene;

    public VMagBrut() {
        // Titre stylé via Style
        Text titre = Style.creerTitre("Gestion du Magasin de Matières Brutes");

        // Boutons stylés via Style
        afficherButton = Style.creerBouton("Afficher");
        modifierButton = Style.creerBouton("Modifier");
        ajouterButton = Style.creerBouton("Ajouter");
        supprimerButton = Style.creerBouton("Supprimer");
        retourButton = Style.creerBoutonRetour();

        // VBox boutons (sauf retour)
        VBox boutonsBox = new VBox(25, afficherButton, modifierButton, ajouterButton, supprimerButton);
        boutonsBox.setAlignment(Pos.CENTER);

        // VBox principal : titre, boutons, retour
        layoutPrincipal = new VBox(50, titre, boutonsBox, retourButton);
        layoutPrincipal.setAlignment(Pos.CENTER);

        // Cadre blanc arrondi avec ombre via Style
        StackPane cadre = Style.creerCadreCentre(layoutPrincipal);

        // Conteneur racine avec fond gris clair et centrage
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        // Création scène taille 1500x8000 
        scene = new Scene(root, 1570,800);
    }

    public void desactiver() {
        modifierButton.setDisable(true);
        ajouterButton.setDisable(true);
        supprimerButton.setDisable(true);
    }

    public Scene getScene() { return scene; }
    public Button getAfficherButton() { return afficherButton; }
    public Button getModifierButton() { return modifierButton; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}