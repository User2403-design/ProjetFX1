/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elève
 */
public class VChoisirPoste {
    private ListView<String> listePostes;
    private Button validerButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VChoisirPoste() {
        listePostes = new ListView<>();
        validerButton = new Button("Modifier ce poste");
        retourButton = new Button("Retour");

        vbox = new VBox(10);
        vbox.getChildren().addAll(
            new Label("Sélectionnez un poste à modifier :"),
            listePostes,
            validerButton,
            retourButton
        );

        scene = new Scene(vbox, 400, 600);
    }

    public ListView<String> getListePostes() {
        return listePostes;
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
