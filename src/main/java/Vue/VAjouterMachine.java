/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Justin
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class VAjouterMachine {

    private Scene sceneAjouterMachine;
    private TextField refField;
    private TextField desField;
    private TextField xField;
    private TextField yField;
    private TextField coutHField;
    private ComboBox<String> etatComboBox;
    private TextField typeField;
    private TextField heureFinOccField;
    private Button ajouterButton;
    private Button retourButton;

    public VAjouterMachine() {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setVgap(10);
        layout.setHgap(10);

        refField = new TextField();
        desField = new TextField();
        xField = new TextField();
        yField = new TextField();
        coutHField = new TextField();
        
        // Remplacement ici
        etatComboBox = new ComboBox<>();
        etatComboBox.getItems().addAll("libre", "panne", "occupée", "maintenance");
        etatComboBox.setValue("libre"); // Valeur par défaut

        typeField = new TextField();
        heureFinOccField = new TextField();

        ajouterButton = new Button("Ajouter Machine");
        retourButton = new Button("Retour");

        layout.add(new Label("Référence :"), 0, 0);
        layout.add(refField, 1, 0);
        layout.add(new Label("Designation :"), 0, 1);
        layout.add(desField, 1, 1);
        layout.add(new Label("X :"), 0, 2);
        layout.add(xField, 1, 2);
        layout.add(new Label("Y :"), 0, 3);
        layout.add(yField, 1, 3);
        layout.add(new Label("Coût Horaire (euro/heure)"), 0, 4);
        layout.add(coutHField, 1, 4);
        layout.add(new Label("État :"), 0, 5);
        layout.add(etatComboBox, 1, 5); // Le comboBox à la place du TextField
        layout.add(new Label("Type :"), 0, 6);
        layout.add(typeField, 1, 6);
        layout.add(new Label("Heure de fin d'occupation :"), 0, 7);
        layout.add(heureFinOccField, 1, 7);
        layout.add(ajouterButton, 0, 8);
        layout.add(retourButton, 1, 8);

        sceneAjouterMachine = new Scene(layout, 400, 400);
    }

    public Scene getSceneAjouterMachine() {
        return sceneAjouterMachine;
    }

    public TextField getRefField() {
        return refField;
    }

    public TextField getDesField() {
        return desField;
    }

    public TextField getxField() {
        return xField;
    }

    public TextField getyField() {
        return yField;
    }

    public TextField getCoutHField() {
        return coutHField;
    }

    // Nouveau getter
    public ComboBox<String> getEtatComboBox() {
        return etatComboBox;
    }

    public TextField getTypeField() {
        return typeField;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public TextField getHeureFinOccField() {
        return heureFinOccField;
    }
}