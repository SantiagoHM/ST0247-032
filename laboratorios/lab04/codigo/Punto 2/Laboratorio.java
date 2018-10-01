/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Labrador
 */
public class Laboratorio {
    
    public static void main(String [] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("All the input data must be separated by one space \n The input Data can´t be finished with an space");
        System.out.println("Enter n, d, r");
        String ndr = br.readLine();        
        System.out.println("Enter Day routine hours");
        String dayRoutine = br.readLine();
        System.out.println("Enter night routine hours");
        String nightRoutine = br.readLine();
        
        int [] auxNDR = convertirArrayNDR(ndr);
        int aux = auxNDR[0];
        int [] day =convertirArray(dayRoutine, aux);
        int [] night =convertirArray(nightRoutine, aux);
                
        int rta =AgenteViajeroVoraz.AVvoraz(auxNDR[0], auxNDR[1], auxNDR[2], day, night);
        System.out.println(rta);
    }
    public static int [] convertirArrayNDR(String str){
        String aux = "";
        int ingreso = 0;
        int indice=0;
        int [] retorno = new int[3];
        for(int i= 0; i<str.length(); i++){
            if(str.charAt(i)!= ' '){
                aux += str.charAt(i);
            }else{                
                ingreso = Integer.parseInt(aux);
                retorno[indice]= ingreso;
                aux = "";
                indice++;                
            }
        }
        ingreso = Integer.parseInt(aux);
        retorno[indice]= ingreso;
        
        return retorno;
    }
    public static int [] convertirArray(String str, int aux){
        
        String temp = "";
        int ingreso = 0;
        int indice=0;
        int [] retorno = new int[aux];
        for(int i= 0; i<str.length(); i++){
            if(str.charAt(i)!= ' '){
                temp += str.charAt(i);
            }else{
                
                ingreso = Integer.parseInt(temp);
                retorno[indice]= ingreso;
                temp = "";
                indice++;
                
            }
        }
        ingreso = Integer.parseInt(temp);
        retorno[indice]= ingreso;
        
        return retorno;
    }
    
    public static void Imprimir(int [] arr){
        System.out.print("[");
        for(int i = 0; i<arr.length;i++){
            if(i == arr.length-1){System.out.print(arr[i]);}else{
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }
}
