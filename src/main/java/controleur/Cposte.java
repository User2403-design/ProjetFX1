/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;


import Modele.Stockage;
import javafx.stage.Stage;
import Vue.VPoste;
import javafx.stage.Stage;
import Modele.Stockage;
import java.util.ArrayList;
import Modele.Poste;

/**
 *
 * @author chloe
 */
public class Cposte {
 
    private Stage primaryStage;
    private VPoste vuePoste;
    private Stockage stockage;
    

    public Cposte(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.vuePoste = new VPoste();
        this.stockage = stockage;
        lancerActions(utilisateur, atelier);
    }

    private void lancerActions(String utilisateur, String atelier) { //définit toutes les actions quand on clique sur un boutons
        
        vuePoste.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); //crée un objet de CAcceuil afin de pouvoir appeler la methode AfficherAccueil
            controleurAcc.afficherAccueil();
        });

        vuePoste.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            
            // Charger les machines depuis le fichier
            //ArrayList<Machine> machinesChargees = FichierMachine.charger();
            // Ajouter ces machines à la liste existante dans stockage
            //stockage.getListeMachines().addAll(machinesChargees);             // a faire dans le cas ou on pré enregistre des machines mais fait une boucle qui donne des doublons donc on utilise pas et on pré enregistre pas de machine
            
            stockage.setListeMachines(FichierMachine.charger()); //récupère les machines stocker dans le fichier, les met dans la liste qui va ensuite être afficher 
            CAfficherMachine controleurAff = new CAfficherMachine(primaryStage, utilisateur, atelier, stockage );
            controleurAff.afficher();
        });

        vuePoste.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CModifierMachine controleurModif = new CModifierMachine(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vuePoste.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            
            CAjouterMachine controleurAjout = new CAjouterMachine(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vuePoste.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerMachine controleurSup = new CSupprimerMachine(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    public void afficherSectionPoste() {
        primaryStage.setTitle("Section Poste");
        primaryStage.setScene(vuePoste.getScene());
        primaryStage.show();
    }
} 

