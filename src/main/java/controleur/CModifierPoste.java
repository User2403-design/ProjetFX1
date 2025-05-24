/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Machine;
import Modele.Poste;
import Modele.Stockage;
import Vue.VModifierPoste;
import javafx.stage.Stage;

/**
 *
 * @author Elèveimport Modele.Machine;
 */
public class CModifierPoste {
    
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private Poste posteAModifier;
    private VModifierPoste vue;

    public CModifierPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, Poste posteAModifier) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.posteAModifier = posteAModifier;
        this.vue = new VModifierPoste();

        remplirChamps();
        remplirListes();

        actionClic();
    }

    //remplit les zones de texte avec la reference et la désignation du Poste selectionné en vu de les modifiers
    private void remplirChamps() {
        vue.getRefField().setText(posteAModifier.getRefposte());
        vue.getDesignationField().setText(posteAModifier.getDposte());
    }

    private void remplirListes() {
        // Remplir liste machines du poste
        for (Machine m : posteAModifier.getMachines()) {
            vue.getListeMachinesPoste().getItems().add(m.getRefmachine());
        }
        // Remplir liste machines disponibles
        for (Machine m : stockage.getListeMachines()) {
            if (!posteAModifier.getMachines().contains(m)) {
                vue.getListeMachinesDisponibles().getItems().add(m.getRefmachine());
            }
        }
    }

    private void actionClic() {
        vue.getAjouterMachineButton().setOnAction(e -> {
            String selected = vue.getListeMachinesDisponibles().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeMachinesDisponibles().getItems().remove(selected);
                vue.getListeMachinesPoste().getItems().add(selected);
            }
        });

        vue.getRetirerMachineButton().setOnAction(e -> {
            String selected = vue.getListeMachinesPoste().getSelectionModel().getSelectedItem();
            if (selected != null) {
                vue.getListeMachinesPoste().getItems().remove(selected);
                vue.getListeMachinesDisponibles().getItems().add(selected);
            }
        });

        vue.getEnregistrerButton().setOnAction(e -> {
            appliquerModifications();
            new Cposte(primaryStage,utilisateur, atelier, stockage).afficherSectionPoste();
        });

        vue.getRetourButton().setOnAction(e -> {
            new Cposte(primaryStage, utilisateur, atelier, stockage).afficherSectionPoste();
        });
    }

    private void appliquerModifications() {
        String nouvelleRef = vue.getRefField().getText();
        String nouvelleDesignation = vue.getDesignationField().getText();

        posteAModifier.setRefposte(nouvelleRef);
        posteAModifier.setDposte(nouvelleDesignation);

        posteAModifier.getMachines().clear();//vide la liste des machines contenue dans le poste
        for (String refMachine : vue.getListeMachinesPoste().getItems()) {
            Machine machine = stockage.rechercherMachineParRef(refMachine);
            if (machine != null) {
                posteAModifier.ajouterMachine(machine);
            }
        }
    }

    public void afficher() {
        primaryStage.setTitle("Modifier Poste");
        primaryStage.setScene(vue.getScene());
        primaryStage.setMaximized(true);
   }

}
