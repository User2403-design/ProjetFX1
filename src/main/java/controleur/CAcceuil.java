/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VAccueil;
import Vue.VInitialisation;
import javafx.stage.Stage;
import Modele.Stockage;

/**
 *
 * @author chloe
 */
public class CAcceuil {
    
    private Stage primaryStage;
    private VAccueil vueAccueil;
    private String utilisateur;
    private String atelier;
    private VInitialisation vueInit;
    private Stockage stockage; // nécessaire pour appeler le constructeur CMachine après

    public CAcceuil(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.vueAccueil = new VAccueil(utilisateur, atelier);
        this.stockage = stockage;
        lancerActions();
    }

    private void lancerActions() { //définit toutes les actions quand on clique sur un boutons
        
        vueAccueil.getDeconnexion().setOnAction(e -> {
            CInitialisation controleurInit = new CInitialisation(primaryStage, stockage);
            controleurInit.afficherConnexion();
        });

        //récupère le bouton Machine de la classe VueAccueil à l'aide du get et définit l'action à réaliser quand on clique dessus 
        vueAccueil.getMachine().setOnAction(e -> {
            
            CMachine controleurMach = new CMachine(primaryStage, utilisateur, atelier, stockage);        
            controleurMach.afficherSectionMachine();
        });

        vueAccueil.getPoste().setOnAction(e -> {
            System.out.println("Cliqué sur Poste !");
            
            Cposte controleurMach = new Cposte(primaryStage, utilisateur, atelier, stockage);        
            controleurMach.afficherSectionPoste();
            
        });

        vueAccueil.getGamme().setOnAction(e -> {
            System.out.println("Cliqué sur Gamme !");
            
            
            
        });

        vueAccueil.getOperation().setOnAction(e -> {
            System.out.println("Cliqué sur Operation !");
            
            COperation controleurMach = new COperation(primaryStage, utilisateur, atelier, stockage);        
            controleurMach.afficherSectionOperation();
        });

        vueAccueil.getOperateur().setOnAction(e -> {
            System.out.println("Cliqué sur Operateur !");
        });

        vueAccueil.getProduit().setOnAction(e -> {
            System.out.println("Cliqué sur Produit !");
        });

        vueAccueil.getFiabilite().setOnAction(e -> {
            System.out.println("Cliqué sur Fiabilité !");
        });
    }

    public void afficherAccueil() {
        primaryStage.setTitle("Accueil de l'Atelier");
        primaryStage.setScene(vueAccueil.getScene()); //remplace la scene qu'il y a avait dans la fenetre principal par celle crée dans Vaccueil
        primaryStage.show();
    }

}
