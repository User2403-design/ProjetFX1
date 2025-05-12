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

public class Fiabilite {
    
    private Map<String, Long> tempsArret = new HashMap<>(); // pour stocker les temps d'arrêt totals de chaque machine
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
    }
    
}


