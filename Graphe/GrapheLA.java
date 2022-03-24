package Graphe;

import java.util.ArrayList;
import java.util.Arrays;

public class GrapheLA {
    private final int nbNoeuds;
    private ArrayList<ArrayList<Integer>> liste;

    public GrapheLA(int nbNoeuds) {
        this.nbNoeuds = nbNoeuds;
        liste = new ArrayList<>();
        for (int i = 0; i < nbNoeuds; ++i){
            liste.add(new ArrayList<>());
        }
    }

    public int getNbNoeuds() {
        return nbNoeuds;
    }

    public void ajouterArc(int x, int y) {
        liste.get(x - 1).add(y);
    }

    public boolean aArc(int x, int y) {
        return liste.get(x - 1).contains(y);
    }

    public int dOut(int x) {
        return liste.get(x - 1).size();
    }

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
