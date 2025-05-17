/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Pos;             // Pour l'alignement des éléments
import javafx.scene.Scene;             // Pour créer la scène
import javafx.scene.control.Button;    // Pour utiliser les boutons
import javafx.scene.effect.DropShadow; // Pour l'ombre portée
import javafx.scene.layout.StackPane;  // Pour empiler les conteneurs (cadre)
import javafx.scene.layout.VBox;        // Pour organiser verticalement les boutons
import javafx.scene.paint.Color;       // Pour gérer les couleurs
import javafx.scene.text.Font;          // Pour définir la police
import javafx.scene.text.FontWeight;    // Pour le poids (gras) de la police
import javafx.scene.text.Text;          // Pour afficher le titre
import javafx.scene.text.TextAlignment; // Pour aligner le texte

/**
 * Vue principale pour la gestion des événements,
 * avec boutons Ajouter, Calculer Fiabilité et Retour.
 * Interface proche du style de VMachine.
 * 
 * @author Chloe
 */
public class VEvenement {

    // Boutons pour les actions disponibles
    private Button ajouterButton;
    private Button fiabiliteButton;
    private Button retourButton;

    // Conteneur principal vertical pour organiser les boutons et titre
    private VBox layoutPrincipal;

    // Scène affichée dans la fenêtre principale
    private Scene scene;

    /**
     * Constructeur de la vue VEvenement.
     * Initialise les composants et applique le style.
     */
    public VEvenement() {
        // Création et personnalisation du titre
        Text titre = new Text("Gestion des Événements");
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 40)); // Police serif, gras, taille 40
        titre.setFill(Color.web("#333333")); // Couleur gris foncé
        titre.setTextAlignment(TextAlignment.CENTER); // Texte centré horizontalement

        // Style CSS commun pour les boutons principaux (bleu ciel)
        String buttonStyle = "-fx-background-color: #66e0e5;" +  // Couleur bleu ciel
                             "-fx-text-fill: white;" +            // Texte blanc
                             "-fx-font-weight: bold;" +           // Texte en gras
                             "-fx-font-size: 18px;" +             // Taille de police
                             "-fx-background-radius: 30;" +       // Bords arrondis
                             "-fx-padding: 12 40;";                // Padding vertical et horizontal

        // Instanciation des boutons avec leur texte respectif
        ajouterButton = new Button("Ajouter un Événement");
        fiabiliteButton = new Button("Calculer Fiabilité");
        retourButton = new Button("Retour");

        // Application du style commun aux boutons d'actions (sauf retour)
        ajouterButton.setStyle(buttonStyle);
        fiabiliteButton.setStyle(buttonStyle);

        // Style spécifique pour le bouton retour, gris clair avec texte sombre
        retourButton.setStyle("-fx-background-color: #cccccc;" +    // Fond gris clair
                              "-fx-text-fill: #333333;" +           // Texte gris foncé
                              "-fx-font-weight: bold;" +            // Texte en gras
                              "-fx-font-size: 18px;" +              // Taille police identique
                              "-fx-background-radius: 30;" +        // Bords arrondis
                              "-fx-padding: 12 40;");                // Padding uniforme

        // Organisation verticale des boutons avec un espacement de 25 pixels
        VBox boutonsBox = new VBox(25, ajouterButton, fiabiliteButton);
        boutonsBox.setAlignment(Pos.CENTER); // Centrer horizontalement

        // Organisation principale verticale : titre, boutons d'actions, puis bouton retour en bas
        layoutPrincipal = new VBox(50, titre, boutonsBox, retourButton);
        layoutPrincipal.setAlignment(Pos.CENTER); // Centrer verticalement et horizontalement

        // Création d'un cadre blanc arrondi autour du contenu principal
        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(600);  // Largeur maximale du cadre
        cadre.setMaxHeight(500); // Hauteur maximale du cadre
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // Fond blanc avec bords arrondis et padding interne

        // Ajout d'une ombre portée pour donner du relief au cadre
        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);                  // Rayon de flou de l'ombre
        ombre.setOffsetX(0);                  // Pas de décalage horizontal
        ombre.setOffsetY(8);                  // Décalage vertical (ombre en dessous)
        ombre.setColor(Color.color(0, 0, 0, 0.25)); // Couleur noire avec transparence
        cadre.setEffect(ombre);               // Appliquer l'effet d'ombre au cadre

        // Conteneur racine qui centre le cadre et définit un fond gris clair pour toute la scène
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;"); // Fond gris clair
        root.setAlignment(Pos.CENTER);                    // Centrer le contenu dans la fenêtre

        // Création de la scène avec le conteneur racine, dimensions 800x600 pixels
        scene = new Scene(root, 800, 600);
    }
        /**
     * Getter pour accéder à la scène principale.
     * @return La scène affichée dans la fenêtre.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Getter pour accéder au bouton Ajouter.
     * @return Le bouton Ajouter un Événement.
     */
    public Button getAjouterButton() {
        return ajouterButton;
    }

    /**
     * Getter pour accéder au bouton Calculer Fiabilité.
     * @return Le bouton Calculer Fiabilité.
     */
    public Button getFiabiliteButton() {
        return fiabiliteButton;
    }

    /**
     * Getter pour accéder au bouton Retour.
     * @return Le bouton Retour.
     */
    public Button getRetourButton() {
        return retourButton;
    }
}