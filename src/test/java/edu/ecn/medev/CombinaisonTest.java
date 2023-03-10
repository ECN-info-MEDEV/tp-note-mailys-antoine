package edu.ecn.medev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.ecn.medev.Pion;

import java.util.ArrayList;

class CombinaisonTest {

    @Test
    void testConstructeur(){
        Combinaison c1 = new Combinaison();
        Pion p1 = new Pion("rouge");
        Pion p2 = new Pion("bleu");
        Pion p3 = new Pion("jaune");
        Pion p4 = new Pion("vert");
        ArrayList<Pion> listePion = new ArrayList<>();
        listePion.add(p1);
        listePion.add(p2);
        listePion.add(p3);
        listePion.add(p4);
        c1.setListePion(listePion);
        Combinaison c2 = new Combinaison(c1);
    }

    @Test
    void getListePion() {
        Combinaison comb = new Combinaison();
        assertEquals(4, comb.getListePion().size());
        assertNull(comb.getListePion().get(0));
        assertNull(comb.getListePion().get(1));
        assertNull(comb.getListePion().get(2));
        assertNull(comb.getListePion().get(3));

        Pion p1 = new Pion("rouge");
        Pion p2 = new Pion("bleu");
        Pion p3 = new Pion("jaune");
        Pion p4 = new Pion("vert");
        ArrayList<Pion> listePion = new ArrayList<>();
        listePion.add(p1);
        listePion.add(p2);
        listePion.add(p3);
        listePion.add(p4);
        comb.setListePion(listePion);
        Combinaison comb2 = new Combinaison(comb);

        assertEquals(4, comb2.getListePion().size());
        assertEquals("rouge", comb2.getListePion().get(0).getCouleur());
        assertEquals("bleu", comb2.getListePion().get(1).getCouleur());
        assertEquals("jaune", comb2.getListePion().get(2).getCouleur());
        assertEquals("vert", comb2.getListePion().get(3).getCouleur());
    }

    @Test
    void testAffiche(){
        // Affichage d'une combinaison vide
        Combinaison comb = new Combinaison();
        String descr = comb.affiche();
        assertEquals("| . | . | . | . |", descr);

        // Utilisation des couleurs
        Pion p1 = new Pion("rouge");
        Pion p2 = new Pion("bleu");
        Pion p3 = new Pion("jaune");
        Pion p4 = new Pion("vert");
        ArrayList<Pion> listePion = new ArrayList<>();
        listePion.add(p1);
        listePion.add(p2);
        listePion.add(p3);
        listePion.add(p4);
        comb.setListePion(listePion);
        Combinaison comb2 = new Combinaison(comb);
        descr = comb2.affiche();
        assertEquals("| R | B | J | V |", descr);

        p1 = new Pion("blanc");
        p2 = new Pion("noir");
        listePion = new ArrayList<>();
        listePion.add(p1);
        listePion.add(null);
        listePion.add(p2);
        listePion.add(null);
        comb.setListePion(listePion);
        Combinaison comb3 = new Combinaison(comb);
        descr = comb3.affiche();
        assertEquals("| W | . | N | . |", descr);
    }
}