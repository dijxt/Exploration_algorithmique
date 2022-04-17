package tests.pCCTest;

import static org.junit.Assert.*;

import graphes.ArcNégatifEx;
import org.junit.Test;

import graphes.GrapheLA;
import graphes.GrapheMA;

import pCC.IGraph;
import pCC.PCCDijkstra;

public class PCCTest {
    @Test
    public void test() {
        String[] noeuds = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        IGraph g = new GrapheMA(noeuds);
        if (!PCCDijkstra.estOkGraphe(g)){
            throw new ArcNégatifEx();
        }
        tester(g);
        testerPCC(g);
        g = new GrapheLA(noeuds);
        if (!PCCDijkstra.estOkGraphe(g)){
            throw new ArcNégatifEx();
        }
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

        assertArrayEquals(new  PCCDijkstra(g, "A", "H").PCC(), new String[]{"A", "C", "H"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "G").PCC(), new String[]{"A", "C", "H", "G"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "F").PCC(), new String[]{"A", "C", "H", "G", "F"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "E").PCC(), new String[]{"A", "D", "E"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "D").PCC(), new String[]{"A", "D"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "C").PCC(), new String[]{"A", "C"});

        assertArrayEquals(new  PCCDijkstra(g, "A", "B").PCC(), new String[]{"A", "D", "B"});
    }
}