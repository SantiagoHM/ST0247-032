
package punto2;
//Importado
import java.util.ArrayList;

public class Grafo {
    
    int tamanio;
    ArrayList<Nodo> nodos = new ArrayList<>();
    
    public  Grafo(int tamanio){
        this.tamanio = tamanio;
        
        for (int i = 0; i < tamanio; i++) {
            add_Nodo(i);
        }
    }
    
    //Ciclo para adicionar nodo
    public void add_Nodo(int numero){
        nodos.add(new Nodo(numero));
    }
    
    //Ciclo para adicionar linea
    public void linea(int numero, int final){
        nodos.get(numero).add_vertice(nodos.get(final));
    }
    
}
