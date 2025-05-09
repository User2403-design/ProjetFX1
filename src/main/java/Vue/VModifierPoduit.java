/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VModifierPoduit {
    private TextField codeRechercheField;     // Pour rechercher le produit à modifier
    private TextField nouveauCodeField;       // Nouveau code produit
    private TextField nouvelleDesignationField; // Nouvelle désignation
    private ComboBox<String> comboBoxGamme;    // ComboBox pour les gammes
    private Button modifierButton;
    private Button retourButton;
    private Scene scene;

    public VModifierPoduit() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        codeRechercheField = new TextField();
        codeRechercheField.setPromptText("Code du produit à modifier");
        
        nouveauCodeField = new TextField();
        nouveauCodeField.setPromptText("Nouveau code du produit");
        
        nouvelleDesignationField = new TextField();
        nouvelleDesignationField.setPromptText("Nouvelle désignation du produit");
        
        comboBoxGamme = new ComboBox<>(); // ComboBox pour les gammes
        comboBoxGamme.setPromptText("Choisir une gamme");

        modifierButton = new Button("Modifier");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
            codeRechercheField,
            nouveauCodeField,
            nouvelleDesignationField,
            comboBoxGamme, // Ajout du ComboBox
            modifierButton,
            retourButton
        );
        scene = new Scene(layout, 400, 500);
    }

    public TextField getCodeRechercheField() {
        return codeRechercheField;
    }

    public TextField getNouveauCodeField() {
        return nouveauCodeField;
    }

    public TextField getNouvelleDesignationField() {
        return nouvelleDesignationField;
    }

    public ComboBox<String> getComboBoxGamme() {
        return comboBoxGamme;
    }

    public Button getModifierButton() {
        return modifierButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
    
    public void afficherMessage(String message) {
        // Méthode pour afficher un message si nécessaire
    }
}