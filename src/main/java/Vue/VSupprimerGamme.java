/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class VSupprimerGamme {

    private ListView<String> listeGamme;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private VBox vbox;
    private Scene scene;

    public VSupprimerGamme() {
        listeGamme = new ListView<>();
        listeGamme.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        supprimerButton = Style.creerBouton("Supprimer Gamme");
        retourButton = Style.creerBoutonRetour();

        messageLabel = Style.creerLabel("");
        messageLabel.setWrapText(true);

        Label instructionLabel = Style.creerLabel("Sélectionner une gamme à supprimer :");

        vbox = new VBox(15, instructionLabel, listeGamme, supprimerButton, retourButton, messageLabel);
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

    // Getters
    public Scene getScene() { return scene; }
    public ListView<String> getListeGamme() { return listeGamme; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}