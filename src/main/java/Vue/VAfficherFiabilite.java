/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Fiabilite;
import Modele.Stockage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.Map;

/**
 * author chloe
 */
public class VAfficherFiabilite {
    private Scene scene;
    private javafx.scene.control.TextArea fiabiliteArea;
    private javafx.scene.control.Button retourButton;
    private Stockage stockage;
    private Fiabilite fiab;

    public VAfficherFiabilite(Map<String, Double> fiabilites, Stockage stockage) {
        this.stockage = stockage;
        this.fiab = new Fiabilite(stockage);

        // Utilisation de Style pour créer la zone de texte
        fiabiliteArea = Style.creerZoneTexte("");
        fiabiliteArea.setText(fiab.afficherFiabilites(fiabilites));

        // Bouton retour via Style
        retourButton = Style.creerBoutonRetour();

        // Label avec style simple 
        Label titreLabel = new Label("Fiabilité des machines :");
        titreLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: #333333; -fx-font-weight: bold;");
        titreLabel.setAlignment(Pos.CENTER);

        // VBox avec espacement et centrage
        VBox vbox = new VBox(20, titreLabel, fiabiliteArea, retourButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new javafx.geometry.Insets(20));

        // Création du cadre via Style
        StackPane cadre = Style.creerCadreCentre(vbox);

        // Conteneur racine avec fond gris clair
        StackPane rootStack = new StackPane(cadre);
        rootStack.setStyle("-fx-background-color: #f5f5f5;");
        rootStack.setAlignment(Pos.CENTER);

        // Création de la scène avec dimensions 1570x800
        scene = new Scene(rootStack, 1570,800);
    }

    public Scene getScene() {
        return scene;
    }

    public javafx.scene.control.TextArea getFiabiliteArea() {
        return fiabiliteArea;
    }

    public javafx.scene.control.Button getRetourButton() {
        return retourButton;
    }
}