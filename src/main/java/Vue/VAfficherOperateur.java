/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vue;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import Modele.Stockage;

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

    public VAfficherOperateur(String operateurs) {
        this.vbox = new VBox(10);
        this.titre = new Label("Liste des Opérateurs :");
        this.textArea = new TextArea(operateurs);
        this.retourButton = new Button("Retour");

        vbox.setPadding(new Insets(10));
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setText(operateurs);

        vbox.getChildren().addAll(titre, textArea, retourButton);

        sceneListeOperateurs = new Scene(vbox, 400, 400);
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