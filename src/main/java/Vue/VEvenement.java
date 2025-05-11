/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elève
 */
public class VEvenement {
    
    private Button ajouterButton;
    private Button fiabiliteButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VEvenement() {
        vbox = new VBox(20);

        ajouterButton = new Button("Ajouter un Événement");
        fiabiliteButton = new Button("Calculer Fiabilité");
        retourButton = new Button("Retour");

        vbox.getChildren().addAll(ajouterButton, fiabiliteButton, retourButton);

        scene = new Scene(vbox, 400, 400);
    }

    public Scene getScene() { return scene; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getFiabiliteButton() { return fiabiliteButton; }
    public Button getRetourButton() { return retourButton; }

}
