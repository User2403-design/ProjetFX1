/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * @author chloe
 */

package Vue;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class VAccueil {

    private Button machine, poste, gamme, operation, operateur, produit, stock, map, deconnexion, fiabilite;
    private VBox layoutPrincipal;
    private Scene scene;

    public VAccueil(String utilisateur, String atelier) {

        // Création du titre via la classe Style
        Text titreTexte = Style.creerTitre("Bienvenue " + utilisateur + " dans l'atelier " + atelier + " !");
        VBox blocTitre = new VBox(titreTexte);
        blocTitre.setAlignment(Pos.CENTER);

        // Création des boutons avec style personnalisé via Style
        machine = Style.creerBouton("Machine");
        poste = Style.creerBouton("Poste");
        gamme = Style.creerBouton("Gamme");
        operation = Style.creerBouton("Opération");
        operateur = Style.creerBouton("Opérateur");
        produit = Style.creerBouton("Produit");
        stock = Style.creerBouton("Magasin de brut");
        map = Style.creerBouton("Carte de l'Atelier");
        fiabilite = Style.creerBouton("Fiabilité");
        deconnexion = Style.creerBoutonRetour(); // Tu peux aussi créer Style.creerBoutonDeconnexion() si besoin

        // Organisation des boutons en lignes
        HBox ligne1 = new HBox(30, machine, poste, gamme, operation, fiabilite);
        ligne1.setAlignment(Pos.CENTER);

        HBox ligne2 = new HBox(30, operateur, produit, stock);
        ligne2.setAlignment(Pos.CENTER);

        VBox blocCentre = new VBox(40, ligne1, ligne2, map);
        blocCentre.setAlignment(Pos.CENTER);

        layoutPrincipal = new VBox(70, blocTitre, blocCentre, deconnexion);
        layoutPrincipal.setAlignment(Pos.CENTER);

        StackPane contenuAvecStyle = Style.creerCadreCentre(new StackPane(layoutPrincipal));
        scene = new Scene(contenuAvecStyle, 1600, 800);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getMachine() {
        return machine;
    }

    public Button getPoste() {
        return poste;
    }

    public Button getGamme() {
        return gamme;
    }

    public Button getOperation() {
        return operation;
    }

    public Button getOperateur() {
        return operateur;
    }

    public Button getProduit() {
        return produit;
    }

    public Button getStock() {
        return stock;
    }

    public Button getMap() {
        return map;
    }

    public Button getDeconnexion() {
        return deconnexion;
    }

    public Button getFiabilite() {
        return fiabilite;
    }
}