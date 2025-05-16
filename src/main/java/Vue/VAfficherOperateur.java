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
public class VAfficherOperateur {
    private Scene sceneListeOperateurs;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    
    
    public VAfficherOperateur(String operateurs){
        this.vbox = new VBox(10);
        this.titre= new Label("Liste des Operateurs :");
        this.textArea = new TextArea(operateurs);
        this.retourButton = new Button("Retour");
        
        vbox.setPadding(new Insets(10));//pour éviter que le contenu soit collé au conteneur
        textArea.setEditable(false);  // l'utilisateur ne pourra pas modifier
        textArea.setWrapText(true);
        textArea.setText(operateurs);
        //textArea.setText(stockage.afficherToutesLesOperateurs());
        vbox.getChildren().addAll(titre, textArea, retourButton);

        sceneListeOperateurs = new Scene(vbox);
        //primaryStage.setScene(sceneListeOperateurs);
    }

    public Scene getSceneListeOperateurs() {
        return sceneListeOperateurs;
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