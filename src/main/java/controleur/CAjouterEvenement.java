/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VAjouterEvenement;           // Vue pour ajouter un événement
import javafx.stage.Stage;               // Fenêtre principale JavaFX
import java.io.BufferedWriter;           // Écriture dans fichier
import java.io.FileWriter;
import java.io.IOException;
import Modele.Stockage;                  // Accès aux données du modèle
import java.time.LocalDate;              // Gestion date/heure
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import Repertoire.GrandEcran;             // Utilitaire plein écran

/**
 * Contrôleur pour ajouter un événement dans le système
 * @author chloe
 */
public class CAjouterEvenement {

    private Stage primaryStage;            // Fenêtre principale
    private VAjouterEvenement vue;         // Vue associée
    private String fichierEvenements;      // Fichier texte des événements
    private String utilisateur;            // Utilisateur courant
    private String atelier;                // Atelier courant
    private Stockage stockage;             // Modèle des données

    /**
     * Constructeur : initialise la vue et les variables
     */
    public CAjouterEvenement(Stage primaryStage, String utilisateur, String atelier, String fichierEvenements, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.fichierEvenements = fichierEvenements;
        this.stockage = stockage;

        // Création de la vue pour ajouter un événement
        vue = new VAjouterEvenement();

        // Initialisation des actions sur boutons
        actionClic();
    }

    /**
     * Définition des actions sur les boutons Ajouter et Retour
     */
    private void actionClic() {
        vue.getAjouterButton().setOnAction(e -> ajouterEvenement());
        vue.getRetourButton().setOnAction(e -> retour());
    }

    /**
     * Méthode appelée lors du clic sur Ajouter
     * Valide les champs, formate et écrit l'événement dans le fichier
     */
    private void ajouterEvenement() {
        String date = vue.getDateField().getText();
        String heure = vue.getHeureField().getText();
        String machine = vue.getMachineField().getText();
        String type = vue.getTypeComboBox().getValue();
        String operateur = vue.getOperateurField().getText();
        String cause = vue.getCauseField().getText();

        // Vérification que tous les champs sont remplis
        if (date.isEmpty() || heure.isEmpty() || machine.isEmpty() || type == null || operateur.isEmpty() || cause.isEmpty()) {
            vue.getMessageLabel().setText("Veuillez remplir tous les champs !");
            return;
        }

        // Validation format date
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date, dateFormatter);
        } catch (DateTimeParseException e) {
            vue.getMessageLabel().setText("❌ Format de date invalide (attendu : yyyy-MM-dd)");
            return;
        }

        // Validation format heure
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(heure, timeFormatter);
        } catch (DateTimeParseException e) {
            vue.getMessageLabel().setText("❌ Format d'heure invalide (attendu : HH:mm)");
            return;
        }

        // Construction de la ligne événement à écrire dans le fichier
        String evenement = date + ";" + heure + ";" + machine + ";" + type + ";" + operateur + ";" + cause;

        // Écriture dans le fichier en mode ajout
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierEvenements, true))) {
            writer.write(evenement);
            writer.newLine();
            vue.getMessageLabel().setText("✅ Événement ajouté avec succès !");
        } catch (IOException ex) {
            vue.getMessageLabel().setText("❌ Erreur : " + ex.getMessage());
        }
    }

    /**
     * Retour à la section événements
     */
    private void retour() {
        CEvenement controleurEvenement = new CEvenement(primaryStage, utilisateur, atelier, fichierEvenements, stockage);
        controleurEvenement.afficherSectionEvenements();
    }

    /**
     * Affichage de la vue avec titre et plein écran
     */
    public void afficher() {
        primaryStage.setTitle("Ajouter un Événement");
        primaryStage.setScene(vue.getScene());
    }
}