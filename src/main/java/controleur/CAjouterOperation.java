/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.*;
import Vue.VAjouterOperation;
import javafx.stage.Stage;

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
        lancerActions();
    }

    private void remplirListes() {
        for (Machine machine : stockage.getListeMachines()) {
            vue.getMachinesDisponibles().getItems().add(machine.getRefmachine());
        }

        for (Poste poste : stockage.getListePostes()) {
            vue.getPostesDisponibles().getItems().add(poste.getRefposte());
        }
    }

    private void lancerActions() {
        vue.getAjouterButton().setOnAction(e -> {
            try {
                String id = vue.getIdField().getText();
                String ref = vue.getRefField().getText();
                float duree = Float.parseFloat(vue.getDureeField().getText());

                String refMachine = vue.getMachinesDisponibles().getSelectionModel().getSelectedItem();
                String refPoste = vue.getPostesDisponibles().getSelectionModel().getSelectedItem();

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
                    System.out.println("Opération ajoutée avec succès !");
                    new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
                } else {
                    System.out.println("Veuillez sélectionner un équipement.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Erreur lors de l'ajout de l'opération.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter une opération");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
