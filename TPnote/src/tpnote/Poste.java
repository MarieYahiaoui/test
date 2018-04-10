/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marie
 */
public class Poste {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Déclaration du nombre total d'usagers et du nombre de guichets
        int nb_total_usagers, nb_guichets;
        
        Random rnd = new Random();
        // Initialisation du nombre d'usagers (aléatoire entre 200 et 300)
        nb_total_usagers = (int) rnd.nextInt(300 - 200 + 1) + 200;
        // Initialisation du nombre de guichets (aléatoire entre 1 et 5)
        nb_guichets = (int) rnd.nextInt(5 - 1 + 1) + 1;
        
        // Création d'un bureau comprenant nb_guichets guichets
        BureauImplemente bureau = new BureauImplemente(nb_guichets);
        
        // Remplissement du bureau et de chaque guichet
        int capacite = 0;
        Guichet guichet;
        int numero_defile = 0;
        // Pour chaque guichet 
        for(int indice_guichet=1; indice_guichet<=nb_guichets; indice_guichet++)
        {
            // L'ouvrir avec une capacité aléatoire comprise entre 10 et 15
            capacite = (int) rnd.nextInt(15 - 10 + 1) + 10;
            guichet = bureau.ouvrirNouveauGuichet(capacite);
            
            // Pour chaque numéro d'usager compris dans cette capacité
            for(int numero_usager=1; numero_usager<=capacite; numero_usager++)
            {
                // L'ajouter au guichet
                guichet.ajouterUsager(numero_usager);
            }
            
            // Afficher son numéro
            System.out.println("numéro du guichet : " + indice_guichet);
            // Défiler le numéro du premier usager
            numero_defile = guichet.premierUsager();
            // Si ce numéro vaut 0 (le guichet est vide), informer l'utilisateur
            if(numero_defile == 0) System.out.println("le guichet est vide");
            // Sinon (le guichet n'est pas vide) afficher ce numéro
            else System.out.println("numéro du premier usager défilé : " + numero_defile );
        }
        
        
        // Déclaration d'un numero de guichet
        int numero_prioritaire = 0;
        // Saisir un des numéros de guichets
        Scanner saisie = new Scanner(System.in);
        do
        {
            System.out.print("Saisissez un numéro de guichet prioritaire entre 1 et " + nb_guichets + " : ");
            numero_prioritaire = saisie.nextInt();
            saisie.nextLine();
            System.out.println();
            // Recommencer tant que le numéro entré ne fait pas partie des guichets existants
        }while( (numero_prioritaire < 1) || (numero_prioritaire > nb_guichets) );
        
        // Générer une capacité aléatoire entre 10 et 15
        capacite = (int) rnd.nextInt(15 - 10 + 1) + 10;
        // Instancer un guichet prioritaire avec cette capacité et le numéro prioritaire saisi ci-dessus
        GuichetPrioritaire guichet_prioritaire = new GuichetPrioritaire(capacite, numero_prioritaire);
        
        // Afficher la méthode toString de ce guichet_prioritaire
        System.out.println(guichet_prioritaire.toString());
    }
}
