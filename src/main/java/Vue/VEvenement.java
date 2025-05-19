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

public class VEvenement {
    private Button ajouterButton;
    private Button fiabiliteButton;
    private Button retourButton;
    private VBox layoutPrincipal;
    private Scene scene;

    public VEvenement() {
        Text titre = Style.creerTitre("Gestion des Événements");

        ajouterButton = Style.creerBouton("Ajouter un Événement");
        fiabiliteButton = Style.creerBouton("Calculer Fiabilité");
        retourButton = Style.creerBoutonRetour();

        VBox boutonsBox = new VBox(25, ajouterButton, fiabiliteButton);
        boutonsBox.setAlignment(Pos.CENTER);

        layoutPrincipal = new VBox(50, titre, boutonsBox, retourButton);
        layoutPrincipal.setAlignment(Pos.CENTER);

        StackPane cadre = Style.creerCadreCentre(layoutPrincipal);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getFiabiliteButton() {
        return fiabiliteButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}