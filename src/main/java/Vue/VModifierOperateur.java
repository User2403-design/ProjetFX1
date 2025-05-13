
  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VModifierOperateur {

    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private CheckBox etatCheckBox;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierOperateur() {
        VBox layout = new VBox(10);

        nomField = new TextField();
        prenomField = new TextField();
        codeField = new TextField();
        etatCheckBox = new CheckBox("Disponible");

        enregistrerButton = new Button("Enregistrer les modifications");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
                new Label("Nom :"), nomField,
                new Label("Prénom :"), prenomField,
                new Label("Code :"), codeField,
                etatCheckBox,
                new HBox(10, enregistrerButton, retourButton)
        );

        scene = new Scene(layout, 400, 400);
    }

    public TextField getNomField() { return nomField; }
    public TextField getPrenomField() { return prenomField; }
    public TextField getCodeField() { return codeField; }
    public CheckBox getEtatCheckBox() { return etatCheckBox; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}