package graphes;

public class NoPathEx extends IllegalArgumentException{

    /**
     * Constructeur de la classe NoPathEx.
     */
    public NoPathEx(){
        super("Il n'y a pas de chemin possible");
    }
}
