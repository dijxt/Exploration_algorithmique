package pCC;

import graphes.ArcNégatifEx;

import java.util.*;

public class PCCDijkstra {

    private final IGraph g;  // le graphe
    private final String source;  // le sommet source
    private final String cible;  // le sommet cible
    private ArrayList<String> noeudsVisites;  // les noeuds deja parcourus par l'algorithme
    private int[] distanceSommets;  // la distance totale de chaque sommet de la source
    private String[] dernierPredecesseur;  // le prédécesseur le plus court de chaque sommet


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
        if (!estOkGraphe(g)) {
            throw new ArcNégatifEx();
        }
        this.g = g;
        this.source = source;
        this.cible = cible;
        this.noeudsVisites = new ArrayList<>();
        this.distanceSommets = new int[g.getNbNoeuds()];
        this.dernierPredecesseur = new String[g.getNbNoeuds()];
        // initialisation du noeud source
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
        chemin.add(cible);
        while (!noeudsVisites.contains(cible)){
            String dernierNoeud = noeudsVisites.get(noeudsVisites.size()-1);
            for (String s: g.getSuccesseurs(dernierNoeud)){
                if(g.getValeur(dernierNoeud, s) + distanceSommets[g.getNumero(dernierNoeud)] < distanceSommets[g.getNumero(s)]){
                    distanceSommets[g.getNumero(s)] = g.getValeur(dernierNoeud, s) + distanceSommets[g.getNumero(dernierNoeud)];
                    dernierPredecesseur[g.getNumero(s)] = dernierNoeud;
                }
            }
            String prochainNoeud = null;
            int prochainSommet = Integer.MAX_VALUE;
            for (int i = 0; i < distanceSommets.length; ++i){
                if (distanceSommets[i] < prochainSommet && !noeudsVisites.contains(g.getLabels()[i])){
                    prochainSommet = distanceSommets[i];
                    prochainNoeud = g.getLabels()[i];
                }
            }
            noeudsVisites.add(prochainNoeud);
        }
        String noeudChemin = cible;
        while (!Objects.equals(noeudChemin, source)){
            chemin.add(dernierPredecesseur[g.getNumero(noeudChemin)]);
            noeudChemin = dernierPredecesseur[g.getNumero(noeudChemin)];
        }
        Collections.reverse(chemin);
        System.out.println(chemin);
        System.out.println(distanceSommets[g.getNumero(cible)]);
        return chemin.toArray(new String[0]);
    }
}