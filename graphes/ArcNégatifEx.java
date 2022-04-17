package graphes;

public class ArcNégatifEx extends IllegalArgumentException{
    /**
     * Constructeur de la classe ArcNEégatifEx.
     */
    public ArcNégatifEx(){
        super("Le graphe possède un arc négatif");
    }
}
