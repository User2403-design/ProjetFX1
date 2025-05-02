package com.mycompany.mavenproject1;


/**
 * JavaFX App
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import Modele.Machine;
import Modele.Equipement;
import Modele.Produit;
import Modele.Evenement;
import Modele.Gamme;
import Modele.Operateur;
import Modele.Operation;
import Modele.Stockage;
import Modele.Poste;

import java.util.List;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) {
        showLoginWindow(primaryStage);
    }

    private void showLoginWindow(Stage stage) {
        Label userLabel = new Label("Nom de l'utilisateur :");
        TextField userField = new TextField(); // créer une zone de texte ou l'utilisateur peut rentrer son nom

        Label workshopLabel = new Label("Nom de l'Atelier :");
        TextField workshopField = new TextField(); // crer une zone de texte pour rentrer le nom de l'atelier 

        Button submitButton = new Button("Valider");

        VBox formBox = new VBox(10, userLabel, userField, workshopLabel, workshopField, submitButton);
        formBox.setPadding(new Insets(20));
        formBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(formBox, 400, 300);
        stage.setTitle("Saisie des informations");
        stage.setScene(scene);
        stage.show();

        submitButton.setOnAction(e -> {
            String nomUtilisateur = userField.getText();
            String nomAtelier = workshopField.getText();
            showProductChoiceWindow(nomUtilisateur, nomAtelier);
            stage.close();
        });
    }

    private void showProductChoiceWindow(String nomUtilisateur, String nomAtelier) {
        Stage stage = new Stage();

        // Infos utilisateur en haut à droite
        VBox topRightBox = new VBox(
            new Label("Utilisateur : " + nomUtilisateur),
            new Label("Atelier : " + nomAtelier)
        );
        topRightBox.setAlignment(Pos.TOP_RIGHT);
        topRightBox.setPadding(new Insets(10));

        // Question et liste des produits
        Label questionLabel = new Label("Créer un produit déjà existant ?");
        ListView<String> productListView = new ListView<>();
        productListView.getItems().addAll(listeProduit);
        productListView.setMaxHeight(120);

        VBox centerBox = new VBox(15, questionLabel, productListView);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(10));

        // Bouton pour créer un nouveau produit
        Button customProductButton = new Button("Non, créer mon propre produit");
        customProductButton.setOnAction(e -> {
            stage.close();
            showMachineChoiceWindow(nomUtilisateur, nomAtelier);
        });

        VBox bottomBox = new VBox(customProductButton);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(20));

        // Organisation avec BorderPane
        BorderPane root = new BorderPane();
        root.setTop(topRightBox);
        root.setCenter(centerBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Choix du produit");
        stage.setScene(scene);
        stage.show();
    }

    private void showMachineChoiceWindow(String nomUtilisateur, String nomAtelier) {
        Stage stage = new Stage();

        Label titleLabel = new Label("Choisissez une machine pour créer votre produit");
        ListView<String> machineListView = new ListView<>();
        machineListView.getItems().addAll(listeMachine);
        machineListView.setMaxHeight(150);

        VBox layout = new VBox(15, titleLabel, machineListView);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 500, 300);
        stage.setTitle("Choix de la machine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}