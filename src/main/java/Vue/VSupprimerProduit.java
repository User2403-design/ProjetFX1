/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
/**
 *
 * @author Justin
 */


public class VSupprimerProduit {
    private TextField nomField;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;
    private ListView<String> listeProduits; // Déclaration de la ListView pour afficher les produits

    public VSupprimerProduit() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        // Initialisation des éléments
       
        supprimerButton = new Button("Supprimer");
        retourButton = new Button("Retour");
        messageLabel = new Label();
        listeProduits = new ListView<>(); // Initialisation de la ListView pour afficher les produits

        // Ajout des éléments au layout
        vbox.getChildren().addAll(supprimerButton, retourButton, listeProduits, messageLabel);

        // Création de la scène
        scene = new Scene(vbox, 400, 300);
    }

    // Méthode pour afficher des messages
    public void afficherMessage(String message) {
        messageLabel.setText(message);
    }

    // Getter pour le champ de texte (nom produit)
    public TextField getNomProduitField() {
        return nomField;
    }

    // Getter pour le bouton supprimer
    public Button getSupprimerButton() {
        return supprimerButton;
    }

    // Getter pour la liste des produits
    public ListView<String> getListeProduits() {
        return listeProduits;
    }

    // Getter pour le bouton retour
    public Button getRetourButton() {
        return retourButton;
    }

    // Getter pour le label de message
    public Label getMessageLabel() {
        return messageLabel;
    }

    // Getter pour la scène
    public Scene getScene() {
        return scene;
    }
    
}