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
/**
 *
 * @author chloe
 */
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
        lancerActions();
    }

    private void lancerActions() {
        vueAjouter.getAjouterButton().setOnAction(e -> {
            try {
                String ref = vueAjouter.getRefField().getText();
                String description = vueAjouter.getDesField().getText();
                float x = Float.parseFloat(vueAjouter.getxField().getText());
                float y = Float.parseFloat(vueAjouter.getyField().getText());
                float coutHoraire = Float.parseFloat(vueAjouter.getCoutHField().getText());
                String etat = vueAjouter.getEtatField().getText();
                String type = vueAjouter.getTypeField().getText();

                Machine nouvelleMachine = new Machine(ref, description, x, y, coutHoraire, etat, type);
                stockage.ajouterMachine(nouvelleMachine);

                // Met à jour le fichier
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

    public void afficher() {
        primaryStage.setTitle("Ajouter une Machine");
        primaryStage.setScene(vueAjouter.getSceneAjouterMachine());
        primaryStage.show();
    }
}

