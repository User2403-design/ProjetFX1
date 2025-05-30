/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Operateur;
import Modele.Stockage;
import Vue.VChoisirOperateur;
import javafx.stage.Stage;

/**
 * author chloe
 */

public class CChoisirOperateur {
    private Stage primaryStage;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private VChoisirOperateur vue;

    public CChoisirOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VChoisirOperateur();
        remplirListe();
        actionClic();
    }

    private void remplirListe() {
        for (Operateur o : stockage.getListeOperateurs()) {
            // Affichage comme "NOM Prénom (CODE)"
            vue.getListeOperateurs().getItems().add(o.getNom() + " " + o.getPrenom() + " (" + o.getCode() + ")");
        }
    }

    private void actionClic() {
        vue.getValiderButton().setOnAction(e -> {
            String selection = vue.getListeOperateurs().getSelectionModel().getSelectedItem();
            if (selection != null && selection.contains("(") && selection.contains(")")) {
                // Extraire le code entre les parenthèses
                String code = selection.substring(selection.indexOf("(") + 1, selection.indexOf(")"));
                Operateur operateur = stockage.rechercherOperateurParCode(code);
                if (operateur != null) {
                    CModifierOperateur controller = new CModifierOperateur(primaryStage, utilisateur, atelier, stockage, operateur);
                    controller.afficher();
                }
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new COperateur(primaryStage, utilisateur, atelier, stockage).afficherSectionOperateur(); 
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir un Opérateur à Modifier");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}