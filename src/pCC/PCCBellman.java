package pCC;

import graphes.IGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PCCBellman {

    /*private static boolean triTopologiqueEffectuable (IGraph g){
        ArrayList<String> labels = new ArrayList<>();
        for (String label : g.getLabels()){
            if (g.dIn(label) == 0){
            }
        }
    }*/

    private static void triTopologique(IGraph g){
        int n = g.getNbNoeuds();
        int[] rang = new int[n];
        int[] degre = new int[n];
        String[] labels = g.getLabels();
        LinkedList<String> L = new LinkedList<String>();
        ArrayList<String> X = new ArrayList<String>();

        Arrays.fill(rang, 0);
        for (int i = 0 ; i < L.size() ; ++i)
            degre[i] = g.dIn(L.get(i));

        while (X.size() < labels.length){
            for (String label : labels){
                if (degre[Arrays.binarySearch(labels, label)] == 0)
                    L.add(label);
            }

            for (String label : L){
                for (String successeur : g.getSuccesseurs(label)) {
                    if (rang[L.indexOf(successeur)] < rang[L.indexOf(label)]+1)
                        rang[L.indexOf(successeur)] = rang[L.indexOf(label)]+1;

                    degre[L.indexOf(successeur)] = degre[L.indexOf(label)]+1;
                }
            }
            X.addAll(L);
            L.clear();
        }
    }

    public static int[] PCCBellman(IGraph g, int source, int cible){

        // TODO code + return
        return new int[0];
    }
}