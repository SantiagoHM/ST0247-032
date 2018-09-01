//Tomado de https://github.com/jpgiraldor
import java.util.ArrayList;

public class Camino {

    static int [] dijsktra(Graph dg, int source) //
    {
        final int [] dist = new int [dg.size()];  // shortest known distance from "s"
        final int [] pred = new int [dg.size()];  // preceeding node in path
        final boolean [] visited = new boolean [dg.size()]; // all false initially

        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; //Infinity
        }
        dist[source] = 0;

        for (int i=0; i<dist.length; i++) {
            final int next = minVertex (dist, visited);
            visited[next] = true;

            // The shortest path to next is dist[next] and via pred[next].

            final ArrayList<Integer> n = dg.getSuccessors (next);
            for (int j=0; j<n.size(); j++) {
                final int v = n.get(j);
                final int d = dist[next] + dg.getWeight(next,v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred;  // (ignore pred[s]==0!)
    }
    private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i<dist.length; i++) {
            if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
        }
        return y;
    }

    public static ArrayList getPath (int [] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x!=s) {
            path.add (0, x);
            x = pred[x];
        }
        path.add (0, s);
        return path;
    }
}