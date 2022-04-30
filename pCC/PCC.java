package pCC;

public class PCC {
    String algorithme;
    int longeurChemin;
    int[] chemin;

    PCC(String algorithme,int longeurChemin, int[] chemin){
        this.algorithme = algorithme;
        this.longeurChemin = longeurChemin;
        this.chemin = chemin;
    }

    public String getAlgorithme() {
        return algorithme;
    }

    public int getLongeurChemin() {
        return longeurChemin;
    }

    public int[] getChemin() {
        return chemin;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(algorithme).append("\n").append(longeurChemin).append("\n");
        for (int i : chemin){
            s.append(i).append(" ");
        }
        return s.toString();
    }
}
