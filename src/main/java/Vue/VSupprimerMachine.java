/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/**
 *
 * @author Justin
 */
public class VSupprimerMachine {

    private TextField refMachineField;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;

    public VSupprimerMachine() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        Label instructionLabel = new Label("Entrez la référence de la machine à supprimer :");
        refMachineField = new TextField();
        supprimerButton = new Button("Supprimer");
        retourButton = new Button("Retour");
        messageLabel = new Label();

        vbox.getChildren().addAll(instructionLabel, refMachineField, supprimerButton, retourButton, messageLabel);

        scene = new Scene(vbox, 400, 300);
    }
    
    public void afficherMessage(String message) { //pour afficher un message indiquand à l'utilisateur si la suppression à eu lieu
        messageLabel.setText(message);
    }

    public TextField getRefMachineField() {
        return refMachineField;
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Scene getScene() {
        return scene;
    }
    
}
