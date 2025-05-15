/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

  */  

package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VAccueil {

    private Scene scene;
    private VBox vbox;
    private Label bienvenue;
    private Button deconnexion;
    private Button machine, poste, gamme, operation, operateur, produit, stock, fiabilite, map;

    public VAccueil(String utilisateur, String atelier) {
        // Création de la mise en page principale
        vbox = new VBox(30);
        vbox.setPadding(new Insets(30));
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #f4f7fa;"); // correspond au code couleur

        // Titre de bienvenue
        bienvenue = new Label("Bienvenue " + utilisateur + " dans l'atelier " + atelier + " !"); 
        bienvenue.setStyle("-fx-font-size: 18px; -fx-text-fill: #333; -fx-font-weight: bold;");

        // Ligne de boutons - Organisation en 2 lignes
        HBox ligne1 = new HBox(15);
        HBox ligne2 = new HBox(15);
        HBox ligne3 = new HBox(15);
        ligne1.setAlignment(Pos.CENTER);
        ligne2.setAlignment(Pos.CENTER);
        ligne2.setAlignment(Pos.CENTER);
        
        machine = new Button("Machine");
        poste = new Button("Poste");
        gamme = new Button("Gamme");
        operation = new Button("Opération");
        operateur = new Button("Opérateur");
        produit = new Button("Produit");
        stock = new Button("Magasin de brut");
        fiabilite = new Button("Fiabilité");
        map = new Button("Carte de l'Atelier");

        // Style commun aux boutons
        Button[] boutons = {machine, poste, gamme, operation, operateur, produit,stock, fiabilite, map};
        for (Button b : boutons) {
            b.setStyle(
                "-fx-background-color: #dceefc;" +
                "-fx-text-fill: #003366;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10px 20px;" +
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;" +
                "-fx-font-size: 14px;"
            );
        }

        ligne1.getChildren().addAll(machine, poste, gamme, operation);
        ligne2.getChildren().addAll(operateur, produit,stock);
        ligne3.getChildren().addAll(fiabilite, map);

        // Bouton de déconnexion
        deconnexion = new Button("Déconnexion");
        deconnexion.setStyle(
            "-fx-background-color: #ffcccc;" +
            "-fx-text-fill: #990000;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10px 20px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;"
        );

        // Ajout au VBox principal
        vbox.getChildren().addAll(bienvenue, ligne1, ligne2,ligne3, deconnexion);

        scene = new Scene(vbox, 700, 400);
    }

    public Scene getScene() { return scene; }
    public VBox getVbox() { return vbox; }
    public Label getBienvenue() { return bienvenue; }
    public Button getDeconnexion() { return deconnexion; }
    public Button getMachine() { return machine; }
    public Button getPoste() { return poste; }
    public Button getGamme() { return gamme; }
    public Button getOperation() { return operation; }
    public Button getOperateur() { return operateur; }
    public Button getProduit() { return produit; }
    public Button getStock() { return stock; }
    public Button getFiabilite() { return fiabilite; }
    public Button getMap() { return map;}
    
}