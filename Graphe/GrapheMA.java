package Graphe;

/**
 * classe de représentation d'un graphe par une matrice d'adjacence
 * @author ABBASSI Ilyes
 */
public class GrapheMA {
	/**nombre de noeuds du graphe*/
    private final int nbNoeuds;
    /**matrice d'adjacence représentant le graphe*/
    private boolean[][] matrice;

    /**
     * constructeur de la classe
     * @param nbNoeuds le nombre de sommets du graphe
     */
    public GrapheMA(int nbNoeuds){
        this.nbNoeuds = nbNoeuds;
        this.matrice = new boolean[nbNoeuds][nbNoeuds];
        for (int i = 0; i < nbNoeuds; ++i){
            for (int j = 0; j < nbNoeuds; ++j){
                matrice[i][j] = false;
            }
        }
    }

    /**
     * @return le nombre de sommets du graphe
     */
    public int getNbNoeuds() {
        return nbNoeuds;
    }

    /**
     * ajoute une arc à la matrice d'adjacence
     * @param x le premier sommet
     * @param y le second sommet
     */
    public void ajouterArc(int x, int y){
        matrice[x - 1][y - 1] = true;
    }

    /**
     * test si l'arc (x, y) est présent dans la matrice
     * @param x le premier sommet
     * @param y le second sommet
     * @return vrai si l'arc existe sinon faux
     */
    public boolean aArc(int x, int y){
        return matrice[x - 1][y - 1];
    }

    /**
     * retourne le degré sortant du sommet x passsé en paramètre
     * @param x le sommet
     * @return le nombre de successeurs
     */
    public int dOut(int x){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[x - 1][i]){
                ++cpt;
            }
        }
        return cpt;
    }

    /**
     * retourne le degré entrant du sommet y
     * @param y le sommet 
     * @return le nombre de prédécesseurs
     */
    public int dIn(int y){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[i][y - 1]){
                ++cpt;
            }
        }
        return cpt;
    }

    /**
     * surcharge de l'opérateur d'affichage par défaut d'une instance de la classe
     * @return une chaine de caractères représentant la matrice
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < nbNoeuds; ++i){
            for (int j = 0; j < nbNoeuds; ++j){
                if (matrice[i][j]){
                    str += "1 ";
                }
                else {
                    str += "0 ";
                }
            }
            str += "\n";
        }
        return str;
    }
}
