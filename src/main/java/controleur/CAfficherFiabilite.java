/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Stockage;
import Modele.Fiabilite;
import Vue.VAfficherFiabilite;
import javafx.stage.Stage;
import java.util.Map;
/**
 *
 * @author Elève
 */
public class CAfficherFiabilite {
    
    private Stage primaryStage;
    private String utilisateur;
    private String atelier;
    private Stockage stockage;
    private String cheminFichierEvenements;
    private VAfficherFiabilite vue;

    public CAfficherFiabilite(Stage primaryStage, String utilisateur, String atelier, Stockage stockage, String cheminFichierEvenements) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;
        this.cheminFichierEvenements = cheminFichierEvenements;
        vue = new VAfficherFiabilite();
        afficherFiabilite();
        lancerActions();
    }

    private void afficherFiabilite() {
        Fiabilite fiabilite = new Fiabilite(new HashMap<>(), new HashMap<>());
        Map<String, java.util.ArrayList<Evenement>> mapEv = LectureFichier.LireFichier(cheminFichierEvenements);

        for (java.util.ArrayList<Evenement> listeEv : mapEv.values()) {
            fiabilite.analyser(listeEv);
        }

        Map<String, Double> fiabilitePourcentage = fiabilite.calculerFiabilitePourcentage();
        
        for (Map.Entry<String, Double> entry : fiabilitePourcentage.entrySet()) {
            String machine = entry.getKey();
            double pourcentage = entry.getValue();
            vue.getListViewFiabilite().getItems().add(machine + " : " + String.format("%.2f", pourcentage) + " %");
        }
    }

    private void lancerActions() {
        vue.getRetourButton().setOnAction(e -> {
            CEvenement controleurEvenement = new CEvenement(primaryStage, utilisateur, atelier, stockage, cheminFichierEvenements);
            controleurEvenement.afficher();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Fiabilité des Machines");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }

}
