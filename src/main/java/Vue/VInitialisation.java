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
import controleur.CInitialisation;
import javafx.scene.layout.GridPane;
/**
 *
 * @author Justin
 */
public class VInitialisation {
    
   //private Stage primaryStage;
   private Scene scene;
   private TextField utilisateurField;
   private TextField atelierField;
   private Button validerButton;
   private CInitialisation controleur;
   
   public VInitialisation(CInitialisation controleur) { 
        this.controleur = controleur;
        construireVue();
    }

   //on sépare du constructeur pour que ca soit plus clair
    private void construireVue(){
        
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
    
        //primaryStage.setTitle("Connexion");
        
        // Création des labels et champs de texte
        Label utilisateurLabel = new Label("Nom de l'utilisateur :");
        utilisateurField = new TextField(); // Permet de creer une zonne de texte 
        
        Label atelierLabel = new Label("Nom de l'Atelier :");
        atelierField = new TextField();
       
        validerButton = new Button("Valider"); // permet de crer un bouton

        validerButton.setOnAction(e -> {
            this.controleur.ValiderButton();
        });

        grid.add(utilisateurLabel, 0, 0);
        grid.add(utilisateurField, 1, 0);
        grid.add(atelierLabel, 0, 1);
        grid.add(atelierField, 1, 1);
        grid.add(validerButton, 1, 2);

        scene = new Scene(grid, 400, 300);

        //primaryStage.setTitle("Saisie des informations");
        //primaryStage.setScene(scene);
        //primaryStage.show();
        
}
    
    public Button getValiderButton(){
        return validerButton;
    }
    
public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getUtilisateurField() {
        return utilisateurField;
    }

    public TextField getAtelierField() {
        return atelierField;
    }
}
