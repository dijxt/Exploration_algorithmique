package pCCTest;

import static org.junit.Assert.* ;

import graphe.GrapheMA;
import org.junit.Test ;

public class PCCBellmanTest {
    private static final int NB_NOEUDS_3_1_1 = 9;
    @Test
    public void test1(){
        GrapheMA g = new GrapheMA(NB_NOEUDS_3_1_1);
        g.ajouterArc(1,3, 2);
        g.ajouterArc(1,4, 1);
        g.ajouterArc(4,3, 5);
        g.ajouterArc(4,5, 3);
        g.ajouterArc(5,3, 1);
        g.ajouterArc(4,2, 3);
        g.ajouterArc(5,7, 3);
        g.ajouterArc(5,8, 7);
        g.ajouterArc(3,8, 2);
        g.ajouterArc(8,7, 2);
        g.ajouterArc(2,7, 3);
        g.ajouterArc(7,2, 2);
        g.ajouterArc(7,6, 1);
        g.ajouterArc(8,6, 4);
        g.ajouterArc(10,8, 10);

    }

    private static final int NB_NOEUDS_3_2 = 10;
    @Test
    public void test2(){
        GrapheMA g = new GrapheMA(NB_NOEUDS_3_2);
    }

    private static final int NB_NOEUDS_3_6 = 7;
    @Test
    public void test3(){
        GrapheMA g = new GrapheMA(NB_NOEUDS_3_6);
    }
}