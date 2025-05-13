package controleur;

import Modele.Operateur;
import Modele.Stockage;
import Vue.VModifierOperateur;
import javafx.stage.Stage;

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

    private void remplirChamps() {
        vue.getNomField().setText(operateur.getNom());
        vue.getPrenomField().setText(operateur.getPrenom());
        vue.getCodeField().setText(operateur.getCode());
        vue.getEtatCheckBox().setSelected(operateur.getEtat());
    }

    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
            operateur.setNom(vue.getNomField().getText());
            operateur.setPrenom(vue.getPrenomField().getText());
            operateur.setCode(vue.getCodeField().getText());
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
        primaryStage.show();
    }
}