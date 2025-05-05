/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Justin
 */
public class VAccueil {
    
   private Stage primaryStage;

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
}
