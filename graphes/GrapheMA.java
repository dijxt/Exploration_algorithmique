package graphes;

import pCC.IGraph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * GrapheMA est une classe qui implémente le graphe de type matrice d'adjacence.
 */
public class GrapheMA implements IGraph, Iterable<String> {
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
        StringBuilder s = new StringBuilder();
        for(String label1 : noeuds.keySet()) {
            s.append(label1).append(" -> ");
            int n1 = noeuds.get(label1);
            for (int n2=0; n2< getNbNoeuds(); ++n2) {
                if (mab[n1][n2])
                    s.append(labels[n2]).append("(").append(mav[n1][n2]).append(") ");
            }
            s.append("\n");
        }
        return s.toString();
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

    /**
     * La liste des successeurs d'un sommet
     * @param label le sommet
     * @return la liste des successeurs
     */
    @Override
    public String[] getSuccesseurs(String label) {
        assert estNoeudOK(label);
        int n = noeuds.get(label);
        String[] str = new String[dOut(label)];
        int nb = 0;
        for (int i=0; i< getNbNoeuds(); ++i)
            if (mab[n][i])
                str[nb++] = this.labels[i];
        return str;
    }

    /**
     * La liste de tout les sommets d'un graphe
     * @return la liste
     */
    @Override
    public String[] getLabels() {
        return labels;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<String> iterator() {
        return noeuds.keySet().iterator();
    }

    /**
     * Renvoie le numéro d'un noeud
     * @param label le noeud
     * @return son numéro
     */
    @Override
    public int getNumero(String label) {
        return noeuds.get(label);
    }
}
