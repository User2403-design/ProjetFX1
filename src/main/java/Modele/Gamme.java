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
    
    public Gamme(String refGamme, ArrayList<Operation> operations) {
        this.refGamme = refGamme;
        this.operations = operations;
        this.equipements = extraireEquipements(operations); // Récupère les équipements automatiquement à partir des opérations
    }
    
    // Méthode pour extraire la liste des équipements des opérations
    private ArrayList<Equipement> extraireEquipements(ArrayList<Operation> operations) {
        ArrayList<Equipement> equipements = new ArrayList<>();
        for (Operation op : operations) {
            Equipement equipement = op.getRefEquipement();
            if (!equipements.contains(equipement)) {
                equipements.add(equipement); // Ajoute l'équipement s'il n'est pas déjà dans la liste
            }
        }
        return equipements;
    }
    
    public String afficherGamme() {
        StringBuilder sb = new StringBuilder(); // Va contenir sous forme de texte l'affichage d'une gamme pour ensuite être affiché dans l'interface

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
            sb.append(" minutes, Equipement utilisé : ");
            sb.append(op.getRefEquipement());
            sb.append("--------\n");
        }

        return sb.toString();
    }

    public float coutGamme() {
        float coutTotal = 0;
        for (Operation op : operations) {
            coutTotal += op.getRefEquipement().coutOperation(op.getDureeOperation());
        }
        return coutTotal;
    }

    public float dureeGamme() {
        float dureeMax = 0;
        for (Operation op : operations) {
            if (op.getDureeOperation() > dureeMax) {
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
        this.equipements = extraireEquipements(operations); // Met à jour la liste des équipements quand les opérations changent
    }

    public void setEquipements(ArrayList<Equipement> equipements) {
        this.equipements = equipements;
    }
}