package graphes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * GrapheMA est une classe qui implémente le graphe de type liste d'adjacence.
 */
public class GrapheLA implements IGraph {
    private Map<String, Integer> noeuds;
    private ArrayList<ArrayList<Arc>> la;

    /**
     * Arc est une classe qui implémente un arc du graphe.
     */
    private static class Arc  {
        String cible;
        int valeur;

        /**
         * Constructeur d'un arc.
         * @param cible la cible de l'arc.
         * @param valeur la valeur de l'arc.
         */
        Arc(String cible, int valeur) {
            this.cible = cible;
            this.valeur = valeur;
        }

        /**
         * Teste si l'arc est le même que l'arc passé en paramètre.
         * @param ob l'arc à comparer.
         * @return true si les deux arcs sont les mêmes, false sinon.
         */
        @Override
        public boolean equals(Object ob) {
            if (this == ob)
                return true;
            if (ob.getClass() != Arc.class)
                return false;
            Arc a = (Arc) ob;
            return a.cible.equals(this.cible); // on ne tient PAS compte de la valeur
            // afin de faciliter l'ecriture de la methode aArc
            // qui cherche si un arc avec la meme cible existe peu importe la valeur
            // en utilisant contains sur une liste d'arcs or contains appelle
            // cette methode equals
        }
    }

    /**
     * Constructeur de GrapheLA.
     * @param labels un tableau de noeuds
     */
    public GrapheLA(String[] labels) {
        this.noeuds = new HashMap<>();
        int nb = labels.length;
        for (int i =0; i< nb; ++i)
            this.noeuds.put(labels[i], i);
        la = new ArrayList<>();
        for (int i = 0; i < nb; ++i)
            la.add(new ArrayList<>());
    }

    /**
     * Renvoie le nombre de noeuds du graphe.
     * @return le nombre de noeuds du graphe.
     */
    @Override
    public int getNbNoeuds() {
        return la.size();
    }

    /**
     * Renvoie si le noeud est valide.
     * @param label le noeud.
     * @return true si le noeud est valide, false sinon.
     */
    @Override
    public boolean estNoeudOK(String label) {
        return noeuds.containsKey(label);
    }

    /**
     * Renvoie si l'arc est valide.
     * @param n1 le noeud d'origine de l'arc.
     * @param n2 le noeud de destination de l'arc.
     * @return true si l'arc est valide, false sinon.
     */
    @Override
    public boolean estArcOK(String n1, String n2) {
        return estNoeudOK(n1) && estNoeudOK(n2);
    }

    /**
     * Ajoute un arc au graphe.
     * @param label1 le noeud d'origine de l'arc.
     * @param label2 le noeud de destination de l'arc.
     * @param valeur la valeur de l'arc.
     */
    @Override
    public void ajouterArc(String label1, String label2, int valeur) {
        assert ! aArc(label1,label2);
        int n1 = noeuds.get(label1);
        la.get(n1).add(new Arc(label2, valeur));
    }

    /**
     * Renvoie si l'arc existe.
     * @param label1 le noeud d'origine de l'arc.
     * @param label2 le noeud de destination de l'arc.
     * @return true si l'arc existe, false sinon.
     */
    @Override
    public boolean aArc(String label1, String label2) {
        assert estArcOK(label1,label2);
        int n1 = noeuds.get(label1);
        return la.get(n1).contains(new Arc(label2, 0));
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
            for (Arc a : la.get(noeuds.get(label1)))
                s+= a.cible + "("+ a.valeur + ") ";
            s+="\n";
        }
        return s;
    }

    /**
     * Renvoie le nombre d'arcs sortants d'un noeud.
     * @param label le noeud.
     * @return le nombre d'arcs sortants du noeud.
     */
    @Override
    public int dOut(String label) {
        assert estNoeudOK(label);
        return la.get(noeuds.get(label)).size();
    }

    /**
     * Renvoie le nombre d'arcs entrants d'un noeud.
     * @param label le noeud.
     * @return le nombre d'arcs entrants du noeud.
     */
    @Override
    public int dIn(String label) {
        assert estNoeudOK(label);
        int d = 0;
        Arc a = new Arc(label, 0);
        for(int i = 0; i< la.size(); ++i)
            if (la.get(i).contains(a))
                ++d;
        return d;
    }

    /**
     * Renvoie la valeur de l'arc.
     * @param label1 le noeud d'origine de l'arc.
     * @param n2 le noeud de destination de l'arc.
     * @return la valeur de l'arc.
     */
    @Override
    public int getValeur(String label1, String n2) {
        assert aArc(label1, n2);
        for (Arc a : la.get(noeuds.get(label1)))
            if (a.cible.equals(n2))
                return a.valeur;
        throw new RuntimeException("Pas de valeur trouvée pour l'arc " + label1 +" -> " +n2);
    }

    /**
     * La liste des successeurs d'un sommet
     * @param label le sommet
     * @return la liste des successeurs
     */
    @Override
    public String[] getSuccesseurs(String label) {
        assert estNoeudOK(label);
        String[] str = new String[dOut(label)];
        int i = 0;
        for (Arc a : la.get(noeuds.get(label))){
            str[i++] = a.cible;
        }

        return str; // TODO
    }

    /**
     * La liste des prédécesseurs d'un sommet
     * @param label le sommet
     * @return la liste des prédécesseurs
     */
    @Override
    public String[] getPredecesseurs(String label) {
        assert estNoeudOK(label);
        String[] str = new String[dIn(label)];
        int i = 0;
        for (int j = 0; j< la.size(); ++j)
            for (Arc a : la.get(j))
                if (a.cible.equals(label)){
                    str[i++] = a.cible;
                }
        return str; // TODO
    }

}
