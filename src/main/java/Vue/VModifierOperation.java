/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VModifierOperation {
    private TextField idField;
    private TextField refField;
    private TextField dureeField;
    private TextField equipementField;
    private ListView<String> machinesDisponibles;
    private ListView<String> postesDisponibles;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierOperation() {
        idField = new TextField();
        refField = new TextField();
        dureeField = new TextField();
        equipementField = new TextField();
        machinesDisponibles = new ListView<>();
        postesDisponibles = new ListView<>();
        enregistrerButton = new Button("Enregistrer");
        retourButton = new Button("Retour");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("ID de l'opération :"), idField,
            new Label("Référence :"), refField,
            new Label("Choisir un équipement :"), equipementField,
            new Label("Durée :"), dureeField,
            new Label("Machines disponibles :"), machinesDisponibles,
            new Label("Postes disponibles :"), postesDisponibles,
            new HBox(10, enregistrerButton, retourButton)
        );

        scene = new Scene(layout, 500, 500);
    }

    public Scene getScene() { return scene; }
    public TextField getIdField() { return idField; }
    public TextField getRefField() { return refField; }
    public TextField getDureeField() { return dureeField; }
    public TextField getEquipementField() { return equipementField; }
    public ListView<String> getMachinesDisponibles() { return machinesDisponibles; }
    public ListView<String> getPostesDisponibles() { return postesDisponibles; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}
