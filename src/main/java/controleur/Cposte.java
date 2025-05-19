/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Modele.Stockage;
import javafx.stage.Stage;
import Vue.VPoste;

public class Cposte {
    private Stage primaryStage;
    private VPoste vuePoste;
    private Stockage stockage;
    private String role;

    public Cposte(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.vuePoste = new VPoste();
        this.stockage = stockage;
        this.role = stockage.getRole(utilisateur); // 👈 Récupérer le rôle
        actionClic(utilisateur, atelier);
        appliquerRestrictions(); // 👈 Appliquer les restrictions
    }

    private void actionClic(String utilisateur, String atelier) {
        vuePoste.getRetour().setOnAction(e -> {
            CAcceuil controleurAcc = new CAcceuil(primaryStage, utilisateur, atelier, stockage);
            controleurAcc.afficherAccueil();
        });

        vuePoste.getAfficher().setOnAction(e -> {
            System.out.println("Cliqué sur Afficher !");
            CAfficherPoste controleurAff = new CAfficherPoste(primaryStage, utilisateur, atelier, stockage);
            controleurAff.afficher();
        });

        vuePoste.getModifier().setOnAction(e -> {
            System.out.println("Cliqué sur Modifier !");
            CChoisirPoste controleurChoisir = new CChoisirPoste(primaryStage, utilisateur, atelier, stockage);
            controleurChoisir.afficher();
        });

        vuePoste.getAjouter().setOnAction(e -> {
            System.out.println("Cliqué sur Ajouter !");
            CAjouterPoste controleurAjout = new CAjouterPoste(primaryStage, utilisateur, atelier, stockage);
            controleurAjout.afficher();
        });

        vuePoste.getSupprimer().setOnAction(e -> {
            System.out.println("Cliqué sur Supprimer !");
            CSupprimerPoste controleurSup = new CSupprimerPoste(primaryStage, utilisateur, atelier, stockage);
            controleurSup.afficher();
        });
    }

    private void appliquerRestrictions() {
        if (!role.equals("chef")) {
            vuePoste.desactiver(); // 🔒 Restriction des droits
        }
    }

    public void afficherSectionPoste() {
        primaryStage.setTitle("Section Poste");
        primaryStage.setScene(vuePoste.getScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}