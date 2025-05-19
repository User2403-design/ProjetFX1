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
        // Champ de référence
        refField = new TextField();
        refField.setPromptText("Référence");

        // ListViews
        listeOperationsGamme = new ListView<>();
        listeOperationsDisponibles = new ListView<>();

        // Boutons stylisés
        ajouterOperationButton = Style.creerBouton("Ajouter Opération");
        retirerOperationButton = Style.creerBouton("Retirer Opération");
        enregistrerButton = Style.creerBouton("Enregistrer Modifications");
        retourButton = Style.creerBoutonRetour();

        // Layouts
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Label labelRef = Style.creerLabel("Référence de la Gamme :");
        Label labelOpsGamme = Style.creerLabel("Opérations de la Gamme :");
        Label labelOpsDisponibles = Style.creerLabel("Opérations Disponibles :");

        HBox boutonsOperations = new HBox(15, ajouterOperationButton, retirerOperationButton);
        boutonsOperations.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                labelRef, refField,
                labelOpsGamme, listeOperationsGamme,
                labelOpsDisponibles, listeOperationsDisponibles,
                boutonsOperations,
                enregistrerButton,
                retourButton
        );

        scene = new Scene(layout, 1570,800);
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