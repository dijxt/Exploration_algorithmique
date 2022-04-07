package pCC;

public interface IGraph{

    /**
     * indique si le graphe peut être soumis à l'algorithme de Dijkstra
     * @param g le graphe
     * @return vrai ou faux
     */
    boolean estOK(IGraph g);

    // TODO les fonctions utiles aux algos de recherche
}
