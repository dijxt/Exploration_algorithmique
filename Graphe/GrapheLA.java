package Graphe;

import java.util.ArrayList;

public class GrapheLA {
    private final int nbNoeuds;
    private ArrayList<ArrayList<Integer>> liste;

    /**
     *
     * @param nbNoeuds le nombre de sommets du graphe
     */
    public GrapheLA(int nbNoeuds) {
        this.nbNoeuds = nbNoeuds;
        liste = new ArrayList<>();
        for (int i = 0; i < nbNoeuds; ++i){
            liste.add(new ArrayList<>());
        }
    }

    /**
     *
     * @return le nombre de sommets du graphe
     */
    public int getNbNoeuds() {
        return nbNoeuds;
    }

    /**
     *
     * @param x le sommet de sortie
     * @param y le sommet d'entrée
     */
    public void ajouterArc(int x, int y) {
        liste.get(x - 1).add(y);
    }

    /**
     *
     * @param x le sommet de sortie
     * @param y le sommet d'entrée
     * @return vrai si l'arc existe sinon faux
     */
    public boolean aArc(int x, int y) {
        return liste.get(x - 1).contains(y);
    }

    /**
     *
     * @param x le sommet de sortie
     * @return le nombre de successeurs
     */
    public int dOut(int x) {
        return liste.get(x - 1).size();
    }

    /**
     *
     * @param y le sommet d'entrée
     * @return le nombre de prédécesseurs
     */
    public int dIn(int y) {
        int cpt = 0;
        for (ArrayList<Integer> i : liste){
            for (int j : i){
                if (j == y){
                    ++cpt;
                }
            }
        }
        return cpt;
    }

    /**
     *
     * @return une chaine de caractères sous forme de listes d'adjacences
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < nbNoeuds; ++i){
            str += (i + 1) + " -> ";
            for (int j : liste.get(i)){
                str += j + " ";
            }
            str += "\n";
        }
        return str;
    }
}
