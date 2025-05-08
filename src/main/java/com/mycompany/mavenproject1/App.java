package com.mycompany.mavenproject1;


/**
 * JavaFX App
 */
import Modele.Stockage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import controleur.CInitialisation;

public class App extends Application {
    
    //référence pour changer de scène facilement
    //private Stage primaryStage;
    //afin de pouvoir acceder au methode et element de la classe Stockage dans toute la classe
    //private Stockage stockage = new Stockage();
    
        
    
    @Override
    public void start(Stage primaryStage) { //appelle le controleur pour afficher la première vue
       
        Stockage stockage = new Stockage();
        CInitialisation controleur = new CInitialisation(primaryStage, stockage);
        controleur.afficherConnexion();
        //this.primaryStage = stage;
        
        
        //appel de la première scéne
        //afficherFenetreConnexion();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /*
    //mettre dans classe VueInitialisation
    private void afficherFenetreConnexion(){
        primaryStage.setTitle("Connexion");
        
        // Création des labels et champs de texte
        Label utilisateurLabel = new Label("Nom de l'utilisateur :");
        TextField utilisateurField = new TextField(); // Permet de creer une zonne de texte 
        
        Label atelierLabel = new Label("Nom de l'Atelier :");
        TextField atelierField = new TextField();
       
        Button validerButton = new Button("Valider"); // permet de crer un bouton

        

        // Encadrement blanc
        VBox whiteBox = new VBox(10, utilisateurLabel, utilisateurField, atelierLabel, atelierField, validerButton);
        whiteBox.setPadding(new Insets(20));
        whiteBox.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        whiteBox.setStyle("-fx-alignment: center;");

        // Fond rose pâle
        StackPane root = new StackPane(whiteBox);
        root.setBackground(new Background(new BackgroundFill(Color.PINK.brighter().brighter(), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Saisie des informations");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Action du bouton : classe ControleurInitialisation
        validerButton.setOnAction(e -> {
            String utilisateur = utilisateurField.getText();
            String atelier = atelierField.getText();
            System.out.println("Nom de l'utilisateur : " + utilisateur);
            System.out.println("Nom de l'Atelier : " + atelier);
            
            if (!utilisateur.isEmpty() && !atelier.isEmpty()) {
                
                // Ouvrir la nouvelle fenêtre
                afficherFenetrePrincipale(utilisateur, atelier);

                //primaryStage.close(); // fermer la première fenêtre
            }  
    
        });
        
}
    //classe VueAccueil
    private void afficherFenetrePrincipale(String utilisateur, String atelier) {
        
        primaryStage.setTitle("Atelier : " + atelier);

        VBox vbox = new VBox(20);
        HBox hbox = new HBox(20);
        
        Label bienvenue = new Label("Bienvenue " + utilisateur + " dans l'atelier " + atelier + " !");
        
        //création du bouton pour revenir en arrière
        Button deconnexion = new Button("Déconnexion");
        //création des boutons pour intervenir sur les différents élements de l'atelier
        Button machine = new Button("Machine");
        Button poste = new Button("Poste");
        Button gamme = new Button("Gamme");
        Button operation = new Button("Operation");
        Button operateur = new Button("Operateur");
        Button produit = new Button("Produit");
        Button fiabilite = new Button("Fiablité");
        
        
        hbox.getChildren().addAll(machine, poste, gamme, operation, operateur, produit, fiabilite);
        vbox.getChildren().addAll(bienvenue,hbox, deconnexion);

        //création de la scène contenant ce que souhaite afficher 
        Scene scenePrincipale = new Scene(vbox, 600, 300);
        
        // changement de scène contenue dans la fenêtre
        primaryStage.setScene(scenePrincipale);

        //Classe ControleurAcceuil
        //définition des actions lors du cliquage sur l'un de ces boutons
        deconnexion.setOnAction(e -> {
            // Si tu veux revenir à la page de connexion
            afficherFenetreConnexion();
        });
        
        machine.setOnAction(e -> afficherBoutonsMachine(utilisateur, atelier));
        poste.setOnAction(e -> afficherBoutonsPoste(utilisateur, atelier));
        gamme.setOnAction(e -> afficherBoutonsGamme(utilisateur, atelier));
        operation.setOnAction(e -> afficherBoutonsOperation(utilisateur, atelier));
        operateur.setOnAction(e -> afficherBoutonsOperateur(utilisateur, atelier));
        produit.setOnAction(e -> afficherBoutonsProduit(utilisateur, atelier));
        fiabilite.setOnAction(e -> afficherBoutonsFiabilite(utilisateur, atelier));
        
    }
    
    //Classe VueMachine
    private void afficherBoutonsMachine(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        // Classe ControleurMachine
        //pour revenir en arrière
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        //ajouter.setOnAction(e -> ajouterM());
    	afficher.setOnAction(e -> afficherM(uti, ate));
    	//modifier.setOnAction(e -> modifierM());
    	//supprimer.setOnAction(e -> supprimerM());
        
        Scene sceneMachine = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneMachine);
    }
    
    private void afficherM(String uti, String ate){
        
    VBox vbox = new VBox(10);
    vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur

    Label titre = new Label("Liste des Machines :");

    
    //utilisation de TextArea pour un affichage propre
    TextArea textArea = new TextArea();
    textArea.setText(stockage.afficherToutesLesMachines());
    textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
    textArea.setWrapText(true);

    Button retourButton = new Button("Retour");

    vbox.getChildren().addAll(titre, textArea, retourButton);

    Scene sceneListeMachines = new Scene(vbox, 400, 400);
    primaryStage.setScene(sceneListeMachines);

    retourButton.setOnAction(e -> afficherBoutonsMachine(uti, ate));
    }
    
    public void ajouterM(){
        Label reference = new Label("Reference:");
        TextField refField = new TextField();
        
        Label designation = new Label("Designation:");
        TextField refdes = new TextField();
        
        Label posX = new Label("PosX");
        TextField posXField = new TextField();
    }
    
    private void afficherBoutonsPoste(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        ajouter.setOnAction(e -> ajouter());
    	afficher.setOnAction(e -> afficher());
    	modifier.setOnAction(e -> modifier());
    	supprimer.setOnAction(e -> supprimer());
        
        Scene scenePoste = new Scene(vbox, 600,300);
        primaryStage.setScene(scenePoste);
    }
    
    private void afficherBoutonsGamme(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        ajouter.setOnAction(e -> ajouter());
    	afficher.setOnAction(e -> afficher());
    	modifier.setOnAction(e -> modifier());
    	supprimer.setOnAction(e -> supprimer());
        
        Scene sceneGamme = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneGamme);
    }
    
    private void afficherBoutonsOperation(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        ajouter.setOnAction(e -> ajouter());
    	afficher.setOnAction(e -> afficher());
    	modifier.setOnAction(e -> modifier());
    	supprimer.setOnAction(e -> supprimer());
        
        Scene sceneOperation = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneOperation);
    }
    
    private void afficherBoutonsOperateur(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        Scene sceneOperateur = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneOperateur);
    }
    
    private void afficherBoutonsProduit(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        Scene sceneProduit = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneProduit);
    }
    
    private void afficherBoutonsFiabilite(String uti, String ate){
        Button afficher = new Button("afficher");
        Button ajouter = new Button("ajouter");
        Button modifier = new Button("modifier");
        Button supprimer = new Button("supprimer");
        
        Button retour = new Button("retour");
        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(afficher, ajouter, modifier, supprimer, retour);
        
        retour.setOnAction(e-> afficherFenetrePrincipale(uti, ate));
        
        Scene sceneFiabilite = new Scene(vbox, 600,300);
        primaryStage.setScene(sceneFiabilite);
    }*/
}

    