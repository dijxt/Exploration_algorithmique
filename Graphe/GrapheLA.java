package Graphe;

import java.util.ArrayList;

/**
 * classe de représentation d'une matrice par list d'adjacence
 * @author ABBASSI Ilyes
 */
public class GrapheLA {	
	/**nombre de noeuds du graphe*/
    private final int nbNoeuds;
    /**listes d'adjacence représentant le graphe*/
    private ArrayList<ArrayList<Integer>> liste;

    /**
     * constructeur de la classe
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
     * @return le nombre de sommets du graphe
     */
    public int getNbNoeuds() {
        return nbNoeuds;
    }

    /**
     * ajoute un arc à la liste d'adjacence du sommet x
     * @param x le premier sommet
     * @param y le second sommet
     */
    public void ajouterArc(int x, int y) {
        liste.get(x - 1).add(y);
    }

    /**
     * test si l'arc (x, y) est présent dans une liste d'adjacence
     * @param x le premier sommet
     * @param y le second sommet
     * @return vrai si l'arc existe sinon faux
     */
    public boolean aArc(int x, int y) {
        return liste.get(x - 1).contains(y);
    }

    /**
     * renvoie le degré sortant d'un sommet
     * @param x le sommet
     * @return le nombre de successeurs
     */
    public int dOut(int x) {
        return liste.get(x - 1).size();
    }

    /**
     * retourne le degré entrant d'un sommet
     * @param y le sommet
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
     * surcharge de l'opérateur d'affichage par défaut d'une instance de la classe
     * @return une chaine de caractères représentant les listes d'adjacences
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
