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

/**
 * author chloe
 */

public class VChoisirOperation {
    private ListView<String> listeOperations;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirOperation() {
        Text titre = Style.creerTitre("Modifier une Opération");

        listeOperations = new ListView<>();
        listeOperations.setPrefHeight(250);

        validerButton = Style.creerBouton("Modifier cette opération");
        retourButton = Style.creerBoutonRetour();

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f2f7fc;");
        layout.getChildren().addAll(
            new Label("Sélectionnez une opération à modifier :"),
            listeOperations,
            validerButton,
            retourButton
        );

        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    public ListView<String> getListeOperations() {
        return listeOperations;
    }

    public Button getValiderButton() {
        return validerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
}