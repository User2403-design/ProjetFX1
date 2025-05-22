/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Machine;
import Modele.Stockage;
import Vue.VModifierMachine;
import javafx.stage.Stage;


public class CModifierMachine {
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Machine machine;
    private VModifierMachine vue;

    public CModifierMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Machine machine) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.machine = machine;
        this.vue = new VModifierMachine();
        remplirChamps();
        actionClic();
    }

    private void remplirChamps() {
        vue.getRefField().setText(machine.getRefmachine());
        vue.getDesignationField().setText(machine.getDmachine());
        vue.getXField().setText(String.valueOf(machine.getX()));
        vue.getYField().setText(String.valueOf(machine.getY()));
        vue.getCoutField().setText(String.valueOf(machine.getCoût()));
        vue.getTypeField().setText(machine.getType());
        vue.getEtatComboBox().setValue(machine.getEtat());
    }

    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
            try {
                // Vérification de la validité des champs X et Y
                float x = Float.parseFloat(vue.getXField().getText());
                float y = Float.parseFloat(vue.getYField().getText());

                // Vérification de la validité du coût horaire
                float cout = Float.parseFloat(vue.getCoutField().getText());

                // Si tout est valide, mise à jour de la machine
                machine.setRefmachine(vue.getRefField().getText());
                machine.setDmachine(vue.getDesignationField().getText());
                machine.setX(x);
                machine.setY(y);
                machine.setCoût(cout);
                machine.setType(vue.getTypeField().getText());
                machine.setEtat(vue.getEtatComboBox().getValue());

                // Retour vers la page des machines après enregistrement
                new CMachine(primaryStage, utilisateur, atelier, stockage).afficherSectionMachine();
            } catch (NumberFormatException ex) {
                // Si la conversion échoue, afficher un message d'erreur global
                vue.getErrorLabel().setText("Erreur: Entrez un nombre valide pour les positions X, Y et le coût horaire.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CChoisirMachine(primaryStage, utilisateur, atelier, stockage).afficher();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Machine");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true); 
        primaryStage.show();
    }
}