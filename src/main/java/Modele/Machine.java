/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */


public class Machine extends Equipement {
    
    private float x;
    private float y;
    private float coût;
    private String etat; // "operationnel", "en arrêt","libre", "occupé"
    private String type;
    
    
    public Machine (String refmachine, String dmachine, float x, float y, float cout, String etat, String type){
        super(refmachine,dmachine);
        this.x = x;
        this.y = y;
        this.coût = cout;//correspond au cout horaire
        this.etat = etat; 
        this.type = type; 
    }  
   
    @Override
    public String toString() {
    return refEquipement + " - " + dEquipement + " (" + type + ")";
    }
    
   
    @Override
    public float coutOperation(float dureeOperation){
        return dureeOperation * coût;
    }
    
    @Override
    public String afficherEquipement(){
        return "Reference Machine : " + refEquipement+"\n"+"Designation : " + dEquipement+"\n"+"Position : (" + x + ", " + y + ")"+"\n"+"Cout horaire : " + coût+" euro/heure \n"+ "Etat : "+ etat+"\n"+"Type : " + type;
    }
    
   public String getRefmachine(){
        return refEquipement;
    }

    public String getDmachine() {
        return dEquipement;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getCoût() {
        return coût;
    }

    public String getType() {
        return type;
    }

    public String getEtat() {
        return etat;
    }

    public void setRefmachine(String refmachine) {
        this.refEquipement = refmachine;
    }

    public void setDmachine(String dmachine) {
        this.dEquipement = dmachine;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setCoût(float coût) {
        this.coût = coût;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    
}
   