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
import java.util.Arrays;
public class Stockage {
    
    //pour stocker chaque elements
    private ArrayList<Machine> listeMachines; 
    private ArrayList<Operation> listeOperations;
    private ArrayList<Operateur> listeOperateurs;
    private ArrayList<Equipement> listeEquipements;// a enlever
    private ArrayList<Gamme> listeGammes;
    private ArrayList<Produit> listeProduits;
    private ArrayList<Magasindebrut> listeMagDeBrut;
    private ArrayList<Poste> listePostes; 
    
    //constructeur pour initialiser les listes (peut pas appelé stockage et remplir toutes les listes en mm temps : crée liste vide qu'on modifie par les methodes ajouter, supprimer de chaque classes 
    public Stockage (){
        this.listeMachines = new ArrayList<>();
        this.listeOperations = new ArrayList<>();
        this.listeOperateurs = new ArrayList<>();
        this.listeEquipements = new ArrayList<>();
        this.listeGammes = new ArrayList<>();
        this.listeProduits = new ArrayList<>();
        this.listeMagDeBrut = new ArrayList<>();
        this.listePostes= new ArrayList(); 
        
        // Création des machines (équipements)
        Machine M1 = new Machine("M231", "Machine de découpe", 0f, 0f, 234f, "Découpe");
        Machine M2 = new Machine("M232", "Machine de montage", 4f, 34f, 345f, "Montage");
        Machine M3 = new Machine("M460", "Machine d'assemblage", 23.0f, 202f, 202f, "Assemblage");
        Machine M4 = new Machine ("M543", "Machine de fraisage", 12f, 3f, 120f, "Fraisage");

        //ajout de la machine dans la liste des machines individuelle
        this.listeMachines.add(M4);

        // Initialisation de la liste de machines
        //ArrayList<Machine> machinesPoste1 = new ArrayList<>(Arrays.asList(M1,M2,M3));
    
        // Création des postes avec les machines affectées
        Poste Poste1 = new Poste("P001", "Poste de découpe", new ArrayList<>(Arrays.asList(M1,M2,M3)));

        //ajout du poste dans la liste des postes
        this.listePostes.add(Poste1);

        //ajouter dans la liste equipement mais jsp comment le faire le plus optimisé 

        // Création des opérations pour le châssis métallique
        Operation op1 = new Operation("O001", "Découpe des plaques acier", M1, 2.0f);
        Operation op2 = new Operation("O002", "Soudage des éléments", M3, 3.5f);
        Operation op3 = new Operation("O003", "Montage du châssis", M2, 2.0f);

        // Création des opérations pour la pince de serrage
        Operation op4 = new Operation("O004", "Découpe des mâchoires", M1, 1.0f);
        Operation op5 = new Operation("O005", "Assemblage mécanisme", M3, 2.5f);
        Operation op6 = new Operation("O006", "Finition poignée", M2, 1.5f);

        this.listeOperations.add(op1);
        this.listeOperations.add(op2);
        this.listeOperations.add(op3);
        this.listeOperations.add(op4);
        this.listeOperations.add(op5);
        this.listeOperations.add(op6);

        // Création des gammes
        Gamme gammeChassis = new Gamme("G001", new ArrayList<>(Arrays.asList(op1, op2, op3)), new ArrayList<>(Arrays.asList(M1, M2, M3)));
        Gamme gammePince = new Gamme("G002", new ArrayList<>(Arrays.asList(op4, op5, op6)), new ArrayList<>(Arrays.asList(M1, M2, M3)));

        this.listeGammes.add(gammeChassis);
        this.listeGammes.add(gammePince);

        // Création des produits
        ArrayList<Gamme> gammeProduitChassis = new ArrayList<>();
        gammeProduitChassis.add(gammeChassis);
        Produit Chassis = new Produit("P001", "Châssis métallique", gammeProduitChassis); //Chassis ou Produit1

        ArrayList<Gamme> gammeProduitPince = new ArrayList<>();
        gammeProduitPince.add(gammePince);
        Produit Pince = new Produit("P002", "Pince de serrage", gammeProduitPince);

        this.listeProduits.add(Chassis);
        this.listeProduits.add(Pince);

        // Création d'un opérateur fictif
       Operateur operateur1 = new Operateur("O001", "Mathis", "TUROUNET", true);
       
       this.listeOperateurs.add(operateur1);
        
    }
    // methode pr ajouter, modif, supp, afficher chaque el

    public ArrayList<Poste> getListePostes() {
        return listePostes;
    }

    public void setListePostes(ArrayList<Poste> listePostes) {
        this.listePostes = listePostes;
    }
    
    public void ajouterStocke (Magasindebrut stocke){
        this.listeMagDeBrut.add(stocke);
    }
    //verifier si une matière existe en quantité suffisante pour fabriquer un produit
    public boolean VerifierStocke (ArrayList<Magasindebrut> mag, String matiere, double quantite){
        return listeMagDeBrut.stream().anyMatch( m -> m.getMatiere().equals(matiere) && m.getQuantite()>= quantite );
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public ArrayList<Operateur> getListeOperateurs() {
        return listeOperateurs;
    }

    public ArrayList<Equipement> getListeEquipements() {
        return listeEquipements;
    }

    public ArrayList<Gamme> getListeGammes() {
        return listeGammes;
    }

    public ArrayList<Produit> getListeProduits() {
        return listeProduits;
    }

    public ArrayList<Magasindebrut> getListeMagDeBrut() {
        return listeMagDeBrut;
    }
    
    
    // Méthodes pour ajouter des objets dans le stockage

    // Ajouter une machine
    public void ajouterMachine(Machine machine) {
        this.listeMachines.add(machine); 
    }

    // Ajouter un poste de travail
    public void ajouterPoste(Poste poste) {
        this.listePostes.add(poste); 
    }

    // Ajouter une opération
    public void ajouterOperation(Operation operation) {
        this.listeOperations.add(operation);// verif que l'equipement existe
        
    }

    // Ajouter une gamme de fabrication
    public void ajouterGamme(Gamme gamme) {
        this.listeGammes.add(gamme); 
    }

    // Ajouter un opérateur
    public void ajouterOperateur(Operateur operateur) {
        this.listeOperateurs.add(operateur);
    }
    
    // Ajouter un opérateur
    public void ajouterProduit(Produit produit) {
        this.listeProduits.add(produit); 
    }
    
    //methodes pour supprimer
    
    public void supprimerOperation(String refOperation) {
         Operation aSupprimer = null;
            for (Operation op : listeOperations) {
                if (op.getRefOperation().equals(refOperation)) {
                aSupprimer = op;
                break;
            }
        }
                if (aSupprimer != null) {
                     listeOperations.remove(aSupprimer);
                    System.out.println("Opération supprimée avec succès.");
        }       else {
            System.out.println("Opération avec la référence " + refOperation + " non trouvée.");
        }
    }
  
    public void supprimerGamme(String refGamme) {
        Gamme aSupprimer = null;
        for (Gamme g : listeGammes) {
            if (g.getRefGamme().equals(refGamme)) {
                aSupprimer = g;
                break;
            }
        }
        if (aSupprimer != null) {
            listeGammes.remove(aSupprimer);
            System.out.println("Gamme supprimée avec succès.");
        } else {
            System.out.println("Gamme avec la référence " + refGamme + " non trouvée.");
        }
    }

    public void supprimerProduit(String refProduit) {
         Produit aSupprimer = null;
        for (Produit p : listeProduits) {
            if (p.getCodeProduit().equals(refProduit)) {
                aSupprimer = p;
                break;
            }
        }
        if (aSupprimer != null) {
            listeProduits.remove(aSupprimer);
            System.out.println("Produit supprimé avec succès.");
        } else {
            System.out.println("Produit avec la référence " + refProduit + " non trouvé.");
        }
    }


    public void supprimerEquipement(String refEquipement) {
        Equipement aSupprimer = null;
        for (Equipement e : listeEquipements) {
            if (e.refEquipement.equals(refEquipement)) {
                aSupprimer = e;
                break;
            }
        }
        if (aSupprimer != null) {
            listeEquipements.remove(aSupprimer);
            System.out.println("Équipement supprimé avec succès.");
        } else {
            System.out.println("Équipement avec la référence " + refEquipement + " non trouvé.");
        }
    }
    
    
    
    public void supprimerOperateur(String codeOperateur) {
       Operateur aSupprimer = null;
       for (Operateur o : listeOperateurs) {
           if (o.getCode().equals(codeOperateur)) {
               aSupprimer = o;
               break;
           }
       }
       if (aSupprimer != null) {
           listeOperateurs.remove(aSupprimer);
           System.out.println("Opérateur supprimé avec succès.");
       } else {
           System.out.println("Opérateur avec le code " + codeOperateur + " non trouvé.");
       }
   }

    
    public void supprimerMachine(String refMachine) {
        Machine aSupprimer = null;
        for (Machine m : listeMachines) {
            if (m.getRefmachine().equals(refMachine)) {
                aSupprimer = m;
                break;
            }
        }
        if (aSupprimer != null) {
            listeMachines.remove(aSupprimer);
            System.out.println("Machine supprimée avec succès.");
        } else {
            System.out.println("Machine avec la référence " + refMachine + " non trouvée.");
        }
    }

   
    public void supprimerPoste(String refPoste) {
        Poste aSupprimer = null;
        for (Poste p : listePostes) {
            if (p.refEquipement.equals(refPoste)) {
                aSupprimer = p;
                break;
            }
        }
        if (aSupprimer != null) {
            listePostes.remove(aSupprimer);
            System.out.println("Poste supprimé avec succès.");
        } else {
            System.out.println("Poste avec la référence " + refPoste + " non trouvé.");
        }
    }
    

     // afficher toutes les gammes disponibles 
        public void afficherToutesLesGammesDisponibles() {
        System.out.println("Liste des gammes disponibles :");
        for (Gamme g : listeGammes) {
            g.afficherGamme();
        }
        }
        
     // afficher toutes les machines
     
         public void afficherToutesLesMachines() {
        System.out.println("Liste des machines disponibles :");
        for (Machine m : listeMachines) {
            m.afficherEquipement(); // si tu as une méthode d’affichage dans Machine/Equipement
    }
         }
         
     // afficher tous les produits 
         
          public void afficherTousLesProduits() {
        System.out.println("Produits disponibles :");
        for (Produit p : listeProduits) {
            p.afficherProduit();
        }
    }

          // afficher tous les opérateurs 
    public void afficherTousLesOperateurs() {
        System.out.println("Opérateurs disponibles :");
        for (Operateur o : listeOperateurs) {
            o.afficherOperateur();
        }
    }
    //afficher toutes les opérations
    public void afficherToutesLesOperations() {
        System.out.println("Opérations disponibles :");
        for (Operation op : listeOperations) {
            op.afficherOperation();
        }
    }
    //afficher tous les postes de travail
    public void afficherTousLesPostesTravail() {
        System.out.println("Postes de travail disponibles :");
        for (Poste pt : listePostes) {
            pt.afficherEquipement(); 
        }
    }
    // afficher tous les équipements 
    public void afficherTousLesEquipements() {
        System.out.println("Équipements disponibles :");
        for (Equipement eq : listeEquipements) {
            eq.afficherEquipement();
        }
    }
    
}