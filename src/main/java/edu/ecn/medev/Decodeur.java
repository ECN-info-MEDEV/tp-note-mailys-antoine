
package edu.ecn.medev;

import java.util.Scanner;
import edu.ecn.medev.Combinaison ;
import java.util.ArrayList;

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
            if (choix.equals("rouge")){
                Pion p = new PionIndication("R");
                tentative.setPion(i, p);
            }else if(choix.equals("bleu")){
                Pion p = new PionIndication("B");
                tentative.setPion(i, p);
            }else if(choix.equals("jaune")){
                Pion p = new PionIndication("J");
                tentative.setPion(i, p);
            }else if(choix.equals("vert")){
                Pion p = new PionIndication("V");
                tentative.setPion(i, p);
            }else if(choix.equals("blanc")){
                Pion p = new PionIndication("B");
                tentative.setPion(i, p);
            }else if(choix.equals("noir")){
                Pion p = new PionIndication("N");
                tentative.setPion(i, p);
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

