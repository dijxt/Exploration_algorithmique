package pCC;

import graphes.CircuitEx;

import java.util.*;

public class PCCBellman {

    public static int[] PCC(IGraphe g, int source, int cible) {
        int[] distances = new int[g.getNbSommets()];
        int[] predecesseurs = new int[g.getNbSommets()];
        List<Integer> sommetsParRang = triTopologique(g);

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecesseurs, (Integer) null);

        distances[sommetsParRang.get(0)] = 0;

        for (Iterator<Integer> it = sommetsParRang.iterator(); it.hasNext(); ) {
            int i = it.next();
            for (int j : g.getSuccesseurs(i))
                if (distances[j] > distances[i] + g.getValuation(i, j)) {
                    distances[j] = distances[i] + g.getValuation(i, j);
                    predecesseurs[j] = i;
                }
        }

        List<Integer> pcc = new ArrayList<>();
        pcc.add(cible);
        while (pcc.get(pcc.size() - 1) != source)
            pcc.add(predecesseurs[pcc.get(pcc.size() - 1)]);

        while (pcc.get(0) != source)
            pcc.add(pcc.remove(0));

        return pcc.stream().mapToInt(Integer::intValue).toArray();
    }


    private static List<Integer> triTopologique(IGraphe g) {
        Map<Integer, List<Integer>> predecesseurs = new HashMap<>();
        for (int i = 0; i < g.getNbSommets(); i++) {
            predecesseurs.put(i, new ArrayList<Integer>());
            for (int j : g.getSuccesseurs(i))
                predecesseurs.get(i).add(j);
        }

        List<Integer> sommetsParRangs = new ArrayList<>();
        List<Integer> sommetsOut = new ArrayList<>();
        for (int i = 0; i < g.getNbSommets(); i++)
            for (int key : predecesseurs.keySet()) {
                if (predecesseurs.get(key).isEmpty() && sommetsParRangs.isEmpty()) {
                    sommetsParRangs.add(key);
                    sommetsOut.add(key);
                    break;
                } else if (sommetsOut.contains(predecesseurs.get(key)))
                    sommetsParRangs.add(key);
            }
        return sommetsParRangs;
    }
}