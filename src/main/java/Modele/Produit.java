
import Modele.Gamme;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Produit {
    private String codeProduit;
    private String dProduit;
    private ArrayList<Gamme> listeGamme;

    public Produit(String codeProduit, String dProduit, ArrayList<Gamme> gammeselect) {
        this.codeProduit = codeProduit;
        this.dProduit = dProduit;
        this.listeGamme = new ArrayList<>(gammeselect);
    }

    public void afficherProduit() {
        System.out.println("Code du produit : " + codeProduit);
        System.out.println("Désignation du produit : " + dProduit);
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public String getdProduit() {
        return dProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public void setdProduit(String dProduit) {
        this.dProduit = dProduit;
    }

    // Pour affichage dans JavaFX ListView
    @Override
    public String toString() {
        return codeProduit + " - " + dProduit;
    }
}