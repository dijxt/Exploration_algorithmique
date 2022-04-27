package pCC;

import java.util.*;

public class PCCBellman {

    public static int PCC(IGraph g, String source, String cible){
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecesseurs = new HashMap<>();

        for (String tmpIterNext : g) {
            distances.put(tmpIterNext, Integer.MAX_VALUE);
            predecesseurs.put(tmpIterNext, null);
        }

        distances.put(source, 0);
        for (String label1 : distances.keySet())
            for (String label2 : distances.keySet())
                if (label1 != source || label2 != source || label2 != label1)
                    if (distances.get(label2) > distances.get(label1) + g.getValeur(label1, label2)){
                        distances.put(label2, distances.get(label1) + g.getValeur(label1, label2));
                        predecesseurs.put(label2, label1);
                    }

        return distances.get(cible);
    }
}
