/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;
import Vue.VChoisirPoste;
import Modele.Stockage;
import Modele.Poste;
import javafx.stage.Stage;
/**
 *
 * @author Elève
 */
public class CChoisirPoste {
    private Stage primaryStage;
    private VChoisirPoste vue;
    private Stockage stockage;
    private String utilisateur, atelier;

    public CChoisirPoste(Stage primaryStage, String utilisateur, String atelier, Stockage stockage) {
        this.primaryStage = primaryStage;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
        this.stockage = stockage;

        vue = new VChoisirPoste();
        lancerAction();
        remplirListe();
    }
    
    public void remplirListe(){
        for (Poste p : stockage.getListePostes()) {
            vue.getListePostes().getItems().add(p.getRefEquipement());
        }
    }

    private void lancerAction() {
        
        vue.getValiderButton().setOnAction(e -> {
            
            String refChoisie = vue.getListePostes().getSelectionModel().getSelectedItem();
            if (refChoisie != null){
            Poste posteChoisi = stockage.rechercherPosteParRef(refChoisie);
            if (posteChoisi != null) {
                CModifierPoste controleurModif = new CModifierPoste(primaryStage, utilisateur, atelier, stockage, posteChoisi);
                controleurModif.afficher();
            }
            }
        });

        vue.getRetourButton().setOnAction(e -> {
            new Cposte(primaryStage, utilisateur, atelier, stockage).afficherSectionPoste();
        });
    }

    public void afficher() {
        primaryStage.setTitle("Choisir un Poste à Modifier");
        primaryStage.setScene(vue.getScene());
        primaryStage.show();
    }
}
