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
    private Label erreurLabel;

    public VModifierProduit() {
        codeField = new TextField();
        designationField = new TextField();
        listeGammesProduit = new ListView<>();
        listeGammesDisponibles = new ListView<>();
        erreurLabel = new Label();
        

        // Boutons stylés avec Style
        ajouterGammeButton = Style.creerBouton("Ajouter Gamme");
        retirerGammeButton = Style.creerBouton("Retirer Gamme");
        enregistrerButton = Style.creerBouton("Enregistrer");
        retourButton = Style.creerBoutonRetour();

        Label codeLabel = new Label("Code Produit :");
        Label designationLabel = new Label("Désignation :");
        Label gammesAssocieesLabel = new Label("Gammes associées :");
        Label gammesDisponiblesLabel = new Label("Gammes disponibles :");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            codeLabel, codeField,
            designationLabel, designationField,
            gammesAssocieesLabel, listeGammesProduit,
            gammesDisponiblesLabel, listeGammesDisponibles,
            new HBox(10, ajouterGammeButton, retirerGammeButton),
            erreurLabel,
            enregistrerButton,
            retourButton
        );

        scene = new Scene(Style.creerCadreCentre(layout), 1570,800);
    }

    // Getters
    public Scene getScene() { return scene; }
    public TextField getCodeField() { return codeField; }
    public TextField getDesignationField() { return designationField; }
    public ListView<String> getListeGammesProduit() { return listeGammesProduit; }
    public ListView<String> getListeGammesDisponibles() { return listeGammesDisponibles; }
    public Button getAjouterGammeButton() { return ajouterGammeButton; }
    public Button getRetirerGammeButton() { return retirerGammeButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
    public Label getErreurLabel() { return erreurLabel;
    }
    
}