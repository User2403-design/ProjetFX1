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
public class Gamme {
    private String refGamme;
    private ArrayList<Operation> operations;
    private ArrayList<Equipement> equipements;
    
    public Gamme (String refGamme, ArrayList<Operation> operations, ArrayList<Equipement> equipements ){
        this.refGamme = refGamme;
        this.operations = operations;
        this.equipements = equipements;        
    }
    
    //Modifier Gamme a faire dans l'interface
    //Ajouter Gamme aussi
   
    
    /*public void afficherGamme (){
        System.out.println ("Référence de la Gamme :"+refGamme);
        for (Equipement e : equipements){
            e.afficherEquipement(); //meth de la classe abs Equipement
        }
        for (Operation op : operations) {
    System.out.println(" - Réf Opération : " + op.getRefOperation() + ", Durée : " + op.getDureeOperation() + " minutes, Equipement utilisé : " + op.getRefEquipement().getRefEquipement());

    }
    }  */
    public String afficherGamme() {
        
    StringBuilder sb = new StringBuilder(); //va contenir sous forme de texte l'affichage d'un poste pour ensuite être afficher dans l'interface
    
    sb.append("Reference Poste : ").append(refGamme).append("\n");
    
    for (Equipement e : equipements) {
        sb.append(e.afficherEquipement()).append("\n");
        sb.append("--------\n");
    }
     for (Operation op : operations) {
        sb.append("- Ref Opération : ");
        sb.append(op.getRefOperation());
        sb.append(", durée : ");
        sb.append(op.getDureeOperation());
        sb.append(" mintes, Equipement utilisé : ");
        sb.append(op.getRefEquipement());
        sb.append("--------\n");
    }
    
    return sb.toString();
    }
    
   
      
    
    public float coutGamme(){    
        float coutTotal = 0;
        for (Operation op : operations){ 
            coutTotal += op.getRefEquipement().coutOperation(op.getDureeOperation());//pr avoir le cout d'une gamme = pls opération on additionne le cout de chaque opé et ce cout est calculé par rapport à la machine(equipement) utilisé dans l'opé donc on recup cet attribut et on lui calcule son cout avec le meth def dans Machine qui prend en para la durée de l'op
        }        
        return coutTotal;         
    }
    
    
    public float dureeGamme(){
        float dureeMax = 0;

        for (Operation op : operations) {
        	if (op.getDureeOperation()>dureeMax) {
        		dureeMax = op.getDureeOperation();
        	} 
        }
        return dureeMax;
    }
    
    public String getRefGamme() {
        return refGamme;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public ArrayList<Equipement> getEquipements() {
        return equipements;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public void setEquipements(ArrayList<Equipement> equipements) {
        this.equipements = equipements;
    }
    
    
    
}

