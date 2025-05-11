/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elève
 */
public class VAjouterEvenement {
    
    private TextField dateField;
    private TextField heureField;
    private TextField machineField;
    private ComboBox<String> typeComboBox;
    private TextField operateurField;
    private TextField causeField;
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterEvenement() {
        vbox = new VBox(10);
        
        dateField = new TextField();
        dateField.setPromptText("Date (yyyy-MM-dd)");
        
        heureField = new TextField();
        heureField.setPromptText("Heure (HH:mm)");
        
        machineField = new TextField();
        machineField.setPromptText("Machine");
        
        typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("A", "D"); // A pour arrêt, D pour démarrage
        typeComboBox.setPromptText("Type d'événement");
        
        operateurField = new TextField();
        operateurField.setPromptText("Opérateur");
        
        causeField = new TextField();
        causeField.setPromptText("Cause");
        
        ajouterButton = new Button("Ajouter Événement");
        retourButton = new Button("Retour");
        
        vbox.getChildren().addAll(new Label("Date :"), dateField,
                                  new Label("Heure :"), heureField,
                                  new Label("Machine :"), machineField,
                                  new Label("Type (A ou D) :"), typeComboBox,
                                  new Label("Opérateur :"), operateurField,
                                  new Label("Cause :"), causeField,
                                  ajouterButton, retourButton);
        
        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() { return scene; }
    public TextField getDateField() { return dateField; }
    public TextField getHeureField() { return heureField; }
    public TextField getMachineField() { return machineField; }
    public ComboBox<String> getTypeComboBox() { return typeComboBox; }
    public TextField getOperateurField() { return operateurField; }
    public TextField getCauseField() { return causeField; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getRetourButton() { return retourButton; }

}
