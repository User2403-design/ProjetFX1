/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VAjouterProduit {

    private TextField codeProduitField;
    private TextField designationProduitField;
    private ListView<String> listeProduits;
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterProduit() {
        vbox = new VBox(10);

        codeProduitField = new TextField();
        codeProduitField.setPromptText("Code du produit :");

        designationProduitField = new TextField();
        designationProduitField.setPromptText("Désignation du produit :");

        listeProduits = new ListView<>();
        listeProduits.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ajouterButton = new Button("Ajouter Produit");
        retourButton = new Button("Retour");

        vbox.getChildren().addAll(
            new Label("Code du produit :"), codeProduitField,
            new Label("Désignation du produit :"), designationProduitField,
            new Label("Liste des produits :"), listeProduits,
            ajouterButton, retourButton
        );

        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getCodeProduitField() {
        return codeProduitField;
    }

    public TextField getDesignationProduitField() {
        return designationProduitField;
    }

    public ListView<String> getListeProduits() {
        return listeProduits;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}