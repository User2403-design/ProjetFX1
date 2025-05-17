/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;  // Déclaration du package Vue

import javafx.geometry.Pos;              // Import pour gérer les positions/alignment dans les layouts
import javafx.scene.Scene;               // Import pour la création d'une scène JavaFX
import javafx.scene.control.Button;     // Import pour utiliser des boutons dans la GUI
import javafx.scene.effect.DropShadow;  // Import pour ajouter des effets d'ombre
import javafx.scene.layout.StackPane;   // Import pour un conteneur empilé (pile d'éléments)
import javafx.scene.layout.VBox;         // Import pour un conteneur vertical (box verticale)
import javafx.scene.paint.Color;        // Import pour gérer les couleurs
import javafx.scene.text.Font;           // Import pour définir la police de caractères
import javafx.scene.text.FontWeight;     // Import pour définir le poids (ex: gras) de la police
import javafx.scene.text.Text;           // Import pour afficher du texte
import javafx.scene.text.TextAlignment;  // Import pour aligner le texte

/**
 * Classe VProduit représentant la vue pour la gestion des produits
 * @author chloe
 */
public class VProduit {
    private Button retour, afficher, modifier, ajouter, supprimer;  // Déclaration des boutons utilisés
    private VBox layoutPrincipal;                                   // Conteneur principal en vertical
    private Scene scene;                                            // Scène principale affichée à l'écran

    /**
     * Constructeur de la vue VProduit
     */
    public VProduit() {
        Text titre = new Text("Section Produit");                      // Création d'un objet texte avec le titre
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));       // Définition de la police (Serif, gras, taille 50)
        titre.setFill(Color.web("#333333"));                           // Couleur du texte en gris foncé (code hexadécimal)
        titre.setTextAlignment(TextAlignment.CENTER);                  // Centrage horizontal du texte

        // Définition du style CSS commun pour les boutons (couleur, forme, taille, padding)
        String buttonStyle = "-fx-background-color: #66e0e5;" +        // Fond bleu ciel
                             "-fx-text-fill: white;" +                  // Texte blanc
                             "-fx-font-weight: bold;" +                 // Texte en gras
                             "-fx-font-size: 18px;" +                   // Taille de police 18 pixels
                             "-fx-background-radius: 30;" +             // Bords arrondis radius 30px
                             "-fx-padding: 12 40;";                      // Padding vertical 12px, horizontal 40px

        retour = new Button("Retour");                                 // Création du bouton "Retour"
        afficher = new Button("Afficher");                             // Création du bouton "Afficher"
        modifier = new Button("Modifier");                             // Création du bouton "Modifier"
        ajouter = new Button("Ajouter");                               // Création du bouton "Ajouter"
        supprimer = new Button("Supprimer");                           // Création du bouton "Supprimer"

        // Application du style commun aux boutons (sauf le bouton retour)
        for (Button b : new Button[]{afficher, modifier, ajouter, supprimer}) {
            b.setStyle(buttonStyle);                                   // Applique le style CSS défini à chaque bouton
        }

        // Style spécifique au bouton retour (fond gris clair, texte sombre, mêmes autres propriétés)
        retour.setStyle("-fx-background-color: #cccccc;" +             // Fond gris clair
                        "-fx-text-fill: #333333;" +                      // Texte gris foncé
                        "-fx-font-weight: bold;" +                       // Texte en gras
                        "-fx-font-size: 18px;" +                         // Taille police 18px
                        "-fx-background-radius: 30;" +                   // Bords arrondis 30px
                        "-fx-padding: 12 40;");                           // Padding vertical 12px, horizontal 40px

        // Conteneur vertical avec espacement de 25px entre les boutons (afficher, modifier, ajouter, supprimer)
        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER);                            // Centrage horizontal des boutons dans la VBox

        // Organisation verticale principale : titre, puis boutons d'actions, puis bouton retour en bas
        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);      // Espacement vertical de 50px entre les éléments
        layoutPrincipal.setAlignment(Pos.CENTER);                       // Centrage horizontal et vertical des éléments dans la VBox

        // Création d'un StackPane qui servira de cadre autour du contenu principal
        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(600);                                         // Largeur maximale du cadre fixée à 600px
        cadre.setMaxHeight(500);                                        // Hauteur maximale du cadre fixée à 500px
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // Fond blanc, coins arrondis radius 25px, padding interne 40px

        DropShadow ombre = new DropShadow();                            // Création d'un effet d'ombre portée
        ombre.setRadius(15);                                            // Rayon de flou de l'ombre fixé à 15px
        ombre.setOffsetX(0);                                            // Pas de décalage horizontal de l'ombre
        ombre.setOffsetY(8);                                            // Décalage vertical de 8px (ombre en dessous)
        ombre.setColor(Color.color(0, 0, 0, 0.25));                     // Couleur noire avec transparence 25%
        cadre.setEffect(ombre);                                         // Application de l'effet d'ombre au cadre

        StackPane root = new StackPane(cadre);                          // Conteneur racine contenant le cadre
        root.setStyle("-fx-background-color: #f5f5f5;");                // Fond gris clair pour toute la scène
        root.setAlignment(Pos.CENTER);                                  // Centrage du contenu dans la fenêtre

        scene = new Scene(root, 2000, 1000);                              // Création de la scène de taille 800x600 pixels
    }

    // Getters permettant au contrôleur d'accéder aux composants de la vue
    public Scene getScene() { return scene; }                         // Retourne la scène principale
    public Button getRetour() { return retour; }                       // Retourne le bouton "Retour"
    public Button getAfficher() { return afficher; }                   // Retourne le bouton "Afficher"
    public Button getModifier() { return modifier; }                   // Retourne le bouton "Modifier"
    public Button getAjouter() { return ajouter; }                     // Retourne le bouton "Ajouter"
    public Button getSupprimer() { return supprimer; }                 // Retourne le bouton "Supprimer"
}