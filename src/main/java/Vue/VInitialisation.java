/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import controleur.CInitialisation;
import javafx.scene.layout.GridPane;
/**
 *
 * @author Justin
 */
public class VInitialisation {
    
   
   private Scene scene; //scene que la vue va construire
   private TextField utilisateurField;
   private TextField atelierField;
   private Button validerButton;
   private CInitialisation controleur; //référence vers le contrôleur pour appeler une méthode quand l'utilisateur clique.
   
   public VInitialisation(CInitialisation controleur) { //prend en paramêtre le controleur qui va controler la vue
        this.controleur = controleur;
        construireVue();
    }

   //on sépare du constructeur pour que ca soit plus clair
    private void construireVue(){
        
        GridPane grid = new GridPane();
        grid.setVgap(50);
        grid.setHgap(50);
    
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
}
    
    public Button getValiderButton(){
        return validerButton;
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
