package tests.graphes;

import graphes.types.GrapheLA;
import graphes.types.GrapheMA;

import org.junit.Test;
import static org.junit.Assert.*;

import pCC.IGraphe;

public class GrapheTest {
    // Graphe de l'exercice 3.1 du poly de maths
    @Test
    public void test() {
        IGraphe g = new GrapheMA(9);
        tester(g);
        g = new GrapheLA(9);
        tester(g);
    }

    void tester(IGraphe g) {
        assertEquals(9, g.getNbSommets());

        g.ajouterArc(1,3,2);
        g.ajouterArc(1,4,1);
        g.ajouterArc(2,7,3);
        g.ajouterArc(3,8,2);
        g.ajouterArc(4,2,3);
        g.ajouterArc(4,3,5);
        g.ajouterArc(4,5,3);
        g.ajouterArc(5,3,1);
        g.ajouterArc(5,7,3);
        g.ajouterArc(5,8,7);
        g.ajouterArc(7,2,2);
        g.ajouterArc(7,6,1);
        g.ajouterArc(8,6,4);
        g.ajouterArc(8,7,2);
        g.ajouterArc(9,8,10);

        assertArrayEquals(g.getSuccesseurs(1), new int[]{3,4});
        assertArrayEquals(g.getSuccesseurs(2), new int[]{7});
        assertArrayEquals(g.getSuccesseurs(3), new int[]{8});
        assertArrayEquals(g.getSuccesseurs(4), new int[]{2,3,5});
        assertArrayEquals(g.getSuccesseurs(5), new int[]{3,7,8});
        assertArrayEquals(g.getSuccesseurs(6), new int[]{});
        assertArrayEquals(g.getSuccesseurs(7), new int[]{2,6});
        assertArrayEquals(g.getSuccesseurs(8), new int[]{6,7});
        assertArrayEquals(g.getSuccesseurs(9), new int[]{8});

        assertTrue(g.aArc(1,4));
        assertTrue(g.aArc(2,7));
        assertTrue(g.aArc(5,7));
        assertTrue(g.aArc(5,8));
        assertTrue(g.aArc(8,6));

        assertFalse(g.aArc(4,1));
        assertFalse(g.aArc(8,3));
        assertFalse(g.aArc(9,9));

        assertEquals(3,g.getValuation(4, 5));
        assertEquals(7,g.getValuation(5, 8));
        assertEquals(10,g.getValuation(9, 8));
        assertEquals(5,g.getValuation(4, 3));

    }
}