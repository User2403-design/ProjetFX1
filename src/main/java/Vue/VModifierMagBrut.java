/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

/**
 * author chloe
 */

public class VModifierMagBrut {
    private TextField nomField;
    private TextField quantiteField;
    private Button enregistrerButton;
    private Button retourButton;
    private Label errorLabel;  // Label pour l'erreur de quantité
    private Scene scene;

    public VModifierMagBrut() {
        nomField = new TextField();
        quantiteField = new TextField();

        // Utilisation des boutons stylés
        enregistrerButton = Style.creerBouton("Enregistrer");
        retourButton = Style.creerBoutonRetour();

        // Label d'erreur en rouge
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().addAll(
            Style.creerLabel("Nom de la matière :"), nomField,
            Style.creerLabel("Quantité (en kg) :"), quantiteField,
            errorLabel,
            new HBox(10, enregistrerButton, retourButton)
        );

        // Centrer horizontalement les boutons
        ((HBox) layout.getChildren().get(layout.getChildren().size() - 1)).setAlignment(Pos.CENTER);

        layout.setMaxWidth(350);

        // Cadre blanc arrondi avec ombre
        StackPane cadre = Style.creerCadreCentre(layout);

        // Racine avec fond gris clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getNomField() {
        return nomField;
    }

    public TextField getQuantiteField() {
        return quantiteField;
    }

    public Button getEnregistrerButton() {
        return enregistrerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
}