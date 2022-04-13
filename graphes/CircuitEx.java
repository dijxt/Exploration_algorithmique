package graphes;

public class CircuitEx extends IllegalArgumentException{
    /**
     * Constructeur de la classe CircuitAbsorbantEx.
     */
    public CircuitEx(){
        super("Le graphe possède un circuit");
    }
}
