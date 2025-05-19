package controleur;

import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Machine;
import Vue.VAjouterMachine;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran
import java.time.LocalTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Contrôleur pour l'ajout d'une Machine
 * @author chloe
 */
public class CAjouterMachine {
    private Stage primaryStage;        // Fenêtre principale
    private String utilisateur;        // Nom utilisateur
    private String atelier;            // Nom atelier
    private Stockage stockage;         // Modèle stockage
    private VAjouterMachine vueAjouter;// Vue ajout machine
    
    /**
     * Constructeur du contrôleur
     */
    public CAjouterMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;        // Stocke la fenêtre
        this.utilisateur = utilisateur;          // Stocke utilisateur
        this.atelier = atelier;                  // Stocke atelier
        this.stockage = stockage;                // Stocke le modèle
        this.vueAjouter = new VAjouterMachine();// Crée la vue
        actionClic();                           // Configure les actions
    }
    
    /**
     * Configuration des actions sur les boutons
     */
    private void actionClic() {
        // Bouton ajouter : ajoute la machine
        vueAjouter.getAjouterButton().setOnAction(e -> {
            try {
                // Récupération des champs
                String ref = vueAjouter.getRefField().getText();
                String description = vueAjouter.getDesField().getText();
                float x = Float.parseFloat(vueAjouter.getxField().getText());
                float y = Float.parseFloat(vueAjouter.getyField().getText());
                float coutHoraire = Float.parseFloat(vueAjouter.getCoutHField().getText());
                String etat = vueAjouter.getEtatComboBox().getValue();
                String type = vueAjouter.getTypeField().getText();
                LocalTime heureFinOcc = LocalTime.parse(vueAjouter.getHeureFinOccField().getText());
                
                // Création d'une nouvelle machine
                Machine nouvelleMachine = new Machine(ref, description, x, y, coutHoraire, etat, type, heureFinOcc);
                stockage.ajouterMachine(nouvelleMachine);  // Ajout au modèle
                
                // Enregistrement de l'événement démarrage
                enregistrerEvenementDemarrage(nouvelleMachine.getRefmachine(), utilisateur);
                
                // Message succès
                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: green;");
                vueAjouter.getMessageLabel().setText("Machine ajoutée avec succès !");
            } catch (NumberFormatException ex) {
                // Message erreur format nombre
                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: red;");
                vueAjouter.getMessageLabel().setText("Erreur : Veuillez entrer des valeurs numériques valides.");
            } catch (Exception ex) {
                // Message erreur générique
                vueAjouter.getMessageLabel().setStyle("-fx-text-fill: red;");
                vueAjouter.getMessageLabel().setText("Erreur lors de l'ajout de la machine.");
                ex.printStackTrace();
            }
        });
        
        // Bouton retour : revient à la section machine
        vueAjouter.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }
    
    /**
     * Enregistre un événement démarrage dans le fichier
     */
    private void enregistrerEvenementDemarrage(String refMachine, String utilisateur) {
        // Ligne au format attendu
        String ligne = LocalDate.now() + ";" + LocalTime.now().withSecond(0).withNano(0) + ";" + refMachine + ";D;" + utilisateur + ";ajout_machine\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suivie_maintenance.txt", true))) {
            writer.write(ligne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Affiche la vue ajout machine en plein écran
     */
    public void afficher() {
        primaryStage.setTitle("Ajouter une Machine");  
        primaryStage.setMaximized(true);// Titre de la fenêtre
        primaryStage.setScene(vueAjouter.getSceneAjouterMachine());        // Applique la scène de la vue ajout machine
        GrandEcran.afficherPleinEcran(primaryStage, vueAjouter.getSceneAjouterMachine());  // Affiche en plein écran
    }
}