/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Fiabilite;
import Modele.Stockage;
import javafx.geometry.Insets;            // Pour les marges internes (padding)
import javafx.geometry.Pos;              // Pour aligner les éléments au centre
import javafx.scene.Scene;               // Pour créer la scène JavaFX
import javafx.scene.control.Button;     // Pour utiliser les boutons
import javafx.scene.control.Label;      // Pour afficher du texte statique
import javafx.scene.control.TextArea;   // Pour afficher une zone de texte multilignes
import javafx.scene.effect.DropShadow;  // Pour ajouter une ombre portée
import javafx.scene.layout.StackPane;   // Conteneur qui empile les éléments
import javafx.scene.layout.VBox;         // Conteneur vertical pour organiser les éléments
import javafx.scene.paint.Color;        // Pour gérer les couleurs

import java.util.Map;                   // Pour gérer la collection de fiabilités

/**
 * Vue pour afficher la fiabilité des machines avec une interface stylée
 * @author Chloe
 */
public class VAfficherFiabilite {
    // Scène principale affichée à l'utilisateur
    private Scene scene;
    // Zone de texte affichant la fiabilité des machines, non modifiable
    private TextArea fiabiliteArea;
    // Bouton permettant de revenir en arrière
    private Button retourButton;
    // Référence vers le stockage principal contenant les données
    private Stockage stockage;
    // Objet gérant les opérations liées à la fiabilité
    private Fiabilite fiab;

    /**
     * Constructeur de la vue affichant les fiabilités
     * @param fiabilites Map des noms de machines et leur fiabilité
     * @param stockage Référence au stockage principal des données
     */
    public VAfficherFiabilite(Map<String, Double> fiabilites, Stockage stockage) {
        // Initialisation de la zone de texte non éditable et avec retour à la ligne automatique
        fiabiliteArea = new TextArea();
        fiabiliteArea.setEditable(false);           // Interdiction de modification par l'utilisateur
        fiabiliteArea.setWrapText(true);             // Active le retour automatique à la ligne

        // Initialisation du bouton retour pour revenir à la vue précédente
        retourButton = new Button("Retour");

        // Stockage local des références passées en paramètres
        this.stockage = stockage;
        this.fiab = new Fiabilite(stockage);

        // Récupération du texte formaté affichant la fiabilité des machines
        String texte = fiab.afficherFiabilites(fiabilites);
        // Placement de ce texte dans la zone de texte dédiée
        fiabiliteArea.setText(texte);

        // Création d'un VBox vertical pour organiser label, zone texte et bouton
        VBox vbox = new VBox(10, new Label("Fiabilité des machines :"), fiabiliteArea, retourButton);
        vbox.setPadding(new Insets(20));            // Espacement interne autour du contenu
        vbox.setAlignment(Pos.CENTER);               // Centrer horizontalement les éléments

        // Création d'un cadre blanc arrondi contenant le VBox principal
        StackPane cadre = new StackPane(vbox);
        cadre.setMaxWidth(600);                       // Largeur maximale du cadre
        cadre.setMaxHeight(500);                      // Hauteur maximale du cadre
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // Style blanc avec bords arrondis et padding

        // Création d'une ombre portée pour donner du relief au cadre
        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);                          // Rayon de flou de l'ombre
        ombre.setOffsetX(0);                          // Pas de décalage horizontal
        ombre.setOffsetY(8);                          // Décalage vertical (ombre en dessous)
        ombre.setColor(Color.color(0, 0, 0, 0.25));  // Couleur noire transparente à 25%
        cadre.setEffect(ombre);                       // Application de l'ombre au cadre

        // Conteneur racine qui centre le cadre et définit un fond gris clair pour toute la scène
        StackPane rootStack = new StackPane(cadre);
        rootStack.setStyle("-fx-background-color: #f5f5f5;"); // Fond gris clair uniforme
        rootStack.setAlignment(Pos.CENTER);                    // Centrage horizontal et vertical du cadre

        // Création de la scène avec le conteneur racine et dimensions fixes 800x600 pixels
        scene = new Scene(rootStack, 2000, 00);
    }

    /**
     * Getter permettant d'accéder à la scène principale de cette vue
     * @return la scène JavaFX affichée
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Getter pour la zone de texte affichant les fiabilités
     * @return la TextArea affichant les fiabilités
     */
    public TextArea getFiabiliteArea() {
        return fiabiliteArea;
    }

    /**
     * Getter pour le bouton retour permettant de revenir à la vue précédente
     * @return le bouton "Retour"
     */
    public Button getRetourButton() {
        return retourButton;
    }
}
