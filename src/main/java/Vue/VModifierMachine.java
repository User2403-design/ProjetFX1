/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VModifierMachine {
    private TextField refField, designationField, xField, yField, coutField, typeField;
    private ComboBox<String> etatComboBox;
    private Button enregistrerButton, retourButton;
    private Scene scene;

    public VModifierMachine() {
        VBox layout = new VBox(10);
        refField = new TextField();
        designationField = new TextField();
        xField = new TextField();
        yField = new TextField();
        coutField = new TextField();
        typeField = new TextField();
        etatComboBox = new ComboBox<>();
        etatComboBox.getItems().addAll("libre", "panne", "occupée", "maintenance");
        enregistrerButton = new Button("Enregistrer Modifications");
        retourButton = new Button("Retour");

        layout.getChildren().addAll(
            new Label("Référence :"), refField,
            new Label("Désignation :"), designationField,
            new Label("Position X :"), xField,
            new Label("Position Y :"), yField,
            new Label("Coût Horaire :"), coutField,
            new Label("Type :"), typeField,
            new Label("État :"), etatComboBox,
            enregistrerButton,
            retourButton
        );

        scene = new Scene(layout, 400, 600);
    }

    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public TextField getDesignationField() { return designationField; }
    public TextField getXField() { return xField; }
    public TextField getYField() { return yField; }
    public TextField getCoutField() { return coutField; }
    public TextField getTypeField() { return typeField; }
    public ComboBox<String> getEtatComboBox() { return etatComboBox; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}