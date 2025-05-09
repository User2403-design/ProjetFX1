/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VOperateur;
import javafx.stage.Stage;
import Modele.Stockage;
import java.util.ArrayList;
import Modele.Operateur;
/**
 *
 * @author chloe
 */
public class COperateur {
    private Stage primaryStage;
    private VOperateur vueOperateur;
    private Stockage stockage;
    

    public COperateur(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.vueOperateur = new VOperateur();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vueOperateur.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); //crée un objet de CAcceuil afin de pouvoir appeler la methode AfficherAccueil
            controleurAcc.afficherAccueil();
        });

        vueOperateur.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            
        });

        vueOperateur.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CModifierOperateur controleurModif = new CModifierOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vueOperateur.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            
            CAjouterOperateur controleurAjout = new CAjouterOperateur(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueOperateur.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            
           CAjouterOperateur controleursup = new CAjouterOperateur(primaryStage, utilisateur, atelier, stockage);
            controleursup.afficher();
        });
    }

    public void afficherSectionOperateur() {
        primaryStage.setTitle("Section Operateur");
        primaryStage.setScene(vueOperateur.getScene());
        primaryStage.show();
    }
}