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
public class VSupprimerMachine {
    
    private ListView<String> listeMachine;
    private Button supprimerButton;
    private Button retourButton;
    private VBox vbox;
    private Scene scene;
    private Label messageLabel;
    

    public VSupprimerMachine() {
        vbox = new VBox(10);
        listeMachine = new ListView<>();
        supprimerButton = new Button("Supprimer Machine");
        retourButton = new Button("Retour");
        messageLabel = new Label();
        
        listeMachine.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 

        vbox.getChildren().addAll(new Label("Sélectionner une machine à supprimer :"), listeMachine, supprimerButton, retourButton);
        scene = new Scene(vbox, 400, 400);
    }
    
    public void afficherMessage(String message) { //pour afficher un message indiquand à l'utilisateur si la suppression à eu lieu
        messageLabel.setText(message);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListeMachine() { return listeMachine; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}
