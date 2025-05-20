/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Modele.Stockage;

public class Fiabilite {
    private Stockage stockage;
    
    public Fiabilite(Stockage stockage){
        this.stockage = stockage;
    }
    
    public static Map<String, Double> calculerFiabiliteMachines(String cheminFichier) {
        Map<String, List<LocalDateTime>> arrets = new HashMap<>();//stocke les dates d'arret de chaque machine
        Map<String, List<LocalDateTime>> redemarrages = new HashMap<>(); // stocke les date de redemarage de chaque machine
        Map<String, LocalDateTime> debutObservation = new HashMap<>(); // stcoke la première date d'activité de chaque machine
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");//crée un formatter définit pour reconnaitre les dates et heure sous la forme yyyy-MM-dd HH:mm

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) { //lecture du fichier 
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] tokens = ligne.split(";"); //découpe la ligne en morceau 
                if (tokens.length < 4) continue; //saute une ligne si elle est pas au bon format pour éviter des erreurs

                LocalDateTime dateHeure = LocalDateTime.parse(tokens[0] + " " + tokens[1], formatter); //crée un objet qui contient la date ET l'heure d'un evenement converti au format définit par le formatter
                String machine = tokens[2];
                String typeEvenement = tokens[3];

                if (typeEvenement.equals("D")) {
                    debutObservation.putIfAbsent(machine, dateHeure); //stocke la date de début de l'observation = premier D rencontré
                    //redemarrages.computeIfAbsent(machine, k -> new ArrayList<>()).add(dateHeure);// ajoute la date de redemaragge dans la liste des dates associé à la machine + crée cette liste si la machine n'étais pas contenu dans la map
                    redemarrages.putIfAbsent(machine, new ArrayList<>());
                    redemarrages.get(machine).add(dateHeure);
                } else if (typeEvenement.equals("A")) {
                    arrets.computeIfAbsent(machine, k -> new ArrayList<>()).add(dateHeure); //de même pour les arrets
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Double> fiabilites = new HashMap<>();

        for (String machine : debutObservation.keySet()) { //pour chaque machine dont on connait la date de début d'observation :
            List<LocalDateTime> listA = arrets.getOrDefault(machine, new ArrayList<>()); //récupère les dates d'arrets 
            List<LocalDateTime> listD = redemarrages.getOrDefault(machine, new ArrayList<>()); //récupère les dates de redemarrages

            listA.sort(Comparator.naturalOrder()); //trie les dates d'arrets par ordre croissant
            listD.sort(Comparator.naturalOrder()); //trie les dates de redemarrages par ordre croissant 

            long tempsArretTotalMinutes = 0;
            int i = 0, j = 0; //initialise

            while (i < listA.size()) {
                LocalDateTime debutArret = listA.get(i); //stocke le début de l'arret localement
                LocalDateTime finArret;

                // Chercher le redémarrage suivant
                if (j < listD.size() && listD.get(j).isAfter(debutArret)) {
                    finArret = listD.get(j); //stocke la fin de l'arret localement
                    j++;
                } else {
                    finArret = LocalDateTime.now(); // Si pas de redémarrage trouver : considérer que c'est encore en panne
                }

                tempsArretTotalMinutes += Duration.between(debutArret, finArret).toMinutes(); //calcule le temps d'arrets total 
                i++;
            }

            long tempsObservationTotalMinutes = Duration.between(debutObservation.get(machine), LocalDateTime.now().withSecond(0).withNano(0)).toMinutes(); //calcule le temps d'observation
            
        double fiabilite;

        if (tempsObservationTotalMinutes == 0) {
            fiabilite = 100.0;
        } else {
            fiabilite = (1 - (double) tempsArretTotalMinutes / tempsObservationTotalMinutes) * 100;
        }
        fiabilites.put(machine, fiabilite);
    }

        return fiabilites;
    }
    
   
    public String afficherFiabilites(Map<String, Double> fiabilites) { // prend en parametre la map ou chaque machine est associé à sa fiabilité
        StringBuilder sb = new StringBuilder();
        for (Machine machine : stockage.getListeMachines()) { // pour seulement afficher la fiabilité des machines présentes dans l'atelier
        String ref = machine.getRefmachine();
        
        if (fiabilites.containsKey(ref)) { //vérifie si la machine est bien dans la map 
            double fiabilite = fiabilites.get(ref); //récupère la valeur de la clé "ref" = la fiabilité de la machine
            sb.append("Machine ").append(ref).append(" : ").append(String.format("%.2f",fiabilite)).append("%\n"); 
        }
        }
        return sb.toString();
    }
    

    /*private Map<String, Long> tempsArret = new HashMap<>(); // pour stocker les temps d'arrêt totals de chaque machine
    private Map<String, Evenement> arretsEnCours = new HashMap<>(); // pour mémoriser l'evenement de type A et l'utiliser pour calculer le temps d'arret d'une machine

    public Fiabilite (Map<String, Long> tempsArret, Map<String, Evenement> arretsEnCours ){
        this.tempsArret = tempsArret;
        this.arretsEnCours = arretsEnCours;
}
    public void analyser(List<Evenement> ev) {
        for (Evenement e : ev) {
            String machine = e.getMachine();// récupère le nom de la machine  
            char type = e.getTypeEv(); //.toUpperCase(); que si de type String //récupère le type d'evenement

            if (type=='A') {
                arretsEnCours.put(machine, e); // stocke l'ev avec sa machine associé si c'est un arrêt
            } else if (type=='D') {
                Evenement debut = arretsEnCours.get(machine); // si ev est un redémarrage de la mchine on cherche le dernier arrêt de cette machine
                if (debut != null) { // vérifie que cet évenement existe bien (normalement oui)
                    long duree = calculerDuree(debut.getDate(), debut.getHeure(), e.getDate(), e.getHeure());
                    tempsArret.put(machine, tempsArret.getOrDefault(machine, 0L) + duree); //ajoute la durée d'arrêt dans le temps totale d'arrêt de la machine
                    arretsEnCours.remove(machine); // on retire l'arrêt de la machine une fois traité de la "mémoire" pour que quand on recroise "D" on sache avec quel "A" faire le calcule (avec le seul stocké = le dernier rencontré)
                }
                else { 
                    System.out.println("Il manque l'évenement d'arrêt pour la machine "+machine);
                }
            }
        }
    }

    public long calculerDuree(String dateDebut, String heureDebut, String dateFin, String heureFin) {
        
        //crée un DateTimeFormatter pour pouvoir écrire les date et les heures sous un format spécifié que java peut interpréter/manipuler 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        //converti date et heure de début et de fin en LocalDateTime : le format que Java peut manipuler 
        LocalDateTime debut = LocalDateTime.parse(dateDebut + " " + heureDebut, formatter);
        LocalDateTime fin = LocalDateTime.parse(dateFin + " " + heureFin, formatter);
        //calcul la durée entre les deux instants
        Duration duree = Duration.between(debut, fin);
        return duree.toMinutes();
    }
    
    public Map<String, Double> calculerFiabilites(double tempsObservation) { // tempsObservation = nombre de jours d'observation (type = int?)
        
    Map<String, Double> fiabilites = new HashMap<>(); // stocke la fiabilité de chaque machine
    
    for (Map.Entry<String, Long> e : tempsArret.entrySet()) { //transforme la map en un ensemble d'objets Map.Entry pour pouvoir la parcourir machine par machine
        String machine = e.getKey(); // récup la "clé" = la ref de la machine
        long tempsArretMachine = e.getValue(); // récup la "valeur" = temps d'arret de la machine en minutes
        double fiabilite = 1.0 - ((double) tempsArretMachine / tempsObservation); // prend en compte le nombre de jour et la durée d'ouverture de l'atelier par jour
        if (fiabilite < 0) fiabilite = 0; // pour éviter une fiabilité négative en cas d'erreur
        fiabilites.put(machine, fiabilite);
    }
    return fiabilites;
}

    public List<Map.Entry<String, Long>> TrieMachine() {
        //crée une liste triable qui va contenir des parie clé-valeurs de la map TempsArret
        List<Map.Entry<String, Long>> listeTemps = new ArrayList<>(tempsArret.entrySet());
        //effectue le trie en fonction de la valeur = temps d'arrêt
        listeTemps.sort(Map.Entry.comparingByValue());
        
        return listeTemps;
    }
    
    public void afficherClassement(List<Map.Entry<String, Long>> listeTemps){
        System.out.println("Machines les plus fiables (moins de pannes) :");
        for (Map.Entry<String, Long> paire : listeTemps) {
            //converti
            long heures = paire.getValue()/60;
            long minutes = paire.getValue()%60;
                    
            System.out.println("Machine" + paire.getKey() + ":" + heures + "h"+minutes +"min");
        }
    }

    //pas besoin mais au cas ou :
    public Map<String, Long> getTempsArret() {
        return tempsArret;
    }

    public void setTempsArret(Map<String, Long> tempsArret) {
        this.tempsArret = tempsArret;
    }

    public Map<String, Evenement> getArretsEnCours() {
        return arretsEnCours;
    }

    public void setArretsEnCours(Map<String, Evenement> arretsEnCours) {
        this.arretsEnCours = arretsEnCours;
    }*/
    
}


