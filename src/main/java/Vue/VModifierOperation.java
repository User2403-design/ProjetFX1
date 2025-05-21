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

public class VModifierOperation {
    private TextField idField;
    private TextField refField;
    private TextField dureeField;
    private ListView<String> machinesDisponibles;
    private ListView<String> postesDisponibles;
    private Button enregistrerButton;
    private Button retourButton;
    private Label errorLabel;  // Label pour l'erreur de durée
    private Scene scene;

    public VModifierOperation() {
        // Champs
        idField = new TextField();
        refField = new TextField();
        dureeField = new TextField();
        machinesDisponibles = new ListView<>();
        postesDisponibles = new ListView<>();
        
        // Boutons stylés via Style
        enregistrerButton = Style.creerBouton("Enregistrer");
        retourButton = Style.creerBoutonRetour();
        
        // Label d'erreur rouge
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        
        // Labels personnalisés (optionnel: tu peux aussi créer un style Label si besoin)
        Label idLabel = new Label("ID de l'opération :");
        Label refLabel = new Label("Référence :");
        Label dureeLabel = new Label("Durée (min):");
        Label machinesLabel = new Label("Machines disponibles :");
        Label postesLabel = new Label("Postes disponibles :");
        
        // Layout vertical principal
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            idLabel, idField,
            refLabel, refField,
            dureeLabel, dureeField,
            machinesLabel, machinesDisponibles,
            postesLabel, postesDisponibles,
            errorLabel,
            new HBox(10, enregistrerButton, retourButton)
        );

        // Centrer le layout et appliquer le cadre stylé
        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    // Getters
    public Scene getScene() { return scene; }
    public TextField getIdField() { return idField; }
    public TextField getRefField() { return refField; }
    public TextField getDureeField() { return dureeField; }
    public ListView<String> getMachinesDisponibles() { return machinesDisponibles; }
    public ListView<String> getPostesDisponibles() { return postesDisponibles; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Label getErrorLabel() { return errorLabel; }
}