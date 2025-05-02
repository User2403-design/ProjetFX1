/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
public class Operateur {
    private String nom;
    private String prenom;
    private String code; // Peut faire partie d'une superclasse "Personne", comme vous voulez
    private boolean etat;

    public Operateur(String nom, String prenom, String code, boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.etat = etat;
    }
    
    // modifer operateur : faut faire un truc ou l'utilisateur choisi ce qu'il veut modier comme attribut car si on met un truc type constructeur il doit rerentrer toute les informations (plus simple)
    public void ModifierOperateur(String newNom, String newPrenom, String newCode, boolean newEtat){
        this.nom = newNom;
        this.prenom = newPrenom;
        this.code = newCode;
        this.etat = newEtat;
    }

    public void afficherOperateur() {
        System.out.println("=== Opérateur ===");
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Code : " + code);
        System.out.println("État : " + (etat ? "Disponible" : "Occupé"));
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCode() {
        return code;
    }

    public boolean getEtat() {
        return etat;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}