/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
import java.util.ArrayList;
       
public class Poste extends Equipement{
    
    private ArrayList<Machine> machines;
    
    
public Poste(String refPoste, String dPoste, ArrayList<Machine> machines) {
        super(refPoste,dPoste);
        this.machines = machines;
    }

    @Override
    public float coutOperation(float dureeOperation){
        float coutTotal = 0.0f;
        for (Machine machine : machines) {
            coutTotal += machine.coutOperation(dureeOperation);
        }
        return coutTotal;
    }
    //Tout les methodes servant pour modifier un Poste
    // Pour ajouter une machine à la liste  
    public void ajouterMachine(Machine machine) {
        if (machine != null){ //&& !refMachine.isEmpty()
            machines.add(machine); 
        }
    }//sert pas pour l'instant

    // Pour supprimer une machine de la liste par référence : a supprimer
    public boolean supprimerMachine(Machine machine) {
        if (machine != null){ //&& !refMachine.isEmpty()) {
            return machines.remove(machine); 
        }
        return false;//renvoie true si la machine a été supprimée
    }
    
    public void modifierReference(String newRef){
        this.refEquipement = newRef;
    }
    
    //a remodifier pour l'interfaces 
    /*@Override
    public String afficherEquipement(){
        System.out.println("Reference Poste:"+refEquipement);
        System.out.println("Designation:"+dEquipement);
        System.out.println("--------");//pour la présentation
        for (Machine m : machines){
            System.out.println("machine :");
            m.afficherEquipement();
            System.out.println("--------");
        }
        return("faut modifier cette methode");
    }*/
    
    @Override
    public String afficherEquipement() {
        
    StringBuilder sb = new StringBuilder(); //va contenir sous forme de texte l'affichage d'un poste pour ensuite être afficher dans l'interface
    
    sb.append("Reference Poste : ").append(refEquipement).append("\n");
    sb.append("Designation : ").append(dEquipement).append("\n");
    sb.append("--------\n");
    
    for (Machine m : machines) {
        sb.append("Machine :\n");
        sb.append(m.afficherEquipement()).append("\n");
        sb.append("--------\n");
    }
    
    return sb.toString();
    }
   
     public String getRefposte() {
        return refEquipement;
    }
    

    public void setRefposte(String refposte) {
        this.refEquipement = refposte;
    }

    public String getDposte() {
        return dEquipement;
    }

    public void setDposte(String dposte) {
        this.dEquipement = dposte;
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    } 
}
