package controleur;

import javafx.stage.Stage;
import Modele.Operateur;
import Modele.Stockage;
import Vue.VModifierOperateur;

public class CModifierOperateur {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private VModifierOperateur vueModifier;

    public CModifierOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vueModifier = new VModifierOperateur();
        lancerActions();
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }

    private void lancerActions() {
        vueModifier.getModifierButton().setOnAction(e -> {
            String codeRecherche = vueModifier.getNouveauCodeField().getText();
            Operateur operateurTrouve = null;

            // Cherche l'opérateur par son code
            for (Operateur operateur : stockage.getListeOperateurs()) {
                if (operateur.getCode().equalsIgnoreCase(codeRecherche)) {
                    operateurTrouve = operateur;
                    break;
                }
            }

            if (operateurTrouve != null) {
                String nouveauNom = vueModifier.getNomField().getText();
                String nouveauPrenom = vueModifier.getNouveauPrenomField().getText();
                String nouvelEtatText = vueModifier.getNouvelEtatField().getText();
                boolean nouvelEtat = nouvelEtatText.equalsIgnoreCase("Actif");

                // Applique les changements (on ne modifie PAS le code car c’est l’identifiant)
                operateurTrouve.ModifierOperateur(
                    nouveauNom.isEmpty() ? operateurTrouve.getNom() : nouveauNom,
                    nouveauPrenom.isEmpty() ? operateurTrouve.getPrenom() : nouveauPrenom,
                    operateurTrouve.getCode(),
                    nouvelEtat
                );

                System.out.println("Opérateur modifié avec succès.");
            } else {
                System.out.println("Opérateur non trouvé !");
            }
        });

        vueModifier.getRetourButton().setOnAction(e -> {
            COperateur controleurOperateur = new COperateur(primaryStage, utilisateur, atelier, stockage);
            controleurOperateur.afficherSectionOperateur();
        });
    }
    public void afficher() {
        primaryStage.setTitle("Modifier un Operateur");
        primaryStage.setScene(vueModifier.getScene());
        primaryStage.show();
    }
}