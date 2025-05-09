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

/**
 *
 * @author Justin
 */
public class VAjouterPoste {
    private TextField refField;
    private TextField designationField;
    private ListView<String> listeMachines; // pour afficher les machines sélectionnables
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterPoste() {
        vbox = new VBox(10);
        refField = new TextField();
        refField.setPromptText("Référence du poste :");

        designationField = new TextField();
        designationField.setPromptText("Désignation du poste :");

        listeMachines = new ListView<>(); //création d'une listView vide pour stocker toutes les machines dispo (rempli dans le controleur)
        listeMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //autorise l'utilisateur à selectionné plusierus machines

        ajouterButton = new Button("Ajouter Poste");
        retourButton = new Button("Retour");

        vbox.getChildren().addAll(new Label("Référence:"), refField, new Label("Designation:"), designationField, new Label("Sélectionner les machines :"), listeMachines, ajouterButton, retourButton);
        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public TextField getDesignationField() { return designationField; }
    public ListView<String> getListeMachines() { return listeMachines; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getRetourButton() { return retourButton; }
}
