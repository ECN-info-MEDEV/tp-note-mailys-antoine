package edu.ecn.medev;

import static org.junit.jupiter.api.Assertions.*;

class ExempleTest {

    @org.junit.jupiter.api.Test
    void getExemple() {
        Exemple exemple = new Exemple();
        assertEquals(exemple.getExemple(), 0);
    }

    @org.junit.jupiter.api.Test
    void setExemple() {
        Exemple exemple = new Exemple();
        exemple.setExemple(2);
        assertEquals(exemple.getExemple(), 2);
    }
}