package graphes;

import java.util.HashMap;
import java.util.Map;

/**
 * GrapheMA est une classe qui implémente le graphe de type matrice d'adjacence.
 */
public class GrapheMA implements IGraph {
    private Map<String, Integer> noeuds;
    private String[] labels; // pour toString
    private boolean[][] mab;
    private int[][] mav;

    /**
     * Constructeur de GrapheMA.
     * @param labels un tableau de noeuds
     */
    public GrapheMA(String[] labels) {
        this.labels = labels.clone();
        this.noeuds = new HashMap<>();
        int nb = labels.length;
        for (int i =0; i< nb; ++i)
            this.noeuds.put(labels[i], i);
        mab = new boolean[nb][nb];
        mav = new int[nb][nb];
    }

    /**
     * Renvoie le nombre de noeuds du graphe.
     * @return le nombre de noeuds
     */
    public int getNbNoeuds() { return mab.length; }

    /**
     * Teste si un noeud est valide.
     * @param label le noeud
     * @return true si le noeud est valide, false sinon
     */
    public boolean estNoeudOK(String label) {
        return noeuds.containsKey(label);
    }

    /**
     * Teste si un arc est valide.
     * @param n1 le premier noeud
     * @param n2 le deuxième noeud
     * @return true si l'arc est valide, false sinon
     */
    public boolean estArcOK(String n1, String n2) {
        return estNoeudOK(n1) && estNoeudOK(n2);
    }

    /**
     * Ajoute un arc entre deux noeuds.
     * @param label1 le premier noeud
     * @param label2 le deuxième noeud
     * @param valeur la valeur de l'arc
     */
    public void ajouterArc(String label1, String label2, int valeur) {
        assert ! aArc(label1,label2);
        int n1 = noeuds.get(label1);
        int n2 = noeuds.get(label2);
        mab[n1][n2] = true;
        mav[n1][n2] = valeur;
    }

    /**
     * Représente le graphe sous forme de chaîne de caractères.
     * @return le graphe sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        String s = "";
        for(String label1 : noeuds.keySet()) {
            s+= label1 + " -> ";
            int n1 = noeuds.get(label1);
            for (int n2=0; n2< getNbNoeuds(); ++n2) {
                if (mab[n1][n2])
                    s+= labels[n2] + "("+ mav[n1][n2] + ") ";
            }
            s+="\n";
        }
        return s;
    }

    /**
     * Teste si un arc existe entre deux noeuds.
     * @param label1 le premier noeud
     * @param label2 le deuxième noeud
     * @return true si l'arc existe, false sinon
     */
    public boolean aArc(String label1, String label2) {
        assert estArcOK(label1,label2);
        return mab[noeuds.get(label1)][noeuds.get(label2)];
    }

    /**
     * Renvoie la valeur de l'arc entre deux noeuds.
     * @param label1 le premier noeud
     * @param label2 le deuxième noeud
     * @return la valeur de l'arc
     */
    public int getValeur(String label1, String label2) {
        assert estArcOK(label1, label2);
        return mav[noeuds.get(label1)][noeuds.get(label2)];
    }

    /**
     * Renvoie le nombre d'arcs sortants d'un noeud.
     * @param label le noeud
     * @return le nombre d'arcs sortants
     */
    public int dOut(String label) {
        assert estNoeudOK(label);
        int n1 = noeuds.get(label);
        int degre = 0;
        for (int n2 = 0; n2 < getNbNoeuds(); ++n2)
            if (mab[n1][n2])
                ++degre;
        return degre;
    }

    /**
     * Renvoie le nombre d'arcs entrants d'un noeud.
     * @param label le noeud
     * @return le nombre d'arcs entrants
     */
    public int dIn(String label) {
        assert estNoeudOK(label);
        int n2 = noeuds.get(label);
        int degre = 0;
        for (int n1 = 0; n1 < getNbNoeuds(); ++n1)
            if (mab[n1][n2])
                ++degre;
        return degre;
    }

}
