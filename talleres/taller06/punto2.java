import java.util.ArrayList;

public class Punto_2 {

    static int [] dijsktra(Graph dg, int peso) {
    
        final int [] distancia = new int [dg.size()];  
        final int [] pr = new int [dg.size()];  
        final boolean [] recorrido = new boolean [dg.size()]; //Se inicializan en falso. (No visitado)
        
        //Ciclo para llenar todos los caminos.
        for (int i = 0; i < distancia.length; i++) {
            distancia[i] = Integer.MAX_VALUE; //Valor máximo para decir que no hay camino
        }
        
        distancia[source] = 0;

        for (int i=0; i<distancia.length; i++) {
            final int next = minVertex (distancia, recorrido);
            recorrido[next] = true;

            // The shortest path to next is distancia[next] and via pred[next].

            final ArrayList<Integer> n = dg.getSuccessors (next);
            for (int j=0; j<n.size(); j++) {
                final int v = n.get(j);
                final int d = distancia[next] + dg.getWeight(next,v);
                if (distancia[v] > d) {
                    distancia[v] = d;
                    pr[v] = next;
                }
            }
        }
        return pr; 
    }
    private static int minVertex (int [] distancia, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   //No hay camino..
        for (int i=0; i<distancia.length; i++) {
            if (!v[i] && distancia[i]<x) {
              y=i; x=dist[i];}
            }
        return y;
    }

    public static ArrayList getPath (int [] pr, int s, int e) {
        final  java.util.ArrayList camino = new  java.util.ArrayList();
        int x = e;
        while (x!=s) {
            camino.add (0, x);
            x = pred[x];
        }
        
        camino.add (0, s);
        return camino;
    }
}
