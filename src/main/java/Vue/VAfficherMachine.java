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
public class VAfficherMachine {
    private Scene sceneListeMachines;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    
    
    public VAfficherMachine(String machines){
        this.vbox = new VBox(10);
        this.titre= new Label("Liste des Machines :");
        this.textArea = new TextArea(machines);
        this.retourButton = new Button("Retour");
        
        vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur
        textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
        textArea.setWrapText(true);
        textArea.setText(machines);
        //textArea.setText(stockage.afficherToutesLesMachines());
        vbox.getChildren().addAll(titre, textArea, retourButton);

        Scene sceneListeMachines = new Scene(vbox, 400, 400);
        //primaryStage.setScene(sceneListeMachines);
    }

    public Scene getSceneListeMachines() {
        return sceneListeMachines;
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
