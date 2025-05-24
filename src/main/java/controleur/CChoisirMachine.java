/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Machine;
import Modele.Stockage;
import Vue.VChoisirMachine;
import javafx.stage.Stage;

public class CChoisirMachine {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VChoisirMachine vue;

    public CChoisirMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirMachine();

        remplirListe();
       actionClic();
    }

    private void remplirListe() {
        for (Machine m : stockage.getListeMachines()) {
            vue.getListeMachines().getItems().add(m.getRefmachine());
        }
    }

    private void actionClic() {
        vue.getValiderButton().setOnAction(e -> {
            String ref = vue.getListeMachines().getSelectionModel().getSelectedItem();
            if (ref != null) {
                Machine machine = stockage.rechercherMachineParRef(ref);
                if (machine != null) {
                    CModifierMachine controleur = new CModifierMachine(primaryStage, utilisateur, atelier, stockage, machine);
                    controleur.afficher();
                }
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CMachine(primaryStage, utilisateur, atelier, stockage).afficherSectionMachine(); 
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir une Machine à Modifier");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}