/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import javafx.stage.Stage;
import Modele.Stockage;
import Modele.Operateur;
/**
 *
 * @author chloe
 */



public class CModifierOperateur {

    private Stage primaryStage;
    private Stockage stockage;

    public CModifierOperateur(Stage primaryStage, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.stockage = stockage;
    }

    public void afficher() {
        // Logique de modification d'un opérateur
        // Par exemple, modifier un opérateur déjà existant
        Operateur operateurToModify = stockage.getListeOperateurs().get(0); // Récupère le premier opérateur pour l'exemple
        operateurToModify.ModifierOperateur("ModifiéNom", "ModifiéPrenom", "ModifiéCode", false);

        // Affichage ou message de confirmation
        System.out.println("Opérateur modifié : " + operateurToModify.afficherOperateur());
    }
}