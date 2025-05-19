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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VAfficherOperateur {
    private Scene sceneListeOperateurs;
    private VBox vbox;
    private TextArea textArea;
    private Button retourButton;

    public VAfficherOperateur(String operateurs) {
        // Titre stylé
        Text titre = new Text("Liste des Opérateurs");
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));
        titre.setFill(Color.web("#333333"));
        titre.setTextAlignment(TextAlignment.CENTER);

        // Zone d'affichage stylée
        textArea = new TextArea(operateurs);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-size: 16px; -fx-padding: 15; -fx-background-radius: 15;");
        textArea.setPrefHeight(400);

        // Bouton retour stylé
        retourButton = new Button("Retour");
        retourButton.setStyle("-fx-background-color: #cccccc;" +
                              "-fx-text-fill: #333333;" +
                              "-fx-font-weight: bold;" +
                              "-fx-font-size: 18px;" +
                              "-fx-background-radius: 30;" +
                              "-fx-padding: 12 40;");

        // Mise en page principale
        vbox = new VBox(30, titre, textArea, retourButton);
        vbox.setAlignment(Pos.CENTER);

        // Cadre blanc avec ombre via méthode centrale
        StackPane cadre = Style.creerCadreCentre(vbox);

        // Fond général gris clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        // Scène principale
        sceneListeOperateurs = new Scene(root, 1570,800);
    }

    public Scene getSceneListeOperateurs() {
        return sceneListeOperateurs;
    }

    public VBox getVbox() {
        return vbox;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}