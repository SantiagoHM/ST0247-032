/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import com.sun.corba.se.impl.oa.NullServantImpl;
import java.util.ArrayList;

/**
 *
 * @author Labrador
 */
public class Prim {
       
    public ArrayList<Integer> encontrarPrim1(DigraphAL g){
        boolean [] b = new boolean [g.size];
        for(int i= 0; i<b.length; i++){
            b[i]=false;
        }
        ArrayList<Integer> aux = new ArrayList<>();
        return encontrarPrim(g, b, aux);
    }
    
    public ArrayList<Integer> encontrarPrim(DigraphAL g, boolean [] visitados, ArrayList<Integer> pesos){
        boolean [] visited = visitados;
        
        for(int i= 0; i<g.nodos.length; i++){            
            if(!visitados[i]){
                int aux = g.menor(i);
                if(!visitados[aux]){
                    pesos.add(g.getWeight(i, aux));
                    visited[i]= true;
                    visited[aux]= true;
                }else{
                    continue;
                }
            }
            
        }
        for(int i = 0; i<visitados.length; i++){
            if(!visitados[i]){
                return encontrarPrim(g, visited, pesos);
            }
        }
        return pesos;
    }
}
