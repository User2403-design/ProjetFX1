/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.SelectionMode;

public class VSupprimerMagBrut {
    private ListView<String> listeMatieres;
    private Button supprimerButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;
    private Label messageLabel;

    public VSupprimerMagBrut() {
        vbox = new VBox(10);
        listeMatieres = new ListView<>();
        supprimerButton = new Button("Supprimer Matière");
        retourButton = new Button("Retour");
        messageLabel = new Label();

        listeMatieres.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 

        vbox.getChildren().addAll(
            new Label("Sélectionnez une matière à supprimer :"),
            listeMatieres,
            supprimerButton,
            retourButton,
            messageLabel
        );

        scene = new Scene(vbox, 500, 400);
    }

    public void afficherMessage(String message) {
        messageLabel.setText(message);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListeMatieres() { return listeMatieres; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}