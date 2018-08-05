package talleres;

import java.util.ArrayList;
import javafx.util.Pair;


public class DigraphAL extends Digraph {
    
    
    ArrayList [] nodos;
    
    public DigraphAL(int size) {
        super(size);
        this.nodos = new ArrayList[size];
    }

    public void addArc(int origen, int destino, int peso) {
        this.nodos[origen].add(destino,peso);
    }

    public ArrayList<Integer> getSuccessors(int vertice) {
        return this.nodos[vertice];    
    }
    
    public int getWeight(int origen, int destino) {
        return (int) this.nodos[origen].get(destino);
    }

}
