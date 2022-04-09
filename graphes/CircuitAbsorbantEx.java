package graphes;

public class CircuitAbsorbantEx extends IllegalArgumentException{
    /**
     * Constructeur de la classe CircuitAbsorbantEx.
     */
    public CircuitAbsorbantEx(){
        super("Le graphe possède un circuit absorbant");
    }
}
