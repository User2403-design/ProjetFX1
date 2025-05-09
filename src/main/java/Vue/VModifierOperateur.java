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
public class VModifierOperateur {
    
    private TextField nomField; 
    private TextField posteField;
    private TextField etatField;
    private TextField codeField;
    private Button modifierButton;
    private Button retourButton;
    private Scene scene;

    public VModifierOperateur() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        nomField = new TextField();
        nomField.setPromptText("Nom de l'opérateur où vous souhaitez apporter des modifications");

        
        posteField = new TextField();
        posteField.setPromptText("Nouveau poste attribué ");
                
        etatField = new TextField();
        etatField.setPromptText("Malade / En congé / Actif ");
        
        codeField = new TextField();
        codeField.setPromptText("Nouveau code de l'opérateur");
                
        modifierButton = new Button("Modifier");
        retourButton = new Button("Retour");
        
       
        layout.getChildren().addAll(
                posteField, 
                nomField, 
                etatField,
                codeField,
                modifierButton,
                retourButton);
        scene = new Scene(layout, 400, 500);
    }

    public Scene getScene() { return scene; }
    public TextField getidOperationField() { return posteField; }
    public TextField getrefOperationField() { return nomField; }
    public TextField getrefMachineField() { return etatField; }
    public TextField getdureeOperation() { return codeField; }
    public Button getModifierButton() { return modifierButton; }
    public Button getRetourButton() { return retourButton; }

}/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
