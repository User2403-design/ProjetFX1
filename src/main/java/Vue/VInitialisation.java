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
import javafx.scene.layout.StackPane;   // Conteneur empilé, utile pour cadre avec ombre
import javafx.geometry.Pos;              // Enumération pour alignement des éléments
import javafx.geometry.Insets;           // Gestion des marges/paddings
import javafx.scene.effect.DropShadow;  // Effet d’ombre portée
import javafx.scene.paint.Color;        // Gestion des couleurs
import javafx.scene.text.Font;           // Gestion des polices de texte
import controleur.CInitialisation;      // Contrôleur associé à cette vue

public class VInitialisation {
    
    private Scene scene;               // Scène principale affichée dans le Stage (fenêtre)
    private TextField utilisateurField; // Champ texte pour saisir le nom utilisateur
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
        utilisateurLabel.setFont(Font.font("Arial", 16));          // Police Arial 16px
        utilisateurLabel.setStyle("-fx-text-fill: #333333;");      // Texte gris foncé
        
        // Champ texte utilisateur
        utilisateurField = new TextField();
        utilisateurField.setPrefWidth(250);                         // Largeur préférée
        utilisateurField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;"); // Style texte
        
        // Label pour le champ atelier
        Label atelierLabel = new Label("Nom de l'Atelier :");
        atelierLabel.setFont(Font.font("Arial", 16));               // Police Arial 16px
        atelierLabel.setStyle("-fx-text-fill: #333333;");           // Texte gris foncé
        
        // Champ texte atelier
        atelierField = new TextField();
        atelierField.setPrefWidth(250);                              // Largeur préférée
        atelierField.setStyle("-fx-font-size: 14px; -fx-text-fill: #222222;");     // Style texte
        
        // Bouton valider
        validerButton = new Button("Valider");
        // Style CSS bouton : fond rose vif, texte blanc, coins arrondis, padding
        validerButton.setStyle(
            "-fx-background-color: #FF69B4; " +    // Rose vif
            "-fx-text-fill: white; " +              // Texte blanc
            "-fx-font-size: 16px; " +               // Taille police 16px
            "-fx-font-weight: bold; " +             // Texte en gras
            "-fx-background-radius: 15; " +         // Coins arrondis
            "-fx-padding: 10 20 10 20;"              // Padding interne
        );
        
        // Action clic bouton : appelle la méthode du contrôleur
        validerButton.setOnAction(e -> {
            this.controleur.ValiderButton();
        });
        
        // Effet survol souris : couleur plus claire au passage
        validerButton.setOnMouseEntered(e -> {
            validerButton.setStyle(
                "-fx-background-color: #FF85C1; " + // Rose clair au survol
                "-fx-text-fill: white; " +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 10 20 10 20;"
            );
        });
        
        // Remise du style original quand souris quitte le bouton
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
        
        // Ajout des éléments dans la grille aux bonnes positions
        grid.add(utilisateurLabel, 0, 0);     // Colonne 0 ligne 0 : label utilisateur
        grid.add(utilisateurField, 1, 0);     // Colonne 1 ligne 0 : champ utilisateur
        grid.add(atelierLabel, 0, 1);         // Colonne 0 ligne 1 : label atelier
        grid.add(atelierField, 1, 1);         // Colonne 1 ligne 1 : champ atelier
        grid.add(validerButton, 1, 2);        // Colonne 1 ligne 2 : bouton valider
        
        // Création d’un conteneur StackPane qui servira de cadre autour de la grille
        StackPane cadre = new StackPane(grid);
        cadre.setMaxWidth(700);                // Largeur max cadre
        cadre.setMaxHeight(500);               // Hauteur max cadre
        cadre.setStyle(
            "-fx-background-color: white; " +  // Fond blanc propre
            "-fx-background-radius: 20; " +    // Bords arrondis du cadre (rayon 20px)
            "-fx-padding: 40;"                  // Padding autour de la grille
        );
        
        // Création et configuration de l’ombre portée sous le cadre
        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);                   // Flou de l’ombre
        ombre.setOffsetX(0);                   // Pas de décalage horizontal
        ombre.setOffsetY(8);                   // Décalage vertical pour ombre sous cadre
        ombre.setColor(Color.color(0, 0, 0, 0.25));  // Ombre noire avec opacité 25%
        cadre.setEffect(ombre);                // Application de l’ombre sur le cadre
        
        // Conteneur racine pour centrer le cadre dans la scène
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");  // Fond gris clair de la scène
        root.setAlignment(Pos.CENTER);                    // Centre le cadre
        
        // Création finale de la scène avec taille fixe
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