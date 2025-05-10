/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
public class Operation {
    private String idOperation;
    private String refOperation;
    private Equipement refEquipement;
    private float dureeOperation;
    
    public Operation(String idOperation,String refOperation,Equipement refEquipement, float dureeOperation ){
        this.idOperation = idOperation;
        this.refOperation = refOperation;
        this.refEquipement = refEquipement;
        this.dureeOperation = dureeOperation;
    }
    /*public void afficherOperation() {
        System.out.println("Référence Opération: " + refOperation);
        System.out.println("Désignation: " + idOperation);
        if (refEquipement != null) { // sécurise si jamais refEquiement est null
     refEquipement.afficherEquipement();
} else {
    System.out.println("Aucun équipement assigné.");
}
        System.out.println("Durée de l'opération: " + dureeOperation + " heures");
    }*/
    public String afficherOperation() {
        
    StringBuilder sb = new StringBuilder(); //va contenir sous forme de texte l'affichage d'un poste pour ensuite être afficher dans l'interface
    
    sb.append("Reference Operation : ").append(refOperation).append("\n");
    sb.append("Designation : ").append(idOperation).append("\n");
    sb.append("Durée de l'opération : (en minutes) ").append(dureeOperation).append("\n");
    sb.append("--------\n");
    
    if (refEquipement != null){
        sb.append(refEquipement.afficherEquipement()).append("\n");
    }else {
        sb.append("Aucun équipement assigné.\n");
    }
    return sb.toString();
    }
    
   
    
         
    public String getIdOperation() {
        return idOperation;
    }

    public String getRefOperation() {
        return refOperation;
    }

    public Equipement getRefEquipement() {
        return refEquipement;
    }

    public float getDureeOperation() {
        return dureeOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }

    public void setRefEquipement(Equipement refEquipement) {
        this.refEquipement = refEquipement;
    }

    public void setDureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }
}
