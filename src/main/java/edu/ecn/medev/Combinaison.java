package edu.ecn.medev;

import java.util.ArrayList;

/**
 * Cette classe représente une combinaison. Dans notre implémentation, une combinaison correspond à une liste de 4 pions.
 * La combinaison peut être un objectif (codeur), une tentative (decodeur) ou une indication (decodeur).
 * Pour les indications, il est possible que certain pion soit null, cela signifie pas d'indication.
 *
 * @author Antoine FRIOGUT (antoine.frigout@eleves.ec-nantes.fr)
 * @author Mailys LE LOCH (mailys.le-loch@eleves.ec-nantes.fr)
 * @version 1.0
 */
public class Combinaison {

    // Attributs
    private ArrayList<Pion> listePion;

    /**
     * Constructeur principal de la classe Combinaison. Par défaut l'ensemble des pions de la combinaison sont null.
     */
    public Combinaison(){
        this.listePion = new ArrayList<Pion>(4);
        this.listePion.add(null);
        this.listePion.add(null);
        this.listePion.add(null);
        this.listePion.add(null);
    }

    /**
     * Constructeur de recopie de la classe Combinaison.
     * @param combinaison La combinaison à copier.
     */
    public Combinaison(Combinaison combinaison){
        this.listePion = new ArrayList<Pion>(combinaison.listePion);
    }

    /**
     * Getter permettant d'obtenir la liste les pions de la combinaison.
     * @return La liste des pions qui composent la combinaison.
     */
    public ArrayList<Pion> getListePion() {
        return listePion;
    }

    /**
     * Setter permettant de modifier la liste des pions de la combinaison.
     * @param listePion La nouvelle liste des pions de la combinaison.
     */
    public void setListePion(ArrayList<Pion> listePion) {
        this.listePion = listePion;
    }
    
    /**
     * Méthode permettant de mettre un pion à la position i dans la combinaison
     * @param position int, position du pion
     * @param p Pion, pion à ajouter 
     */
    public void setPion(int position, Pion p){
        this.listePion.set(position, p);
    }
    


    /**
     * Méthode permettant de tester que deux combinaisons sont similaires.
     * On considère que deux combinaisons sont semblables dès lors que leurs listes de pions contiennent des pions de même couleur au même position.
     * @param o La combinaison à comparer.
     * @return True si les deux combinaisons sont semblables, False sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combinaison that = (Combinaison) o;

        return getListePion() != null ? getListePion().equals(that.getListePion()) : that.getListePion() == null;
    }

    /**
     * Méthode pour retourner une combinaison sous forme textuelle.
     * @return La description textuelle de la combinaison.
     */
    public String affiche(){
        StringBuilder s = new StringBuilder();
        s.append("|");
        for(Pion p : this.listePion){
            if(p == null){
                s.append(" . |");
            } else {
                switch (p.getCouleur()) {
                    case "rouge" -> s.append(" R |");
                    case "bleu" -> s.append(" B |");
                    case "vert" -> s.append(" V |");
                    case "jaune" -> s.append(" J |");
                    case "noir" -> s.append(" N |");
                    case "blanc" -> s.append(" W |");
                    default -> s.append(" . |");
                }
            }
        }
        return s.toString();
    }
}
