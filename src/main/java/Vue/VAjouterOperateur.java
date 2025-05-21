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

public class VAjouterOperateur {
    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private TextField competencesField;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox root;
    private Scene scene;

    public VAjouterOperateur() {
        // Titre stylé avec ta classe Style
        Text titre = Style.creerTitre("Ajouter un Opérateur");

        nomField = new TextField();
        nomField.setPromptText("Nom");

        prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        codeField = new TextField();
        codeField.setPromptText("Code opérateur");
        
        competencesField = new TextField();
        competencesField.setPromptText("Code opérateur : ...,...,... ");

        // Boutons stylés
        ajouterButton = Style.creerBouton("Ajouter");
        retourButton = Style.creerBoutonRetour();

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        VBox form = new VBox(10,
            new Label("Nom :"), nomField,
            new Label("Prénom :"), prenomField,
            new Label("Code :"), codeField,
            new Label("Compétences : "), competencesField,     
            ajouterButton,
            retourButton,
            messageLabel
        );
        
        form.setPadding(new Insets(20));
        form.setPrefWidth(350);

        // Cadre stylé avec ombre
        StackPane cadre = Style.creerCadreCentre(form);

        root = new VBox(30, titre, cadre);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setMaxWidth(450);
        root.setMaxHeight(500);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

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