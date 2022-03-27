package Graphe;

public class GrapheMA {
    private final int nbNoeuds;
    private boolean[][] matrice;

    /**
     *
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
    public void ajouterArc(int x, int y){
        matrice[x - 1][y - 1] = true;
    }

    /**
     *
     * @param x le sommet de sortie
     * @param y le sommet d'entrée
     * @return vrai si l'arc existe sinon faux
     */
    public boolean aArc(int x, int y){
        return matrice[x - 1][y - 1];
    }

    /**
     *
     * @param x le sommet de sortie
     * @return le nombre de successeurs
     */
    public int dOut(int x){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[x - 1][i] == true){
                ++cpt;
            }
        }
        return cpt;
    }

    /**
     *
     * @param y le sommet d'entrée
     * @return le nombre de prédécesseurs
     */
    public int dIn(int y){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[i][y - 1] == true){
                ++cpt;
            }
        }
        return cpt;
    }

    /**
     *
     * @return une chaine de caractères sous forme de matrice
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < nbNoeuds; ++i){
            for (int j = 0; j < nbNoeuds; ++j){
                if (matrice[i][j] == true){
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
