/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 *
 * @author chloe
 */
public class VAjouterProduit {
    private TextField designationField;
    private TextField codeField;
    private ListView<String> listeProduits;
    private ListView<String> listeGammes; // Renommé proprement
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterProduit() {
        vbox = new VBox(10);

        // Champs de texte pour désignation et code du produit
        designationField = new TextField();
        designationField.setPromptText("Désignation du produit :");

        codeField = new TextField();
        codeField.setPromptText("Code du produit :");

        // Liste des produits existants
        listeProduits = new ListView<>();
        listeProduits.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Liste des gammes à associer
        listeGammes = new ListView<>();
        listeGammes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // un produit -> une gamme
        // tu peux aussi mettre MULTIPLE si tu veux plusieurs gammes par produit
        listeGammes.setPlaceholder(new Label("Aucune gamme disponible"));

        // Boutons
        ajouterButton = new Button("Ajouter Produit");
        retourButton = new Button("Retour");

        // Mise en page
        vbox.getChildren().addAll(
            new Label("Code du produit :"), codeField,
            new Label("Désignation du produit :"), designationField,
            new Label("Gamme du produit :"), listeGammes,
            new Label("Liste des produits existants :"), listeProduits,
            ajouterButton, retourButton
        );

        // Création de la scène
        scene = new Scene(vbox, 400, 600);
    }

    // Getters
    public Scene getScene() {
        return scene;
    }

    public TextField getDesignationField() {
        return designationField;
    }

    public TextField getCodeField() {
        return codeField;
    }

    public VBox getVbox() {
        return vbox;
    }

    public ListView<String> getListeProduits() {
        return listeProduits;
    }

    public ListView<String> getListeGammes() {
        return listeGammes;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
    
}