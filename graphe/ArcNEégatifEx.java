package graphe;

public class ArcNEégatifEx extends IllegalArgumentException{
    public ArcNEégatifEx(){
        super("Le graphe possède un arc négatif");
    }
}
