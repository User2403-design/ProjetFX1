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

/**
 *
 * @author chloe
 */
public class VAjouterProduit {

    private TextField nomField;
    private TextField prenomField; // À adapter si un produit n'a pas de "prénom"
    private TextField codeField;
    private ListView<String> listeProduits;
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterProduit() {
        vbox = new VBox(10);

        // Champs de texte pour nom, prénom et code du produit
        nomField = new TextField();
        nomField.setPromptText("Nom du produit :");

        prenomField = new TextField();
        prenomField.setPromptText("Prénom du produit :"); // À adapter si non pertinent

        codeField = new TextField();
        codeField.setPromptText("Code du produit :");

        // Liste des produits, si nécessaire pour afficher ceux déjà existants
        listeProduits = new ListView<>();
        listeProduits.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Boutons pour ajouter un produit et revenir à l'écran précédent
        ajouterButton = new Button("Ajouter Produit");
        retourButton = new Button("Retour");

        // Mise en page avec labels et champs
        vbox.getChildren().addAll(
            new Label("Nom du produit :"), nomField,
            new Label("Prénom du produit :"), prenomField,
            new Label("Code du produit :"), codeField,
            new Label("Liste des produits :"), listeProduits,
            ajouterButton, retourButton
        );

        // Création de la scène
        scene = new Scene(vbox, 400, 600);
    }

    // Getters pour accéder aux éléments
    public Scene getScene() {
        return scene;
    }

    public TextField getNomField() {
        return nomField;
    }

    public TextField getPrenomField() {
        return prenomField;
    }

    public TextField getCodeField() {
        return codeField;
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