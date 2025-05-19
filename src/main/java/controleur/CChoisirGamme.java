/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Gamme;
import Modele.Stockage;
import Vue.VChoisirGamme;
import javafx.stage.Stage;
import java.util.List;

public class CChoisirGamme {
    private Stage primaryStage;
    private VChoisirGamme vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CChoisirGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirGamme();
        initialiserListeGammes();
        actionClic();
    }

    private void initialiserListeGammes() {
        List<Gamme> gammes = stockage.getListeGammes();
        vue.getListeGammes().getItems().clear(); // Vide avant remplissage au cas où
        for (Gamme gamme : gammes) {
            vue.getListeGammes().getItems().add(gamme.getRefGamme());
        }
    }

    private void actionClic() {
        vue.getChoisirButton().setOnAction(e -> {
            String refGamme = vue.getListeGammes().getSelectionModel().getSelectedItem();
            if (refGamme != null) {
                Gamme gammeSelectionnee = stockage.rechercherGammeParRef(refGamme);
                if (gammeSelectionnee != null) {
                    CModifierGamme controleurModif = new CModifierGamme(primaryStage, utilisateur, atelier, stockage, gammeSelectionnee);
                    controleurModif.afficher();
                }
            } else {
                System.out.println("Veuillez sélectionner une gamme.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CGamme(primaryStage, utilisateur, atelier, stockage).afficherSectionGamme();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir une Gamme");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}