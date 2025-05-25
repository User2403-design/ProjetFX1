/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * author chloe
 */

public class VAjouterPoste {
    private TextField refField;
    private TextField designationField;
    private ListView<String> listeMachines;
    private Button ajouterButton;
    private Button retourButton;
    private Label erreurLabel;
    private VBox root;
    private Scene scene;

    public VAjouterPoste() {
        // Titre
        Text titre = Style.creerTitre("Ajouter un Poste");

        // Champs texte
        refField = new TextField();
        refField.setPromptText("Référence du poste");
        
        erreurLabel = new Label();
        erreurLabel.setStyle("-fx-text-fill: red;");
        
        designationField = new TextField();
        designationField.setPromptText("Désignation du poste");

        // Liste machines (multi-sélection)
        listeMachines = new ListView<>();
        listeMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeMachines.setPrefHeight(200);

        // Boutons via Style
        ajouterButton = Style.creerBouton("Ajouter Poste");
        retourButton = Style.creerBoutonRetour();

        // Boîte horizontale pour aligner les boutons au centre avec espacement
        HBox boutonsBox = new HBox(20, ajouterButton, retourButton);
        boutonsBox.setAlignment(Pos.CENTER);

        // Formulaire vertical avec labels et champs
        VBox form = new VBox(20,
            new Label("Référence :"), refField,
            new Label("Désignation :"), designationField,
            new Label("Sélectionner les machines :"), listeMachines,
            boutonsBox,
            erreurLabel
        );
        form.setPadding(new Insets(20));
        form.setMaxWidth(500);

        // Centrer le formulaire dans un cadre avec style
        root = new VBox(20, titre, Style.creerCadreCentre(form));
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f9f9f9;");
        root.setMaxWidth(450);
        root.setAlignment(Pos.TOP_CENTER);

        // Scene avec taille initiale
        scene = new Scene(root, 1570, 800);
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

    public ListView<String> getListeMachines() {
        return listeMachines;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
    public Label getErreurLabel() {
        return erreurLabel;
    }
}