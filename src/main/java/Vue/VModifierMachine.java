/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

/**
 * author chloe
 */

public class VModifierMachine {
    private TextField refField, designationField, xField, yField, coutField, typeField;
    private ComboBox<String> etatComboBox;
    private Button enregistrerButton, retourButton;
    private Label errorLabel;  // Label pour l'erreur globale
    private Scene scene;

    public VModifierMachine() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_LEFT);

        // Utilisation des labels stylés
        layout.getChildren().add(Style.creerLabel("Référence :"));
        refField = new TextField();
        layout.getChildren().add(refField);

        layout.getChildren().add(Style.creerLabel("Désignation :"));
        designationField = new TextField();
        layout.getChildren().add(designationField);

        layout.getChildren().add(Style.creerLabel("Position X :"));
        xField = new TextField();
        layout.getChildren().add(xField);

        layout.getChildren().add(Style.creerLabel("Position Y :"));
        yField = new TextField();
        layout.getChildren().add(yField);

        layout.getChildren().add(Style.creerLabel("Coût Horaire (euro/heure) :"));
        coutField = new TextField();
        layout.getChildren().add(coutField);

        layout.getChildren().add(Style.creerLabel("Type :"));
        typeField = new TextField();
        layout.getChildren().add(typeField);

        layout.getChildren().add(Style.creerLabel("État :"));
        etatComboBox = new ComboBox<>();
        etatComboBox.getItems().addAll("libre", "panne", "occupée", "maintenance");
        layout.getChildren().add(etatComboBox);

        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        layout.getChildren().add(errorLabel);

        enregistrerButton = Style.creerBouton("Enregistrer Modifications");
        retourButton = Style.creerBoutonRetour();

        layout.getChildren().addAll(enregistrerButton, retourButton);
        layout.setMaxWidth(350);

        // Cadre centré avec style blanc et ombre
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

    public TextField getRefField() {
        return refField;
    }

    public TextField getDesignationField() {
        return designationField;
    }

    public TextField getXField() {
        return xField;
    }

    public TextField getYField() {
        return yField;
    }

    public TextField getCoutField() {
        return coutField;
    }

    public TextField getTypeField() {
        return typeField;
    }

    public ComboBox<String> getEtatComboBox() {
        return etatComboBox;
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