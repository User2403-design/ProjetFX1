/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue; // Package regroupant les classes de vue

import javafx.scene.Scene;               // Conteneur principal affiché dans la fenêtre
import javafx.scene.control.Button;     // Composant bouton cliquable
import javafx.scene.control.Label;      // Composant texte statique
import javafx.scene.control.TextField;  // Composant champ texte
import javafx.scene.layout.GridPane;    // Conteneur en grille (colonnes/lignes)
import javafx.scene.layout.StackPane;   // Conteneur empilé, utile pour centrer la grille
import javafx.geometry.Pos;              // Enumération pour alignement des éléments
import javafx.geometry.Insets;           // Gestion des marges/paddings
import javafx.scene.text.Font;           // Gestion des polices de texte
import controleur.CInitialisation;      // Contrôleur associé à cette vue

public class VInitialisation {

    private Scene scene;                  // Scène principale affichée dans le Stage (fenêtre)
    private TextField utilisateurField;  // Champ texte pour saisir le nom utilisateur
    private TextField atelierField;      // Champ texte pour saisir le nom atelier
    private Button validerButton;        // Bouton valider pour valider la saisie
    private CInitialisation controleur;  // Contrôleur associé pour gérer la logique

    // Constructeur : reçoit le contrôleur associé et construit la vue
    public VInitialisation(CInitialisation controleur) {
        this.controleur = controleur;    // Stocke la référence du contrôleur
        construireVue();                 // Initialise la vue graphique
    }

    // Méthode privée qui construit l’interface graphique complète
    private void construireVue(){
        // Création d’une grille pour organiser les champs et labels
        GridPane grid = new GridPane();
        grid.setVgap(20);                      // Espacement vertical entre lignes
        grid.setHgap(20);                      // Espacement horizontal entre colonnes
        grid.setPadding(new Insets(40));      // Marge intérieure tout autour
        grid.setAlignment(Pos.CENTER);        // Centre la grille dans la scène

        // Label pour le champ utilisateur
        Label utilisateurLabel = new Label("Nom de l'utilisateur :");
        utilisateurLabel.setFont(Font.font("Arial", 35));          
        utilisateurLabel.setStyle("-fx-text-fill: #333333;");

        // Champ texte utilisateur
        utilisateurField = new TextField();
        utilisateurField.setPrefWidth(250);                         
        utilisateurField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;");

        // Label pour le champ atelier
        Label atelierLabel = new Label("Nom de l'Atelier :");
        atelierLabel.setFont(Font.font("Arial", 35));               
        atelierLabel.setStyle("-fx-text-fill: #333333;");

        // Champ texte atelier
        atelierField = new TextField();
        atelierField.setPrefWidth(250);                              
        atelierField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;");

        // Bouton valider
        validerButton = new Button("Valider");
        validerButton.setStyle(
            "-fx-background-color: #FF69B4; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16px; " +
            "-fx-font-weight: bold; " +
            "-fx-background-radius: 15; " +
            "-fx-padding: 10 20 10 20;"
        );

        validerButton.setOnAction(e -> {
            this.controleur.ValiderButton();
        });

        validerButton.setOnMouseEntered(e -> {
            validerButton.setStyle(
                "-fx-background-color: #FF85C1; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 10 20 10 20;"
            );
        });

        validerButton.setOnMouseExited(e -> {
            validerButton.setStyle(
                "-fx-background-color: #FF69B4; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 10 20 10 20;"
            );
        });

        // Ajout des éléments dans la grille
        grid.add(utilisateurLabel, 0, 0);
        grid.add(utilisateurField, 1, 0);
        grid.add(atelierLabel, 0, 1);
        grid.add(atelierField, 1, 1);
        grid.add(validerButton, 1, 2);

        // Conteneur racine avec fond blanc et grille centrée
        StackPane root = new StackPane(grid);
        root.setStyle("-fx-background-color: white;");  // Fond blanc
        root.setAlignment(Pos.CENTER);                   // Centre la grille

        // Création finale de la scène
        scene = new Scene(root, 600, 400);
    }

    // Getter pour récupérer la scène et l’afficher dans le Stage
    public Scene getScene() {
        return scene;
    }

    // Getter pour récupérer le champ utilisateur (saisie)
    public TextField getUtilisateurField() {
        return utilisateurField;
    }

    // Getter pour récupérer le champ atelier (saisie)
    public TextField getAtelierField() {
        return atelierField;
    }

    // Getter pour récupérer le bouton valider (ajout d’action possible)
    public Button getValiderButton(){
        return validerButton;
    }
}