/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elève
 */
public class VAfficherFiabilite {
  
    private VBox vbox;
    private Scene scene;
    private ListView<String> listeFiabilite;
    private Button retourButton;

    public VAfficherFiabilite() {
        vbox = new VBox(10);

        Label titre = new Label("Fiabilité des Machines");
        listeFiabilite = new ListView<>();
        retourButton = new Button("Retour");

        vbox.getChildren().addAll(titre, listeFiabilite, retourButton);
        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() {
        return scene;
    }

    public ListView<String> getListeFiabilite() {
        return listeFiabilite;
    }

    public Button getRetourButton() {
        return retourButton;
    }

}
