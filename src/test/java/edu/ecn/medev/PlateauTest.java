package edu.ecn.medev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe permet de tester la classe Plateau.
 */
class PlateauTest {

    @Test
    void testConstructeur(){
        Plateau plateau = new Plateau();

        assertEquals(0, plateau.getListeTentative().size());
        assertEquals(0, plateau.getListeTentative().size());

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

        plateau.setObjectif(c1);
        assertEquals("| R | B | J | V |", plateau.getObjectif().affiche());

        plateau.getListeIndication().add(c1);

        Combinaison c2 = new Combinaison();
        Pion p11 = new Pion("noir");
        Pion p31 = new Pion("blanc");
        Pion p41 = new Pion("blanc");
        ArrayList<Pion> listePion1 = new ArrayList<>();
        listePion.add(p11);
        listePion.add(p31);
        listePion.add(null);
        listePion.add(p41);
        c2.setListePion(listePion);
        plateau.getListeTentative().add(c2);
    }

    @Test
    void testAffiche(){
        Plateau plateau = new Plateau();

        String plateauVide = "-----------------------------------\n" +
                "|    DECODEUR   | |     CODEUR    |\n" +
                "-----------------------------------\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "-----------------------------------";
        assertEquals(plateauVide, plateau.affiche());

        // Ajout d'une combinaison dans l'affichage
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
        plateau.getListeTentative().add(c1);

        String plateau1 = "-----------------------------------\n" +
                "|    DECODEUR   | |     CODEUR    |\n" +
                "-----------------------------------\n" +
                "| R | B | J | V | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "-----------------------------------";
        assertEquals(plateau1, plateau.affiche());

        Combinaison c2 = new Combinaison();
        Pion p11 = new Pion("noir");
        Pion p31 = new Pion("blanc");
        Pion p41 = new Pion("blanc");
        ArrayList<Pion> listePion1 = new ArrayList<>();
        listePion1.add(p11);
        listePion1.add(p31);
        listePion1.add(null);
        listePion1.add(p41);
        c2.setListePion(listePion1);
        plateau.getListeIndication().add(c2);

        String plateau2 = "-----------------------------------\n" +
                "|    DECODEUR   | |     CODEUR    |\n" +
                "-----------------------------------\n" +
                "| R | B | J | V | | N | W | . | W |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "| . | . | . | . | | . | . | . | . |\n" +
                "-----------------------------------";
        assertEquals(plateau2, plateau.affiche());
    }
}