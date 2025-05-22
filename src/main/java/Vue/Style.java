/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Vue; 

import javafx.scene.Node; // nécessaire pour manipuler les éléments d'interface génériques, permet à la méthode d'être generique et réutilisable
import javafx.geometry.Pos; // pour les alignements
import javafx.scene.control.Button; // pour les boutons
import javafx.scene.control.Label; // pour les étiquettes
import javafx.scene.control.TextArea; // pour les zones de texte
import javafx.scene.layout.StackPane; // conteneur qui superpose les éléments
import javafx.scene.paint.Color; // pour gérer les couleurs
import javafx.scene.text.Font; // pour gérer les polices
import javafx.scene.text.FontWeight; // pour gérer l'épaisseur de la police
import javafx.scene.text.Text; // pour les objets texte
import javafx.scene.text.TextAlignment; // pour l'alignement du texte

/**
 * 
 * @author chloe
 */
public class Style {

    public static Text creerTitre(String texte) { // méthode pour créer un titre stylisé
        Text titre = new Text(texte); // création d'un objet texte avec le contenu passé
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50)); // police serif, en gras, de taille 50
        titre.setFill(Color.web("#333333")); // couleur gris foncé
        titre.setTextAlignment(TextAlignment.CENTER); // centré horizontalement
        return titre; // retourne l'objet texte
    }

    public static Label creerLabel(String texte) { // méthode pour créer un label stylisé
        Label label = new Label(texte); // création du label
        label.setFont(Font.font("Serif", FontWeight.BOLD, 18)); // police serif, en gras, de taille 18
        label.setTextFill(Color.web("#333333")); // couleur gris foncé
        label.setAlignment(Pos.CENTER_LEFT); // aligné à gauche
        return label; 
    }

    public static TextArea creerZoneTexte(String contenu) { // méthode pour créer une zone de texte non modifiable
        TextArea zone = new TextArea(contenu); // création de la zone de texte avec le contenu
        zone.setEditable(false); // zone non modifiable
        zone.setWrapText(true); // retour automatique à la ligne
        zone.setPrefHeight(400); // hauteur "préférée" de 400 pixels
        zone.setStyle("-fx-font-size: 16px; -fx-padding: 15; -fx-background-radius: 15;"); // style css, bords arrondis
        return zone; 
    }

    public static Button creerBoutonRetour() { // méthode pour créer un bouton "Retour" stylisé
        Button retour = new Button("Retour"); // création du bouton avec texte "Retour"
        retour.setStyle("-fx-background-color: #cccccc;" + // fond gris clair
                        "-fx-text-fill: #333333;" + // texte gris foncé
                        "-fx-font-weight: bold;" + // texte en gras
                        "-fx-font-size: 18px;" + // taille du texte 18px
                        "-fx-background-radius: 30;" + // bords arrondis
                        "-fx-padding: 12 40;"); // espacement intérieur haut/bas 12, gauche/droite 40
        return retour; // retourne bouton retour
    }

    public static Button creerBouton(String texte) { 
        Button bouton = new Button(texte); // création du bouton avec texte personnalisé
        bouton.setStyle("-fx-background-color: #66e0e5;" + // fond bleu clair
                        "-fx-text-fill: white;" + // texte blanc
                        "-fx-font-weight: bold;" + // texte en gras
                        "-fx-font-size: 18px;" + // taille du texte 18px
                        "-fx-background-radius: 30;" + // bords arrondis
                        "-fx-padding: 12 40;"); // espacement intérieur haut/bas 12, gauche/droite 40
        return bouton; 
    }

    public static StackPane creerCadreCentre(Node contenu) { // méthode pour créer un cadre centré stylisé, Node car on ne sait pas ce que l'on va mettre dedans
        StackPane cadre = new StackPane(contenu); // conteneur centré avec le contenu passé en paramètre
        cadre.setMaxWidth(800); // largeur maximale du cadre
        cadre.setMaxHeight(600); // hauteur maximale du cadre
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;"); // style css du fond et arrondi
        return cadre; // retourne le cadre
    }
}