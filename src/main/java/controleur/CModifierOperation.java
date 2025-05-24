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
        actionClic();
    }

    private void remplirChamps() {
        vue.getIdField().setText(operation.getIdOperation());
        vue.getRefField().setText(operation.getRefOperation());
        vue.getDureeField().setText(String.valueOf(operation.getDureeOperation()));
    }

    private void remplirListes() {
        //ajout des ref de chaque machines disponibles dans la listeView
        for (Machine m : stockage.getListeMachines()) {
            vue.getMachinesDisponibles().getItems().add(m.getRefmachine());
        }
        //ajout des ref de chaque postes disponibles dans la listeView
        for (Poste p : stockage.getListePostes()) {
            vue.getPostesDisponibles().getItems().add(p.getRefEquipement());
        }
        //A QUOI SA SERT ?
        // Sélectionner l'équipement actuel
        Equipement eq = operation.getRefEquipement();
        //si c'est une machine
        if (eq instanceof Machine) {
            vue.getMachinesDisponibles().getSelectionModel().select(((Machine) eq).getRefmachine()); //récupère l'equipement convertit en type machine de l'operation selectionné  
        //si c'est un poste    
        } else if (eq instanceof Poste) {
            vue.getPostesDisponibles().getSelectionModel().select(((Poste) eq).getRefEquipement());
        }
    }

    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
            // Vérification de la validité de la durée
            try {
                float duree = Float.parseFloat(vue.getDureeField().getText());
                if (duree <= 0) {
                    throw new NumberFormatException(); 
                }
                appliquerModifications();
                new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation(); //retour sur la page précédente des qu'on à cliquer sur enregistrer
            } catch (NumberFormatException ex) {
                vue.getErrorLabel().setText("Erreur: Entrez une durée valide (nombre positif).");
            }
        });
        vue.getRetourButton().setOnAction(e -> {
            new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
        });
    }

    private void appliquerModifications() {
        operation.setRefOperation(vue.getRefField().getText());

        // Durée déjà validée
        float duree = Float.parseFloat(vue.getDureeField().getText());
        operation.setDureeOperation(duree);

        String selectedMachine = vue.getMachinesDisponibles().getSelectionModel().getSelectedItem();
        String selectedPoste = vue.getPostesDisponibles().getSelectionModel().getSelectedItem();

        if (selectedMachine != null && selectedPoste != null) {
            // Priorité à la machine si les deux sont sélectionnés
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
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}