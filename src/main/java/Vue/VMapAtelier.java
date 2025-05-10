/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Modele.Machine;
import java.util.List;

/**
 *
 * @author Elève
 */
public class VMapAtelier {
    
    private Pane pane;
    private Scene scene;

    public VMapAtelier(List<Machine> machines) {
        pane = new Pane();
        afficherMachines(machines);
        scene = new Scene(pane, 1000, 800); 
    }

    private void afficherMachines(List<Machine> machines) {
        for (Machine machine : machines) {
            Label labelMachine = new Label(machine.getRefmachine());
            labelMachine.setFont(new Font("Arial", 12));
            labelMachine.setStyle("-fx-border-color: black; -fx-alignment: center;");
            labelMachine.setMinSize(100, 40);
            
            String etat = machine.getEtat(); 

            // Définit la couleur selon l'état
            String couleurFond;
            switch (etat.toLowerCase()) { //pour éviter les erreur si y'a des majuscules 
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
                    couleurFond = "grey"; // au cas où
                    break;
            }
            labelMachine.setStyle(labelMachine.getStyle() + "-fx-background-color: " + couleurFond + ";");

            // Place la machine sur la carte
            labelMachine.setLayoutX(machine.getX());
            labelMachine.setLayoutY(machine.getY());

            pane.getChildren().add(labelMachine);
        }
    }

    public Scene getScene() {
        return scene;
    }

}
