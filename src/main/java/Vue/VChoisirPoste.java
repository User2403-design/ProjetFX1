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

public class VChoisirPoste {
    private ListView<String> listePostes;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirPoste() {
        Text titre = Style.creerTitre("Modifier un Poste");

        listePostes = new ListView<>();
        listePostes.setPrefHeight(350);

        validerButton = Style.creerBouton("Modifier ce poste");
        retourButton = Style.creerBoutonRetour();

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f2f7fc;");
        layout.getChildren().addAll(
            new Label("Sélectionnez un poste à modifier :"),
            listePostes,
            validerButton,
            retourButton
        );

        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    public ListView<String> getListePostes() {
        return listePostes;
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