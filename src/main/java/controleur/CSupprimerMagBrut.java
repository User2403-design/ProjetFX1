/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Magasindebrut;
import Modele.Stockage;
import Vue.VSupprimerMagBrut;
import javafx.stage.Stage;

public class CSupprimerMagBrut {
    private Stage primaryStage;
    private VSupprimerMagBrut vueSupprimer;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CSupprimerMagBrut(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueSupprimer = new VSupprimerMagBrut();
        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Magasindebrut m : stockage.getListeMagDeBrut()) {
            vueSupprimer.getListeMatieres().getItems().add(m.getMatiere());
        }
    }

    private void actionClic() {
        vueSupprimer.getRetourButton().setOnAction(e -> {
            new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut();
        });

        vueSupprimer.getSupprimerButton().setOnAction(e -> {
            String nomSelectionne = vueSupprimer.getListeMatieres().getSelectionModel().getSelectedItem();
            if (nomSelectionne != null && stockage.supprimerMagBrut(nomSelectionne)) {
                vueSupprimer.afficherMessage("Matière supprimée avec succès !");
                vueSupprimer.getListeMatieres().getItems().remove(nomSelectionne);
            } else {
                vueSupprimer.afficherMessage("Matière non trouvée ou erreur de sélection.");
            }
        });
    }

    public void afficher() {
        primaryStage.setTitle("Supprimer une Matière Première");
        primaryStage.setScene(vueSupprimer.getScene());
        primaryStage.show();
    }
}
