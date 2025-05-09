/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;
import Modele.Stockage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
/**
 *
 * @author chloe
 */
public class VAfficherProduit {
    private Scene sceneListeProduits;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    
    
    public VAfficherProduit(String produits){
        this.vbox = new VBox(10);
        this.titre= new Label("Liste des Produits :");
        this.textArea = new TextArea(produits);
        this.retourButton = new Button("Retour");
        
        vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur
        textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
        textArea.setWrapText(true);
        textArea.setText(produits);
        //textArea.setText(stockage.afficherToutesLesProduits());
        vbox.getChildren().addAll(titre, textArea, retourButton);

        sceneListeProduits = new Scene(vbox, 400, 400);
        //primaryStage.setScene(sceneListeProduits);
    }

    public Scene getSceneListeProduits() {
        return sceneListeProduits;
    }

    public VBox getVbox() {
        return vbox;
    }

    public Label getTitre() {
        return titre;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getRetourButton() {
        return retourButton;
    }
    
}