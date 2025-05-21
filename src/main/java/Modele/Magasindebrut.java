/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
public class Magasindebrut {
    //private String stock;
    private String matiere;
    private double quantite;
    
    public Magasindebrut (String matiere, double quantite){
        this.matiere = matiere;
        this.quantite = quantite;
    }
    
    public void ajouterStock (String matiere, double quantite){
        this.matiere = matiere;
        this.quantite = quantite;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    
}

