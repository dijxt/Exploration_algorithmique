package tests.pCCTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import graphes.GrapheLA;
import graphes.GrapheMA;

import pCC.IGraph;
import pCC.PCCDijkstra;

public class PCCTest {
    @Test
    void test() {
        String[] noeuds = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        IGraph g = new GrapheMA(noeuds);
        tester(g);
        testerPCC(g);
        g = new GrapheLA(noeuds);
        tester(g);
        testerPCC(g);
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
    }

    void testerPCC(IGraph g){

        PCCDijkstra p1 = new  PCCDijkstra(g, "A", "H");
        Assertions.assertEquals(p1.PCC(), new String[]{"A", "C", "H"});

        PCCDijkstra p2 = new  PCCDijkstra(g, "A", "G");
        Assertions.assertEquals(p2.PCC(), new String[]{"A", "C", "H", "G"});

        PCCDijkstra p3 = new  PCCDijkstra(g, "A", "F");
        Assertions.assertEquals(p3.PCC(), new String[]{"A", "C", "H", "G", "F"});

        PCCDijkstra p4 = new  PCCDijkstra(g, "A", "E");
        Assertions.assertEquals(p4.PCC(), new String[]{"A", "D", "E"});

        PCCDijkstra p5 = new  PCCDijkstra(g, "A", "D");
        Assertions.assertEquals(p5.PCC(), new String[]{"A", "D"});

        PCCDijkstra p6 = new  PCCDijkstra(g, "A", "C");
        Assertions.assertEquals(p6.PCC(), new String[]{"A", "C"});

        PCCDijkstra p7 = new  PCCDijkstra(g, "A", "B");
        Assertions.assertEquals(p7.PCC(), new String[]{"A", "D", "B"});
    }
}