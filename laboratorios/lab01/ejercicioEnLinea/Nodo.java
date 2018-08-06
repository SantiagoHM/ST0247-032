
package punto2;
//Importado
import java.util.ArrayList;

//Clase Nodo
public class Nodo {
    
    //Caracteristdcas
    int color = 0;
    int ident;
    ArrayList<Nodo> vertice = new ArrayList<>();
    
    
    public Nodo(int ident){
        this.ident = ident;
    }
    public boolean add_vertice(Nodo w){
        for(Nodo nodo: vertice){
            if(nodo.ident == w.ident){
                return false;
            }
        }
        vertice.add(w);
        return true;
    }
    
}
