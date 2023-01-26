
package edu.ecn.medev;

import java.util.Scanner;

/**
 * Classe fille de Joueur implémentant un joueur dans le rôle du décodeur
 * @author maily
 */
public class Decodeur extends Joueur{
    
    /**
     * Constructeur du Codeur
     * @param j string, nom du joueur
     */
    public Decodeur(Joueur j){
        super(j);
    }
    
    public Combinaison jouer(){
        
        Combinaison tentative = new Combinaison();
        
        System.out.println("Vous allez rentrer la combinaison que vous souhaitez essayer pour deviner la combinaison cachée \n"
                + "Il faut que vous rentriez une combinaison de 4 pions \n"
                + "Les couleurs possibles sont les suivantes : \n"
                + "rouge, bleu, jaune, vert , blanc, noir \n");
        
        // Remplissage de la combinaison souhaitée
        int i = 0 ;
        while (i<=3){
            Scanner scanner = new Scanner(System.in);
            String choix = ""; 
            System.out.println("Rentrer en toutes lettres la couleur souhaitée pour la boule n° " + (i+1));
            choix = scanner.next();
            if (choix == "rouge"){
                tentative.add("R");
            }else if(choix == "bleu"){
                tentative.add("B");
            }else if(choix == "jaune"){
                tentative.add("J");
            }else if(choix == "vert"){
                tentative.add("v");
            }else if(choix == "blanc"){
                tentative.add("W");
            }else if(choix == "noir"){
                tentative.add("N");
            }else{
                i--;
            }
            i++;
        }
        // Affichage final après avoir choisi la combinaison 
        System.out.println("Vous avez proposé la combinaison suivante");
        System.out.println(tentative.affiche());
        return tentative ;
    }

}

