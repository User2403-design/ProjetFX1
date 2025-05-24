/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
/**
 * author chloe
 */

public class VSupprimerProduit {
    
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;
    private ListView<String> listeProduits;

    public VSupprimerProduit() {
        
        // Initialisation des composants
        listeProduits = new ListView<>();
        supprimerButton = Style.creerBouton("Supprimer");
        retourButton = Style.creerBoutonRetour();
        messageLabel = Style.creerLabel("");

        Label titre = Style.creerLabel("Supprimer un produit");

        VBox vbox = new VBox(15, titre, listeProduits, supprimerButton, retourButton, messageLabel);
        vbox.setAlignment(Pos.CENTER);

        StackPane cadre = Style.creerCadreCentre(vbox);
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public void afficherMessage(String message) {
        messageLabel.setText(message);
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }

    public ListView<String> getListeProduits() {
        return listeProduits;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Scene getScene() {
        return scene;
    }
}
