/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class VAfficherProduit {
    private TextArea zoneAffichage;
    private Button retourButton;
    private VBox vbox;
    private Scene sceneListeProduits;

    public VAfficherProduit(String produits) {
        // Titre stylé
        Text titre = new Text("Liste des Produits");
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));
        titre.setFill(Color.web("#333333"));
        titre.setTextAlignment(TextAlignment.CENTER);

        // Utilisation des méthodes Style
        zoneAffichage = Style.creerZoneTexte(produits);
        retourButton = Style.creerBoutonRetour();

        vbox = new VBox(30);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        vbox.getChildren().addAll(titre,zoneAffichage, retourButton);

        StackPane cadre = Style.creerCadreCentre(vbox);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(javafx.geometry.Pos.CENTER);

        sceneListeProduits = new Scene(root, 1570,800);
    }

    public Scene getSceneListeProduits() {
        return sceneListeProduits;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}