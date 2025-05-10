/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
/**
 *
 * @author chloe
 */
public class VSupprimerPoste {
    
    private ListView<String> listePostes;
    private Button supprimerButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;
    private Label messageLabel;
    

    public VSupprimerPoste() {
        vbox = new VBox(10);
        listePostes = new ListView<>();
        supprimerButton = new Button("Supprimer Poste");
        retourButton = new Button("Retour");
        messageLabel = new Label();
        
        listePostes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 

        vbox.getChildren().addAll(new Label("Sélectionner un poste à supprimer :"), listePostes, supprimerButton, retourButton, messageLabel);
        scene = new Scene(vbox, 600, 300);
    }
    
    public void afficherMessage(String message) { //pour afficher un message indiquand à l'utilisateur si la suppression à eu lieu
        messageLabel.setText(message);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListePostes() { return listePostes; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}