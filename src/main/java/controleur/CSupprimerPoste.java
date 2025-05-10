/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VSupprimerPoste;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class CSupprimerPoste {
    private Stage primaryStage;
    private VSupprimerPoste vueSupprimer;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        this.vueSupprimer = new VSupprimerPoste();
        lancerActions();
    }

    private void lancerActions() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            Cposte controleurPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);
            controleurPoste.afficherSectionPoste();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String refPoste = vueSupprimer.getRefPosteField().getText();
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
