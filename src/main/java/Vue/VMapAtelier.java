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
    private Pane pane; //zone libre où les machines seront placées visuellement
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

        // Ajoute le cadre et les machines en focntion de leur coordonnées
        CadreDynamique(machines);
        afficherMachines(machines);

        // Légende
        HBox legende = creerLegende();

        // Structure finale
        vbox.getChildren().addAll(titre, pane, legende, retour);
        scene = new Scene(vbox, 2000, 1000);
    }

    private void CadreDynamique(List<Machine> machines) { //calcul un rectangle autour des machines pour les encadrer
        if (machines.isEmpty()) return; // ne fais rien si la liste des machines est vide

        //initialisation des bornes pour détecter les positions extremes des machines 
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        //calcule les coordonnées minimal et maximal de toutes les machines
        for (Machine machine : machines) {
            double x = machine.getX();
            double y = machine.getY();
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        double marge = 40; // définit un marge de 40 pixels pour que le cadre ne soit pas collé aux machines

        //création d'un rectangle JavaFX
        Rectangle cadre = new Rectangle(
            minX - marge, //position horizontal du coin supérieure gauche  
            minY - marge, //position verticale du coin supérieure droit 
            (maxX - minX) + 2 * marge, //largeur du rectangle
            (maxY - minY) + 2 * marge //hauteur du rectangle
        );

        cadre.setFill(Color.TRANSPARENT); //fond du rectangle transparent 
        cadre.setStroke(Color.DARKGRAY); //bordure grise 
        cadre.setStrokeWidth(3); // bordure d'épaisseur 3 pixels

        pane.getChildren().add(cadre); //ajout du cadre au pane
    }

    private void afficherMachines(List<Machine> machines) {
        for (Machine machine : machines) {
            Label labelMachine = new Label(machine.getRefmachine());//récupère la ref de toute les machines
            
            labelMachine.setFont(new Font("Arial", 12));
            labelMachine.setStyle("-fx-border-color: black; -fx-alignment: center;"); // définit un cadre noir et positionne le label au centre à l'aide d'un morceau de style CSS JavaFX 
            labelMachine.setMinSize(40, 20);

            String couleurFond; // contient l'information de la couleur à appliqué en fonction de l'état de la machine
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

            labelMachine.setStyle(labelMachine.getStyle() + "-fx-background-color: " + couleurFond + ";");//applique la couleur de fond du Label  selon l'état en gardant les précédentes instruction de style (bordure noir, etc)
            //place le label au coordonnées de la machine qu'elle représente
            labelMachine.setLayoutX(machine.getX()); 
            labelMachine.setLayoutY(machine.getY());

            pane.getChildren().add(labelMachine);
        }
    }

    //création d'une légende
    private HBox creerLegende() {
        HBox hbox = new HBox(15);
        hbox.setStyle("-fx-padding: 10;"); //définit un espace entre les blocs de la legende
        
        hbox.getChildren().addAll(
            creerBlocLegende("Libre", "lightgreen"),
            creerBlocLegende("Occupée", "orange"),
            creerBlocLegende("En panne", "red"),
            creerBlocLegende("Maintenance", "lightblue"),
            creerBlocLegende("Inconnue", "grey")
        );

        return hbox;
    }

    //création d'un bloc contenant un rectangle de couleur et un texte descriptif.
    private HBox creerBlocLegende(String texte, String couleur) {
        Rectangle rect = new Rectangle(20, 20);
        rect.setFill(Color.web(couleur)); //définit la couleur du fond 
        rect.setStroke(Color.BLACK); //définit la couleur de la bordure

        Label label = new Label(texte); //création du label qui contient le texte indiquant quelle couleur correspond à quel état
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