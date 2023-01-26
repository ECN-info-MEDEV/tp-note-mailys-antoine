
package edu.ecn.medev;

import java.util.Scanner ;
import edu.ecn.medev.Combinaison ;
import java.util.ArrayList; 

/**
 * Classe fille de Joueur implémentant un joueur dans le rôle du codeur
 * @author maily
 */
public class Codeur extends Joueur {
    
    /**
     * Constructeur du Codeur
     * @param j, joueur 
     */
    public Codeur(Joueur j){
        super(j);
    }
    
    
    /**
     * Méthode permettant de réaliser un tour de jeu pour le codeur
     * Le codeur propose une combinaison de pion noir et blanc donnant des indications sur la combinaison donnée par le décodeur au tour précédent
     * La méthode vérifie que la combinaison proposée par le codeur est cohérente 
     * @param courante combinaison courante du jeu, la dernière que le décodeur aura proposé
     * @param target combinaison cachée du eu, celle que le décodeur doit deviner
     * @return combinaison de pion noir et blanc donnant des indications sur la combinaison que le décodeur aura proposé
     */
    public Combinaison jouer(Combinaison courante, Combinaison target){
        
        Combinaison result = new Combinaison();
        boolean juste = false ; 
        int noirResult = 0 ; 
        int blancResult = 0 ; 
                
        while (juste == false){
            // Enregistrement de la combinaison que le codeur propose
            System.out.println("Rentrer la combinaison de 4 pions que vous souhaitez \n"
                    + "Rappel : \n"
                    + "N : le décodeur a une boule de bonne couleur au bon endroit \n"
                    + "B : le décodeur a une boule de bonne couleur mais au mauvais endroit \n"
                    + "nul : la boule n'est pas correcte ");
            Scanner scanner = new Scanner(System.in);
            String choix = ""; 
            int i = 0 ; 
            while (i != 4){
                System.out.println("Rentrer le pion n° " + i);
                choix = scanner.next();
                Pion p = new PionIndication(choix);
                result.setPion(i, p);
                i++;
                if (choix.equals("N")){
                    noirResult ++ ;
                }
                if (choix.equals("B")){
                    blancResult ++ ;
                }
            }

            //Vérification que la combinaison proposée par le codeur est cohérente
            int noir = 0 ; 
            int blanc = 0 ; 
            int nul = 0 ; 

            for (int k=0;k<=3;k++){
                if (courante.getListePion().get(k) == target.getListePion().get(k)){
                    noir++ ; 
                }
                else{
                    for (int j=k+1;j<=3;j++){
                        if ((courante.getListePion().get(j) == target.getListePion().get(k)) && (courante.getListePion().get(j) != target.getListePion().get(j))){
                            blanc++; 
                        }
                    }
                }
                nul = 4 - noir - blanc ;
            }


            if ((noirResult == noir) && (blancResult == blanc)){
                juste = true ;
            }
            else{
                System.out.println("La combinaison rentrée n'est pas cohérente, il faut re-éssayer !");
            }
     
        }
        return result ;
    }
    
    /**
     * Méthode permettant au codeur de choisir la combinaison que le décodeur devra deviner pendant sa partie
     * @return combinaison à faire deviner pendant la partie
     */
    public Combinaison choisirObjectif(){
        Combinaison target = new Combinaison();
        
        System.out.println("Vous allez rentrer la combinaison à deviner lors de cette partie \n"
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
                target.setPion(i, p);
            }else if(choix.equals("bleu")){
                Pion p = new PionIndication("B");
                target.setPion(i, p);
            }else if(choix.equals("jaune")){
                Pion p = new PionIndication("J");
                target.setPion(i, p);
            }else if(choix.equals("vert")){
                Pion p = new PionIndication("V");
                target.setPion(i, p);
            }else if(choix.equals("blanc")){
                Pion p = new PionIndication("B");
                target.setPion(i, p);
            }else if(choix.equals("noir")){
                Pion p = new PionIndication("N");
                target.setPion(i, p);
            }else{
                i--;
            }
            i++;
        }
        // Affichage final après avoir choisi la combinaison à faire deviner pendant le jeu
        System.out.println("Retenez bien la combinaison suivante, c'est celle que vous devez faire deviner !");
        System.out.println(target.affiche());
        return target ;
    }
    
}
