/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class VChoisirGamme {
    private ListView<String> listeGammes;
    private Button choisirButton;
    private Scene scene;
    private Button retourButton;
    
    public VChoisirGamme() {
        listeGammes = new ListView<>();
        choisirButton = new Button("Choisir");
        retourButton = new Button("Retour");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(listeGammes, choisirButton, retourButton);
        
        scene = new Scene(layout, 300, 200);
    }

    public ListView<String> getListeGammes() {
        return listeGammes;
    }

    public Button getChoisirButton() {
        return choisirButton;
    }

    public Scene getScene() {
        return scene;
    }
    public Button getRetourButton() { 
        return retourButton; 
    }
}