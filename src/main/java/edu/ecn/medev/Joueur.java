
package edu.ecn.medev;

/**
 * Classe représentant un joueur
 * Le joueur aura seulement un nom comme attribut et les méthodes de base (constructeur, getters, setters)
 * Les méthodes pour jouer seront implémentées dans les classes filles de Joueur
 * @author maily
 */
public class Joueur {
    
    private String nom ;
    private int score ;
    
    /**
     * Constructeur du Joueur pour l'initialiser au début de la partie (avec un score nul)
     * @param n string, nom du joueur
     */
    public Joueur(String n){
        this.nom = n ; 
        this.score = 0 ;
    }
    
    /**
     * Constructeur de recopie
     * @param j joueur
     */
    public Joueur(Joueur j){
        this.nom = j.getNom() ; 
        this.score = j.getScore() ;
    }
    
    /**
     * Méthode mettant à jour le nom du joueur
     * @param n string, nom à mettre au joueur
     */
    public void setNom(String n){
        this.nom = n ; 
    }
    
    /**
     * Méthode retournant le nom du joueur
     * @return string, le nom du joueur
     */
    public String getNom(){
        return this.nom ; 
    }
    
    /**
     * Méthode mettant à jour le score du joueur
     * @param s int, score à mettre au joueur
     */
    public void setScore(int s){
        this.score = s ; 
    }
    
    /**
     * Méthode retournant le score du joueur
     * @return int, score courant du joueur
     */
    public int getScore(){
        return this.score ; 
    }
    
    
}
