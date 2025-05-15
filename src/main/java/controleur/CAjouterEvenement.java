/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAjouterEvenement;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Modele.Stockage;

public class CAjouterEvenement {

    private Stage primaryStage;
    private VAjouterEvenement vue;
    private String fichierEvenements;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CAjouterEvenement(Stage primaryStage, String utilisateur, String atelier, String fichierEvenements, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.fichierEvenements = fichierEvenements;
        this.stockage = stockage;
        vue = new VAjouterEvenement();
        actionClic();
    }

    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> ajouterEvenement());
        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void ajouterEvenement() {
        String date = vue.getDateField().getText();
        String heure = vue.getHeureField().getText();
        String machine = vue.getMachineField().getText();
        String type = vue.getTypeComboBox().getValue();
        String operateur = vue.getOperateurField().getText();
        String cause = vue.getCauseField().getText();

        if (date.isEmpty() || heure.isEmpty() || machine.isEmpty() || type == null || operateur.isEmpty() || cause.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez remplir tous les champs !");
            return;
        }

        String evenement = date + ";" + heure + ";" + machine + ";" + type + ";" + operateur + ";" + cause;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierEvenements, true))) {
            writer.write(evenement);
            writer.newLine();
            vue.getMessageLabel().setText("✅ Événement ajouté avec succès !");
        } catch (IOException ex) {
            vue.getMessageLabel().setText("❌ Erreur : " + ex.getMessage());
        }
    }

    private void retour() {
        CEvenement controleurEvenement = new CEvenement(primaryStage, utilisateur, atelier, fichierEvenements, stockage);
        controleurEvenement.afficherSectionEvenements();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Événement");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}