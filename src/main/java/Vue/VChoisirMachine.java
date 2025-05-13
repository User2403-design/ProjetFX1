/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VChoisirMachine {
    private ListView<String> listeMachines;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirMachine() {
        listeMachines = new ListView<>();
        validerButton = new Button("Modifier cette machine");
        retourButton = new Button("Retour");
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
            new Label("Sélectionnez une machine à modifier :"),
            listeMachines,
            validerButton,
            retourButton
        );
        scene = new Scene(vbox, 400, 500);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListeMachines() { return listeMachines; }
    public Button getValiderButton() { return validerButton; }
    public Button getRetourButton() { return retourButton; }
}