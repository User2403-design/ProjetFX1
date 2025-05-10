/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VAfficherGamme {
    private Scene scene;
    private TextArea zoneAffichage;
    private Button retour;

    public VAfficherGamme() {
        this.zoneAffichage = new TextArea();
        this.zoneAffichage.setEditable(false);
        this.zoneAffichage.setPrefHeight(400);

        this.retour = new Button("Retour");

        VBox vbox = new VBox(20, zoneAffichage, retour);
        BorderPane layout = new BorderPane();
        layout.setCenter(vbox);

        this.scene = new Scene(layout, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public TextArea getZoneAffichage() {
        return zoneAffichage;
    }

    public Button getRetour() {
        return retour;
    }
}
