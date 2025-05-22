package com.mycompany.mavenproject1;

import Modele.Stockage;
import javafx.application.Application;
import javafx.stage.Stage;
import controleur.CInitialisation;


public class App extends Application {

   @Override
public void start(Stage primaryStage) {
    Stockage stockage = new Stockage();
    CInitialisation controleur = new CInitialisation(primaryStage, stockage);
    
    // Affiche la première scène dans le stage
    controleur.afficherConnexion();

    primaryStage.setMaximized(true);

    // Affiche la fenêtre (appelle show qu'une seule fois)
    primaryStage.show();
}}
