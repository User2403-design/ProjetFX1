package com.mycompany.mavenproject1;


/**
 * JavaFX App
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création des labels et champs de texte
        Label userLabel = new Label("Nom de l'utilisateur :");
        TextField userField = new TextField(); // Permet de creer une zonne de texte 
        
        Label workshopLabel = new Label("Nom de l'Atelier :");
        TextField workshopField = new TextField();

        Button submitButton = new Button("Valider"); // permet de crer un bouton

        // Action du bouton
        submitButton.setOnAction(e -> {
            String userName = userField.getText();
            String workshopName = workshopField.getText();
            System.out.println("Nom de l'utilisateur : " + userName);
            System.out.println("Nom de l'Atelier : " + workshopName);
        });

        // Encadrement blanc
        VBox whiteBox = new VBox(10, userLabel, userField, workshopLabel, workshopField, submitButton);
        whiteBox.setPadding(new Insets(20));
        whiteBox.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        whiteBox.setStyle("-fx-alignment: center;");

        // Fond rose pâle
        StackPane root = new StackPane(whiteBox);
        root.setBackground(new Background(new BackgroundFill(Color.PINK.brighter().brighter(), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Saisie des informations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}