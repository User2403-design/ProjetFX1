/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Justin
 */
package Vue;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

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
    private Label messageLabel;

    public VAjouterMachine() {
        // Titre stylé
        Text titre = Style.creerTitre("Ajouter une Machine");

        // GridPane pour le formulaire
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER_LEFT);

        // Champs
        refField = new TextField();
        desField = new TextField();
        xField = new TextField();
        yField = new TextField();
        coutHField = new TextField();
        etatComboBox = new ComboBox<>();
        etatComboBox.getItems().addAll("libre", "panne", "occupée", "maintenance");
        etatComboBox.setValue("libre");
        typeField = new TextField();
        heureFinOccField = new TextField();

        // Boutons stylés
        ajouterButton = Style.creerBouton("Ajouter Machine");
        retourButton = Style.creerBoutonRetour();

        // Message label
        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        // Ajouter les éléments au grid
        layout.add(new Label("Référence :"), 0, 0);
        layout.add(refField, 1, 0);
        layout.add(new Label("Désignation :"), 0, 1);
        layout.add(desField, 1, 1);
        layout.add(new Label("X :"), 0, 2);
        layout.add(xField, 1, 2);
        layout.add(new Label("Y :"), 0, 3);
        layout.add(yField, 1, 3);
        layout.add(new Label("Coût Horaire (€/heure) :"), 0, 4);
        layout.add(coutHField, 1, 4);
        layout.add(new Label("État :"), 0, 5);
        layout.add(etatComboBox, 1, 5);
        layout.add(new Label("Type :"), 0, 6);
        layout.add(typeField, 1, 6);
        layout.add(new Label("Heure de fin d'occupation :"), 0, 7);
        layout.add(heureFinOccField, 1, 7);

        layout.add(ajouterButton, 0, 8);
        layout.add(retourButton, 1, 8);
        layout.add(messageLabel, 0, 9, 2, 1);

        // VBox principal pour inclure le titre et la grille
        VBox vboxPrincipal = new VBox(20, titre, layout);
        vboxPrincipal.setPadding(new Insets(10));
        vboxPrincipal.setAlignment(Pos.CENTER);

        // Cadre centré avec ombre
        StackPane cadre = Style.creerCadreCentre(vboxPrincipal);

        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        sceneAjouterMachine = new Scene(root, 1570,800);
    }

    // Getters
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
    public ComboBox<String> getEtatComboBox() {
        return etatComboBox;
    }
    public TextField getTypeField() {
        return typeField;
    }
    public TextField getHeureFinOccField() {
        return heureFinOccField;
    }
    public Button getAjouterButton() {
        return ajouterButton;
    }
    public Button getRetourButton() {
        return retourButton;
    }
    public Label getMessageLabel() {
        return messageLabel;
    }
}