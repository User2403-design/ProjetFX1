/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */



public class Evenement {
    private String date;
    private String heure;
    private String machine; 
    private char typeEv; //A ou D
    private String operateur; 
    private String cause;  
    
    public Evenement (String date,String heure,String machine,char typeEv,String operateur,String cause){
        this.date = date;
        this.heure = heure;
        this.machine = machine;
        this.operateur = operateur;
        this.typeEv = typeEv;
        this.cause = cause;
    }
    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public char getTypeEv() {
        return typeEv;
    }

    public void setTypeEv(char typeEv) {
        this.typeEv = typeEv;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    
}
    


