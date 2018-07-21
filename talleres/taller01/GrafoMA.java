/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;

/**
 *
 * Codigo esqueleto tomado de: https://github.com/mauriciotoro/ST0245-Eafit/blob/master/talleres/taller11/java/Laboratorio1/DiagraphAL.java
 * @author Isaias Labrador, Santiago Hincapie, .........
 *
 */
public class GrafoMA {
    
    private int [][] Matriz_AD;
    
    public GrafoMA(int size){
        this.Matriz_AD = new int [size][size]; 
    }
    
    /**
     * 
     * @param origen
     * @param destino 
     * @param peso
     */
    public void addArc(int origen, int destino, int peso){
        this.Matriz_AD[origen][destino] = peso;
    }
    
    /**
     * 
     * @param origen
     * @param destino
     * @return peso del arco entre el vertice origen y el vertice destino
     */
    public int getWeight(int origen, int destino){
        return this.Matriz_AD[origen][destino];
    }
    
    /**
     * 
     * @param vertice
     * @return vertices que tienen conexion o arista con el vertice parametro
     */
    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> sucesors = new ArrayList<>();
        
        for(int i = 0; i < this.Matriz_AD.length; i++){
            if(this.Matriz_AD[vertice][i] != 0){
            sucesors.add(i);
            }
        }
        return sucesors;
    }
}
