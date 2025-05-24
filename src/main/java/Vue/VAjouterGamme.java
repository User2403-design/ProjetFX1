/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * author chloe
 */

public class VAjouterGamme {
    private TextField refGammeField;
    private ListView<String> listeOperations;
    private Button enregistrerButton, retourButton;
    private Label messageLabel;
    private Scene scene;

    public VAjouterGamme() {
        // Titre
        var titre = Style.creerTitre("Ajouter une Gamme");

        // Champs et listes
        Label refLabel = new Label("Référence de la Gamme :");
        refGammeField = new TextField();
        refGammeField.setPromptText("Ex : G123");

        Label opLabel = new Label("Sélectionner les opérations associées :");
        listeOperations = new ListView<>();
        listeOperations.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeOperations.setPrefHeight(200);

        // Boutons stylés
        enregistrerButton = Style.creerBouton("Enregistrer");
        retourButton = Style.creerBoutonRetour();

        HBox boutonBox = new HBox(10, enregistrerButton, retourButton);
        boutonBox.setAlignment(Pos.CENTER);

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        // Layout principal
        VBox layout = new VBox(15,
            titre,
            refLabel,
            refGammeField,
            opLabel,
            listeOperations,
            boutonBox,
            messageLabel
        );
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER_LEFT);

        // Cadre centré et stylé
        StackPane cadre = Style.creerCadreCentre(layout);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    // Getters
    public Scene getScene() {
        return scene;
    }
    public TextField getRefGammeField() {
        return refGammeField;
    }
    public ListView<String> getListeOperations() {
        return listeOperations;
    }
    public Button getEnregistrerButton() {
        return enregistrerButton;
    }
    public Button getRetourButton() {
        return retourButton;
    }
    public Label getMessageLabel() {
        return messageLabel;
    }
}