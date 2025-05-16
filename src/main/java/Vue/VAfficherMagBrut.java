/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

public class VAfficherMagBrut {
    private Scene scene;
    private VBox vbox;
    private Label titre;
    private TextArea textArea;
    private Button retourButton;

    public VAfficherMagBrut(String contenuStock) {
        titre = new Label("Stock de matières premières :");
        textArea = new TextArea(contenuStock);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        retourButton = new Button("Retour");

        vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        vbox.getChildren().addAll(titre, textArea, retourButton);

        scene = new Scene(vbox);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getRetourButton() {
        return retourButton;
    }
}
