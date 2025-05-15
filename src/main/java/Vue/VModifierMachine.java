/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VModifierMachine {
    private TextField refField, designationField, xField, yField, coutField, typeField;
    private ComboBox<String> etatComboBox;
    private Button enregistrerButton, retourButton;
    private Label errorLabel;  // Label pour l'erreur globale
    private Scene scene;

    public VModifierMachine() {
        VBox layout = new VBox(10);

        // Création des champs de saisie
        refField = new TextField();
        designationField = new TextField();
        xField = new TextField();
        yField = new TextField();
        coutField = new TextField();
        typeField = new TextField();

        // ComboBox pour l'état de la machine
        etatComboBox = new ComboBox<>();
        etatComboBox.getItems().addAll("libre", "panne", "occupée", "maintenance");

        // Label d'erreur global
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);  // Le message d'erreur sera en rouge

        // Boutons d'enregistrement et retour
        enregistrerButton = new Button("Enregistrer Modifications");
        retourButton = new Button("Retour");

        // Ajout des éléments à la mise en page
        layout.getChildren().addAll(
            new Label("Référence :"), refField,
            new Label("Désignation :"), designationField,
            new Label("Position X :"), xField,
            new Label("Position Y :"), yField,
            new Label("Coût Horaire (euro/heure):"), coutField,
            new Label("Type :"), typeField,
            new Label("État :"), etatComboBox,
            errorLabel,  // Affichage de l'erreur sous les champs
            enregistrerButton,
            retourButton
        );

        scene = new Scene(layout, 400, 600);
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

    // Méthode pour accéder au label d'erreur
    public Label getErrorLabel() {
        return errorLabel;
    }
}