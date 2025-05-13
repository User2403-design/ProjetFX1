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
 * @author Elève
 */
public class CMapAtelier {
    
    private Stage primaryStage;
    private VMapAtelier vueMap;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;

    public CMapAtelier(Stage primaryStage, Stockage stockage) {
        this.primaryStage = primaryStage;
        List<Machine> machines = stockage.getListeMachines(); // on récupère toutes les machines connues
        vueMap = new VMapAtelier(machines);
        this.stockage = stockage;
        
        actionClic(utilisateur, atelier);
    }
    
    private void actionClic(String utilisateur, String atelier){
        vueMap.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage); 
            controleurAcc.afficherAccueil();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Carte de l'Atelier");
        primaryStage.setScene(vueMap.getScene());
        primaryStage.show();
    }

}
