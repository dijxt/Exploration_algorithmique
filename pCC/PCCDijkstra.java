package pCC;

import graphes.ArcNégatifEx;

import java.util.*;

public class PCCDijkstra {
    private static final int INFINI = Integer.MAX_VALUE;

    /**
     * Retourne le plus court chemin entre deux sommets d'un graphe
     * @param g un graphe
     * @param source un sommet source
     * @param cible un sommet cible
     */
    public static int[] PCC(IGraphe g, int source, int cible) {
        if (!estOkGraphe(g)) {
            throw new ArcNégatifEx();
        }

        if (source == cible) {
            return new int[]{source};
        }
        ArrayList<Integer> chemin = new ArrayList<>();
        chemin.add(cible);
        ArrayList<Integer> noeudsVisites = new ArrayList<>();
        int[] distanceSommets = new int[g.getNbSommets()];
        int[] dernierPredecesseur = new int[g.getNbSommets()];

        for (int i = 1; i <= g.getNbSommets(); ++i) {
            if (Arrays.asList(g.getSuccesseurs(source)).contains(i)) {
                distanceSommets[i - 1] = g.getValuation(source, i);
                dernierPredecesseur[i - 1] = source;
            } else {
                distanceSommets[i - 1] = INFINI;
                dernierPredecesseur[i - 1] = (Integer) null;
            }
        }
        while (!noeudsVisites.contains(cible)) {
            int dernierNoeud = noeudsVisites.get(noeudsVisites.size() - 1);
            for (int s : g.getSuccesseurs(dernierNoeud)) {
                if (g.getValuation(dernierNoeud, s) + distanceSommets[dernierNoeud] < distanceSommets[s - 1]) {
                    distanceSommets[s - 1] = g.getValuation(dernierNoeud, s) + distanceSommets[dernierNoeud - 1];
                    dernierPredecesseur[s - 1] = dernierNoeud;
                }
            }
            int prochainNoeud = (Integer) null;
            int valeurArcProchainNoeud = INFINI;
            for (int i = 0; i < distanceSommets.length; ++i) {
                if (distanceSommets[i] < valeurArcProchainNoeud && !noeudsVisites.contains(i + 1)) {
                    valeurArcProchainNoeud = distanceSommets[i];
                    prochainNoeud = i + 1;
                }
            }
            noeudsVisites.add(prochainNoeud);
        }
        int noeudChemin = cible;
        while (!(noeudChemin == source)) {
            chemin.add(dernierPredecesseur[noeudChemin - 1]);
            noeudChemin = dernierPredecesseur[noeudChemin - 1];
        }
        Collections.reverse(chemin);
        System.out.println(chemin);
        System.out.println(distanceSommets[cible - 1]);
        return chemin.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Indique si un graphe peut être soumis à l'algorithme de dijkstra
     * @param g le graphe
     * @return true si le graphe est correct, false sinon
     */
    private static boolean estOkGraphe(IGraphe g) {
        for (int s = 1; s <= g.getNbSommets(); ++s) {
            for (int sc : g.getSuccesseurs(s)) {
                if (g.getValuation(s, sc) < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}