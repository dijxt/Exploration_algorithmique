package graphes.ihm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import pCC.IGraphe;
import graphes.types.GrapheLA;

public class GraphImporter {
    public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException {
        Arc df = new Arc();
        IGraphe g = importer("graphe1.txt", df);
        System.out.print(g);
        System.out.println("debut fin : "+ df.getSource() + " ==> "+ df.getDestination());
        verifierGraphes();
        // tester PCC
    }

    public static void verifierGraphes() throws FileNotFoundException {
        IGraphe g;
        Arc df = new Arc();
        String dirStr = System.getProperty("user.dir")+ "\\graphes\\sc";
        System.out.println("Working Directory = " + dirStr);
        File dir = new File(dirStr);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                System.out.println(child);
                g = importer(child, df);
                System.out.println(g.getNbSommets() + " sommets");
                System.out.println("debut et fin du chemin à trouver : "+ df.getSource()+ " ==> "+ df.getDestination()+"\n");
            }
        } else {
            System.out.println("Erreur : "+ dirStr + " n'est pas un réperoire");
        }
    }

    public static Arc parse(String string) {
        String[] parts = string.split(" ");
        int source, valuation, destination;
        try {
            source = Integer.parseInt(parts[0]);
            valuation = Integer.valueOf(parts[1]);
            destination = Integer.parseInt(parts[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException(string + " n'est pas un arc");
        }
        Arc a = new Arc(source, valuation, destination);
        return a;
    }
    private static IGraphe importer(File file, Arc df) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        String line;
        IGraphe g;
        if (! sc.hasNextLine()) {
            sc.close();
            throw new IllegalArgumentException("Pas de graphe dans "+ file);
        }
        line = sc.nextLine();
        int nbNodes = Integer.parseInt(line.trim());
        g = new GrapheLA(nbNodes);
        Arc a;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            a = parse(line);
            if (sc.hasNextLine())
                g.ajouterArc(a.getSource(),  a.getValuation(), a.getDestination());
            else {// la derniere ligne n'est pas un arc mais le debut et la fin du chemin à trouver
                df.set(a);
            }
        }
        sc.close();
        return g;
    }
    private static IGraphe importer(String filepath, Arc df)
            throws  NumberFormatException, IOException, FileNotFoundException {
        File file = new File(filepath);
        return importer(file, df);
    }
}