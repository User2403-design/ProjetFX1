/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.*;
import Vue.VAjouterOperation;
import javafx.stage.Stage;

/**
 * author chloe
 */
     

public class CAjouterOperation {

    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VAjouterOperation vue;

    public CAjouterOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VAjouterOperation();
        
        remplirListes();
        configurerActions();
    }

    private void remplirListes() {
        // Remplir les listes de machines et de postes disponibles
        for (Machine machine : stockage.getListeMachines()) {
            vue.getMachinesDisponibles().getItems().add(machine.getRefmachine());
        }
        for (Poste poste : stockage.getListePostes()) {
            vue.getPostesDisponibles().getItems().add(poste.getRefposte());
        }
    }

    private void configurerActions() {
        vue.getAjouterButton().setOnAction(e -> ajouterOperation());
        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void ajouterOperation() {
        try {
            // Récupérer les valeurs des champs
            String id = vue.getIdField().getText().trim();
            String ref = vue.getRefField().getText().trim();
            String dureeText = vue.getDureeField().getText().trim();
            String refMachine = vue.getMachinesDisponibles().getSelectionModel().getSelectedItem();
            String refPoste = vue.getPostesDisponibles().getSelectionModel().getSelectedItem();

            if (id.isEmpty() || ref.isEmpty() || dureeText.isEmpty()) {
                vue.getMessageLabel().setText("Veuillez remplir tous les champs.");
                vue.getMessageLabel().setStyle("-fx-text-fill: red;");
                return;
            }

            float duree = Float.parseFloat(dureeText); // Conversion en float

            Equipement equipement = null;
            if (refMachine != null) {
                Machine machine = stockage.rechercherMachineParRef(refMachine);
                if (machine != null) {
                    equipement = machine;
                }
            } else if (refPoste != null) {
                Poste poste = stockage.rechercherPosteParRef(refPoste);
                if (poste != null) {
                    equipement = poste;
                }
            }

            if (equipement != null) {
                Operation operation = new Operation(id, ref, equipement, duree);
                stockage.ajouterOperation(operation);
                vue.getMessageLabel().setText("Opération ajoutée avec succès !");
                vue.getMessageLabel().setStyle("-fx-text-fill: green;");
                
                // Réinitialisation des champs après l'ajout
                vue.getIdField().clear();
                vue.getRefField().clear();
                vue.getDureeField().clear();
                vue.getMachinesDisponibles().getSelectionModel().clearSelection();
                vue.getPostesDisponibles().getSelectionModel().clearSelection();
            } else {
                vue.getMessageLabel().setText("Veuillez sélectionner un équipement.");
                vue.getMessageLabel().setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException ex) {
            vue.getMessageLabel().setText("Erreur : La durée doit être un nombre valide.");
            vue.getMessageLabel().setStyle("-fx-text-fill: red;");
        } catch (Exception ex) {
            vue.getMessageLabel().setText("Erreur lors de l'ajout de l'opération.");
            vue.getMessageLabel().setStyle("-fx-text-fill: red;");
        }
    }

    private void retour() {
        COperation controleur = new COperation(primaryStage, utilisateur, atelier, stockage);
        controleur.afficherSectionOperation();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter une opération");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}