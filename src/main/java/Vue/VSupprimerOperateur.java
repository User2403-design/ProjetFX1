/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.SelectionMode;

public class VSupprimerOperateur {
    
    private ListView<String> listeOperateurs;
    private Button supprimerButton;
    private Button retourButton;
    private Label messageLabel;
    private Scene scene;

    public VSupprimerOperateur() {
        VBox vbox = new VBox(10);
        listeOperateurs = new ListView<>();
        supprimerButton = new Button("Supprimer Opérateur");
        retourButton = new Button("Retour");
        messageLabel = new Label();

        listeOperateurs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        vbox.getChildren().addAll(new Label("Sélectionnez un opérateur à supprimer :"),
                                  listeOperateurs, supprimerButton, retourButton, messageLabel);
        scene = new Scene(vbox, 400, 400);
    }

    public void afficherMessage(String message) {
        messageLabel.setText(message);
    }

    public ListView<String> getListeOperateurs() {
        return listeOperateurs;
    }

    public Button getSupprimerButton() {
        return supprimerButton;
    }

    public Button getRetourButton() {
        return retourButton;
    }

    public Scene getScene() {
        return scene;
    }
}