/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VAjouterProduit {
    private TextField codeProduitField;
    private TextField designationProduitField;
    private ListView<String> listeGammesView;
    private Button ajouterButton;
    private Button retourButton;
    private Scene scene;

    public VAjouterProduit() {
        // Titre principal
        Label titre = new Label("Ajouter un Produit");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titre.setTextFill(Color.web("#2b4d70"));

        // Champs de saisie
        Label codeLabel = new Label("Code du produit :");
        codeProduitField = new TextField();
        codeProduitField.setPromptText("Ex : P001");

        Label designationLabel = new Label("Désignation :");
        designationProduitField = new TextField();
        designationProduitField.setPromptText("Ex : Roulement, Arbre...");

        Label gammeLabel = new Label("Sélectionner des gammes :");
        listeGammesView = new ListView<>();
        listeGammesView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeGammesView.setPrefHeight(150);

        ajouterButton = new Button("Ajouter Produit");
        retourButton = new Button("Retour");

        // Mise en page avec GridPane pour alignement propre
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.add(codeLabel, 0, 0);
        formGrid.add(codeProduitField, 1, 0);
        formGrid.add(designationLabel, 0, 1);
        formGrid.add(designationProduitField, 1, 1);
        formGrid.add(gammeLabel, 0, 2);
        formGrid.add(listeGammesView, 1, 2);

        // Boutons centrés en bas
        HBox buttonBox = new HBox(15, ajouterButton, retourButton);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setStyle("-fx-alignment: center;");

        // Layout principal
        VBox root = new VBox(20, titre, formGrid, buttonBox);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f2f7fc;");

        scene = new Scene(root, 500, 450);
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getCodeField() {
        return codeProduitField;
    }

    public TextField getDesignationField() {
        return designationProduitField;
    }

    public ListView<String> getListeGammesView() {
        return listeGammesView;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}