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
/**
 *
 * @author Elève
 */
public class CAjouterEvenement {
    
    private Stage primaryStage;
    private VAjouterEvenement vue;
    private String fichierEvenements; // chemin du fichier événements
    private String utilisateur;
    private String atelier;

    public CAjouterEvenement(Stage primaryStage, String utilisateur, String atelier, String fichierEvenements) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.fichierEvenements = fichierEvenements;
        vue = new VAjouterEvenement();
        lancerActions();
    }

    private void lancerActions() {
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
            System.out.println("Veuillez remplir tous les champs !");
            return;
        }

        String evenement = date + " " + heure + " " + machine + " " + type + " " + operateur + " " + cause;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierEvenements, true))) {
            writer.write(evenement);
            writer.newLine();
            System.out.println("Événement ajouté avec succès !");
        } catch (IOException ex) {
            System.err.println("Erreur lors de l'ajout de l'événement : " + ex.getMessage());
        }

        retour();
    }

    private void retour() {
        CEvenement controleurEvenement = new CEvenement(primaryStage, utilisateur, atelier, fichierEvenements);
        controleurEvenement.afficherSectionEvenements();
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter un Événement");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }

}
