/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VModifierGamme {
    private TextField refField;
    private ListView<String> listeOperationsGamme;
    private ListView<String> listeOperationsDisponibles;
    private Button ajouterOperationButton;
    private Button retirerOperationButton;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierGamme() {
        // Layout principal élargi et centré
        VBox layout = new VBox(25);
        layout.setPadding(new Insets(40));
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPrefWidth(900);

        // Référence
        Label labelRef = Style.creerLabel("Référence de la Gamme :");
        refField = new TextField();
        refField.setPromptText("Référence");
        refField.setMaxWidth(Double.MAX_VALUE);

        // Listes et labels
        Label labelOpsGamme = Style.creerLabel("Opérations de la Gamme :");
        Label labelOpsDisponibles = Style.creerLabel("Opérations Disponibles :");

        listeOperationsGamme = new ListView<>();
        listeOperationsGamme.setPrefHeight(250);
        listeOperationsGamme.setPrefWidth(350);

        listeOperationsDisponibles = new ListView<>();
        listeOperationsDisponibles.setPrefHeight(250);
        listeOperationsDisponibles.setPrefWidth(350);

        // Boutons pour ajouter / retirer
        ajouterOperationButton = Style.creerBouton("Ajouter →");
        retirerOperationButton = Style.creerBouton("← Retirer");

        VBox boutonsOperations = new VBox(20, ajouterOperationButton, retirerOperationButton);
        boutonsOperations.setAlignment(Pos.CENTER);

        // Mise en page horizontale pour listes + boutons
        VBox leftBox = new VBox(10, labelOpsGamme, listeOperationsGamme);
        VBox rightBox = new VBox(10, labelOpsDisponibles, listeOperationsDisponibles);

        HBox listesBox = new HBox(30, leftBox, boutonsOperations, rightBox);
        listesBox.setAlignment(Pos.CENTER);

        // Boutons enregistrer et retour
        enregistrerButton = Style.creerBouton("Enregistrer Modifications");
        retourButton = Style.creerBoutonRetour();

        VBox.setMargin(enregistrerButton, new Insets(20, 0, 0, 0));
        VBox.setMargin(retourButton, new Insets(10, 0, 0, 0));

        // Assemblage final dans la VBox principale
        layout.getChildren().addAll(
                labelRef, refField,
                listesBox,
                enregistrerButton,
                retourButton
        );

        // Cadre centré avec style
        StackPane cadre = Style.creerCadreCentre(layout);

        // Fond global clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 1570, 800);
    }

    // Getters
    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public ListView<String> getListeOperationsGamme() { return listeOperationsGamme; }
    public ListView<String> getListeOperationsDisponibles() { return listeOperationsDisponibles; }
    public Button getAjouterOperationButton() { return ajouterOperationButton; }
    public Button getRetirerOperationButton() { return retirerOperationButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}