/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class VAjouterOperation {
    private TextField idField;
    private TextField refField;
    private TextField dureeField;
    private ListView<String> machinesDisponibles;
    private ListView<String> postesDisponibles;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox root;
    private Scene scene;

    public VAjouterOperation() {
        // Titre stylé
        Text titre = Style.creerTitre("Ajouter une Opération");

        // Champs stylés
        idField = new TextField();
        idField.setPromptText("ID de l'opération");

        refField = new TextField();
        refField.setPromptText("Référence");

        dureeField = new TextField();
        dureeField.setPromptText("Durée en minutes");

        machinesDisponibles = new ListView<>();
        machinesDisponibles.setPrefHeight(120);

        postesDisponibles = new ListView<>();
        postesDisponibles.setPrefHeight(120);

        // Boutons stylés
        ajouterButton = Style.creerBouton("Ajouter");
        retourButton = Style.creerBoutonRetour();

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        // Formulaire avec étiquettes et champs
        GridPane formGrid = new GridPane();
        formGrid.setVgap(10);
        formGrid.setHgap(15);
        formGrid.setPadding(new Insets(10));

        formGrid.add(new Label("ID de l'opération :"), 0, 0);
        formGrid.add(idField, 1, 0);

        formGrid.add(new Label("Référence :"), 0, 1);
        formGrid.add(refField, 1, 1);

        formGrid.add(new Label("Durée (min) :"), 0, 2);
        formGrid.add(dureeField, 1, 2);

        formGrid.add(new Label("Machines disponibles :"), 0, 3);
        formGrid.add(machinesDisponibles, 1, 3);

        formGrid.add(new Label("Postes disponibles :"), 0, 4);
        formGrid.add(postesDisponibles, 1, 4);

        HBox boutonsBox = new HBox(20, ajouterButton, retourButton);
        boutonsBox.setPadding(new Insets(10, 0, 0, 0));

        VBox contenu = new VBox(15, formGrid, boutonsBox, messageLabel);
        contenu.setPadding(new Insets(20));
        contenu.setMaxWidth(450);

        StackPane cadre = Style.creerCadreCentre(contenu);

        root = new VBox(30, titre, cadre);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");
        root.setMaxWidth(600);
        root.setMaxHeight(650);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getIdField() {
        return idField;
    }

    public TextField getRefField() {
        return refField;
    }

    public TextField getDureeField() {
        return dureeField;
    }

    public ListView<String> getMachinesDisponibles() {
        return machinesDisponibles;
    }

    public ListView<String> getPostesDisponibles() {
        return postesDisponibles;
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