/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elève
 */
public class VAfficherFiabilite {
    
    private VBox vbox;
    private ListView<String> listViewFiabilite;
    private Button retourButton;
    private Scene scene;

    public VAfficherFiabilite() {
        vbox = new VBox(10);
        listViewFiabilite = new ListView<>();
        retourButton = new Button("Retour");
        vbox.getChildren().addAll(new Label("Fiabilité des machines (%) :"), listViewFiabilite, retourButton);
        scene = new Scene(vbox, 400, 600);
    }

    public Scene getScene() { return scene; }
    public ListView<String> getListViewFiabilite() { return listViewFiabilite; }
    public Button getRetourButton() { return retourButton; }

}
