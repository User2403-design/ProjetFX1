/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * @author chloe
 */

package Vue;

import javafx.geometry.Pos;               // Gestion alignement
import javafx.scene.Scene;               // Conteneur scène
import javafx.scene.control.Button;     // Boutons
import javafx.scene.layout.*;            // Layouts (VBox, HBox, StackPane)
import javafx.scene.paint.Color;        // Couleurs
import javafx.scene.text.*;              // Textes et polices
import javafx.scene.effect.DropShadow;  // Ombre portée

public class VAccueil {
    // Boutons de navigation
    private Button machine, poste, gamme, operation, operateur, produit, stock, map, deconnexion, fiabilite;
    private VBox layoutPrincipal;  // Layout principal vertical
    private Scene scene;           // Scène principale

    // Constructeur, reçoit noms utilisateur et atelier pour le titre
    public VAccueil(String utilisateur, String atelier) {
        // Création titre stylé
        TextFlow titre = new TextFlow();
        titre.setTextAlignment(TextAlignment.CENTER);

        Text bienvenue = new Text("Bienvenue ");
        bienvenue.setFill(Color.web("#333333"));
        bienvenue.setFont(Font.font("Serif", FontWeight.NORMAL, 60));

        Text nomUtilisateur = new Text(utilisateur);
        nomUtilisateur.setFill(Color.PINK);
        nomUtilisateur.setFont(Font.font("Serif", FontWeight.BOLD, 60));

        Text dans = new Text(" dans l'atelier ");
        dans.setFill(Color.web("#333333"));
        dans.setFont(Font.font("Serif", FontWeight.NORMAL, 60));

        Text nomAtelier = new Text(atelier + " !");
        nomAtelier.setFill(Color.PINK);
        nomAtelier.setFont(Font.font("Serif", FontWeight.BOLD, 60));

        titre.getChildren().addAll(bienvenue, nomUtilisateur, dans, nomAtelier);

        // Style commun boutons bleu ciel
        String buttonStyle = "-fx-background-color: #66e0e5;" + // Bleu ciel
                             "-fx-text-fill: white;" +
                             "-fx-font-weight: bold;" +
                             "-fx-font-size: 20px;" +
                             "-fx-background-radius: 30;" +
                             "-fx-padding: 10 25;";

        // Création boutons
        machine = new Button("Machine");
        poste = new Button("Poste");
        gamme = new Button("Gamme");
        operation = new Button("Opération");
        operateur = new Button("Opérateur");
        produit = new Button("Produit");
        stock = new Button("Magasin de brut");
        map = new Button("Carte de l'Atelier");
        fiabilite = new Button("Fiabilité");

        // Application style commun
        for (Button b : new Button[]{machine, poste, gamme, operation, operateur, produit, stock, map, fiabilite}) {
            b.setStyle(buttonStyle);
        }

        // Bouton déconnexion style rose
        deconnexion = new Button("Déconnexion");
        deconnexion.setStyle("-fx-background-color: #f77ca2;" +
                             "-fx-text-fill: white;" +
                             "-fx-font-weight: bold;" +
                             "-fx-font-size: 20px;" +
                             "-fx-background-radius: 30;" +
                             "-fx-padding: 10 25;");

        // Organisation des boutons sur 2 lignes + carte
        HBox ligne1 = new HBox(25, machine, poste, gamme, operation, fiabilite);
        ligne1.setAlignment(Pos.CENTER);
        HBox ligne2 = new HBox(25, operateur, produit, stock);
        ligne2.setAlignment(Pos.CENTER);
        VBox blocCentre = new VBox(30, ligne1, ligne2, map);
        blocCentre.setAlignment(Pos.CENTER);

        // Layout principal (titre, centre avec boutons, déconnexion)
        layoutPrincipal = new VBox(50, titre, blocCentre, deconnexion);
        layoutPrincipal.setAlignment(Pos.CENTER);

        // ----- Ajout du cadre blanc arrondi avec ombre -----
        // Conteneur cadre pour contenir layoutPrincipal
        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(900);  // Largeur max du cadre
        cadre.setMaxHeight(650); // Hauteur max du cadre
        cadre.setStyle(
            "-fx-background-color: white;" +      // Fond blanc propre
            "-fx-background-radius: 25;" +        // Coins arrondis rayon 25px
            "-fx-padding: 40;"                     // Padding intérieur généreux
        );

        // Ombre portée douce sous le cadre
        DropShadow ombre = new DropShadow();
        ombre.setRadius(20);                 // Flou de l’ombre
        ombre.setOffsetX(0);                 // Pas de décalage horizontal
        ombre.setOffsetY(10);                // Décalage vertical vers le bas
        ombre.setColor(Color.color(0, 0, 0, 0.3)); // Noir à 30% d’opacité
        cadre.setEffect(ombre);

        // Conteneur racine pour centrer le cadre dans la scène
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");  // Fond gris clair général
        root.setAlignment(Pos.CENTER);

        // Création scène finale
        scene = new Scene(root, 1000, 700);
    }

    // Getters pour contrôleur
    public Scene getScene() {
        return scene;
    }
    public Button getMachine() {
        return machine;
    }
    public Button getPoste() {
        return poste;
    }
    public Button getGamme() {
        return gamme;
    }
    public Button getOperation() {
        return operation;
    }
    public Button getOperateur() {
        return operateur;
    }
    public Button getProduit() {
        return produit;
    }
    public Button getStock() {
        return stock;
    }
    public Button getMap() {
        return map;
    }
    public Button getDeconnexion() {
        return deconnexion;
    }
    public Button getFiabilite() {
        return fiabilite;
    }
}