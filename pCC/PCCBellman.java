package pCC;

import graphes.CircuitEx;

import java.util.*;

public class PCCBellman {

    public static int PCC(IGraph g, String source, String cible){
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecesseurs = new HashMap<>();

        for (String tmpIterNext : g) {
            distances.put(tmpIterNext, Integer.MAX_VALUE);
            predecesseurs.put(tmpIterNext, null);
        }

        distances.put(source, 0);
        for (String label1 : distances.keySet())
            for (String label2 : distances.keySet())
                if (label1 != source || label2 != source || label2 != label1)
                    if (distances.get(label2) > distances.get(label1) + g.getValeur(label1, label2)){
                        distances.put(label2, distances.get(label1) + g.getValeur(label1, label2));
                        predecesseurs.put(label2, label1);
                    }

        if (!rechercheCircuit(predecesseurs, source) || predecesseurs.size() != g.getNbSommets())
            throw new CircuitEx();

        return distances.get(cible);
    }

    private static boolean rechercheCircuit(Map<Integer, Integer> predecesseurs, int source){
        Map<Integer, Integer> rangs = new HashMap<>();
        rangs.put(source, 0);
        List<Integer> sommetsOut = new ArrayList<>();
        sommetsOut.add(source);
        for (int i = 1 ; i < predecesseurs.size() ; i++) {
            for (int key : predecesseurs.keySet())
                if (sommetsOut.contains(predecesseurs.get(key)))
                    rangs.put(key, i);

            if (rangs.keySet() == predecesseurs.keySet())
                return true;
        }
        return false;
    }
}