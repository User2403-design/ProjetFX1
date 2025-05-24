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

public class VAjouterProduit {
    private TextField codeProduitField;
    private TextField designationProduitField;
    private ListView<String> listeGammesView;
    private Button ajouterButton;
    private Button retourButton;
    private Label erreurLabel;
    private Scene scene;

    public VAjouterProduit() {
        // Utilisation du style pour le titre
        Text titre = Style.creerTitre("Ajouter un Produit");

        // Champs de saisie
        codeProduitField = new TextField();
        codeProduitField.setPromptText("Ex : PRD001");

        designationProduitField = new TextField();
        designationProduitField.setPromptText("Ex : Perceuse, Scie...");

        listeGammesView = new ListView<>();
        listeGammesView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listeGammesView.setPrefHeight(150);

        // Boutons stylés avec Style
        ajouterButton = Style.creerBouton("Ajouter Produit");
        retourButton = Style.creerBoutonRetour();
        
        erreurLabel = new Label();
        erreurLabel.setStyle("-fx-text-fill: red;");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.add(new Label("Code du produit :"), 0, 0);
        formGrid.add(codeProduitField, 1, 0);
        formGrid.add(new Label("Désignation :"), 0, 1);
        formGrid.add(designationProduitField, 1, 1);
        formGrid.add(new Label("Sélectionner des gammes :"), 0, 2);
        formGrid.add(listeGammesView, 1, 2);
        formGrid.add(erreurLabel, 0, 3);

        HBox buttonBox = new HBox(15, ajouterButton, retourButton);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setStyle("-fx-alignment: center;");

        VBox content = new VBox(20, titre, formGrid, buttonBox);
        content.setPadding(new Insets(30));
        content.setStyle("-fx-background-color: #f2f7fc;");

        // Utiliser le cadre centré avec ombre de Style
        StackPane root = Style.creerCadreCentre(content);

        scene = new Scene(root, 1570,800);
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

    public Label getErreurLabel() {
        return erreurLabel;
    }
    
}