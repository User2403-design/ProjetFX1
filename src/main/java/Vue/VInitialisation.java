/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import controleur.CInitialisation;

public class VInitialisation {
    private Scene scene;
    private TextField utilisateurField;
    private TextField atelierField;
    private Button validerButton;
    private CInitialisation controleur;

    public VInitialisation(CInitialisation controleur) {
        this.controleur = controleur;
        construireVue();
    }

    private void construireVue() {
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(40));
        grid.setAlignment(Pos.CENTER);

        // Label utilisateur avec style basique (pas dans Style.java)
        Label utilisateurLabel = new Label("Nom de l'utilisateur :");
        utilisateurLabel.setStyle("-fx-text-fill: #333333; -fx-font-size: 35px;");

        utilisateurField = new TextField();
        utilisateurField.setPrefWidth(250);
        utilisateurField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;");

        Label atelierLabel = new Label("Nom de l'Atelier :");
        atelierLabel.setStyle("-fx-text-fill: #333333; -fx-font-size: 35px;");

        atelierField = new TextField();
        atelierField.setPrefWidth(250);
        atelierField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;");

        // Bouton valider avec style via Style.creerBouton()
        validerButton = Style.creerBouton("Valider");

        // Ajout d’effet hover pour le bouton valider
        validerButton.setOnAction(e -> controleur.ValiderButton());
       
 
        validerButton.setOnMouseExited(e -> 
            validerButton.setStyle(
                "-fx-background-color: #66e0e5;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 18px;" +
                "-fx-background-radius: 30;" +
                "-fx-padding: 12 40;"
            )
        );

        grid.add(utilisateurLabel, 0, 0);
        grid.add(utilisateurField, 1, 0);
        grid.add(atelierLabel, 0, 1);
        grid.add(atelierField, 1, 1);
        grid.add(validerButton, 1, 2);

        StackPane root = Style.creerCadreCentre(grid);
        root.setStyle("-fx-background-color: white;");  // Fond blanc

        scene = new Scene(root, 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getUtilisateurField() {
        return utilisateurField;
    }

    public TextField getAtelierField() {
        return atelierField;
    }

    public Button getValiderButton() {
        return validerButton;
    }
}