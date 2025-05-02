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
  

    //plus simple de faire cette classe dans Stockage 
    //public String verifierStock (String matiere, double quantite){
        //crée un (hasmap) liste dans classe Stockage et faire vérif si ce qu'on demande est contenu en recup attribue de chaque el magbrut 
    //for (Magasindebrut mag : listeMagDeBrut)
    //}

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

