/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;
import java.io.*;
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
}
