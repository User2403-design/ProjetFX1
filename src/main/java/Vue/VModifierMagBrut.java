/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
        enregistrerButton = new Button("Enregistrer");
        retourButton = new Button("Retour");

        // Label d'erreur global
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);  // Le message d'erreur sera en rouge

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("Nom de la matière :"), nomField,
            new Label("Quantité :"), quantiteField,
            errorLabel,  // Affichage de l'erreur sous les champs
            new HBox(10, enregistrerButton, retourButton)
        );

        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() { return scene; }
    public TextField getNomField() { return nomField; }
    public TextField getQuantiteField() { return quantiteField; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Label getErrorLabel() { return errorLabel; }  // Méthode pour accéder au label d'erreur
}