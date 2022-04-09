package graphes;

public class ArcNEégatifEx extends IllegalArgumentException{
    /**
     * Constructeur de la classe ArcNEégatifEx.
     */
    public ArcNEégatifEx(){
        super("Le graphe possède un arc négatif");
    }
}
