/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Stockage;
import Vue.VSupprimerMachine;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerMachine {

    private Stage primaryStage;
    private VSupprimerMachine vueSupprimer;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        this.vueSupprimer = new VSupprimerMachine();
        lancerActions();
    }

    private void lancerActions() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            CMachine controleurMachine = new CMachine(primaryStage, utilisateur, atelier, stockage);
            controleurMachine.afficherSectionMachine();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String refMachine = vueSupprimer.getRefMachineField().getText();
            if (stockage.supprimerMachine(refMachine)) {
                vueSupprimer.afficherMessage("Machine supprimée avec succès !");
            } else {
                vueSupprimer.afficherMessage("Machine non trouvée.");
            }
        });
    }

    public void afficher() {
        primaryStage.setTitle("Supprimer une Machine");
        primaryStage.setScene(vueSupprimer.getScene());
        primaryStage.show();
    }
}
