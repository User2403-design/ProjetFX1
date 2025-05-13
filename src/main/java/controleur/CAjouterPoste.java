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

/**
 *
 * @author chloe
 */
public class CAjouterPoste {
    private Stage primaryStage;
    private VAjouterPoste vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;

        vue = new VAjouterPoste();
        remplirListeMachines();
        actionClic();
    }

    private void remplirListeMachines() {
        for (Machine machine : stockage.getListeMachines()) {
            vue.getListeMachines().getItems().add(machine.getRefmachine());
        }
    }

    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> {
            
            String ref = vue.getRefField().getText();
            String designation = vue.getDesignationField().getText();

            if (ref.isEmpty() || designation.isEmpty()) { //verification que les champs sont rempli
                System.out.println("Veuillez remplir tous les champs !");
                return; // la methode s'arrete si c'est le cas
            }

            ArrayList<Machine> machineSelect = new ArrayList<>(); // liste qui va contenir les machines selectionnées par l'utilisateur pour crée un poste
            
            //parcourt toute les machines du stockages pour ajouter leur référence à la listView : déjà fait avec remplirliste()
            /*for (Machine m : stockage.getListeMachines()) {
                 vue.getListeMachines().getItems().add(m.getRefmachine());
            }*/
            
            for (String refMachine : vue.getListeMachines().getSelectionModel().getSelectedItems()) { //parcourt les références des machines selectionnées dans la vue
                for (Machine machine : stockage.getListeMachines()) { // pour chaque référence selectionnées, on cherche la machine correspondante
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

        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
       Cposte controleurPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);
       controleurPoste.afficherSectionPoste();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Poste");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
