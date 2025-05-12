/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author chloe
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

public class LectureFichier {
      
    public static Map<String, ArrayList<Evenement>> LireFichier (String nomFichier) {// pk ArrayList ?
    Map<String, ArrayList<Evenement>> map = new HashMap<>();
    
    try (BufferedReader lire = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            
            while ((ligne = lire.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue; // saute lignes vides

                String[] tokens = ligne.split("\\s+");// crée tableau pour stocker les token obtenue par découpage de la chaine en token chaque fois que y'a un ou plusieurs espaces grâce a split
                if (tokens.length < 6) continue; // ignore lignes malformées

                String date = tokens[0];
                String heure = tokens[1];
                String machine = tokens[2];
                char evenement = tokens[3].charAt(0);//pour obtenir le 1er caractère de la ligne (y'en à qu'on seul ici mais son type n'est plus chaine de caract mais caract = > plus facile pour faire des comparaison (pas besoin de equals juste =))
                String operateur = tokens[4];
                String cause = tokens[5];
                
                Evenement ev = new Evenement(date, heure, machine, evenement, operateur, cause);
                //MaintenanceEvent e = new MaintenanceEvent(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                
                if (!map.containsKey(machine)) { // si la machine était pas encore dans le map
                    map.put(machine, new ArrayList<>()); // on ajoute une liste vide (dont la clé est la machine) qui contiendra les ev lié à la machine
                }
                map.get(machine).add(ev); // puis on ajoute l'ev crée à cette liste 
                // avec lambda : map.computeIfAbsent(machine, k -> new ArrayList<>()).add(event);
            } 
        }
        catch (IOException e) {
        System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }

        return map;
    }
}  

