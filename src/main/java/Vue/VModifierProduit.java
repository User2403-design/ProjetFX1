/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VModifierProduit {
    private TextField codeField;
    private TextField designationField;
    private ListView<String> listeGammesProduit;
    private ListView<String> listeGammesDisponibles;
    private Button ajouterGammeButton;
    private Button retirerGammeButton;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;

    public VModifierProduit() {
        codeField = new TextField();
        designationField = new TextField();
        listeGammesProduit = new ListView<>();
        listeGammesDisponibles = new ListView<>();
        ajouterGammeButton = new Button("Ajouter Gamme");
        retirerGammeButton = new Button("Retirer Gamme");
        enregistrerButton = new Button("Enregistrer");
        retourButton = new Button("Retour");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("Code Produit :"), codeField,
            new Label("Désignation :"), designationField,
            new Label("Gammes associées :"), listeGammesProduit,
            new Label("Gammes disponibles :"), listeGammesDisponibles,
            new HBox(10, ajouterGammeButton, retirerGammeButton),
            enregistrerButton,
            retourButton
        );

        scene = new Scene(layout, 500, 700);
    }

    public Scene getScene() { return scene; }
    public TextField getCodeField() { return codeField; }
    public TextField getDesignationField() { return designationField; }
    public ListView<String> getListeGammesProduit() { return listeGammesProduit; }
    public ListView<String> getListeGammesDisponibles() { return listeGammesDisponibles; }
    public Button getAjouterGammeButton() { return ajouterGammeButton; }
    public Button getRetirerGammeButton() { return retirerGammeButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}
