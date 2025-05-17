/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * @author chloe
 */

package Vue;

import javafx.geometry.Pos;               // Pour gérer l'alignement des éléments
import javafx.scene.Scene;               // Conteneur principal de la scène
import javafx.scene.control.Button;     // Pour les boutons
import javafx.scene.layout.*;            // Pour les layouts (VBox, HBox, StackPane)
import javafx.scene.paint.Color;        // Pour la gestion des couleurs
import javafx.scene.text.*;              // Pour gérer les textes et polices

public class VAccueil {
    // Déclaration des boutons de navigation
    private Button machine, poste, gamme, operation, operateur, produit, stock, map, deconnexion, fiabilite;
    private VBox layoutPrincipal;  // Layout vertical principal qui contient tout
    private Scene scene;           // Scène principale affichée à l'écran

    // Constructeur : reçoit le nom de l'utilisateur et de l'atelier pour personnaliser le titre
    public VAccueil(String utilisateur, String atelier) {
        // Création d'un TextFlow pour le titre composé de plusieurs Text
        TextFlow titre = new TextFlow();
        titre.setTextAlignment(TextAlignment.CENTER);  // Centrer le texte du titre

        // Texte "Bienvenue " avec style normal, couleur gris foncé, police taille 80
        Text bienvenue = new Text("Bienvenue ");
        bienvenue.setFill(Color.web("#333333"));
        bienvenue.setFont(Font.font("Serif", FontWeight.NORMAL, 35));

        // Texte nom utilisateur en vert et gras, taille 80
        Text nomUtilisateur = new Text(utilisateur);
        nomUtilisateur.setFill(Color.GREEN);
        nomUtilisateur.setFont(Font.font("Serif", FontWeight.BOLD, 35));

        // Texte " dans l'atelier " style normal, gris foncé, taille 80
        Text dans = new Text(" dans l'atelier ");
        dans.setFill(Color.web("#333333"));
        dans.setFont(Font.font("Serif", FontWeight.NORMAL, 35));

        // Texte nom atelier en vert et gras, taille 80
        Text nomAtelier = new Text(atelier + " !");
        nomAtelier.setFill(Color.GREEN);
        nomAtelier.setFont(Font.font("Serif", FontWeight.BOLD, 35));

        // Ajout des parties du titre dans le TextFlow
        titre.getChildren().addAll(bienvenue, nomUtilisateur, dans, nomAtelier);

        // Style CSS commun pour les boutons (fond gris moyen, texte blanc, gras, taille 26, arrondi)
        String buttonStyle = "-fx-background-color: #999999;" +   // fond gris
                             "-fx-text-fill: white;" +            // texte blanc
                             "-fx-font-weight: bold;" +           // texte en gras
                             "-fx-font-size: 26px;" +              // taille de police 26 px
                             "-fx-background-radius: 30;" +       // coins arrondis rayon 30 px
                             "-fx-padding: 15 35;";                // padding interne haut/bas 15, gauche/droite 35

        // Création de tous les boutons avec leurs libellés
        machine = new Button("Machine");
        poste = new Button("Poste");
        gamme = new Button("Gamme");
        operation = new Button("Opération");
        operateur = new Button("Opérateur");
        produit = new Button("Produit");
        stock = new Button("Magasin de brut");
        map = new Button("Carte de l'Atelier");
        fiabilite = new Button("Fiabilité");

        // Application du style commun à tous les boutons sauf déconnexion
        for (Button b : new Button[]{machine, poste, gamme, operation, operateur, produit, stock, map, fiabilite}) {
            b.setStyle(buttonStyle);
        }

        // Bouton déconnexion avec style spécifique rose, texte blanc, gras, taille 26, arrondi
        deconnexion = new Button("Déconnexion");
        deconnexion.setStyle("-fx-background-color: #f77ca2;" +   // fond rose
                             "-fx-text-fill: white;" +            // texte blanc
                             "-fx-font-weight: bold;" +           // texte en gras
                             "-fx-font-size: 26px;" +              // taille de police 26 px
                             "-fx-background-radius: 30;" +       // coins arrondis rayon 30 px
                             "-fx-padding: 15 35;");               // padding interne haut/bas 15, gauche/droite 35

        // Création de la première ligne horizontale de boutons avec espace de 30 px entre eux
        HBox ligne1 = new HBox(30, machine, poste, gamme, operation, fiabilite);
        ligne1.setAlignment(Pos.CENTER);   // Centrer horizontalement les boutons

        // Création de la deuxième ligne horizontale avec les autres boutons
        HBox ligne2 = new HBox(30, operateur, produit, stock);
        ligne2.setAlignment(Pos.CENTER);   // Centrer horizontalement

        // Regroupement des deux lignes plus le bouton carte en colonne verticale avec espacement 40 px
        VBox blocCentre = new VBox(40, ligne1, ligne2, map);
        blocCentre.setAlignment(Pos.CENTER);  // Centrer verticalement le bloc

        // Layout principal vertical : titre en haut, bloc centre boutons, bouton déconnexion en bas
        layoutPrincipal = new VBox(70, titre, blocCentre, deconnexion);
        layoutPrincipal.setAlignment(Pos.CENTER);  // Centrer tout verticalement

        // Conteneur racine StackPane pour centrer le layout principal dans la scène
        StackPane root = new StackPane(layoutPrincipal);
        root.setStyle("-fx-background-color: #f5f5f5;");  // Fond gris clair de la fenêtre
        root.setAlignment(Pos.CENTER);                    // Centrer le contenu

        // Création de la scène principale avec taille 2000x1000 pixels
        scene = new Scene(root, 2000, 1000);
    }

    // Getter pour accéder à la scène depuis le contrôleur
    public Scene getScene() {
        return scene;
    }

    // Getters pour accéder aux boutons depuis le contrôleur

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