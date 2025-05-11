/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class VModifierGamme {
    
    private TextField refField;
    private ListView<String> listeOperationsGamme;
    private ListView<String> listeOperationsDisponibles;
    private Button ajouterOperationButton;
    private Button retirerOperationButton;
    private Button enregistrerButton;
    private Button retourButton;
    private Scene scene;
    
    public VModifierGamme() {
        VBox layout = new VBox(10);
        
        // Champ de référence de la gamme
        refField = new TextField();
        
        // ListView pour les opérations dans la gamme
        listeOperationsGamme = new ListView<>();
        
        // ListView pour les opérations disponibles
        listeOperationsDisponibles = new ListView<>();
        
        // Boutons d'ajout et de retrait des opérations
        ajouterOperationButton = new Button("Ajouter Opération");
        retirerOperationButton = new Button("Retirer Opération");
        
        // Boutons pour enregistrer ou revenir
        enregistrerButton = new Button("Enregistrer Modifications");
        retourButton = new Button("Retour");
        
        // Ajouter tous les éléments au layout
        layout.getChildren().addAll(
                new Label("Référence de la Gamme :"), refField,
                new Label("Opérations de la Gamme :"), listeOperationsGamme,
                new Label("Opérations Disponibles :"), listeOperationsDisponibles,
                new HBox(10, ajouterOperationButton, retirerOperationButton),
                enregistrerButton,
                retourButton
        );
        
        // Initialiser la scène
        scene = new Scene(layout, 500, 500);
    }

    // Getters pour accéder aux composants
    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public ListView<String> getListeOperationsGamme() { return listeOperationsGamme; }
    public ListView<String> getListeOperationsDisponibles() { return listeOperationsDisponibles; }
    public Button getAjouterOperationButton() { return ajouterOperationButton; }
    public Button getRetirerOperationButton() { return retirerOperationButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}