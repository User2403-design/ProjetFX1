/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
import java.time.LocalTime;


public class Machine extends Equipement {
    
    private float x;
    private float y;
    private float coût;
    private float duree; // duree d'utilisation ?
    private String etat; // "operationnel", "en arrêt","libre", "occupé"
    private String type;
    private LocalTime heureFinOccupation; 
    
    public Machine (String refmachine, String dmachine, float x, float y, float cout, String type){
        super(refmachine,dmachine);
        this.x = x;
        this.y = y;
        this.coût = cout;//correspond au cout horaire
        this.etat = "libre"; // comment savoir si ope ? 
        this.type = type;
        this.heureFinOccupation = null; //libre au début
    }  
   
    @Override
    public String toString() {
    return refEquipement + " - " + dEquipement + " (" + type + ")";
    }
    // ajouter methode pour changer etat et temps avant libération
    
    public void ajouterMachine(){
        
    }  
    // pour gérer l'état des machines quand elles sont utilisés pour fabriquer un produit 
    
    //verifie que la machine est libre 
    public boolean isLibre() {
        return heureFinOccupation == null || LocalTime.now().isAfter(heureFinOccupation);
    }
    
    //inialisation de l'attribut heureFinOcupation en fonction de la durée d'utilisation (à calculer pour chaque machine suivant les operation de la gamme ou prendre durée de la gamme entière = plus simple)
    //changement de l'état
    public void occuperMachine(float dureeMinutes) {
        this.heureFinOccupation = LocalTime.now().plusMinutes((long) dureeMinutes);
        this.etat = "occupé";
    }
    
    //compare l'heure de fin d'ocupation à l'heure réelle pour déterminer si la machine est libre
    public void libererSiTermine() {
        if (heureFinOccupation != null && LocalTime.now().isAfter(heureFinOccupation)) {
            this.heureFinOccupation = null;
            this.etat = "operationnel";
        }
    }
    
    
    public float duree (Produit p, String refmachine){
            //parcourir les operations dans la gamme liée au prduit et faire verif quand l'equipement utilisé à la mm ref que celui entrée en parametre, 
            //peut être initialisé une variable duree et ajouter a durée, à chaque fois que la verif renvoire true, le temps de l'operation qui utilise la machine  
            return duree;
    }
    
   // a refaire 
    @Override
    /*public float coutOperation (Operation op){
        Machine m = op.getRefEquipement();
        return op.getDureeOperation()*op.getRefEquipement()
    }*/
    // sert pas a grand chose faut la modifier
    public float coutOperation(float dureeOperation){
        return dureeOperation * coût;
    }
    
    @Override
    public String afficherEquipement(){
        return "Reference Machine: " + refEquipement+"/n"+"Designation: " + dEquipement+"/n"+"Position: (" + x + ", " + y + ")"+"/n"+"Cout horaire: " + coût+"/n"+"Type: " + type+"/n"+"Fin de l'occupation à :"+ heureFinOccupation;
    }
    //FAUT RAJOUTER LA DUREE
    
    /*public void afficherEquipement() { 
        System.out.println("Reference Machine: " + refEquipement);
        System.out.println("Designation: " + dEquipement);
        System.out.println("Position: (" + x + ", " + y + ")");
        System.out.println("Cout horaire: " + coût);
        System.out.println("Type: " + type);
        System.out.println("Duree d'operation (produit specifique) : " + duree);// à changé 
    }*/
    
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

    public float getDurée() {
        return duree;
    }

    public String getType() {
        return type;
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

    public void setDurée(float durée) {
        this.duree = durée;
    }

    public void setType(String type) {
        this.type = type;
    }
}
   