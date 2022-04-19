package pCC;

import java.util.ArrayList;
import java.util.Arrays;

public class PCCDijkstra {

    private final IGraph g;
    private final String source;
    private final String cible;
    private ArrayList<String> noeudsVisites;
    private int[] distanceSommets;
    private String[] dernierPredecesseur;


    /**
     * Indique si un graphe peut être soumis à l'algorithme de dijkstra
     * @param g le graphe
     * @return true si le graphe est correct, false sinon
     */
    public static boolean estOkGraphe(IGraph g){
        for (String s: g.getLabels()){
            for (String sc: g.getSuccesseurs(s)){
                if (g.getValeur(s, sc) < 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Constructeur de la classe PCCDijkstra.
     * @param g un graphe
     * @param source un sommet source
     * @param cible un sommet cible
     */
    public PCCDijkstra(IGraph g, String source, String cible){
        assert estOkGraphe(g);
        this.g = g;
        this.source = source;
        this.cible = cible;
        this.noeudsVisites = new ArrayList<>();
        this.distanceSommets = new int[g.getNbNoeuds()];
        this.dernierPredecesseur = new String[g.getNbNoeuds()];

        noeudsVisites.add(source);
        distanceSommets[0] = 0;
        dernierPredecesseur[0] = null;

        for(int i = 1; i < g.getNbNoeuds(); ++i) {
            if (Arrays.asList(g.getSuccesseurs(source)).contains(g.getLabels()[i])) {
                distanceSommets[i] = g.getValeur(source, g.getLabels()[i]);
                dernierPredecesseur[i] = source;
            } else {
                distanceSommets[i] = Integer.MAX_VALUE;
                dernierPredecesseur[i] = null;
            }
        }
    }

    /**
     * Renvoie le plus court chemin entre deux sommets d'un graphe
     * @return le plus court chemin
     */
    public String[] PCC(){
        ArrayList<String> chemin = new ArrayList<>();
        chemin.add(source);
        while (!noeudsVisites.contains(cible)){
            for (String s: g.getSuccesseurs(noeudsVisites.get(noeudsVisites.size()-1))){

            }
        }
        return chemin.toArray(new String[0]);
    }
}