package graphes;

public interface IGraph{
    /**
     * Retourne le nombre de sommets du graphe
     * @return le nombre de sommets du graphe
     */
    int getNbNoeuds();

    /**
     * Teste si un noeud est valide
     * @param label le noeud
     * @return true si le noeud est valide, false sinon
     */
    boolean estNoeudOK(String label);

    /**
     * Teste si un arc est valide
     * @param n1 le sommet de départ
     * @param n2 le sommet d'arrivée
     * @return true si l'arc est valide, false sinon
     */
    boolean estArcOK(String n1, String n2);

    /**
     * Ajoute un arc entre deux sommets
     * @param label1 le sommet de départ
     * @param label2 le sommet d'arrivée
     * @param i la valeur de l'arc
     */
    void ajouterArc(String label1, String label2, int i);

    /**
     * Teste si un arc existe entre deux sommets
     * @param label1 le sommet de départ
     * @param label2 le sommet d'arrivée
     * @return true si l'arc existe, false sinon
     */
    boolean aArc(String label1, String label2);

    /**
     * Retourne le nombre d'arcs sortants d'un sommet
     * @param label le sommet
     * @return le nombre d'arcs sortants
     */
    int dOut(String label);

    /**
     * Retourne le nombre d'arcs entrants d'un sommet
     * @param label le sommet
     * @return le nombre d'arcs entrants
     */
    int dIn(String label);

    /**
     * Retourne la valeur de l'arc entre deux sommets
     * @param label1 le sommet de départ
     * @param label2 le sommet d'arrivée
     * @return la valeur de l'arc
     */
    int getValeur(String label1, String label2);

    /**
     * La liste des successeurs d'un sommet
     * @param label le sommet
     * @return la liste des successeurs
     */
    String[] getSuccesseurs(String label);

    /**
     * La liste des prédécesseurs d'un sommet
     * @param label le sommet
     * @return la liste des prédécesseurs
     */
    String[] getPredecesseurs(String label);
}
