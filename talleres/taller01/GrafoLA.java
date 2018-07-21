/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;

/**
 * Codigo esqueleto tomado de: https://github.com/mauriciotoro/ST0245-Eafit/blob/master/talleres/taller11/java/Laboratorio1/DiagraphAL.java
 * @author Isaias Labrador, Santiago Hincapie, .........
 */
public class GrafoLA {
    
    ArrayList [] nodos;
    
    public GrafoLA(int size){
        this.nodos = new ArrayList[size];
    }
    
    /**
     * @see Añade un arco o arista
     * @param origen
     * @param destino
     * @param peso 
     */
    public void addArc(int origen, int destino, int peso){
        this.nodos[origen].add(destino,peso);
    }
    
    /**
     * 
     * @param origen
     * @param destino
     * @return el peso del arco o la arista 
     */
    public int getPeso(int origen, int destino){
        return (int) this.nodos[origen].get(destino);
    }
    /**
     * 
     * @param vertice
     * @return Arraylist con los vertices que tienen conexion con este nodo 
     */
    public ArrayList<Integer> getSuccessors(int vertice){
        return this.nodos[vertice];
    }
    
}
