/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.util.Map;
/**
 *
 * @author Elève
 */
public class VAfficherFiabilite {
  
    private Scene scene;
    private TextArea fiabiliteArea;
    private Button retourButton;

    public VAfficherFiabilite() {
        BorderPane root = new BorderPane();
        fiabiliteArea = new TextArea();
        fiabiliteArea.setEditable(false);
        fiabiliteArea.setWrapText(true);
        retourButton = new Button("Retour");

        VBox vbox = new VBox(10, new Label("Fiabilité des machines :"), fiabiliteArea, retourButton);
        vbox.setPadding(new Insets(20));

        root.setCenter(vbox);
        scene = new Scene(root, 500, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public TextArea getFiabiliteArea() {
        return fiabiliteArea;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public void afficherFiabilites(Map<String, Double> fiabilites) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : fiabilites.entrySet()) {
            sb.append("Machine ").append(entry.getKey())
              .append(" : ").append(String.format("%.2f", entry.getValue())).append("%\n");
        }
        fiabiliteArea.setText(sb.toString());
    }

}
