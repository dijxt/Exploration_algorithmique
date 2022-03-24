package Graphe;

public class GrapheMA {
    private final int nbNoeuds;
    private boolean[][] matrice;

    public GrapheMA(int nbNoeuds){
        this.nbNoeuds = nbNoeuds;
        this.matrice = new boolean[nbNoeuds][nbNoeuds];
        for (int i = 0; i < nbNoeuds; ++i){
            for (int j = 0; j < nbNoeuds; ++j){
                matrice[i][j] = false;
            }
        }
    }

    public int getNbNoeuds() {
        return nbNoeuds;
    }

    public void ajouterArc(int x, int y){
        matrice[x - 1][y - 1] = true;
    }

    public boolean aArc(int x, int y){
        return matrice[x - 1][y - 1];
    }

    public int dOut(int x){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[x - 1][i] == true){
                ++cpt;
            }
        }
        return cpt;
    }

    public int dIn(int y){
        int cpt = 0;
        for(int i = 0; i < nbNoeuds; ++i){
            if (matrice[i][y - 1] == true){
                ++cpt;
            }
        }
        return cpt;
    }

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
