package controleur;

import Modele.Operateur;
import Modele.Stockage;
import Vue.VModifierOperateur;
import javafx.stage.Stage;

/**
 * author chloe
 */

public class CModifierOperateur {

    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Operateur operateur;
    private VModifierOperateur vue;

    public CModifierOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Operateur operateur) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.operateur = operateur;
        this.vue = new VModifierOperateur();
        remplirChamps();
        actionClic();
    }

    //remplissage des champs à l'aide de la recuperation des attributs de l'operateur
    private void remplirChamps() {
        vue.getNomField().setText(operateur.getNom());
        vue.getPrenomField().setText(operateur.getPrenom());
        vue.getCodeField().setText(operateur.getCode());
        vue.getCompetencesField().setText(operateur.getCompetences());
        vue.getEtatCheckBox().setSelected(operateur.getEtat());
    }

    //modification des attributs de l'operateur par ceux entré par utilisateur
    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
        String nom = vue.getNomField().getText().trim();// .trim enlève les espaces : même si on met que un espace ça affiche l'erreur
        String prenom = vue.getPrenomField().getText().trim();
        String code = vue.getCodeField().getText().trim();
        String competences = vue.getCompetencesField().getText().trim();

        // Vérifications basiques des champs obligatoires
        if (nom.isEmpty() || prenom.isEmpty() || code.isEmpty() || competences.isEmpty()) {
            vue.getErreurLabel().setText("Tous les champs doivent être remplis !");
            return;
        }
            operateur.setNom(vue.getNomField().getText().trim());
            operateur.setPrenom(vue.getPrenomField().getText().trim());
            operateur.setCode(vue.getCodeField().getText().trim());
            operateur.setCompetences(vue.getCompetencesField().getText().trim());
            operateur.setEtat(vue.getEtatCheckBox().isSelected());
            new COperateur(primaryStage, utilisateur, atelier, stockage).afficherSectionOperateur();
        });

        vue.getRetourButton().setOnAction(e -> {
            new COperateur(primaryStage, utilisateur, atelier, stockage).afficherSectionOperateur();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Opérateur");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}