package talleres;

import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;


public class DigraphAL extends Digraph {
    
    
    ArrayList<Integer> [] nodos;    
    
    public DigraphAL(int size) {
        super(size);
        this.nodos = new ArrayList[size];
        for(int i= 0; i<this.nodos.length;i++){
            this.nodos[i] = new ArrayList<>(Collections.nCopies(size, 0));
        }
    }

    public void addArc(int origen, int destino, int peso) {
        
        this.nodos[origen].add(destino,peso);
//        this.nodos[destino].add(origen,peso);
    }

    public ArrayList<Integer> getSuccessors(int vertice) {
        return this.nodos[vertice];    
    }
    
    public int getWeight(int origen, int destino) {
        return (int) this.nodos[origen].get(destino);
    }
    
    public int menor(int indice){
        int aux = this.nodos[indice].size();
        int menor = this.nodos[indice].get(0);
        for(int i =0; i<aux; i++){
            int aux2= this.nodos[indice].get(i);
            if(aux2 < menor){menor = aux2;}
        }
        return menor;
    }

}
