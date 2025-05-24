/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controleur;

import javafx.stage.Stage;
import Vue.VMapAtelier;
import Modele.Machine;
import Modele.Stockage;
import java.util.List;


/**
 *
 * @author chloe
 */
public class CMapAtelier {

    private Stage primaryStage;
    private VMapAtelier vueMap;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;


    public CMapAtelier(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        List<Machine> machines = stockage.getListeMachines(); //récupère l'ensemble des machines présentes dans l'atelier
        this.vueMap = new VMapAtelier(machines); //crée la vue pour afficher la map 

        actionClic();
    }

    
    private void actionClic() {
        vueMap.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });
    }

    
    public void afficher() {
        primaryStage.setTitle("Carte de l'Atelier");
        primaryStage.setScene(vueMap.getScene());
        primaryStage.setMaximized(true);
    }
}
