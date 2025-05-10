/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;


import javafx.stage.Stage;
import Modele.Operateur;
import Modele.Stockage;
import Vue.VAjouterOperateur;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 *
 * @author chloe
 */

public class CAjouterOperateur {
    
    private Stage primaryStage;
    private VAjouterOperateur vue;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;

    public CAjouterOperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        vue = new VAjouterOperateur();
        lancerActions();
    }

    private void lancerActions() {
        vue.getAjouterButton().setOnAction(e -> {
            // Récupérer les valeurs des champs de texte
            String nom = vue.getNomField().getText();
            String prenom = vue.getPrenomField().getText();
            String code = vue.getCodeField().getText();

            // Vérification que les champs sont remplis
            if (nom.isEmpty() || prenom.isEmpty() || code.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }
           
            // Création de l'opérateur et ajout à la liste des opérateurs
            Operateur operateur = new Operateur(nom, prenom, code, true); // L'état initial est "true" (disponible)
            stockage.getListeOperateurs().add(operateur);
            System.out.println("Opérateur ajouté avec succès !");
            
            // Retour à la vue des opérateurs
            retour();
        });

        vue.getRetourButton().setOnAction(e -> retour());
    }

    private void retour() {
        // Retour à la vue des opérateurs
        COperateur controleurOperateur = new COperateur(primaryStage, utilisateur, atelier, stockage);
        controleurOperateur.afficherSectionOperateur();
    }

    public void afficher() {
        // Affichage de la vue d'ajout d'opérateur
        primaryStage.setTitle("Ajouter un Opérateur");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}