/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VChoisirOperateur {
    private ListView<String> listeOperateurs;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirOperateur() {
        listeOperateurs = new ListView<>();
        validerButton = new Button("Modifier cet opérateur");
        retourButton = new Button("Retour");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("Sélectionnez un opérateur à modifier :"),
            listeOperateurs,
            validerButton,
            retourButton
        );
        scene = new Scene(layout, 400, 600);
    }

    public ListView<String> getListeOperateurs() {
        return listeOperateurs;
    }

    public Button getValiderButton() {
        return validerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
}
