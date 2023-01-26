package edu.ecn.medev;

import org.apache.velocity.util.TemplateNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Méthode permettant de représenter le plateau de jeu.
 * Dans notre implémentation, le plateau de jeu est composé d'un objectif (une combinaison), d'une liste de tentative (la liste des combinaisons proposées par le décodeur et de la liste d'indications données par le codeur.
 *
 * @author Antoine FRIOGUT (antoine.frigout@eleves.ec-nantes.fr)
 * @author Mailys LE LOCH (mailys.le-loch@eleves.ec-nantes.fr)
 * @version 1.0
 */
public class Plateau {

    private Combinaison objectif;
    private ArrayList<Combinaison> listeTentative;
    private ArrayList<Combinaison> listeIndication;

    /**
     * Constructeur de la classe plateau. Lors de l'appel au constructeur, les deux listes (tentative et indication sont vides) et l'objectif par défaut est une combinaison vide.
     */
    public Plateau(){
        this.objectif = new Combinaison();
        this.listeIndication = new ArrayList<>();
        this.listeTentative = new ArrayList<>();
    }

    /**
     * Getter permettant d'obtenir la combinaison objectif.
     * @return La combinaison objectif de la partie.
     */
    public Combinaison getObjectif() {
        return objectif;
    }

    /**
     * Setter permettant de mettre à jour la combinaison objectif de la partie.
     * @param objectif La nouvelle combinaison objectif de la partie.
     */
    public void setObjectif(Combinaison objectif) {
        this.objectif = new Combinaison(objectif);
    }

    /**
     * Getter permettant d'obtenir la liste des tentatives faites par le decodeur.
     * @return La liste des tentatives faites par le décodeur.
     */
    public ArrayList<Combinaison> getListeTentative() {
        return listeTentative;
    }

    /**
     * Getter permettant d'obtenir la liste des indications données par le codeur.
     * @return La liste des indications données par le codeur.
     */
    public ArrayList<Combinaison> getListeIndication() {
        return listeIndication;
    }

    /**
     * Méthode permettant de réinitialiser les listes du plateau à vide.
     */
    public void reset(){
        this.listeTentative = new ArrayList<>();
        this.listeIndication = new ArrayList<>();
    }

    /**
     * Cette méthode permet de retourner le contenu du plateau sous forme textuelle.
     * @return Le contenu du tableau sous forme textuelle.
     */
    public String affiche(){
        StringBuilder s = new StringBuilder();
        s.append("-----------------------------------\n");
        s.append("|    DECODEUR   | |     CODEUR    |\n");
        s.append("-----------------------------------\n");
        for(int i = 0; i < 12; i++){
            try {
                s.append(this.listeTentative.get(i).affiche());
            } catch (IndexOutOfBoundsException e){
                Combinaison combVide = new Combinaison();
                s.append(combVide.affiche());
            }
            s.append(" ");
            try {
                s.append(this.listeIndication.get(i).affiche());
            } catch (IndexOutOfBoundsException e){
                Combinaison combVide = new Combinaison();
                s.append(combVide.affiche());
            }
            s.append("\n");

        }
        s.append("-----------------------------------");
        return s.toString();
    }
}
