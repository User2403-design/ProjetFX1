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
    private String utilisateur, atelier;

    
    public CChoisirGamme(Stage primaryStage, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
        this.vue = new VChoisirGamme();
        initialiserListeGammes();
        actionClic();
    }

    // Initialiser la liste des gammes dans la fenêtre
    private void initialiserListeGammes() {
        List<Gamme> gammes = stockage.getListeGammes();  // Obtenez les gammes depuis le stockage
        for (Gamme gamme : gammes) {
            vue.getListeGammes().getItems().add(gamme.getRefGamme());  // Afficher les références des gammes
        }
    }

    // Actions associées aux boutons et interactions
    private void actionClic() {
        vue.getChoisirButton().setOnAction(e -> {
            // Récupérer la gamme sélectionnée
            String refGamme = vue.getListeGammes().getSelectionModel().getSelectedItem();
            if (refGamme != null) {
                // Trouver la gamme à partir de sa référence
                Gamme gammeSelectionnee = stockage.rechercherGammeParRef(refGamme);
                if (gammeSelectionnee != null) {
                    // Ouvrir la fenêtre de modification de la gamme
                   CModifierGamme controleurModif = new CModifierGamme(primaryStage, stockage, gammeSelectionnee);
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

    // Afficher la fenêtre
    public void afficher() {
        primaryStage.setTitle("Choisir une Gamme");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}