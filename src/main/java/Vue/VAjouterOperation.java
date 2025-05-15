/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class VAjouterOperation {

    private TextField idField;
    private TextField refField;
    private TextField dureeField;
    private ListView<String> machinesDisponibles;
    private ListView<String> postesDisponibles;
    private Button ajouterButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;

    public VAjouterOperation() {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setVgap(10);
        layout.setHgap(10);

        // Champs de saisie
        idField = new TextField();
        refField = new TextField();
        dureeField = new TextField();

        // Listes des machines et postes disponibles
        machinesDisponibles = new ListView<>();
        postesDisponibles = new ListView<>();

        // Boutons
        ajouterButton = new Button("Ajouter");
        retourButton = new Button("Retour");

        // Message label pour les erreurs et succès
        messageLabel = new Label();
        messageLabel.setFont(new Font("Arial", 14));

        // Ajout des éléments dans le layout
        layout.add(new Label("ID de l'opération :"), 0, 0);
        layout.add(idField, 1, 0);

        layout.add(new Label("Référence :"), 0, 1);
        layout.add(refField, 1, 1);

        layout.add(new Label("Durée (h) :"), 0, 2);
        layout.add(dureeField, 1, 2);

        layout.add(new Label("Machines disponibles :"), 0, 3);
        layout.add(machinesDisponibles, 1, 3);

        layout.add(new Label("Postes disponibles :"), 0, 4);
        layout.add(postesDisponibles, 1, 4);

        layout.add(ajouterButton, 0, 5);
        layout.add(retourButton, 1, 5);

        layout.add(messageLabel, 0, 6, 2, 1);  // Message label à la fin

        scene = new Scene(layout, 500, 500);
    }

    public Scene getScene() { return scene; }

    public TextField getIdField() { return idField; }
    public TextField getRefField() { return refField; }
    public TextField getDureeField() { return dureeField; }
    public ListView<String> getMachinesDisponibles() { return machinesDisponibles; }
    public ListView<String> getPostesDisponibles() { return postesDisponibles; }
    public Button getAjouterButton() { return ajouterButton; }
    public Button getRetourButton() { return retourButton; }
    public Label getMessageLabel() { return messageLabel; }
}