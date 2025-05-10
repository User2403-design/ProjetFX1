/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VAjouterOperateur {

    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterOperateur() {
        vbox = new VBox(10);

        nomField = new TextField();
        nomField.setPromptText("Nom de l'opérateur :");

        prenomField = new TextField();
        prenomField.setPromptText("Prénom de l'opérateur :");

        codeField = new TextField();
        codeField.setPromptText("Code de l'opérateur :");

        ajouterButton = new Button("Ajouter Opérateur");
        retourButton = new Button("Retour");

        vbox.getChildren().addAll(
            new Label("Nom de l'opérateur :"), nomField,
            new Label("Prénom de l'opérateur :"), prenomField,
            new Label("Code de l'opérateur :"), codeField,
            ajouterButton, retourButton
        );

        scene = new Scene(vbox, 400, 300);
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
}