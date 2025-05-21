/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Magasindebrut;
import Modele.Stockage;
import Vue.VChoisirMatiere;
import javafx.stage.Stage;
import Repertoire.GrandEcran;      // Classe utilitaire plein écran

public class CChoisirMatiere {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VChoisirMatiere vue;

    public CChoisirMatiere(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirMatiere();
        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Magasindebrut m : stockage.getListeMagDeBrut()) {
            vue.getListeMatieres().getItems().add(m.getMatiere());
        }
    }

    private void actionClic() {
        vue.getValiderButton().setOnAction(e -> {
            int index = vue.getListeMatieres().getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                Magasindebrut matiere = stockage.getListeMagDeBrut().get(index);
                CModifierMagBrut ctrl = new CModifierMagBrut(primaryStage, utilisateur, atelier, stockage, matiere);
                ctrl.afficher();
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CMagBrut(primaryStage, utilisateur, atelier, stockage).afficherSectionMagBrut(); // À adapter
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir Matière à Modifier");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
      GrandEcran.afficherPleinEcran(primaryStage, vue.getScene());
    }
}