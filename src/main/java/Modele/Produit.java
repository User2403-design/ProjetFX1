


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.util.ArrayList;

public class Produit {
    private String codeProduit;
    private String dProduit;
    private ArrayList<Gamme> listeGamme;

    public Produit(String codeProduit, String dProduit, ArrayList<Gamme> gammeselect) {
        this.codeProduit = codeProduit;
        this.dProduit = dProduit;
        this.listeGamme = new ArrayList<>(gammeselect); // Copie pour éviter les effets de bord
    }

    
    public String afficherProduit() {
    String resultat = "Code Produit: " + codeProduit + "\n" +
                      "Designation: " + dProduit + "\n" +
                      "Gammes associées:\n";
    for (Gamme g : listeGamme) {
        String duree = String.format("%.2f", g.dureeGamme());
        String cout = String.format("%.2f", g.coutGamme());
        resultat += " - " + g.getRefGamme() +
                    " | Durée: " + duree + "min" +
                    " | Coût: " + cout + "€\n";
    }
    return resultat;
}

    
   

    public String getCodeProduit() {
        return codeProduit;
    }

    public String getdProduit() {
        return dProduit;
    }

    public ArrayList<Gamme> getListeGamme() {
        return listeGamme;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public void setdProduit(String dProduit) {
        this.dProduit = dProduit;
    }

    public void setListeGamme(ArrayList<Gamme> listeGamme) {
        this.listeGamme = listeGamme;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(codeProduit + " - " + dProduit + " | Gammes : ");
        for (Gamme g : listeGamme) {
            sb.append(g.getRefGamme()).append(", ");
        }
        if (!listeGamme.isEmpty()) {
            sb.setLength(sb.length() - 2); // Retirer la virgule finale
        }
        return sb.toString();
    }
}