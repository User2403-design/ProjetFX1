/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets; // Pour gérer les marges internes
import javafx.geometry.Pos; // Pour gérer les alignements
import javafx.scene.Scene; // Représente la scène principale
import javafx.scene.control.*; // Pour utiliser les contrôles comme TextField, Label, Button, etc.
import javafx.scene.layout.HBox; // Pour une disposition horizontale
import javafx.scene.layout.StackPane; // Pour empiler des éléments
import javafx.scene.layout.VBox; // Pour une disposition verticale

/**
 * Vue pour modifier une gamme (interface graphique)
 * @author Chloé
 */
public class VModifierGamme {
    private TextField refField;                           // Champ de texte pour la référence de la gamme
    private ListView<String> listeOperationsGamme;        // Liste des opérations associées à la gamme
    private ListView<String> listeOperationsDisponibles;  // Liste des opérations disponibles à ajouter
    private Button ajouterOperationButton;                // Bouton pour ajouter une opération
    private Button retirerOperationButton;                // Bouton pour retirer une opération
    private Button enregistrerButton;                     // Bouton pour enregistrer les modifications
    private Button retourButton;                          // Bouton pour revenir à la vue précédente
    private Scene scene;                                  // Scène contenant toute l'interface

    public VModifierGamme() {
        // Layout principal vertical avec espacement de 25px
        VBox layout = new VBox(25);                       
        layout.setPadding(new Insets(30));                // Marges internes de 40px
        layout.setAlignment(Pos.TOP_CENTER);              // Alignement en haut au centre
        layout.setPrefWidth(1500);                         // Largeur préférée de 1500px

        // Label pour la référence
        Label labelRef = Style.creerLabel("Référence de la Gamme :"); 

        // Champ de texte pour saisir la référence
        refField = new TextField();                       
        refField.setPromptText("Référence");              // Texte d'exemple dans le champ
        refField.setMaxWidth(Double.MAX_VALUE);           // Largeur maximum

        // Labels pour les listes
        Label labelOpsGamme = Style.creerLabel("Opérations de la Gamme :");
        Label labelOpsDisponibles = Style.creerLabel("Opérations Disponibles :");

        // Liste des opérations de la gamme
        listeOperationsGamme = new ListView<>();
        listeOperationsGamme.setPrefHeight(250);          // Hauteur de 250px
        listeOperationsGamme.setPrefWidth(350);           // Largeur de 350px

        // Liste des opérations disponibles
        listeOperationsDisponibles = new ListView<>();
        listeOperationsDisponibles.setPrefHeight(250);    // Hauteur de 250px
        listeOperationsDisponibles.setPrefWidth(350);     // Largeur de 350px

        // Création des boutons d'ajout/retrait
        ajouterOperationButton = Style.creerBouton("Ajouter");
        retirerOperationButton = Style.creerBouton("Retirer");

        // Fixe une largeur minimale pour que le texte soit toujours visible
        ajouterOperationButton.setMinWidth(150);          
        retirerOperationButton.setMinWidth(150);          

        // VBox contenant les deux boutons verticaux avec un espacement de 20px
        VBox boutonsOperations = new VBox(20, ajouterOperationButton, retirerOperationButton);
        boutonsOperations.setAlignment(Pos.CENTER);       // Centrage vertical

        // Partie gauche : label + liste des opérations de la gamme
        VBox leftBox = new VBox(10, labelOpsGamme, listeOperationsGamme);

        // Partie droite : label + liste des opérations disponibles
        VBox rightBox = new VBox(10, labelOpsDisponibles, listeOperationsDisponibles);

        // HBox contenant les 3 parties (liste gauche, boutons, liste droite)
        HBox listesBox = new HBox(30, leftBox, boutonsOperations, rightBox);
        listesBox.setAlignment(Pos.CENTER);               // Centrage horizontal

        // Bouton pour enregistrer les modifications
        enregistrerButton = Style.creerBouton("Enregistrer Modifications");

        // Bouton retour avec style personnalisé
        retourButton = Style.creerBoutonRetour();         

        // Marge au-dessus du bouton d’enregistrement
        VBox.setMargin(enregistrerButton, new Insets(20, 0, 0, 0)); 
        // Marge au-dessus du bouton retour
        VBox.setMargin(retourButton, new Insets(10, 0, 0, 0));      

        // Ajout de tous les éléments à la VBox principale
        layout.getChildren().addAll(
                labelRef, refField,
                listesBox,
                enregistrerButton,
                retourButton
        );

        // Encadrement centré de toute l’interface
        StackPane cadre = Style.creerCadreCentre(layout); 

        // Fond global clair
        StackPane root = new StackPane(cadre);            
        root.setStyle("-fx-background-color: #f5f5f5;");   // Couleur de fond gris clair
        root.setAlignment(Pos.CENTER);                    // Centrage de l’ensemble

        // Création de la scène avec la taille globale de l’application
        scene = new Scene(root, 1570, 800);               
    }

    // Getters pour accéder aux composants depuis le contrôleur
    public Scene getScene() { return scene; }
    public TextField getRefField() { return refField; }
    public ListView<String> getListeOperationsGamme() { return listeOperationsGamme; }
    public ListView<String> getListeOperationsDisponibles() { return listeOperationsDisponibles; }
    public Button getAjouterOperationButton() { return ajouterOperationButton; }
    public Button getRetirerOperationButton() { return retirerOperationButton; }
    public Button getEnregistrerButton() { return enregistrerButton; }
    public Button getRetourButton() { return retourButton; }
}