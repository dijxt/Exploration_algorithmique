package tests.PCC;

import graphes.GrapheLA;
import graphes.GrapheMA;
import graphes.IGraph;
import org.junit.jupiter.api.Test;
import pCC.PCCDijkstra;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PCCDijkstraTest {

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
        g.ajouterArc("A", "C", 2);
        g.ajouterArc("A", "D", 1);
        g.ajouterArc("B", "G", 3);
        g.ajouterArc("C", "H", 2);
        g.ajouterArc("D", "B", 3);
        g.ajouterArc("D", "C", 5);
        g.ajouterArc("D", "E", 3);
        g.ajouterArc("E", "C", 1);
        g.ajouterArc("E", "G", 3);
        g.ajouterArc("E", "H", 7);
        g.ajouterArc("G", "B", 2);
        g.ajouterArc("G", "F", 1);
        g.ajouterArc("H", "F", 4);
        g.ajouterArc("H", "G", 2);
        g.ajouterArc("I", "H", 10);

        /*assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "H"), new int[]{1, 3, 8});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "G"), new int[]{1, 3, 8, 7});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "F"), new int[]{1, 3, 8, 7, 6});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "E"), new int[]{1, 4, 5});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "D"), new int[]{1, 4});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "C"), new int[]{1, 3});
        assertEquals(PCCDijkstra.PCCDijkstra(g, "A", "B"), new int[]{1, 4, 2});*/
    }
}