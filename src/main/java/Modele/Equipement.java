/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
public abstract class Equipement {
     protected String refEquipement;
    protected String dEquipement;
    
 public String getRefEquipement() {
    return refEquipement;
}
   
    public Equipement(String refEquipement,String dEquipement ){
        this.refEquipement = refEquipement;
        this.dEquipement = dEquipement;
    }
    public abstract void afficherEquipement ();

    public abstract float coutOperation(float dureeOperation);

    
    /*public String getRefEquipement() {// faut les enlever ou pas 
        return refEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public String getdEquipement() {
        return dEquipement;
    }

    public void setdEquipement(String dEquipement) {
        this.dEquipement = dEquipement;
    }
    */
 
}
