/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author Justin
 */
public class VModifierPoste {
    
    private TextField refField;
    private TextField designationField;
    private ListView<String> listeMachinesPoste;
    private ListView<String> listeMachinesDisponibles;
    private Button ajouterMachineButton;
    private Button retirerMachineButton;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierPoste() {
        VBox layout = new VBox(10);

        refField = new TextField();
        designationField = new TextField();
        listeMachinesPoste = new ListView<>();
        listeMachinesDisponibles = new ListView<>();

        ajouterMachineButton = new Button("Ajouter Machine");
        retirerMachineButton = new Button("Retirer Machine");
        enregistrerButton = new Button("Enregistrer Modifications");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
                new Label("Référence du Poste :"), refField,
                new Label("Désignation :"), designationField,
                new Label("Machines du Poste :"), listeMachinesPoste,
                new Label("Machines disponibles :"), listeMachinesDisponibles,
                new HBox(10, ajouterMachineButton, retirerMachineButton),
                enregistrerButton,
                retourButton
        );

        scene = new Scene(layout, 500, 700);
    }

    // Getters
    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public TextField getDesignationField() { return designationField; }
    public ListView<String> getListeMachinesPoste() { return listeMachinesPoste; }
    public ListView<String> getListeMachinesDisponibles() { return listeMachinesDisponibles; }
    public Button getAjouterMachineButton() { return ajouterMachineButton; }
    public Button getRetirerMachineButton() { return retirerMachineButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }

}
