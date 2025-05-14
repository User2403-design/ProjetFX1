/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VAjouterGamme {

    private TextField refGammeField;
    private ListView<String> listeOperations;
    private Button enregistrerButton, retourButton;
    private Label messageLabel;
    private Scene scene;

    public VAjouterGamme() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        Label refLabel = new Label("Référence de la Gamme :");
        refGammeField = new TextField();
        refGammeField.setPromptText("Ex : G123");

        Label opLabel = new Label("Sélectionner les opérations associées :");
        listeOperations = new ListView<>();
        listeOperations.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeOperations.setPrefHeight(200);

        enregistrerButton = new Button("Enregistrer");
        retourButton = new Button("Retour");

        HBox boutonBox = new HBox(10, enregistrerButton, retourButton);

        messageLabel = new Label(); // Message d'erreur ou de confirmation

        layout.getChildren().addAll(
            refLabel,
            refGammeField,
            opLabel,
            listeOperations,
            boutonBox,
            messageLabel
        );

        scene = new Scene(layout, 500, 500);
    }

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