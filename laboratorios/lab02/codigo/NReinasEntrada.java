/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @version 1.0
 * @author Isaias Labrador, Santiago Hincapie, Andrés
 */
public class NReinasEntrada {
    
    private static int indice;
    private static boolean justAdded = false;
    static int [][] malos;
    private static int fila = 0;
   
    
    public NReinasEntrada(){
        Scanner teclado = new Scanner(System.in);
        int numero = teclado.nextInt();
        malos = new int[numero][numero];
        Scanner nuevo = new Scanner(System.in);
        for(int i = 0; i< numero; i++){
            String cadena = nuevo.nextLine();
            guardarMalo(cadena);
            fila++;
        }
//        imppr();
        System.out.println(nQueens(numero));
    }
    
    public static void guardarMalo(String cadena){
        for(int i = 0; i<cadena.length(); i++){
            if(cadena.charAt(i)== '*'){
                malos[fila][i] = -1;
            }else{
                malos[fila][i] = 0;
            }
        }    
    }
    
    /**
     * @see nReinas
     * @param tamaño
     * @return numero de soluciones existentes en el problema de las N reinas 
     */
    public static int nQueens(int tamaño){
        int [] tablero = new int[tamaño];
        indice = tamaño -1;
        return nReinas(tablero);
    }
    
    /**
     * Al ser un algoritmo de fuerza bruta este lo que hace es usar todas las posibles combinaciones en el tablero 
     * e identificar cual es correcta y seguir hasta agotar las posibilidades
     * @param tablero
     * @return numero de soluciones que existen en el problema de las NReinas 
     */
    public static int nReinas(int [] tablero){
        if(completado(tablero)){return 0;}
        if(correcto(tablero)){
            tablero = moverTablero(tablero);
            return 1 + nReinas(tablero);
        }if(!correcto(tablero)){
            tablero = moverTablero(tablero);
            return 0 + nReinas(tablero);
            
        }
        if(correcto(tablero) && indice == 0){
            return 1;
        }
        if(indice == 0 && tablero[0]== tablero.length - 1){
           return 0;
        }       
        tablero = moverTablero(tablero);
        return nReinas(tablero);
        
    }
    
    /**
     * 
     * @param tablero
     * @return si el tablero ya no tiene mas posibilidades restantes por verificar 
     */
    public static boolean completado(int [] tablero){
        for(int i = 0; i< tablero.length; i++){
            if(tablero[i]!=tablero.length-1){
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param tablero
     * @return tablero de ajedrez despues de mover la ficha, dependiendo de nuestro "indice"
     */
    public static int [] moverTablero(int [] tablero){        
        if(tablero[indice] == tablero.length-1 && indice != 0){
            tablero[indice] = 0;
            indice = indice -1;
            moverTablero(tablero);
        }else{
            if(tablero[indice] != tablero.length-1 && indice != tablero.length-1 && justAdded){
                tablero[indice] = tablero[indice]+1;
                indice = tablero.length-1;
                justAdded= false;
                return tablero;
            }else{
                tablero[indice] = tablero[indice] +1;
                justAdded = true;
                return tablero;
            }
        }
        return tablero;
    }
    
    /**
     * 
     * @param tablero
     * @return valida la solucion del tablero
     */
    public static boolean correcto(int [] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0; j < tablero.length; j++){
                int uno = Math.abs(tablero[i] + i);
                int dos = Math.abs(tablero[j]+ j);
                int tres = tablero[i] - i;
                int cuatro = tablero[j] - j;
                if(tablero[i] == tablero[j] && j != i){return false;}
                if((uno == dos || tres == cuatro) && i!= j){return false;}                
                if(malos[i][tablero[i]]== -1){return false;}
            }
        }
        return true;
    }
    
    
    public static void imprimir(int [] tablero){
        for(int i = 0; i< tablero.length; i++){
            for(int j = 0; j< tablero.length; j++){
                if(tablero[j] == i){
                    System.out.print("| Q |");
                }else{
                    System.out.print("| X |");
                }
                if(j == tablero.length -1){System.out.println();}
            }
        }
        System.out.println();
        System.out.println();
    }
    
    public static void imppr(){
        for(int i = 0 ; i< malos.length; i++){
            for(int j = 0; j<malos.length;j++){
                System.out.print("|"+malos[i][j] + "|");
            }
            System.out.println();
        }
    }
}