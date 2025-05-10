/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.*;
import Vue.VModifierOperation;
import javafx.stage.Stage;

public class CModifierOperation {
    private Stage primaryStage;
    private String utilisateur, atelier;
    private Stockage stockage;
    private Operation operation;
    private VModifierOperation vue;

    public CModifierOperation(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Operation operation) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.operation = operation;
        this.vue = new VModifierOperation();
        remplirChamps();
        remplirListes();
        lancerActions();
    }

    private void remplirChamps() {
        vue.getIdField().setText(operation.getIdOperation());
        vue.getRefField().setText(operation.getRefOperation());
        vue.getDureeField().setText(String.valueOf(operation.getDureeOperation()));
    }

    private void remplirListes() {
        for (Machine m : stockage.getListeMachines()) {
            vue.getMachinesDisponibles().getItems().add(m.getRefmachine());
        }
        for (Poste p : stockage.getListePostes()) {
            vue.getPostesDisponibles().getItems().add(p.getRefEquipement());
        }

        // Sélectionner l'équipement actuel
        Equipement eq = operation.getRefEquipement();
        if (eq instanceof Machine) {
            vue.getMachinesDisponibles().getSelectionModel().select(((Machine) eq).getRefmachine());
        } else if (eq instanceof Poste) {
            vue.getPostesDisponibles().getSelectionModel().select(((Poste) eq).getRefEquipement());
        }
    }

    private void lancerActions() {
        vue.getEnregistrerButton().setOnAction(e -> {
            appliquerModifications();
            new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
        });

        vue.getRetourButton().setOnAction(e -> {
            new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
        });
    }

    private void appliquerModifications() {
        operation.setRefOperation(vue.getRefField().getText());
        operation.setDureeOperation(Float.parseFloat(vue.getDureeField().getText()));

        String selectedMachine = vue.getMachinesDisponibles().getSelectionModel().getSelectedItem();
        String selectedPoste = vue.getPostesDisponibles().getSelectionModel().getSelectedItem();

        if (selectedMachine != null && selectedPoste != null) {
            // Si les deux sont sélectionnés, on peut afficher un message d'erreur ou choisir une priorité
            // Par exemple, priorité à la machine
            selectedPoste = null;
        }

        if (selectedMachine != null) {
            Machine m = stockage.rechercherMachineParRef(selectedMachine);
            if (m != null) operation.setRefEquipement(m);
        } else if (selectedPoste != null) {
            Poste p = stockage.rechercherPosteParRef(selectedPoste);
            if (p != null) operation.setRefEquipement(p);
        } else {
            operation.setRefEquipement(null); // Aucun équipement sélectionné
        }
    }

    public void afficher() {
        primaryStage.setTitle("Modifier opération");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}