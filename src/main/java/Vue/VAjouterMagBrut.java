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

public class VAjouterMagBrut {
    private TextField matiereField;
    private TextField quantiteField;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox root;

    public VAjouterMagBrut() {
        // Utilisation de Style pour créer un titre stylé
        Text titre = Style.creerTitre("Ajouter une matière au stock brut");

        matiereField = new TextField();
        matiereField.setPromptText("Nom de la matière");

        quantiteField = new TextField();
        quantiteField.setPromptText("Quantité (en kg)");

        // Boutons avec style
        ajouterButton = Style.creerBouton("Ajouter");
        retourButton = Style.creerBoutonRetour();

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        VBox formBox = new VBox(10, matiereField, quantiteField, ajouterButton, retourButton, messageLabel);
        formBox.setPadding(new Insets(20));
        formBox.setPrefWidth(300);

        // Ajout d'un cadre stylé avec ombre autour du formulaire
        StackPane cadre = Style.creerCadreCentre(formBox);

        root = new VBox(30, titre, cadre);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setMaxWidth(400);
        root.setMaxHeight(400);
        root.setAlignment(javafx.geometry.Pos.CENTER);
    }

    public Scene getScene() {
        return new Scene(root, 1570,800);
    }

    public TextField getMatiereField() {
        return matiereField;
    }

    public TextField getQuantiteField() {
        return quantiteField;
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