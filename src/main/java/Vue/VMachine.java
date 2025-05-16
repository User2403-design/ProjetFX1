/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Pos;             // Pour alignement (Pos.CENTER)
import javafx.scene.Scene;             // Pour créer la scène
import javafx.scene.control.Button;    // Pour utiliser les boutons
import javafx.scene.effect.DropShadow; // Pour l'ombre portée
import javafx.scene.layout.StackPane;  // Pour empiler les conteneurs (cadre)
import javafx.scene.layout.VBox;        // Pour organiser verticalement
import javafx.scene.paint.Color;       // Pour gérer les couleurs
import javafx.scene.text.Font;          // Pour définir la police
import javafx.scene.text.FontWeight;    // Pour définir le poids (gras) de la police
import javafx.scene.text.Text;          // Pour afficher du texte
import javafx.scene.text.TextAlignment; // Pour aligner le texte

public class VMachine {

    // Déclaration des boutons utilisés dans la vue
    private Button retour, afficher, modifier, ajouter, supprimer;
    // Conteneur principal vertical qui organise tout
    private VBox layoutPrincipal;
    // La scène affichée dans la fenêtre principale
    private Scene scene;

    // Constructeur de la vue VMachine
    public VMachine() {
        // Création et personnalisation du titre
        Text titre = new Text("Section Machine");
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50)); // Police serif, gras, taille 50
        titre.setFill(Color.web("#333333")); // Couleur gris foncé pour un style sérieux
        titre.setTextAlignment(TextAlignment.CENTER); // Centrer le texte horizontalement

        // Style CSS commun pour les boutons principaux (bleu ciel)
        String buttonStyle = "-fx-background-color: #66e0e5;" +  // Couleur bleu ciel
                             "-fx-text-fill: white;" +            // Texte blanc
                             "-fx-font-weight: bold;" +           // Texte en gras
                             "-fx-font-size: 18px;" +             // Taille de police plus grande
                             "-fx-background-radius: 30;" +       // Bords arrondis
                             "-fx-padding: 12 40;";                // Padding vertical et horizontal

        // Instanciation des boutons avec leur texte respectif
        retour = new Button("Retour");
        afficher = new Button("Afficher");
        modifier = new Button("Modifier");
        ajouter = new Button("Ajouter");
        supprimer = new Button("Supprimer");

        // Application du style commun aux boutons d'actions (sauf retour)
        for (Button b : new Button[]{afficher, modifier, ajouter, supprimer}) {
            b.setStyle(buttonStyle);
        }

        // Style spécifique pour le bouton retour, gris clair et texte sombre
        retour.setStyle("-fx-background-color: #cccccc;" +    // Gris clair en fond
                        "-fx-text-fill: #333333;" +           // Texte gris foncé
                        "-fx-font-weight: bold;" +            // Texte en gras
                        "-fx-font-size: 18px;" +              // Taille de police identique
                        "-fx-background-radius: 30;" +        // Bords arrondis
                        "-fx-padding: 12 40;");                // Padding uniforme

        // Organisation verticale des boutons d'actions avec un espacement de 25 pixels
        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER); // Centrer horizontalement

        // Organisation principale verticale : titre, boutons d'actions, puis bouton retour en bas
        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);
        layoutPrincipal.setAlignment(Pos.CENTER); // Centrer tout verticalement et horizontalement

        // Création d'un cadre blanc arrondi autour du contenu principal
        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(600);  // Largeur maximale du cadre
        cadre.setMaxHeight(500); // Hauteur maximale du cadre
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // Fond blanc avec bords arrondis et padding interne

        // Ajout d'une ombre portée pour donner du relief au cadre
        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);               // Rayon de flou de l'ombre
        ombre.setOffsetX(0);               // Pas de décalage horizontal
        ombre.setOffsetY(8);               // Décalage vertical (ombre en dessous)
        ombre.setColor(Color.color(0, 0, 0, 0.25)); // Couleur noire avec transparence
        cadre.setEffect(ombre);            // Appliquer l'effet d'ombre au cadre

        // Conteneur racine qui centre le cadre et définit un fond gris clair pour toute la scène
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;"); // Fond gris clair
        root.setAlignment(Pos.CENTER);                    // Centrer le contenu dans la fenêtre

        // Création de la scène avec le conteneur racine, dimensions 800x600 pixels
        scene = new Scene(root, 800, 600);
    }

    // Getters pour que le contrôleur puisse accéder aux composants

    /**
     * Retourne la scène principale de cette vue.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Retourne le bouton "Retour".
     */
    public Button getRetour() {
        return retour;
    }

    /**
     * Retourne le bouton "Afficher".
     */
    public Button getAfficher() {
        return afficher;
    }

    /**
     * Retourne le bouton "Modifier".
     */
    public Button getModifier() {
        return modifier;
    }

    /**
     * Retourne le bouton "Ajouter".
     */
    public Button getAjouter() {
        return ajouter;
    }

    /**
     * Retourne le bouton "Supprimer".
     */
    public Button getSupprimer() {
        return supprimer;
    }
}