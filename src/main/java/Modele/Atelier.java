/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;
import java.util.ArrayList;
/**
 *
 * @author chloe
 */
public class Atelier {
    private String designation ;
    private ArrayList<Equipement> equipements;
    
    public Atelier(String designation, ArrayList<Equipement> equipements){
        this.designation = designation;
        this.equipements = equipements;
    }

    public String getDesignation() {
        return designation;
    }

    public ArrayList<Equipement> getEquipements() {
        return equipements;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setEquipements(ArrayList<Equipement> equipements) {
        this.equipements = equipements;
    }
}

   


