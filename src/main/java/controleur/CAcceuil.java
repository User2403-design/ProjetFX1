/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;  
import Vue.VAccueil;  // import de la classe VAccueil (vue d'accueil)
import Vue.VInitialisation;  // import de la classe VInitialisation (vue d'initialisation)
import javafx.stage.Stage;  // import de la classe Stage (fenêtre JavaFX)
import Modele.Stockage;  // import de la classe Stockage (modèle des données)


/**
 * 
 * @author chloe
 */
public class CAcceuil {  // début de la classe CAcceuil
    
    private Stage primaryStage;  // fenêtre principale (Stage)
    private VAccueil vueAccueil;  // vue accueil (interface utilisateur)
    private String utilisateur;  // nom/utilisateur connecté
    private String atelier;  // nom/atelier sélectionné
    private VInitialisation vueInit;  // vue initialisation (non utilisée ici mais déclarée)
    private Stockage stockage;  // modèle des données partagées
    
    // constructeur de la classe CAcceuil avec les paramètres nécessaires
    public CAcceuil(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;  // initialisation de la fenêtre principale
        this.utilisateur = utilisateur;  // mémoriser le nom de l'utilisateur
        this.atelier = atelier;  // mémoriser le nom de l'atelier
        this.vueAccueil = new VAccueil(utilisateur, atelier);  // créer la vue accueil avec infos utilisateur et atelier
        this.stockage = stockage;  // mémoriser le modèle de données
        actionClic();  // appeler la méthode pour gérer les actions des boutons
    }
    
    // méthode privée pour définir les actions au clic sur les boutons
    private void actionClic() {
        
        // quand on clique sur le bouton déconnexion
        vueAccueil.getDeconnexion().setOnAction(e -> {
            CInitialisation controleurInit = new CInitialisation(primaryStage, stockage);  // créer contrôleur initialisation
            controleurInit.afficherConnexion();  // afficher la page de connexion
        });
        
        // quand on clique sur le bouton Machine
        vueAccueil.getMachine().setOnAction(e -> {
            CMachine controleurMach = new CMachine(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur Machine
            controleurMach.afficherSectionMachine();  // afficher la section machine
        });
        
        // quand on clique sur le bouton Poste
        vueAccueil.getPoste().setOnAction(e -> {
            System.out.println("Cliqué sur Poste !");  // afficher message dans la console
            Cposte controleurPoste = new Cposte(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur Poste
            controleurPoste.afficherSectionPoste();  // afficher la section poste
        });
        
        // quand on clique sur le bouton Gamme
        vueAccueil.getGamme().setOnAction(e -> {
            System.out.println("Cliqué sur Gamme !");  // afficher message dans la console
            CGamme controleurPoste = new CGamme(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur Gamme
            controleurPoste.afficherSectionGamme();  // afficher la section gamme
        });
        
        // quand on clique sur le bouton Operation
        vueAccueil.getOperation().setOnAction(e -> {
            System.out.println("Cliqué sur Operation !");  // afficher message dans la console
            COperation controleurMach = new COperation(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur Operation
            controleurMach.afficherSectionOperation();  // afficher la section operation
        });
        
        // quand on clique sur le bouton Stock (Magasin de brut)
        vueAccueil.getStock().setOnAction(e -> {
            System.out.println("Cliqué sur Magasin de brut !");  // afficher message dans la console
            CMagBrut controleurMB = new CMagBrut(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur magasin brut
            controleurMB.afficherSectionMagBrut();  // afficher la section magasin brut
        });
        
        // quand on clique sur le bouton Operateur
        vueAccueil.getOperateur().setOnAction(e -> {
            System.out.println("Cliqué sur Operateur !");  // afficher message dans la console
            COperateur controleurPR = new COperateur(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur operateur
            controleurPR.afficherSectionOperateur();  // afficher la section operateur
        });
        
        // quand on clique sur le bouton Produit
        vueAccueil.getProduit().setOnAction(e -> {
            System.out.println("Cliqué sur Produit !");  // afficher message dans la console
            CProduit controleurPR = new CProduit(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur produit
            controleurPR.afficherSectionProduit();  // afficher la section produit
        });
        
        // quand on clique sur le bouton Fiabilite (événements)
        vueAccueil.getFiabilite().setOnAction(e -> {
            System.out.println("Cliqué sur Fiabilité !");  // afficher message dans la console
            CEvenement controleurEv = new CEvenement(primaryStage, utilisateur, atelier, "machine.txt", stockage);  // créer contrôleur événement
            controleurEv.afficherSectionEvenements();  // afficher la section événements
        });
        
        // quand on clique sur le bouton Map (carte atelier)
        vueAccueil.getMap().setOnAction(e-> {
            System.out.println("Cliqué sur Map !");  // afficher message dans la console
            CMapAtelier controleurMap = new CMapAtelier(primaryStage, utilisateur, atelier, stockage);  // créer contrôleur carte atelier
            controleurMap.afficher();  // afficher la carte atelier
        });
    }
    
    // méthode pour afficher la vue accueil dans la fenêtre principale
    public void afficherAccueil() {
        primaryStage.setTitle("Accueil de l'Atelier");  // définir le titre de la fenêtre
        primaryStage.setScene(vueAccueil.getScene());  // définir la scène à afficher dans la fenêtre principale
   
}}