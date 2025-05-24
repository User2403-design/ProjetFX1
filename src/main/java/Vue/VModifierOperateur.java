
  
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

/**
 * author chloe
 */

public class VModifierOperateur {
    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private TextField competencesField;
    private CheckBox etatCheckBox;
    private Label erreurLabel;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierOperateur() {
        nomField = new TextField();
        prenomField = new TextField();
        codeField = new TextField();
        competencesField = new TextField();
        etatCheckBox = new CheckBox("Disponible");
        erreurLabel = new Label();
        erreurLabel.setStyle("-fx-text-fill: red;");
        // Boutons stylés
        enregistrerButton = Style.creerBouton("Enregistrer les modifications");
        retourButton = Style.creerBoutonRetour();

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().addAll(
            Style.creerLabel("Nom :"), nomField,
            Style.creerLabel("Prénom :"), prenomField,
            Style.creerLabel("Code :"), codeField,
            Style.creerLabel("Competences :"), competencesField,
            etatCheckBox,erreurLabel,
            enregistrerButton,
            retourButton
        );

        HBox boutonBox = new HBox(30, enregistrerButton, retourButton);
        boutonBox.setAlignment(Pos.CENTER);
        layout.getChildren().add(boutonBox);
        StackPane cadre = Style.creerCadreCentre(layout);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public TextField getNomField() { return nomField; }
    public TextField getPrenomField() { return prenomField; }
    public TextField getCodeField() { return codeField; }
    public TextField getCompetencesField() { return competencesField; }
    public CheckBox getEtatCheckBox() { return etatCheckBox; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
    public Label getErreurLabel() {return erreurLabel;
    }
    
}