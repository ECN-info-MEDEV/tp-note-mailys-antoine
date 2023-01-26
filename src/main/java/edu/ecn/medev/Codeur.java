
package edu.ecn.medev;

import java.util.Scanner;

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
                    + "noir : le décodeur a une boule de bonne couleur au bon endroit \n"
                    + "blanc : le décodeur a une boule de bonne couleur mais au mauvais endroit \n"
                    + "nul : la boule n'est pas correcte ");
            Scanner scanner = new Scanner(System.in);
            String choix = ""; 
            int i = 0 ; 
            while (i != 4){
                System.out.println("Rentrer le pion n° " + i);
                choix = scanner.next();
                result.add(choix);
                i++;
                if (choix == "noir"){
                    noirResult ++ ;
                }
                if (choix == "blanc"){
                    blancResult ++ ;
                }
            }

            //Vérification que la combinaison proposée par le codeur est cohérente
            int noir = 0 ; 
            int blanc = 0 ; 
            int nul = 0 ; 

            for (int k=0;k<=3;k++){
                if (courante.get(k) == target.get(k)){
                    noir++ ; 
                }
                else{
                    for (int j=k+1;j<=3;j++){
                        if ((courante.get(j) == target.get(k)) && (courante.get(j) != target.get(j))){
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
            if (choix == "rouge"){
                target.add("R");
            }else if(choix == "bleu"){
                target.add("B");
            }else if(choix == "jaune"){
                target.add("J");
            }else if(choix == "vert"){
                target.add("v");
            }else if(choix == "blanc"){
                target.add("W");
            }else if(choix == "noir"){
                target.add("N");
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
