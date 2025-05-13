/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VChoisirProduit {
    private ListView<String> listeProduits;
    private Button validerButton;
    private Button retourButton;
    private Scene scene;

    public VChoisirProduit() {
        listeProduits = new ListView<>();
        validerButton = new Button("Modifier ce produit");
        retourButton = new Button("Retour");
        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
            new Label("Sélectionnez un produit à modifier :"),
            listeProduits,
            validerButton,
            retourButton
        );
        
        scene = new Scene(vbox, 400, 600);
    }

    public ListView<String> getListeProduits() { return listeProduits; }
    public Button getValiderButton() { return validerButton; }
    public Button getRetourButton() { return retourButton; }
    public Scene getScene() { return scene; }
}