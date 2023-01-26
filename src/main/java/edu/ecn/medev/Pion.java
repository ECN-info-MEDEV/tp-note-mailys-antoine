
package edu.ecn.medev;

/**
 * La classe pion permet de représenter un pion/ une boule du jeu.
 * @author maily
 */
public class Pion {
    
    private String couleur ;
    
    /**
     * Constructeur du Pion
     * @param c String représentant la couleur du pion 
     */
    public Pion(String c){
        this.couleur = c;
    }

    /**
     * Méthode retournant la couleur du pion
     * @return couleur : string
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Méthode permettant de mettre à jour la couleur du pion
     * @param couleur : string
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
}
