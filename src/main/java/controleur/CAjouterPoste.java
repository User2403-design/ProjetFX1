/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Machine;
import Modele.Poste;
import Modele.Stockage;
import Vue.VAjouterPoste;
import java.util.ArrayList;
import javafx.stage.Stage;

public class CAjouterPoste {

    private Stage primaryStage;
    private VAjouterPoste vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        vue = new VAjouterPoste();
        remplirListeMachines();
        configurerActions();
    }

    private void remplirListeMachines() {
        // Remplir la ListView avec les machines disponibles dans le stockage
        for (Machine machine : stockage.getListeMachines()) {
            vue.getListeMachines().getItems().add(machine.getRefmachine());
        }
    }

    private void configurerActions() {
        // Action du bouton Ajouter Poste
        vue.getAjouterButton().setOnAction(e -> {
            String ref = vue.getRefField().getText().trim();
            String designation = vue.getDesignationField().getText().trim();

            if (ref.isEmpty() || designation.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }

            ArrayList<Machine> machineSelect = new ArrayList<>();
            
            // Récupérer les machines sélectionnées par l'utilisateur
            for (String refMachine : vue.getListeMachines().getSelectionModel().getSelectedItems()) {
                for (Machine machine : stockage.getListeMachines()) {
                    if (machine.getRefmachine().equals(refMachine)) {
                        machineSelect.add(machine);
                        break;
                    }
                }
            }

            Poste poste = new Poste(ref, designation, machineSelect);
            stockage.ajouterPoste(poste);
            System.out.println("Poste ajouté avec succès !");
            retour();
        });

        // Action du bouton Retour
        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
        // Retour à la section des postes
        Cposte controleurPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);
        controleurPoste.afficherSectionPoste();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Poste");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}