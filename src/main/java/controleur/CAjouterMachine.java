package controleur;

import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Machine;
import Vue.VAjouterMachine;

import java.time.LocalTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

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
                String etat = vueAjouter.getEtatComboBox().getValue();
                String type = vueAjouter.getTypeField().getText();
                LocalTime heureFinOcc = LocalTime.parse(vueAjouter.getHeureFinOccField().getText());

                Machine nouvelleMachine = new Machine(ref, description, x, y, coutHoraire, etat, type, heureFinOcc);
                stockage.ajouterMachine(nouvelleMachine);
                enregistrerEvenementDemarrage(nouvelleMachine.getRefmachine(), utilisateur);

                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: green;");
                vueAjouter.getMessageLabel().setText("Machine ajoutée avec succès !");
            } catch (NumberFormatException ex) {
                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: red;");
                vueAjouter.getMessageLabel().setText("Erreur : Veuillez entrer des valeurs numériques valides.");
            } catch (Exception ex) {
                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: red;");
                vueAjouter.getMessageLabel().setText("Erreur lors de l'ajout de la machine.");
                ex.printStackTrace();
            }
        });

        vueAjouter.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }

    private void enregistrerEvenementDemarrage(String refMachine, String utilisateur) {
        String ligne = LocalDate.now() + ";" + LocalTime.now().withSecond(0).withNano(0) + ";" + refMachine + ";D;" + utilisateur + ";ajout_machine\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suivie_maintenance.txt", true))) {
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