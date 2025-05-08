/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author Elève
 */
public class FichierMachine {
    
    public static void creerFichierMachine() {
        try {
            File fichier = new File("machines.txt");
            if (!fichier.exists()) {
                fichier.createNewFile();
            System.out.println("Fichier créé : " + fichier.getName());
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier.");
            e.printStackTrace();
        }
    }
    //methode pour remplir la liste qui contient les machines de l'atelier qu'on affiche par la suite
    public static void charger(ArrayList<Machine> listeMachines) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("machines.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parties = ligne.split(";"); // car on sépares les champs par ";"
                
                if (parties.length == 9) { // vérifie qu'on à bien 8 partie = 8 attributs
                    
                String ref = parties[0];
                String des = parties[1];
                float x = Float.parseFloat(parties[2]); //pour convertir en float car c'est en String sinon
                float y = Float.parseFloat(parties[3]);
                float coutH = Float.parseFloat(parties[4]);
                //float duree = Float.parseFloat(parties[5]);
                String etat = parties[5];
                String type = parties[6];
                LocalTime heureFinOcc = LocalTime.parse(parties[7]);
                
                    Machine m = new Machine(ref, des, x, y, coutH, etat,type); 
                    listeMachines.add(m);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //sauvegarde ce qui est ajouter dans la liste/ce que contient la liste dans le fichier machine
        public static void sauvegarder(ArrayList<Machine> listeMachines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("machines.txt"))) {
            for (Machine machine : listeMachines) {
                
                writer.write(machine.getRefmachine() + ";" + machine.getDmachine() + ";" + machine.getX()+ ";" +machine.getY()+ ";" +machine.getCoût()+ ";" + machine.getDurée()+";" + machine.getEtat()+ ";" + machine.getType() + ";" +machine.getHeureFinOccupation());
                writer.newLine(); //pour passer à la ligne aprés chaque machine 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
