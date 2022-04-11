package tests.graphes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphes.GrapheLA;
import graphes.GrapheMA;
import graphes.IGraph;

import java.util.Arrays;

class GrapheTest {

    // Graphe de l'exercice 3.1 du poly de maths
    @Test
    void test() {
        String[] noeuds = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        IGraph g = new GrapheMA(noeuds);
        tester(g);
        g = new GrapheLA(noeuds);
        tester(g);
    }

    void tester(IGraph g) {
        assertEquals(9, g.getNbNoeuds());
        g.ajouterArc("A","C",2);
        g.ajouterArc("A","D",1);
        g.ajouterArc("B","G",3);
        g.ajouterArc("C","H",2);
        g.ajouterArc("D","B",3);
        g.ajouterArc("D","C",5);
        g.ajouterArc("D","E",3);
        g.ajouterArc("E","C",1);
        g.ajouterArc("E","G",3);
        g.ajouterArc("E","H",7);
        g.ajouterArc("G","B",2);
        g.ajouterArc("G","F",1);
        g.ajouterArc("H","F",4);
        g.ajouterArc("H","G",2);
        g.ajouterArc("I","H",10);

        assertTrue(g.aArc("A","D"));
        assertTrue(g.aArc("B","G"));
        assertTrue(g.aArc("E","G"));
        assertTrue(g.aArc("E","H"));
        assertTrue(g.aArc("H","F"));

        assertFalse(g.aArc("D","A"));
        assertFalse(g.aArc("H","C"));
        assertFalse(g.aArc("I","I"));

        assertEquals(2,g.dOut("A"));
        assertEquals(1,g.dOut("B"));
        assertEquals(1,g.dOut("C"));
        assertEquals(3,g.dOut("D"));
        assertEquals(0,g.dOut("F"));
        assertEquals(1,g.dOut("I"));

        assertEquals(0,g.dIn("A"));
        assertEquals(2,g.dIn("B"));
        assertEquals(2,g.dIn("F"));
        assertEquals(0,g.dIn("I"));

        assertEquals(3,g.getValeur("D", "E"));
        assertEquals(7,g.getValeur("E", "H"));
        assertEquals(10,g.getValeur("I", "H"));
        assertEquals(5,g.getValeur("D", "C"));

        //assertEquals(new String[]{"C", "D"}, g.getSuccesseurs("A"));
        //assertEquals(new String[]{"B", "C", "E"}, g.getSuccesseurs("D"));
        System.out.println(Arrays.toString(g.getSuccesseurs("A")));
        System.out.println(Arrays.toString(g.getSuccesseurs("D")));
        //assertEquals(new String[]{"A"}, g.getPredecesseurs("D"));
        //assertEquals(new String[]{"D"}, g.getPredecesseurs("E"));
        System.out.println(Arrays.toString(g.getPredecesseurs("D")));
        System.out.println(Arrays.toString(g.getPredecesseurs("E")));

        //System.out.println(g);
    }


}
