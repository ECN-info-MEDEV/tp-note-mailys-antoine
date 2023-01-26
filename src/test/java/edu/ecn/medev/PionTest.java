
package edu.ecn.medev;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe est une classe de test et génère les tests unitaires pour la classe pion
 * @author maily
 */
public class PionTest {
    
    /**
     * Méthode test permettant de tester si la méthode getCouleur renvoie bien la couleur du pion
     */
    @org.junit.jupiter.api.Test
    void getCouleur() {
        Pion pion = new Pion("jaune");
        assertEquals("jaune", pion.getCouleur());
    }

    /**
     * Méthode test permettant de tester si la méthode setCouleur implémente bien la couleur que l'on souhaite dans pion
     */
    @org.junit.jupiter.api.Test
    void setExemple() {
        Pion pion = new Pion("bleu");
        pion.setCouleur("bleu");
        assertEquals("bleu",pion.getCouleur());
    }
    
}
