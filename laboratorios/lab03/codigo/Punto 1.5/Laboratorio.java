/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Labrador
 */
public class Laboratorio {
    
    public static void main(String [] args) throws IOException{
        DigraphAM grafo = new DigraphAM(4);        

        
        grafo.addArc(0, 1, 1);
        grafo.addArc(1, 0, 1);
        grafo.addArc(0, 2, 1);
        grafo.addArc(2, 0, 1);
        grafo.addArc(1,3,1);
        grafo.addArc(3,1,1);
        grafo.addArc(2, 3, 1);
        grafo.addArc(3, 2, 1);
        
        
        System.out.println(CicleGraph.buscarCiclo(grafo, 0));
        
    }
    
    public static void Imprimir(ArrayList<Integer> arr){
        for(int i = 0; i<arr.size(); i++){
            System.out.println("Estas Son las aristas que se toman: " + arr.get(i));
        }
    }
}
