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
    

    public VSupprimerPoste() {
        vbox = new VBox(10);
        listePostes = new ListView<>();
        supprimerButton = new Button("Supprimer Poste");
        retourButton = new Button("Retour");
        
        listePostes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 

        vbox.getChildren().addAll(new Label("Sélectionner un poste à supprimer :"), listePostes, supprimerButton, retourButton);
        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListePostes() { return listePostes; }
    public Button getSupprimerButton() { return supprimerButton; }
    public Button getRetourButton() { return retourButton; }
}