/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VAjouterPoste {

    private TextField refField;
    private TextField designationField;
    private ListView<String> listeMachines;
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterPoste() {
        vbox = new VBox(10);

        // Initialisation des champs de texte
        refField = new TextField();
        refField.setPromptText("Référence du poste :");

        designationField = new TextField();
        designationField.setPromptText("Désignation du poste :");

        // Liste des machines disponibles
        listeMachines = new ListView<>();
        listeMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Permet de sélectionner plusieurs machines

        // Initialisation des boutons
        ajouterButton = new Button("Ajouter Poste");
        retourButton = new Button("Retour");

        // Organisation des éléments dans le layout
        vbox.getChildren().addAll(
            new Label("Référence :"), refField,
            new Label("Désignation :"), designationField,
            new Label("Sélectionner les machines :"), listeMachines,
            ajouterButton, retourButton
        );

        scene = new Scene(vbox, 400, 600);
    }

    // Getters pour accéder aux éléments dans le contrôleur
    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public TextField getDesignationField() { return designationField; }
    public ListView<String> getListeMachines() { return listeMachines; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getRetourButton() { return retourButton; }
}