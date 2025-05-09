/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Justin
 */
public class VModifierOperation {
    
    private TextField idOperationField; // Pour entrer la référence de la machine
    private TextField refOperationField;
    private TextField refMachineField;
    private TextField dureeOperation;
    private Button modifierButton;
    private Button retourButton;
    private Scene scene;

    public VModifierOperation() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        idOperationField = new TextField();
        idOperationField.setPromptText("Id de l'opération à modifier");

        refOperationField = new TextField();
        refOperationField.setPromptText("Nouvelle référence");
        
        refMachineField = new TextField();
        refMachineField.setPromptText("Nouvelle ref machine");
                
        dureeOperation = new TextField();
        dureeOperation.setPromptText("Nouvelle durée de l'opération");

        modifierButton = new Button("Modifier");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
                idOperationField, 
                refOperationField, 
                refMachineField,
                dureeOperation,
                modifierButton,
                retourButton);
        scene = new Scene(layout, 400, 500);
    }

    public Scene getScene() { return scene; }
    public TextField getidOperationField() { return idOperationField; }
    public TextField getrefOperationField() { return refOperationField; }
    public TextField getrefMachineField() { return refMachineField; }
    public TextField getdureeOperation() { return dureeOperation; }
    public Button getModifierButton() { return modifierButton; }
    public Button getRetourButton() { return retourButton; }

}
