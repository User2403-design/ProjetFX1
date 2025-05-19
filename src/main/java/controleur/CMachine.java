/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Vue.VMachine;
import javafx.stage.Stage;
import Modele.Stockage;
import Modele.FichierMachine;
import java.util.ArrayList;
import Modele.Machine;
import Repertoire.GrandEcran;

public class CMachine {
    private Stage primaryStage;
    private VMachine vueMachine;
    private Stockage stockage;
    private String utilisateur;
    private String atelier;
    private String role;

    public CMachine(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vueMachine = new VMachine();
        this.stockage = stockage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.role = stockage.getRole(utilisateur); // 🔥 Récupération du rôle

        actionClic();
        appliquerRestrictions(); // 👈 Appliquer les droits selon le rôle
    }

    private void actionClic() {
        vueMachine.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });

        vueMachine.getAfficher().setOnAction(e -> {
            CAfficherMachine controleurAff = new CAfficherMachine(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });

        vueMachine.getModifier().setOnAction(e -> {
            CChoisirMachine controleurModif = new CChoisirMachine(primaryStage, utilisateur, atelier, stockage);
            controleurModif.afficher();
        });

        vueMachine.getAjouter().setOnAction(e -> {
            CAjouterMachine controleurAjout = new CAjouterMachine(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vueMachine.getSupprimer().setOnAction(e -> {
            CSupprimerMachine controleurSup = new CSupprimerMachine(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vueMachine.desactiver(); // 🔐 On désactive les boutons interdits
        }
    }

    public void afficherSectionMachine() {
        primaryStage.setTitle("Section Machine");
        primaryStage.setScene(vueMachine.getScene());
        primaryStage.setMaximized(true);
        GrandEcran.afficherPleinEcran(primaryStage, vueMachine.getScene());
    }
}