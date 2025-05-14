/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VModifierMagBrut {
    private TextField nomField;
    private TextField quantiteField;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierMagBrut() {
        VBox layout = new VBox(10);
        nomField = new TextField();
        quantiteField = new TextField();
        enregistrerButton = new Button("Enregistrer");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
            new Label("Nom de la matière :"), nomField,
            new Label("Quantité :"), quantiteField,
            new HBox(10, enregistrerButton, retourButton)
        );

        scene = new Scene(layout, 400, 300);
    }

    public TextField getNomField() { return nomField; }
    public TextField getQuantiteField() { return quantiteField; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}
