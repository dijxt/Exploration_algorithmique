package graphes;

public class CircuitAbsorbantEx extends IllegalArgumentException{
    public CircuitAbsorbantEx(){
        super("Le graphe possède un circuit absorbant");
    }
}
