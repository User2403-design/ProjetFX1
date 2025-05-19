/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VChoisirMachine {
    private ListView<String> listeMachines;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirMachine() {
        // Titre stylé
        Text titre = Style.creerTitre("Modifier une Machine");

        listeMachines = new ListView<>();
        listeMachines.setPrefHeight(200);

        validerButton = Style.creerBouton("Modifier cette machine");
        retourButton = Style.creerBoutonRetour();

        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f2f7fc;");
        vbox.getChildren().addAll(
            new Label("Sélectionnez une machine à modifier :"),
            listeMachines,
            validerButton,
            retourButton
        );

        // Encapsulation dans un cadre centré avec ombre
        scene = new Scene(Style.creerCadreCentre(vbox), 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public ListView<String> getListeMachines() {
        return listeMachines;
    }

    public Button getValiderButton() {
        return validerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}