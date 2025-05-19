/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VChoisirMatiere {
    private ListView<String> listeMatieres;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirMatiere() {
        Text titre = Style.creerTitre("Modifier une Matière");

        listeMatieres = new ListView<>();
        listeMatieres.setPrefHeight(300);

        validerButton = Style.creerBouton("Modifier cette matière");
        retourButton = Style.creerBoutonRetour();

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f2f7fc;");
        layout.getChildren().addAll(
            new Label("Sélectionnez une matière à modifier :"),
            listeMatieres,
            validerButton,
            retourButton
        );

        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    public ListView<String> getListeMatieres() { return listeMatieres; }
    public Button getValiderButton() { return validerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}