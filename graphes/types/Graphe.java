package graphes.types;

import pCC.IGraphe;

public abstract class Graphe implements IGraphe {
    protected final static int INFINI = Integer.MAX_VALUE;

    public boolean estNoeudOK(int n) {
        return n >= 1 && n <= getNbSommets();
    }

    public boolean estArcOK(int a, int b) {
        return estNoeudOK(a) && estNoeudOK(b);
    }

    @Override
    public boolean aArc(int a, int b) {
        return getValuation(a,b) != INFINI;
    }

}