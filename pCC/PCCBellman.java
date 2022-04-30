package pCC;

import graphes.CircuitEx;

import java.util.*;

public class PCCBellman {

    public static int[] PCC(IGraphe g, int source, int cible) {
        int[] distances = new int[g.getNbSommets()];
        int[] predecesseurs = new int[g.getNbSommets()];
        List<Integer> sommetsParRang = triTopologique(g);

        //System.out.println(sommetsParRang);

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecesseurs, 0);

        distances[sommetsParRang.get(0)] = 0;

        for (Iterator<Integer> it = sommetsParRang.iterator(); it.hasNext(); ) {
            int i = it.next();
            for (int j : g.getSuccesseurs(i+1)) {
                j = j-1;
                if (distances[j] > distances[i] + g.getValuation(i, j)) {
                    distances[j] = distances[i] + g.getValuation(i, j);
                    predecesseurs[j] = i;
                }
            }
        }

        List<Integer> pcc = new ArrayList<>();
        pcc.add(cible);
        for (int i = 0 ; (pcc.get(pcc.size() - 1) != source || pcc.get(pcc.size() - 1) != 0) && i < g.getNbSommets() ; i++) {
            pcc.add(predecesseurs[pcc.get(pcc.size() - 1)]);
        }

        Collections.reverse(pcc);
        for (int i : predecesseurs)
            System.out.print(Integer.toString(i) + " ");
        System.out.println();
        for (int i : distances)
            System.out.print(Integer.toString(i) + " ");
        System.out.println();
        System.out.println(pcc);
        return pcc.stream().mapToInt(Integer::intValue).toArray();
    }


    private static List<Integer> triTopologique(IGraphe g) {
        Map<Integer, List<Integer>> predecesseurs = new HashMap<>();
        for (int i = 0; i < g.getNbSommets(); i++) {
            predecesseurs.put(i, new ArrayList<Integer>());
            for (int j : g.getSuccesseurs(i + 1))
                predecesseurs.get(i).add(j);
        }
        for (int i : predecesseurs.keySet())
            System.out.println(Integer.toString(i) + " : " + predecesseurs.get(i));

        List<Integer> sommetsParRangs = new ArrayList<>();
        List<Integer> sommetsOut = new ArrayList<>();
        sommetsOut.add(2);
        sommetsOut.add(8);
        List<Integer> sommetsAEnlever = new ArrayList<>();
        for (int i = 0; i < g.getNbSommets(); i++){
            for (int key : predecesseurs.keySet()) {
                if (sommetsOut.containsAll(predecesseurs.get(key)) && !sommetsOut.contains(key+1)){
                    sommetsParRangs.add(key);
                    sommetsAEnlever.add(key+1);
                }
            }
            for(int sommet : sommetsAEnlever)
                sommetsOut.add(sommet);
            sommetsAEnlever.clear();
            System.out.println(sommetsOut);
        }
        return sommetsParRangs;
    }
}