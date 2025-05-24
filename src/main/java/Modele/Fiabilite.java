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
                    redemarrages.computeIfAbsent(machine, k -> new ArrayList<>()).add(dateHeure);// ajoute la date de redemaragge dans la liste des dates associé à la machine + crée cette liste si la machine n'étais pas contenu dans la map
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
                LocalDateTime finArret = null;

                // Chercher le redémarrage suivant
                while (j < listD.size()) {
                if (listD.get(j).isAfter(debutArret)) {
                    finArret = listD.get(j); //stocke la fin de l'arret localement
                    j++;
                    break ;
                }
                j++; //si la date du D rencontré n'étais pas superieure à la date de l'arret, on avance j pour qu'il continue de parcourir les D jusqu'a trouver le bon 
                }

                if (finArret == null){
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
}


