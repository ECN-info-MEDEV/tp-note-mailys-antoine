
package edu.ecn.medev;

/**
 * Classe fille de la classe Pion permettant de préciser que le pion est un 
 * pion de couleur qui compose les combinaisons.
 * @author maily
 */
public class PionJeu extends Pion {
     /**
     * Constructeur de PionJeu
     * Prend en paramètre une couleur et se construit comme Pion
     * @param couleur string, couleur du pion
     */
    public PionJeu(String couleur){
        super(couleur);
    }
}
