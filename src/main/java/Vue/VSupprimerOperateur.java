/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.SelectionMode;
import javafx.geometry.Pos;

/**
 * author chloe
 */

public class VSupprimerOperateur {

    private ListView<String> listeOperateurs;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;

    public VSupprimerOperateur() {
        listeOperateurs = new ListView<>();
        listeOperateurs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        supprimerButton = Style.creerBouton("Supprimer Opérateur");
        retourButton = Style.creerBoutonRetour();

        Label instructionLabel = Style.creerLabel("Sélectionnez un opérateur à supprimer :");
        messageLabel = Style.creerLabel("");
        messageLabel.setWrapText(true);

        VBox vbox = new VBox(15, instructionLabel, listeOperateurs, supprimerButton, retourButton, messageLabel);
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

    public ListView<String> getListeOperateurs() {
        return listeOperateurs;
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
}