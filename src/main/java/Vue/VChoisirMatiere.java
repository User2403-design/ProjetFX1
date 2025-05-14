/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VChoisirMatiere {
    private ListView<String> listeMatieres;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirMatiere() {
        listeMatieres = new ListView<>();
        validerButton = new Button("Modifier cette matière");
        retourButton = new Button("Retour");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("Sélectionnez une matière à modifier :"),
            listeMatieres,
            validerButton,
            retourButton
        );

        scene = new Scene(layout, 400, 600);
    }

    public ListView<String> getListeMatieres() { return listeMatieres; }
    public Button getValiderButton() { return validerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}
