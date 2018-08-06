
package punto2;
//Importado
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.FileNotFoundException;


public class Punto2 {

    //Método principal
    public static void main(String[] args) {
       //Try y catch por is no se encuentra el archivo
        try{ punto_2();
       
       } catch(FileNotFoundException e){
           e.printStackTrace();
       }
    }
    
    
    public static void punto_2()throws FileNotFoundException{
        ArrayList<Grafo> c = Scan.leer("ejercicioEnLinea/prueba.txt"); //Archivo de Prueba dado por el docente
        
            //
            boolean bicolor = true; 
            
            //Ciclo para determinar el color de los nodos
            for (Grafo grafo : c) {
            bicolor = true;
            int color_temp = -1; // esto significa qu eno hay conexión. Usualmente se representa con numero smuy grande so con -1
                for (Nodo nodo : grafo.nodos) {
                    if(nodo.color == 0) 
                        nodo.color = color_temp; //Siendo el color temporal
                        color_temp = nodo.color * -1; //Sino volvería a ser -1. 
                    
                    
                    for (Nodo primer_nodo : nodo.vertice){
                        if(primer_nodo.color == nodo.color){
                            bicolor = false;
                            break;
                        }
                        if(primer_nodo.color == 0) primer_nodo.color = color_temp;
                        
                    }
                    if(!bicolor){
                        break;
                    }
                }
                //Impresi{on de si es o no es BICOLORABLE
                if (bicolor){
                    System.out.println("BICOLORABLE");
                }else{
                    System.out.println("NOT BICOLORABLE");
                }
        }
    }
    
}
