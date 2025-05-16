/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class VAjouterOperateur {

    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;

    public VAjouterOperateur() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titre = new Label("Ajouter un Opérateur");
        titre.setFont(new Font("Arial", 20));

        nomField = new TextField();
        nomField.setPromptText("Nom");

        prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        codeField = new TextField();
        codeField.setPromptText("Code opérateur");

        ajouterButton = new Button("Ajouter");
        retourButton = new Button("Retour");

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        VBox form = new VBox(8,
            new Label("Nom :"), nomField,
            new Label("Prénom :"), prenomField,
            new Label("Code :"), codeField,
            ajouterButton, retourButton,
            messageLabel
        );

        layout.getChildren().addAll(titre, form);

        scene = new Scene(layout);
    }

    public Scene getScene() { return scene; }
    public TextField getNomField() { return nomField; }
    public TextField getPrenomField() { return prenomField; }
    public TextField getCodeField() { return codeField; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getRetourButton() { return retourButton; }
    public Label getMessageLabel() { return messageLabel; }
}