package com.mycompany.mavenproject1;


/**
 * JavaFX App
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class App extends Application {
    
    //référence pour changer de scène facilement
    private Stage primaryStage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        
        //appel de la première scéne
        afficherFenetreConnexion();
    }
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
        
        // Action du bouton
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
    private void afficherFenetrePrincipale(String utilisateur, String atelier) {
        
        primaryStage.setTitle("Atelier : " + atelier);

        VBox vbox = new VBox(20);
        HBox hbox = new HBox(20);
        Label bienvenue = new Label("Bienvenue " + utilisateur + " dans l'atelier " + atelier + " !");
        
        Button deconnexion = new Button("Déconnexion");
        Button machine = new Button("Machine");
        Button poste = new Button("Poste");
        Button gamme = new Button("Gamme");
        Button operation = new Button("Operation");
        Button operateur = new Button("Operateur");
        Button produit = new Button("Produit");
        Button fiabilite = new Button("Fiablité");
        
        vbox.getChildren().addAll(bienvenue, deconnexion);
        hbox.getChildren().addAll(machine, poste, gamme, operation, operateur, produit, fiabilite);

        Scene scenePrincipale = new Scene(vbox, 400, 200);
        primaryStage.setScene(scenePrincipale);

        deconnexion.setOnAction(e -> {
            // Si tu veux revenir à la page de connexion
            afficherFenetreConnexion();
        });
    }
}

    