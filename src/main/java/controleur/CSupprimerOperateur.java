/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Stockage;
import Vue.VSupprimerOperateur;
import javafx.stage.Stage;
import Modele.Operateur;
import Repertoire.GrandEcran;

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
        initialiserListe();
        actionClic();
    }

    private void initialiserListe() {
        for (Operateur o : stockage.getListeOperateurs()) {
            // On peut afficher son nom ou code ou les deux
            vueSupprimer.getListeOperateurs().getItems().add(o.getNom());
        }
    }

    private void actionClic() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            COperateur controleurOperateur = new COperateur(primaryStage, utilisateur, atelier, stockage);
            controleurOperateur.afficherSectionOperateur();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String nomSelectionne = vueSupprimer.getListeOperateurs().getSelectionModel().getSelectedItem();
            if (nomSelectionne != null) {
                boolean success = stockage.supprimerOperateur(nomSelectionne); // ⚠ méthode à ajouter
                if (success) {
                    vueSupprimer.getListeOperateurs().getItems().remove(nomSelectionne);
                    vueSupprimer.afficherMessage("Opérateur supprimé avec succès !");
                } else {
                    vueSupprimer.afficherMessage("Opérateur non trouvé.");
                }
            } else {
                vueSupprimer.afficherMessage("Veuillez sélectionner un opérateur.");
            }
        });
    }

    public void afficher() {
        primaryStage.setTitle("Supprimer un Opérateur");
        primaryStage.setScene(vueSupprimer.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}