/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class VMachine {
    private Button retour, afficher, modifier, ajouter, supprimer;
    private VBox layoutPrincipal;
    private Scene scene;

    public VMachine() {
        Text titre = new Text("Section Machine");
        titre.setFont(Font.font("Serif", FontWeight.BOLD, 50));
        titre.setFill(Color.web("#333333"));
        titre.setTextAlignment(TextAlignment.CENTER);

        String buttonStyle = "-fx-background-color: #66e0e5;" +
                             "-fx-text-fill: white;" +
                             "-fx-font-weight: bold;" +
                             "-fx-font-size: 18px;" +
                             "-fx-background-radius: 30;" +
                             "-fx-padding: 12 40;";

        retour = new Button("Retour");
        afficher = new Button("Afficher");
        modifier = new Button("Modifier");
        ajouter = new Button("Ajouter");
        supprimer = new Button("Supprimer");

        for (Button b : new Button[]{afficher, modifier, ajouter, supprimer}) {
            b.setStyle(buttonStyle);
        }

        retour.setStyle("-fx-background-color: #cccccc;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 18px;" +
                        "-fx-background-radius: 30;" +
                        "-fx-padding: 12 40;");

        VBox boutonsBox = new VBox(25, afficher, modifier, ajouter, supprimer);
        boutonsBox.setAlignment(Pos.CENTER);

        layoutPrincipal = new VBox(50, titre, boutonsBox, retour);
        layoutPrincipal.setAlignment(Pos.CENTER);

        StackPane cadre = new StackPane(layoutPrincipal);
        cadre.setMaxWidth(600);
        cadre.setMaxHeight(500);
        cadre.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 40;");

        DropShadow ombre = new DropShadow();
        ombre.setRadius(15);
        ombre.setOffsetX(0);
        ombre.setOffsetY(8);
        ombre.setColor(Color.color(0, 0, 0, 0.25));
        cadre.setEffect(ombre);

        // Ajout demandé : Conteneur racine qui centre le cadre dans la scène avec fond gris clair
        StackPane root = new StackPane(cadre);
        root.setStyle("-fx-background-color: #f5f5f5;");
        root.setAlignment(Pos.CENTER);

        // Scène avec taille 2000x1000
        scene = new Scene(root, 2000, 1000);
    }

    public Scene getScene() { return scene; }
    public Button getRetour() { return retour; }
    public Button getAfficher() { return afficher; }
    public Button getModifier() { return modifier; }
    public Button getAjouter() { return ajouter; }
    public Button getSupprimer() { return supprimer; }
}