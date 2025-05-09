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
    private TextField NouvelEtatField;
    private TextField NouveauPrenomField;
    private TextField NouveauCodeField;
    private Button modifierButton;
    private Button retourButton;
    private Scene scene;

    public TextField getNouveauPrenomField() {
        return NouveauPrenomField;
    }

    public void setNouveauPrenomField(TextField NouveauPrenomField) {
        this.NouveauPrenomField = NouveauPrenomField;
    }
   
    

    public TextField getNomField() {
        return nomField;
    }
    

    public void setNomField(TextField nomField) {
        this.nomField = nomField;
    }

 
    public TextField getNouvelEtatField() {
        return NouvelEtatField;
    }

    public void setNouvelEtatField(TextField NouvelEtatField) {
        this.NouvelEtatField = NouvelEtatField;
    }

    public TextField getNouveauCodeField() {
        return NouveauCodeField;
    }

    public void setNouveauCodeField(TextField NouveauCodeField) {
        this.NouveauCodeField = NouveauCodeField;
    }

    public Button getModifierButton() {
        return modifierButton;
    }

    public void setModifierButton(Button modifierButton) {
        this.modifierButton = modifierButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public void setRetourButton(Button retourButton) {
        this.retourButton = retourButton;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public VModifierOperateur() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        nomField = new TextField();
        nomField.setPromptText("Nom de l'opérateur où vous souhaitez apporter des modifications");

        NouveauPrenomField = new TextField();
        NouveauPrenomField.setPromptText("Nouveau Nom de l'opérateur (Mariage/Divorce)");      
       
        NouvelEtatField = new TextField();
        NouvelEtatField.setPromptText("Malade / En congé / Actif ");
        
        NouveauCodeField = new TextField();
        NouveauCodeField.setPromptText("Nouveau code de l'opérateur");
                
        modifierButton = new Button("Modifier");
        retourButton = new Button("Retour");
        
       
        layout.getChildren().addAll(
                NouveauPrenomField,
                nomField, 
                NouvelEtatField,
                NouveauCodeField,
                modifierButton,
                retourButton);
        scene = new Scene(layout, 400, 500);
    }}

  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
