/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Modele.Operation;
import Modele.Stockage;
import Modele.Gamme;
import Vue.VAjouterGamme;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CAjouterGamme {
    private Stage primaryStage;
    private String utilisateur, atelier;
    private Stockage stockage;
    private VAjouterGamme vue;

    public CAjouterGamme(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.vue = new VAjouterGamme();
        initialiserListe();
        actionClic();
    }

    private void initialiserListe() {
        for (Operation op : stockage.getListeOperations()) {
            vue.getListeOperations().getItems().add(op.getRefOperation());
        }
    }

    private void actionClic() {
        vue.getEnregistrerButton().setOnAction(e -> {
            String ref = vue.getRefGammeField().getText();
            List<String> refsOp = vue.getListeOperations().getSelectionModel().getSelectedItems();

            if (!ref.isEmpty() && !refsOp.isEmpty()) {
                ArrayList<Operation> operations = new ArrayList<>();
                for (String r : refsOp) {
                    Operation op = stockage.rechercherOperationParRef(r);
                    if (op != null) operations.add(op);
                }

                Gamme nouvelleGamme = new Gamme(ref, operations);
                stockage.ajouterGamme(nouvelleGamme);

                System.out.println("Gamme ajoutée avec succès !");
                new COperation(primaryStage, utilisateur, atelier, stockage).afficherSectionOperation();
            } else {
                System.out.println("Veuillez remplir tous les champs.");
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new CGamme(primaryStage, utilisateur, atelier, stockage).afficherSectionGamme();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Ajouter une Gamme");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
