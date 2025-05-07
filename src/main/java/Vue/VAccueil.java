/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author Justin
 */
public class VAccueil {
    
    private Scene scene;
    private VBox vbox;
    private HBox hbox;
    private Label bienvenue;
    private Button deconnexion;
    private Button machine, poste, gamme, operation, operateur, produit, fiabilite;

    public VAccueil(String utilisateur, String atelier) {
        vbox = new VBox(20);
        hbox = new HBox(20);

        bienvenue = new Label("Bienvenue " + utilisateur + " dans l'atelier " + atelier + " !");
        deconnexion = new Button("Déconnexion");

        machine = new Button("Machine");
        poste = new Button("Poste");
        gamme = new Button("Gamme");
        operation = new Button("Operation");
        operateur = new Button("Operateur");
        produit = new Button("Produit");
        fiabilite = new Button("Fiabilité");

        hbox.getChildren().addAll(machine, poste, gamme, operation, operateur, produit, fiabilite);
        vbox.getChildren().addAll(bienvenue, hbox, deconnexion);

        scene = new Scene(vbox, 600, 300);
    }

    public Scene getScene() {
        return scene;
    }

    public VBox getVbox() {
        return vbox;
    }

    public HBox getHbox() {
        return hbox;
    }

    public Label getBienvenue() {
        return bienvenue;
    }

    public Button getDeconnexion() {
        return deconnexion;
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

    public Button getFiabilite() {
        return fiabilite;
    }
    
    
}
