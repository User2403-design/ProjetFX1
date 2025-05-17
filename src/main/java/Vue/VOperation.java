/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;  // Package de la vue

import javafx.geometry.Pos;             // Import pour la gestion des alignements
import javafx.scene.Scene;              // Import pour créer une scène JavaFX
import javafx.scene.control.Button;    // Import pour utiliser des boutons
import javafx.scene.effect.DropShadow; // Import pour ajouter une ombre portée
import javafx.scene.layout.StackPane;  // Import pour empiler les conteneurs (cadre)
import javafx.scene.layout.VBox;        // Import pour organiser verticalement
import javafx.scene.paint.Color;       // Import pour gérer les couleurs
import javafx.scene.text.Font;          // Import pour définir la police
import javafx.scene.text.FontWeight;    // Import pour définir le poids (gras) de la police
import javafx.scene.text.Text;          // Import pour afficher du texte
import javafx.scene.text.TextAlignment; // Import pour aligner le texte

/**
 * @author chloe
 */

public class VOperation {
    // Déclaration des boutons utilisés dans la vue
    private Button retour, afficher, modifier, ajouter, supprimer;
    // Conteneur principal vertical qui organise tout
    private VBox layoutPrincipal;
    // La scène affichée dans la fenêtre principale
    private Scene scene;

    /**
     * Constructeur de la vue VOperation
     */
    public VOperation() {
        // Création du titre de la fenêtre
        Text titre = new Text("Section Operation");                  // Texte du titre
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));      // Police serif, gras, taille 50
        titre.setFill(Color.web("#333333"));                         // Couleur gris foncé pour sérieux
        titre.setTextAlignment(TextAlignment.CENTER);                // Centrer le texte horizontalement

        // Style commun pour les boutons d'action (bleu ciel, texte blanc, bords arrondis)
        String buttonStyle = "-fx-background-color: #66e0e5;" +      // Fond bleu ciel
                             "-fx-text-fill: white;" +                // Texte blanc
                             "-fx-font-weight: bold;" +               // Texte en gras
                             "-fx-font-size: 18px;" +                 // Taille de police 18px
                             "-fx-background-radius: 30;" +           // Bords arrondis 30px
                             "-fx-padding: 12 40;";                    // Padding vertical et horizontal

        // Initialisation des boutons avec leur texte respectif
        retour = new Button("Retour");                               // Bouton retour
        afficher = new Button("Afficher");                           // Bouton afficher
        modifier = new Button("Modifier");                           // Bouton modifier
        ajouter = new Button("Ajouter");                             // Bouton ajouter
        supprimer = new Button("Supprimer");                         // Bouton supprimer

        // Application du style commun aux boutons sauf le bouton retour
        for (Button b : new Button[]{afficher, modifier, ajouter, supprimer}) {
            b.setStyle(buttonStyle);                                 // Appliquer le style bleu ciel
        }

        // Style spécifique pour le bouton retour (gris clair, texte foncé)
        retour.setStyle("-fx-background-color: #cccccc;" +          // Fond gris clair
                        "-fx-text-fill: #333333;" +                   // Texte gris foncé
                        "-fx-font-weight: bold;" +                    // Texte en gras
                        "-fx-font-size: 18px;" +                      // Taille police 18px
                        "-fx-background-radius: 30;" +                // Bords arrondis 30px
                        "-fx-padding: 12 40;");                        // Padding vertical et horizontal

        // Boîte verticale contenant les boutons d'action, espacement 25px
        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER);                        // Centrer horizontalement

        // Organisation principale verticale : titre, boutons d'action, bouton retour en bas
        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);
        layoutPrincipal.setAlignment(Pos.CENTER);                   // Centrer verticalement et horizontalement

        // Création d'un cadre blanc arrondi autour du layout principal
        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(600);                                     // Largeur max 600px
        cadre.setMaxHeight(500);                                    // Hauteur max 500px
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // Fond blanc arrondi avec padding

        // Création et configuration de l'ombre portée sous le cadre
        DropShadow ombre = new DropShadow();                        // Nouvelle ombre portée
        ombre.setRadius(15);                                        // Rayon de flou 15px
        ombre.setOffsetX(0);                                        // Pas de décalage horizontal
        ombre.setOffsetY(8);                                        // Décalage vertical 8px
        ombre.setColor(Color.color(0, 0, 0, 0.25));                 // Couleur noire transparente (25%)
        cadre.setEffect(ombre);                                     // Appliquer l'ombre au cadre

        // Conteneur racine qui centre le cadre et met un fond gris clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");            // Fond gris clair
        root.setAlignment(Pos.CENTER);                              // Centrer contenu

        // Création de la scène principale avec dimensions 800x600
        scene = new Scene(root, 2000, 1000);
    }

    // Getters pour accéder aux boutons et à la scène
    public Scene getScene() { return scene; }
    public Button getRetour() { return retour; }
    public Button getAfficher() { return afficher; }
    public Button getModifier() { return modifier; }
    public Button getAjouter() { return ajouter; }
    public Button getSupprimer() { return supprimer; }
}