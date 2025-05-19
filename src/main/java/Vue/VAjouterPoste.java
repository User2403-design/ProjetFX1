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

public class VAjouterPoste {
    private TextField refField;
    private TextField designationField;
    private ListView<String> listeMachines;
    private Button ajouterButton;
    private Button retourButton;
    private VBox root;
    private Scene scene;

    public VAjouterPoste() {
        Text titre = Style.creerTitre("Ajouter un Poste");

        refField = new TextField();
        refField.setPromptText("Référence du poste");

        designationField = new TextField();
        designationField.setPromptText("Désignation du poste");

        listeMachines = new ListView<>();
        listeMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeMachines.setPrefHeight(200);

        ajouterButton = Style.creerBouton("Ajouter Poste");
        retourButton = Style.creerBoutonRetour();

        VBox form = new VBox(10,
            new Label("Référence :"), refField,
            new Label("Désignation :"), designationField,
            new Label("Sélectionner les machines :"), listeMachines,
            new HBox(15, ajouterButton, retourButton)
        );
        form.setPadding(new Insets(15));
        form.setMaxWidth(350);

        root = new VBox(20, titre, Style.creerCadreCentre(form));
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f9f9f9;");
        root.setMaxWidth(450);

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

    public ListView<String> getListeMachines() {
        return listeMachines;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}