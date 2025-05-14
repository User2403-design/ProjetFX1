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

public class VAjouterMagBrut {

    private TextField matiereField;
    private TextField quantiteField;
    private Button ajouterButton;
    private Button retourButton;
    private VBox root;

    public VAjouterMagBrut() {
        Label titre = new Label("Ajouter une matière dans le stock brut");
        titre.setFont(new Font("Arial", 20));

        matiereField = new TextField();
        matiereField.setPromptText("Nom de la matière");

        quantiteField = new TextField();
        quantiteField.setPromptText("Quantité");

        ajouterButton = new Button("Ajouter");
        retourButton = new Button("Retour");

        VBox formBox = new VBox(10, matiereField, quantiteField, ajouterButton, retourButton);
        formBox.setPadding(new Insets(20));
        formBox.setPrefWidth(300);

        root = new VBox(15, titre, formBox);
        root.setPadding(new Insets(20));
    }

    public Scene getScene() {
        return new Scene(root, 400, 300);
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
}
