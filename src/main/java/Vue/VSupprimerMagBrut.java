/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;

/**
 * author chloe
 */

public class VSupprimerMagBrut {

    private ListView<String> listeMatieres;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox vbox;
    private Scene scene;

    public VSupprimerMagBrut() {
        listeMatieres = new ListView<>();
        listeMatieres.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        supprimerButton = Style.creerBouton("Supprimer Matière");
        retourButton = Style.creerBoutonRetour();

        Label instructionLabel = Style.creerLabel("Sélectionnez une matière à supprimer :");
        messageLabel = Style.creerLabel("");
        messageLabel.setWrapText(true);

        vbox = new VBox(15, instructionLabel, listeMatieres, supprimerButton, retourButton, messageLabel);
        vbox.setAlignment(Pos.CENTER);

        StackPane cadre = Style.creerCadreCentre(vbox);
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570,800);
    }

    public void afficherMessage(String message) {
        messageLabel.setText(message);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListeMatieres() { return listeMatieres; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}