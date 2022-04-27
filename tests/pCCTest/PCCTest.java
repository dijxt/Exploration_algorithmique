package tests.pCCTest;

import static org.junit.Assert.*;

import graphes.ArcNégatifEx;
import org.junit.Test;

import graphes.GrapheLA;
import graphes.GrapheMA;

import pCC.IGraph;
import pCC.PCCDijkstra;

public class PCCTest {

    //@Test
    public void test() {
        String[] noeuds3_1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] noeuds3_2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] noeuds3_6 = {"A", "B", "C", "D", "E", "F", "G"};

        IGraph g = new GrapheMA(noeuds3_1);  // test de l'exercice 3.1
        tester3_1(g);
        g = new GrapheLA(noeuds3_1);
        tester3_1(g);

        g = new GrapheMA(noeuds3_2);  // test de l'exercice 3.2
        tester3_2(g);
        g = new GrapheLA(noeuds3_2);
        tester3_2(g);

        g = new GrapheMA(noeuds3_6);  // test de l'exercice 3.6
        tester3_6(g);
        g = new GrapheLA(noeuds3_6);
        tester3_6(g);
    }

    void tester3_1(IGraph g) {
        assertEquals(9, g.getNbNoeuds());

        g.ajouterArc("A", "C", 2);  // ajout des arcs
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

        // test de l'algo de dijkstra
        assertArrayEquals(new  PCCDijkstra(g, "A", "H").PCC(), new String[]{"A", "C", "H"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "G").PCC(), new String[]{"A", "C", "H", "G"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "F").PCC(), new String[]{"A", "C", "H", "G", "F"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "E").PCC(), new String[]{"A", "D", "E"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "D").PCC(), new String[]{"A", "D"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "C").PCC(), new String[]{"A", "C"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "B").PCC(), new String[]{"A", "D", "B"});

        // test de l'algo de bellman
        /*assertArrayEquals(new PCCBellman(g, "A", "H").PCC(), new String[]{"A", "C", "H"});
        assertArrayEquals(new  PCCBellman(g, "A", "G").PCC(), new String[]{"A", "C", "H", "G"});
        assertArrayEquals(new  PCCBellman(g, "A", "F").PCC(), new String[]{"A", "C", "H", "G", "F"});
        assertArrayEquals(new  PCCBellman(g, "A", "E").PCC(), new String[]{"A", "D", "E"});
        assertArrayEquals(new  PCCBellman(g, "A", "D").PCC(), new String[]{"A", "D"});
        assertArrayEquals(new  PCCBellman(g, "A", "C").PCC(), new String[]{"A", "C"});
        assertArrayEquals(new  PCCBellman(g, "A", "B").PCC(), new String[]{"A", "D", "B"});*/
    }

    void tester3_2(IGraph g){
        assertEquals(10, g.getNbNoeuds());

        g.ajouterArc("A","B",8);
        g.ajouterArc("A","D",3);
        g.ajouterArc("B","C",4);
        g.ajouterArc("B","E",5);
        g.ajouterArc("C","F",1);
        g.ajouterArc("C","I",5);
        g.ajouterArc("D","E",2);
        g.ajouterArc("D","J",1);
        g.ajouterArc("E","G",3);
        g.ajouterArc("E","I",2);
        g.ajouterArc("F","H",5);
        g.ajouterArc("G","H",4);
        g.ajouterArc("I","H",2);
        g.ajouterArc("J","F",6);
        g.ajouterArc("J","G",6);


        assertArrayEquals(new  PCCDijkstra(g, "A", "H").PCC(), new String[]{"A", "D", "E", "I", "H"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "G").PCC(), new String[]{"A", "D", "E", "G"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "F").PCC(), new String[]{"A", "D", "J", "F"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "E").PCC(), new String[]{"A", "D", "E"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "D").PCC(), new String[]{"A", "D"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "C").PCC(), new String[]{"A", "B", "C"});
        assertArrayEquals(new  PCCDijkstra(g, "A", "B").PCC(), new String[]{"A", "B"});

        /*assertArrayEquals(new  PCCBellman(g, "A", "H").PCC(), new String[]{"A", "D", "E", "I", "H"});
        assertArrayEquals(new  PCCBellman(g, "A", "G").PCC(), new String[]{"A", "D", "E", "G"});
        assertArrayEquals(new  PCCBellman(g, "A", "F").PCC(), new String[]{"A", "D", "J", "F"});
        assertArrayEquals(new  PCCBellman(g, "A", "E").PCC(), new String[]{"A", "D", "E"});
        assertArrayEquals(new  PCCBellman(g, "A", "D").PCC(), new String[]{"A", "D"});
        assertArrayEquals(new  PCCBellman(g, "A", "C").PCC(), new String[]{"A", "B", "C"});
        assertArrayEquals(new  PCCBellman(g, "A", "B").PCC(), new String[]{"A", "B"});*/
    }

    void tester3_6(IGraph g){
        assertEquals(7, g.getNbNoeuds());

        g.ajouterArc("A","B",7);
        g.ajouterArc("A","C",1);
        g.ajouterArc("B","D",4);
        g.ajouterArc("B","E",2);
        g.ajouterArc("B","F",-3);
        g.ajouterArc("C","B",5);
        g.ajouterArc("C","E",2);
        g.ajouterArc("C","F",7);
        g.ajouterArc("D","G",4);
        g.ajouterArc("E","G",10);
        g.ajouterArc("F","D",5);
        g.ajouterArc("F","E",3);

        // nous nous assurons qu'une exception est levée
        /*
        boolean b = false;
        try {
            new PCCDijkstra(g, "A", "B").PCC();
        }catch (ArcNégatifEx e){
            assertTrue(true);
            b = true;
        }finally {
            assertTrue(b);
        }*/

    }

}