package graphes.types;

import java.util.ArrayList;
import java.util.List;

public class GrapheLA extends Graphe{
    private static class Stub {
        public int valuation, cible;
        public Stub (int valuation, int cible) {
            this.valuation = valuation;
            this.cible = cible;
        }
    }
    private	List<Stub> la[];

    @SuppressWarnings("unchecked")
    public GrapheLA(int nbNoeuds) {
        super();
        la = new List[nbNoeuds]; // necessite le SuppressWarnings ci-dessus
        for (int i = 0; i < nbNoeuds; ++i)
            la[i] = new ArrayList<>();
    }

    @Override
    public int getNbSommets() {
        return la.length;
    }

    @Override
    public int getValuation(int a, int b) {
        assert estArcOK(a,b);
        List<Stub> stubs = la[a-1];
        for (Stub s : stubs)
            if (s.cible == b)
                return s.valuation;
        return INFINI;
    }

    /**
     * Retourne le nombre de successeurs d'un sommet
     * @param n le sommet
     * @return le nombre de successeurs
     */
    private int dOut(int n) {
        return la[n-1].size();
    }


    public void ajouterArc(int a, int b, int v) {
        assert ! aArc(a,b);
        la[a-1].add(new Stub(v, b));
    }


    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i< la.length; ++i) {
            str += (i+1) + " =>";
            for (Stub s : la[i])
                str += " "+s.cible + "("+s.valuation+")";
            str +="\n";
        }
        return str;
    }

    /**
     * Retourne les successeurs d'un sommet
     * @param n le sommet
     * @return les successeurs
     */
    @Override
    public int[] getSuccesseurs(int n) {
        List<Stub> stubs = la[n-1];
        int[] succ = new int[dOut(n)];
        int i = 0;
        for (Stub s : stubs)
            succ[i++] = s.cible;
        return succ;
    }
}