/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Machine;
import Modele.FichierMachine;
import Vue.VAjouterMachine;
import java.time.LocalTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CAjouterMachine {

    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VAjouterMachine vueAjouter;

    public CAjouterMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueAjouter = new VAjouterMachine();
        actionClic();
    }

    private void actionClic() {
        vueAjouter.getAjouterButton().setOnAction(e -> {
            try {
                String ref = vueAjouter.getRefField().getText();
                String description = vueAjouter.getDesField().getText();
                float x = Float.parseFloat(vueAjouter.getxField().getText());
                float y = Float.parseFloat(vueAjouter.getyField().getText());
                float coutHoraire = Float.parseFloat(vueAjouter.getCoutHField().getText());
                
                // Récupération de l'état via le ComboBox
                String etat = vueAjouter.getEtatComboBox().getValue(); // Changement ici pour récupérer la valeur du ComboBox
                
                String type = vueAjouter.getTypeField().getText();
                LocalTime heureFinOcc = LocalTime.parse(vueAjouter.getHeureFinOccField().getText());

                // Création de la nouvelle machine
                Machine nouvelleMachine = new Machine(ref, description, x, y, coutHoraire, etat, type, heureFinOcc);
                stockage.ajouterMachine(nouvelleMachine);
                enregistrerEvenementDemarrage(nouvelleMachine.getRefmachine(), utilisateur);

                // Sauvegarde du fichier
                FichierMachine.sauvegarder(stockage.getListeMachines());
                System.out.println("Machine ajoutée avec succès !");
            } catch (NumberFormatException ex) {
                System.out.println("Erreur de format dans les champs numériques.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        vueAjouter.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }
    
    private void enregistrerEvenementDemarrage(String refMachine, String utilisateur) {
    String ligne = LocalDate.now() + ";" + LocalTime.now() + ";" + refMachine + ";D;" + utilisateur + ";ajout_machine\n";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("suivi_maintenance.csv", true))) {
        writer.write(ligne);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void afficher() {
        primaryStage.setTitle("Ajouter une Machine");
        primaryStage.setScene(vueAjouter.getSceneAjouterMachine());
        primaryStage.show();
    }
}