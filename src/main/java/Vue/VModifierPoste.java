/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

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
        refField = new TextField();
        designationField = new TextField();
        listeMachinesPoste = new ListView<>();
        listeMachinesDisponibles = new ListView<>();

        // Boutons stylés via Style
        ajouterMachineButton = Style.creerBouton("Ajouter Machine");
        retirerMachineButton = Style.creerBouton("Retirer Machine");
        enregistrerButton = Style.creerBouton("Enregistrer Modifications");
        retourButton = Style.creerBoutonRetour();

        Label refLabel = new Label("Référence du Poste :");
        Label designationLabel = new Label("Désignation :");
        Label machinesPosteLabel = new Label("Machines du Poste :");
        Label machinesDisponiblesLabel = new Label("Machines disponibles :");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            refLabel, refField,
            designationLabel, designationField,
            machinesPosteLabel, listeMachinesPoste,
            machinesDisponiblesLabel, listeMachinesDisponibles,
            new HBox(10, ajouterMachineButton, retirerMachineButton),
            enregistrerButton,
            retourButton
        );

        // Application du cadre centré stylé
        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
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