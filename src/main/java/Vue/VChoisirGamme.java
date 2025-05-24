/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VChoisirGamme {
    private ListView<String> listeGammes;
    private Button choisirButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirGamme() {
        // Titre avec style
        Text titre = Style.creerTitre("Choisir une Gamme");

        listeGammes = new ListView<>();
        listeGammes.setPrefHeight(200); //pour que la liste soit situé à une hauteur de 200 pixels

        // Boutons avec style
        choisirButton = Style.creerBouton("Choisir");
        retourButton = Style.creerBoutonRetour();

        VBox layout = new VBox(15, titre, listeGammes, choisirButton, retourButton);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f2f7fc;");
        layout.setMaxWidth(400);

        // Utilisation du cadre centré de Style
        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    public ListView<String> getListeGammes() {
        return listeGammes;
    }

    public Button getChoisirButton() {
        return choisirButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
}