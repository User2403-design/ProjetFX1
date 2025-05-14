/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VMagBrut {
    private Button afficherButton;
    private Button modifierButton;
    private Button supprimerButton;
    private Button ajouterButton;
    private Button retourButton;
    private Scene scene;

    public VMagBrut() {
        afficherButton = new Button("Afficher le stock");
        modifierButton = new Button("Modifier le stock");
        ajouterButton = new Button("Ajouter une matère");
        supprimerButton = new Button("Supprimer");
        retourButton = new Button("Retour");

        VBox layout = new VBox(15);
        layout.getChildren().addAll(
                afficherButton,
                modifierButton,
                ajouterButton,
                supprimerButton,
                retourButton
        );

        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getAfficherButton() {
        return afficherButton;
    }

    public Button getModifierButton() {
        return modifierButton;
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}

