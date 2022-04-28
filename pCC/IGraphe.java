package pCC;

public interface IGraphe{
    /**
     * Retourne le nombre de sommets du graphe
     * @return le nombre de sommets du graphe
     */
    int getNbSommets();

    /**
     * Ajoute un arc entre deux sommets
     * @param n1 le sommet de départ
     * @param n2 le sommet d'arrivée
     * @param i la valeur de l'arc
     */
    void ajouterArc(int n1, int n2, int i);

    /**
     * Teste si un arc existe entre deux sommets
     * @param n1 le sommet de départ
     * @param n2 le sommet d'arrivée
     * @return true si l'arc existe, false sinon
     */
    boolean aArc(int n1, int n2);

    /**
     * Retourne la valeur de l'arc entre deux sommets
     * @param n1 le sommet de départ
     * @param n2 le sommet d'arrivée
     * @return la valeur de l'arc
     */
    int getValuation(int n1, int n2);

    /**
     * Retourne une chaine de caractère représentant un graphe
     * @return la chaine
     */
    String toString();

    /**
     * Retourne les successeurs d'un sommet
     * @param n le sommet
     * @return les successeurs
     */
    int[] getSuccesseurs(int n);
}
