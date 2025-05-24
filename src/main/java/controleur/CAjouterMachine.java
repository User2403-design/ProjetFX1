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

/**
 * @author chloe
 */
public class CAjouterMachine {
    private Stage primaryStage;        // Fenêtre principale
    private String utilisateur;        // Nom utilisateur
    private String atelier;            // Nom atelier
    private Stockage stockage;         
    private VAjouterMachine vueAjouter;// Vue ajout machine
    
    /**
     * Constructeur du contrôleur
     */
    public CAjouterMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;        // Stocke la fenêtre
        this.utilisateur = utilisateur;          // Stocke utilisateur
        this.atelier = atelier;                  // Stocke atelier
        this.stockage = stockage;                
        this.vueAjouter = new VAjouterMachine();// Crée la vue
        actionClic();                           // Configure les actions
    }
    
    //Configuration des actions sur les boutons
     
    private void actionClic() {
        // Bouton ajouter : ajoute la machine
        vueAjouter.getAjouterButton().setOnAction(e -> {
            try {
            // Vérification des champs vides, pas avec catch parce que c'est pas une exception
                if (vueAjouter.getRefField().getText().isEmpty() ||
                    vueAjouter.getDesField().getText().isEmpty() ||
                    vueAjouter.getxField().getText().isEmpty() ||
                    vueAjouter.getyField().getText().isEmpty() ||
                    vueAjouter.getCoutHField().getText().isEmpty() ||
                    vueAjouter.getEtatComboBox().getValue() == null || 
                    vueAjouter.getTypeField().getText().isEmpty()) {
            
                    vueAjouter.getMessageLabel().setStyle("-fx-text-fill: red;");
                    vueAjouter.getMessageLabel().setText("Erreur : Tous les champs doivent être remplis.");
                return;  
                }
                // Récupération des champs
                String ref = vueAjouter.getRefField().getText();
                String description = vueAjouter.getDesField().getText();
                float x = Float.parseFloat(vueAjouter.getxField().getText());
                float y = Float.parseFloat(vueAjouter.getyField().getText());
                float coutHoraire = Float.parseFloat(vueAjouter.getCoutHField().getText());
                String etat = vueAjouter.getEtatComboBox().getValue();
                String type = vueAjouter.getTypeField().getText();
                
                // Création d'une nouvelle machine
                Machine nouvelleMachine = new Machine(ref, description, x, y, coutHoraire, etat, type);
                stockage.ajouterMachine(nouvelleMachine);  // Ajout dans le stockage
                
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
                  }
        });
        
        // Bouton retour : revient à la section machine
        vueAjouter.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }
    
    // Enregistre un événement démarrage dans le fichier lors de l'ajout pour garder une trace de la date d'ajout de chaque machine
    private void enregistrerEvenementDemarrage(String refMachine, String utilisateur) {
        // Ligne au format attendu
        String ligne = LocalDate.now() + ";" + LocalTime.now().withSecond(0).withNano(0) + ";" + refMachine + ";D;" + utilisateur + ";ajout_machine\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suivie_maintenance.txt", true))) {
            writer.write(ligne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void afficher() {
        primaryStage.setTitle("Ajouter une Machine");  
        primaryStage.setMaximized(true);// Titre de la fenêtre
        primaryStage.setScene(vueAjouter.getSceneAjouterMachine());        // Applique la scène de la vue ajout machine
        }
}