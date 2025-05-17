/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repertoire;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author chloe
 */
public class GrandEcran {
    

    public static void afficherPleinEcran(Stage stage, Scene scene) {
        
        stage.setFullScreenExitHint("");  // Supprime le message "Appuyez sur ESC..."
        stage.setFullScreen(true);        // Active le plein écran
        stage.show();                     // Affiche la fenêtre
    }
}