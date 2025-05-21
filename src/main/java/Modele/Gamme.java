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
    StringBuilder sb = new StringBuilder();
    
    sb.append("🔹 Référence Gamme : ").append(refGamme).append("\n\n");

    sb.append("Équipements utilisés :\n");
    for (Equipement e : equipements) {
        sb.append("   • ").append(e.afficherEquipement()).append("\n\n");
    }

    sb.append("\n🛠️  Opérations :\n");
    for (Operation op : operations) {
        sb.append(String.format(
            "   • Ref: %-10s | Durée: %5.1f min | Équipement: %s\n",
            op.getRefOperation(),
            op.getDureeOperation(),
            op.getRefEquipement().getRefEquipement()
        ));
    }

    sb.append("\nCoût total de la gamme : ")
      .append(String.format("%.2f €", coutGamme()))
      .append("\n");
    
    sb.append("\n temps total de la gamme : ")
      .append(String.format("%.2f minutes", dureeGamme()))
      .append("\n");

    return sb.toString();
}
    /*public String afficherGamme() {
        StringBuilder sb = new StringBuilder(); // Va contenir sous forme de texte l'affichage d'une gamme pour ensuite être affiché dans l'interface

        sb.append("Reference Gamme : ").append(refGamme).append("\n");
        sb.append("--------\n");
        for (Equipement e : equipements) {
            sb.append(e.afficherEquipement()).append("\n");
            sb.append("--------\n");
        }
        
        sb.append("Operation utilisé :"+"\n");
        for (Operation op : operations) {
            
            sb.append("- Ref Opération : ");
            sb.append(op.getRefOperation());
            sb.append(", durée : ");
            sb.append(op.getDureeOperation());
            sb.append(" minutes, Equipement utilisé : ");
            sb.append(op.getRefEquipement());
            sb.append("--------\n");
        }
        // Affichage du coût à deux décimales
    sb.append(String.format("Coût total de la gamme : %.2f €", coutGamme()));
    return sb.toString();
    }*/
    public float coutGamme() {
    float coutTotal = 0;
    for (Operation op : operations) {
        // conversion des minutes en heures plus logique pour entrer la durée d'une gamme
        float dureeHeure = op.getDureeOperation() / 60.0f;
        coutTotal += op.getRefEquipement().coutOperation(dureeHeure);
    }
    return coutTotal;
}
   
    
    public void ajouterOperation(Operation operation) {
        // Vérifier si l'opération n'est pas déjà présente dans la gamme
        if (!operations.contains(operation)) {
            operations.add(operation);
        }
    }
    
   public float dureeGamme() {
    float dureeTotale = 0;
    for (Operation op : operations) {
        dureeTotale += op.getDureeOperation();
    }
    return dureeTotale;
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