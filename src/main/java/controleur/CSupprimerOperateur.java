/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Stockage;
import Vue.VSupprimerOperateur;
import javafx.stage.Stage;
import Modele.Operateur;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

/**
 *
 * @author chloe
 */
public class CSupprimerOperateur {

    private Stage primaryStage;
    private VSupprimerOperateur vueSupprimer;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        this.vueSupprimer = new VSupprimerOperateur();
        actionClic();
    }

    private void actionClic() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            COperateur controleurOperateur = new COperateur(primaryStage, utilisateur, atelier, stockage);
            controleurOperateur.afficherSectionOperateur();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String nom = vueSupprimer.getNomOperateurField().getText();
            if (stockage.supprimerOperateur(nom)) {
                vueSupprimer.afficherMessage("Operateur supprimé avec succès !");
            } else {
                vueSupprimer.afficherMessage("Operateur non trouvé.");
            }
        });
    }

    public void afficher() {
        primaryStage.setTitle("Supprimer une Operateur");
        primaryStage.setScene(vueSupprimer.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
