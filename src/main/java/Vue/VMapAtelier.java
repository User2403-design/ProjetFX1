/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import Modele.Machine;
import java.util.List;

/**
 * 
 */
public class VMapAtelier {

    private VBox vbox;
    private Pane pane;
    private Scene scene;
    private Button retour;

    public VMapAtelier(List<Machine> machines) {
        vbox = new VBox(15);
        pane = new Pane();
        retour = new Button("Retour");

        // Titre de l’atelier
        Label titre = new Label("Carte de l'Atelier");
        titre.setFont(new Font("Arial", 24));
        titre.setStyle("-fx-font-weight: bold;");

        // Ajoute le cadre et les machines
        ajouterCadreDynamique(machines);
        afficherMachines(machines);

        // Légende
        HBox legende = creerLegende();

        // Structure finale
        vbox.getChildren().addAll(titre, pane, legende, retour);
        scene = new Scene(vbox, 1000, 800);
    }

    private void ajouterCadreDynamique(List<Machine> machines) {
        if (machines.isEmpty()) return;

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Machine machine : machines) {
            double x = machine.getX();
            double y = machine.getY();
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        double padding = 40;

        Rectangle cadre = new Rectangle(
            minX - padding,
            minY - padding,
            (maxX - minX) + 2 * padding,
            (maxY - minY) + 2 * padding
        );

        cadre.setFill(Color.TRANSPARENT);
        cadre.setStroke(Color.DARKGRAY);
        cadre.setStrokeWidth(3);

        pane.getChildren().add(cadre);
    }

    private void afficherMachines(List<Machine> machines) {
        for (Machine machine : machines) {
            Label labelMachine = new Label(machine.getRefmachine());
            labelMachine.setFont(new Font("Arial", 12));
            labelMachine.setStyle("-fx-border-color: black; -fx-alignment: center;");
            labelMachine.setMinSize(40, 20);

            String couleurFond;
            switch (machine.getEtat().toLowerCase()) {
                case "libre":
                    couleurFond = "lightgreen";
                    break;
                case "occupée":
                    couleurFond = "orange";
                    break;
                case "panne":
                    couleurFond = "red";
                    break;
                case "maintenance":
                    couleurFond = "lightblue";
                    break;
                default:
                    couleurFond = "grey";
                    break;
            }

            labelMachine.setStyle(labelMachine.getStyle() + "-fx-background-color: " + couleurFond + ";");
            labelMachine.setLayoutX(machine.getX());
            labelMachine.setLayoutY(machine.getY());

            pane.getChildren().add(labelMachine);
        }
    }

    private HBox creerLegende() {
        HBox hbox = new HBox(15);
        hbox.setStyle("-fx-padding: 10;");
        
        hbox.getChildren().addAll(
            creerBlocLegende("Libre", "lightgreen"),
            creerBlocLegende("Occupée", "orange"),
            creerBlocLegende("Panne", "red"),
            creerBlocLegende("Maintenance", "lightblue"),
            creerBlocLegende("Inconnue", "grey")
        );

        return hbox;
    }

    private HBox creerBlocLegende(String texte, String couleur) {
        Rectangle rect = new Rectangle(20, 20);
        rect.setFill(Color.web(couleur));
        rect.setStroke(Color.BLACK);

        Label label = new Label(texte);
        label.setFont(new Font("Arial", 14));

        HBox bloc = new HBox(5, rect, label);
        return bloc;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getRetour() {
        return retour;
    }
}