/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 *
 * @author Justin
 */
public class VAfficherPoste {
   
    private Scene sceneListePostes;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    
    
    public VAfficherPoste(String postes){
        this.vbox = new VBox(10);
        this.titre= new Label("Liste des Postes :");
        this.textArea = new TextArea(postes);
        this.retourButton = new Button("Retour");
        
        vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur
        textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
        textArea.setWrapText(true);
        textArea.setText(postes);
        //textArea.setText(stockage.afficherToutesLesMachines());
        vbox.getChildren().addAll(titre, textArea, retourButton);

        sceneListePostes = new Scene(vbox, 400, 400);
        //primaryStage.setScene(sceneListeMachines);
    }

    public Scene getSceneListePostes() {
        return sceneListePostes;
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

