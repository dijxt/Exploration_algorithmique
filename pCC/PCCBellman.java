package pCC;

import graphes.CircuitEx;

import java.util.*;

public class PCCBellman {
/*
    public static int[] PCC(IGraphe g, int source, int cible){
        int[] distances = new int[g.getNbSommets()];
        int[] rangs = triTopologique(g);

        for (int i = 0 ; i < g.getNbSommets() ; i++) {
            if (rangs[i] == 0)
                distances[i] = 0;
            else
                distances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0 ; i < g.getNbSommets() ; i++)
            for (int j )
                if (i != source || j != source || i != j)
                    if (distances[j] > distances[i] + g.getValuation(i, j)){
                        distances[j] = distances[i] + g.getValuation(i, j);
                        predecesseurs[j] = i;
                    }

        if (!estOkGraphe(predecesseurs, source) || predecesseurs.length != g.getNbSommets())
            throw new CircuitEx();

        List<Integer> pcc = new ArrayList<>();
        pcc.add(cible);
        while(pcc.get(pcc.size() - 1) != source)
            pcc.add(predecesseurs[pcc.get(pcc.size() - 1)]);

        while(pcc.get(0) != source)
            pcc.add(pcc.remove(0));

        return pcc.stream().mapToInt(Integer::intValue).toArray();
    }


    private static int[] triTopologique(IGraphe g){
        Map<Integer, List<Integer>> predecesseurs = new HashMap<>();
        for (int i = 0 ; i < g.getNbSommets() ; i++) {
            predecesseurs.put(i, new ArrayList<Integer>());
            for (int j : g.getSuccesseurs(i))
                predecesseurs.get(i).add(j);
        }

        int[] rangs = new int[g.getNbSommets()];
        List<Integer> sommetsOut = new ArrayList<>();
        for (int i = 0 ; i < g.getNbSommets() ; i++)
            for (int key : predecesseurs.keySet()) {
                if (predecesseurs.get(key).isEmpty() && g.getSuccesseurs(key).length > 0) {
                    rangs[key] = 0;
                    sommetsOut.add(key);
                }
                else if (sommetsOut.contains(predecesseurs.get(key)))
                    rangs[key] = i;
            }
        return rangs;*/
    }