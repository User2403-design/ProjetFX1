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
 * @author chloe
 */

public class VAjouterOperateur {
    
    private TextField nomField;
    private TextField prenomField;
    private TextField codeField;
    private ListView<String> listeOperateurs; // pour afficher les opérateurs sélectionnables (si besoin)
    private Button ajouterButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;

    public VAjouterOperateur() {
        vbox = new VBox(10);
        
        // Champs de texte pour nom, prénom et code de l'opérateur
        nomField = new TextField();
        nomField.setPromptText("Nom de l'opérateur :");
        
        prenomField = new TextField();
        prenomField.setPromptText("Prénom de l'opérateur :");
        
        codeField = new TextField();
        codeField.setPromptText("Code de l'opérateur :");

        // Liste des opérateurs, si nécessaire pour afficher ceux déjà existants
        listeOperateurs = new ListView<>(); // Si tu veux une liste d'opérateurs existants, on peut l'utiliser
        listeOperateurs.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Permet de sélectionner plusieurs opérateurs si besoin

        // Boutons pour ajouter un opérateur et revenir à l'écran précédent
        ajouterButton = new Button("Ajouter Opérateur");
        retourButton = new Button("Retour");

        // Mise en page avec labels et champs
        vbox.getChildren().addAll(
            new Label("Nom de l'opérateur :"), nomField,
            new Label("Prénom de l'opérateur :"), prenomField,
            new Label("Code de l'opérateur :"), codeField,
            new Label("Liste des opérateurs :"), listeOperateurs,
            ajouterButton, retourButton
        );
        
        // Création de la scène
        scene = new Scene(vbox, 400, 600);
    }

    // Getters pour accéder aux éléments
    public Scene getScene() {
        return scene;
    }

    public TextField getNomField() {
        return nomField;
    }

    public TextField getPrenomField() {
        return prenomField;
    }

    public TextField getCodeField() {
        return codeField;
    }

    public ListView<String> getListeOperateurs() {
        return listeOperateurs;
    }

    public Button getAjouterButton() {
        return ajouterButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}