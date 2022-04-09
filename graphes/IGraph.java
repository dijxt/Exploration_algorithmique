package graphes;

public interface IGraph{
    int getNbNoeuds();

    void ajouterArc(String a, String c, int i);

    boolean aArc(String a, String d);

    int dOut(String a);

    int dIn(String a);

    int getValeur(String d, String e);
}
