/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;  
import javafx.stage.Stage;
import Modele.Machine;
import Modele.Stockage;
import Vue.VModifierMachine;
import java.time.*;

/**
 *
 * @author Elève
 */
public class CModifierMachine {

    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VModifierMachine vueModifier;

    public CModifierMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueModifier = new VModifierMachine();

        lancerActions();
    }

    private void lancerActions() {
        vueModifier.getModifierButton().setOnAction(e -> {
            String ref = vueModifier.getRefMachineField().getText();
            Machine machineTrouvee = null;

            //A MODIFIER AVEC LA NOUVELLE METHODE RECHERCHE PAR REF dans stockage 
            // Trouver la machine par la référence
            for (Machine machine : stockage.getListeMachines()) {
                if (machine.getRefmachine().equals(ref)) {
                    machineTrouvee = machine;
                    break;
                }
            }

            if (machineTrouvee != null) {
                // Afficher les informations existantes dans les champs
                vueModifier.getNouvelleDescriptionField().setText(machineTrouvee.getDmachine());
                vueModifier.getNouvelleXField().setText(String.valueOf(machineTrouvee.getX()));
                vueModifier.getNouvelleYField().setText(String.valueOf(machineTrouvee.getY()));
                vueModifier.getNouveauCoutField().setText(String.valueOf(machineTrouvee.getCoût()));
                vueModifier.getNouvelEtatField().setText(machineTrouvee.getEtat());
                vueModifier.getNouveauTypeField().setText(machineTrouvee.getType());

                // Quand l'utilisateur appuie sur "Modifier" : récupère tout les attributs entrer par l'utilisateur dans les zones de textes
                vueModifier.getModifierButton().setOnAction(modify -> {
                    String description = vueModifier.getNouvelleDescriptionField().getText();
                    float x = Float.parseFloat(vueModifier.getNouvelleXField().getText());
                    float y = Float.parseFloat(vueModifier.getNouvelleYField().getText());
                    float cout = Float.parseFloat(vueModifier.getNouveauCoutField().getText());
                    String etat = vueModifier.getNouvelEtatField().getText();
                    String type = vueModifier.getNouveauTypeField().getText();

                    // Créer la nouvelle machine modifiée
                    Machine nouvelleMachine = new Machine(ref, description, x, y, cout, etat, type, LocalTime.now());

                    // Supprimer l'ancienne machine
                    stockage.supprimerMachine(ref); // Appel à la méthode pour supprimer la machine par référence

                    // Ajouter la nouvelle machine modifiée
                    stockage.ajouterMachine(nouvelleMachine); //Appel à la methode pour ajouter une nouvelle machine dans le stockage
                });

            } else {
                System.out.println("Machine non trouvée !");
            }
        });

        vueModifier.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier une Machine");
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }

}
