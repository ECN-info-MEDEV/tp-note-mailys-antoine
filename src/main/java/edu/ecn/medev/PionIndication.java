
package edu.ecn.medev;

/**
 * Classe fille de la classe Pion permettant de préciser que le pion est un 
 * "petit" pion blanc ou noir donnant des indications sur les propositions.
 * @author maily
 */
public class PionIndication extends Pion {
    
    /**
     * Constructeur de PionIndication
     * Prend en paramètre une couleur et se construit comme Pion
     * @param couleur string, couleur du pion
     */
    public PionIndication(String couleur){
        super(couleur);
    }
}
