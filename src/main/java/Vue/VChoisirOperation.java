/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VChoisirOperation {
    private ListView<String> listeOperations;
    private Button validerButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VChoisirOperation() {
        listeOperations = new ListView<>();
        validerButton = new Button("Modifier cette opération");
        retourButton = new Button("Retour");

        vbox = new VBox(10);
        vbox.getChildren().addAll(
            new Label("Sélectionnez une opération à modifier :"),
            listeOperations,
            validerButton,
            retourButton
        );

        scene = new Scene(vbox, 400, 400);
    }

    public ListView<String> getListeOperations() { return listeOperations; }
    public Button getValiderButton() { return validerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}
