/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;

/**
 * author chloe
 */

public class VAjouterEvenement {
    private TextField dateField;
    private TextField heureField;
    private TextField machineField;
    private ComboBox<String> typeComboBox;
    private TextField operateurField;
    private TextField causeField;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox vbox;
    private Scene scene;

    public VAjouterEvenement() {
        // Titre stylé
        var titre = Style.creerTitre("Ajouter un Événement");

        // Champs texte
        dateField = new TextField();
        dateField.setPromptText("Date (yyyy-MM-dd)");

        heureField = new TextField();
        heureField.setPromptText("Heure (HH:mm)");

        machineField = new TextField();
        machineField.setPromptText("Machine");

        typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("A", "D"); // A pour arrêt, D pour démarrage
        typeComboBox.setPromptText("Type d'événement");

        operateurField = new TextField();
        operateurField.setPromptText("Opérateur");

        causeField = new TextField();
        causeField.setPromptText("Cause");

        // Boutons stylés
        ajouterButton = Style.creerBouton("Ajouter Événement");
        retourButton = Style.creerBoutonRetour();

        // Label message
        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        // VBox avec espacement et alignement
        vbox = new VBox(10,
            titre,
            new Label("Date :"), dateField,
            new Label("Heure :"), heureField,
            new Label("Machine :"), machineField,
            new Label("Type (Arrêt ou Démarage) :"), typeComboBox,
            new Label("Opérateur :"), operateurField,
            new Label("Cause :"), causeField,
            ajouterButton,
            retourButton,
            messageLabel
        );
        vbox.setAlignment(Pos.CENTER_LEFT);

        // Cadre stylé centré
        StackPane cadre = Style.creerCadreCentre(vbox);

        // Racine de la scène
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    // Getters
    public Scene getScene() {
        return scene;
    }
    public TextField getDateField() {
        return dateField;
    }
    public TextField getHeureField() {
        return heureField;
    }
    public TextField getMachineField() {
        return machineField;
    }
    public ComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }
    public TextField getOperateurField() {
        return operateurField;
    }
    public TextField getCauseField() {
        return causeField;
    }
    public Button getAjouterButton() {
        return ajouterButton;
    }
    public Button getRetourButton() {
        return retourButton;
    }
    public Label getMessageLabel() {
        return messageLabel;
    }
}