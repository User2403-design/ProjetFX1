/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private String code; 
    private boolean etat;
    private String competences; 
    

    public Operateur(String nom, String prenom, String code, boolean etat, String competences ) {
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.etat = etat;
        this.competences = competences;
    }

    public String afficherOperateur() {
        return "=== Opérateur ==="+ "\n"
        + "Nom : " + nom + "\n"
        + "Prénom : " + prenom + "\n"
        + "Code : " + code + "\n"
        + "État : " + (etat ? "Disponible" : "Occupé") + "\n"
        + "Competences : " + competences;
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

    public boolean isEtat() {
        return etat;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }
    
}