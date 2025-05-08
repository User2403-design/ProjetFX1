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
public class VModifierMachine {
    
    private TextField refMachineField; // Pour entrer la référence de la machine
    private TextField nouvelleDescriptionField;
    private TextField nouvelleXField;
    private TextField nouvelleYField;
    private TextField nouveauCoutField;
    private TextField nouvelEtatField;
    private TextField nouveauTypeField;
    private Button modifierButton;
    private Button retourButton;
    private Scene scene;

    public VModifierMachine() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        refMachineField = new TextField();
        refMachineField.setPromptText("Référence de la machine à modifier");

        nouvelleDescriptionField = new TextField();
        nouvelleDescriptionField.setPromptText("Nouvelle description");

        nouvelleXField = new TextField();
        nouvelleXField.setPromptText("Nouvelle position X");

        nouvelleYField = new TextField();
        nouvelleYField.setPromptText("Nouvelle position Y");

        nouveauCoutField = new TextField();
        nouveauCoutField.setPromptText("Nouveau coût horaire");

        nouvelEtatField = new TextField();
        nouvelEtatField.setPromptText("Nouvel état");

        nouveauTypeField = new TextField();
        nouveauTypeField.setPromptText("Nouveau type");

        modifierButton = new Button("Modifier");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(refMachineField, nouvelleDescriptionField, nouvelleXField, nouvelleYField,
                                    nouveauCoutField, nouvelEtatField, nouveauTypeField, modifierButton, retourButton);

        scene = new Scene(layout, 400, 500);
    }

    public Scene getScene() { return scene; }
    public TextField getRefMachineField() { return refMachineField; }
    public TextField getNouvelleDescriptionField() { return nouvelleDescriptionField; }
    public TextField getNouvelleXField() { return nouvelleXField; }
    public TextField getNouvelleYField() { return nouvelleYField; }
    public TextField getNouveauCoutField() { return nouveauCoutField; }
    public TextField getNouvelEtatField() { return nouvelEtatField; }
    public TextField getNouveauTypeField() { return nouveauTypeField; }
    public Button getModifierButton() { return modifierButton; }
    public Button getRetourButton() { return retourButton; }

}
