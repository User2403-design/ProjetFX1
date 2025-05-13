/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Machine;
import Modele.Stockage;
import Vue.VModifierMachine;
import javafx.stage.Stage;

public class CModifierMachine {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Machine machine;
    private VModifierMachine vue;

    public CModifierMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Machine machine) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.machine = machine;
        this.vue = new VModifierMachine();

        remplirChamps();
        lancerActions();
    }

    private void remplirChamps() {
        vue.getRefField().setText(machine.getRefmachine());
        vue.getDesignationField().setText(machine.getDmachine());
        vue.getXField().setText(String.valueOf(machine.getX()));
        vue.getYField().setText(String.valueOf(machine.getY()));
        vue.getCoutField().setText(String.valueOf(machine.getCoût()));
        vue.getTypeField().setText(machine.getType());
        vue.getEtatComboBox().setValue(machine.getEtat());
    }

    private void lancerActions() {
        vue.getEnregistrerButton().setOnAction(e -> {
            machine.setRefmachine(vue.getRefField().getText());
            machine.setDmachine(vue.getDesignationField().getText());
            machine.setX(Float.parseFloat(vue.getXField().getText()));
            machine.setY(Float.parseFloat(vue.getYField().getText()));
            machine.setCoût(Float.parseFloat(vue.getCoutField().getText()));
            machine.setType(vue.getTypeField().getText());
            machine.setEtat(vue.getEtatComboBox().getValue());

            new CMachine(primaryStage, utilisateur, atelier, stockage).afficherSectionMachine(); // ou retour vers une page machine
        });

        vue.getRetourButton().setOnAction(e -> {
            new CMachine(primaryStage, utilisateur, atelier, stockage).afficherSectionMachine();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Machine");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}