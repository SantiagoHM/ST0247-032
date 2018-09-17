/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import java.util.ArrayList;

/**
 *
 * @author Labrador
 */
public class CicleGraph {
    
    public static boolean buscarCiclo(DigraphAM g, int indice){
        if(indice >= g.size){return false;}
        int aux40 = indice;
        ArrayList<Integer> aux = new ArrayList<>();
        ArrayList<Integer> aux2 = new ArrayList<>();
        for(int i= indice; i<g.size-1; i++){
            aux= g.getSuccessors(i);
            aux2 = g.getSuccessors(i+1);
            
//            System.out.println(aux);
        }
        for(int i= 0; i<aux.size(); i++){
            for(int j= 0; j<aux2.size(); j++){
                
                if(aux.get(i) == aux40+2 || aux2.get(j)== aux40+1){
                    System.out.println(aux +" "+ aux2 + " :: " + aux40);
                    return true;
                }else{
                    
                    return buscarCiclo(g, indice+1);
                }
            }
        }
        return false;
    }    
}
