/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Node;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Style {

    public static Text creerTitre(String texte) {
        Text titre = new Text(texte);
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));
        titre.setFill(Color.web("#333333"));
        titre.setTextAlignment(TextAlignment.CENTER);
        return titre;
    }

    public static Label creerLabel(String texte) {
        Label label = new Label(texte);
        label.setFont(Font.font("Serif", FontWeight.BOLD, 18));
        label.setTextFill(Color.web("#333333"));
        label.setAlignment(Pos.CENTER_LEFT);
        return label;
    }

    public static TextArea creerZoneTexte(String contenu) {
        TextArea zone = new TextArea(contenu);
        zone.setEditable(false);
        zone.setWrapText(true);
        zone.setPrefHeight(400);
        zone.setStyle("-fx-font-size: 16px; -fx-padding: 15; -fx-background-radius: 15;");
        return zone;
    }

    public static Button creerBoutonRetour() {
        Button retour = new Button("Retour");
        retour.setStyle("-fx-background-color: #cccccc;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 18px;" +
                        "-fx-background-radius: 30;" +
                        "-fx-padding: 12 40;");
        return retour;
    }

    public static Button creerBouton(String texte) {
        Button bouton = new Button(texte);
        bouton.setStyle("-fx-background-color: #66e0e5;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 18px;" +
                        "-fx-background-radius: 30;" +
                        "-fx-padding: 12 40;");
        return bouton;
    }

    public static StackPane creerCadreCentre(Node contenu) {
        StackPane cadre = new StackPane(contenu);
        cadre.setMaxWidth(800);
        cadre.setMaxHeight(600);
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;");
        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);
        ombre.setOffsetX(0);
        ombre.setOffsetY(8);
        ombre.setColor(Color.color(0, 0, 0, 0.25));
        cadre.setEffect(ombre);
        return cadre;
    }
    
}
