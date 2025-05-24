/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * author chloe
 */

public class VAfficherGamme {
    private Scene scene;
    private TextArea zoneAffichage;
    private Button retour;

    public VAfficherGamme() {
        // Titre via Style
        Text titre = Style.creerTitre("Affichage des Gammes");

        // Zone de texte
        zoneAffichage = new TextArea();
        zoneAffichage.setEditable(false);
        zoneAffichage.setPrefHeight(400);
        zoneAffichage.setStyle("-fx-font-size: 16px; -fx-padding: 15; -fx-background-radius: 15;");

        // Bouton retour via Style
        retour = Style.creerBoutonRetour();

        // Mise en page VBox
        VBox contenu = new VBox(30, titre, zoneAffichage, retour);
        contenu.setAlignment(Pos.CENTER);

        // Cadre stylé via méthode utilitaire
        StackPane cadre = Style.creerCadreCentre(contenu);

        // Racine pour centrer le cadre au milieu
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        // Scène
        scene = new Scene(root, 1570, 800);
    }

    public Scene getScene() {
        return scene;
    }

    public TextArea getZoneAffichage() {
        return zoneAffichage;
    }

    public Button getRetour() {
        return retour;
    }
}