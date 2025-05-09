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
 * @author Justin
 */
public class VAfficherOperation {
    private Scene sceneListeOperations;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    
    
    public VAfficherOperation(String operations){
        this.vbox = new VBox(10);
        this.titre= new Label("Liste des Opérations :");
        this.textArea = new TextArea(operations);
        this.retourButton = new Button("Retour");
        
        vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur
        textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
        textArea.setWrapText(true);
        textArea.setText(operations);
        //textArea.setText(stockage.afficherToutesLesMachines());
        vbox.getChildren().addAll(titre, textArea, retourButton);

        sceneListeOperations = new Scene(vbox, 400, 400);
        //primaryStage.setScene(sceneListeMachines);
    }

    public Scene getSceneListeOperations() {
        return sceneListeOperations;
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
