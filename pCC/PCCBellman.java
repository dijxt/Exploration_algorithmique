package pCC;

import graphes.CircuitEx;
import graphes.NoPathEx;

import java.util.*;

public class PCCBellman {

    public static PCC PCC(IGraphe g, int source, int cible) {
        int[] distances = new int[g.getNbSommets()];
        int[] predecesseurs = new int[g.getNbSommets()];
        List<ArrayList<Integer>> sommetsParRang = triTopologique(g);

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecesseurs, -1);

        for (int sommet : sommetsParRang.get(0))
            distances[sommet] = 0;

        for (List<Integer> listDeSommets : sommetsParRang)
            for (int sommet : listDeSommets)
                for (int successeur : g.getSuccesseurs(sommet + 1)) {
                    successeur--;
                    if (distances[successeur] > distances[sommet] + g.getValuation(sommet + 1, successeur + 1)) {
                        distances[successeur] = distances[sommet] + g.getValuation(sommet + 1, successeur + 1);
                        predecesseurs[successeur] = sommet;
                    }
                }

        List<Integer> pcc = new ArrayList<>();
        pcc.add(cible);
        for (int i = 0 ; pcc.get(pcc.size() - 1) != source && i < g.getNbSommets() ; i++)
            pcc.add(predecesseurs[pcc.get(pcc.size() - 1) - 1]+1);

        Collections.reverse(pcc);
        return new PCC("Bellman", distances[cible - 1] - distances[source - 1], pcc.stream().mapToInt(Integer::intValue).toArray());
    }


    private static List<ArrayList<Integer>> triTopologique(IGraphe g) {
        Map<Integer, List<Integer>> predecesseurs = new HashMap<>();
        for (int i = 0; i < g.getNbSommets(); i++)
            predecesseurs.put(i, new ArrayList<>());

        for (int i = 0; i < g.getNbSommets(); i++)
            for (int j : g.getSuccesseurs(i + 1))
                predecesseurs.get(j - 1).add(i);

        List<ArrayList<Integer>> rangs = new ArrayList<ArrayList<Integer>>();
        List<Integer> sommetsOut = new ArrayList<>();
        List<Integer> sommetsAEnlever = new ArrayList<>();
        for (int i = 0; i < g.getNbSommets(); i++){
            if (sommetsOut.size() == g.getNbSommets())
                return rangs;
            rangs.add(new ArrayList<>());
            for (int key : predecesseurs.keySet()) {
                if ((predecesseurs.get(key).isEmpty() || sommetsOut.containsAll(predecesseurs.get(key))) && !sommetsOut.contains(key)){
                    rangs.get(i).add(key);
                    sommetsAEnlever.add(key);
                }
            }
            for(int sommet : sommetsAEnlever)
                sommetsOut.add(sommet);
            sommetsAEnlever.clear();
        }
        return rangs;
    }


}