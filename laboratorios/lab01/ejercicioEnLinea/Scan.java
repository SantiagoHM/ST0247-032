
package punto2;
//Importadors
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Scan {
    
    public static ArrayList<Grafo> leer(String h) throws FileNotFoundException{
        File documt = new File(h);
        Scanner entrada = new Scanner(documt); //Uso de Scanner para leer el archivo.
        
        ArrayList<Grafo> lista = new ArrayList<>();
        
        //Mientras que haya una siguente línea
        while(entrada.hasNextLine()){
            String linea = entrada.nextLine(); //Ser{a la siguiente linea
            Scanner n_linea = new Scanner(linea);
            
            int nodos = entrada.nextInt();
            if(nodos == 0){ //Si es igual a 0
                break;      //sale del ciclo
            }
            //Nuevo grafo
            Grafo grafo = new Grafo(nodos); 
            
            linea = entrada.nextLine(); 
            n_linea = new Scanner(linea);
            
            int camino = n_linea.nextInt();
            for (int k = 0; k < camino; k++) {
                linea = entrada.nextLine();
                n_linea = new Scanner(linea);
                grafo.linea(n_linea.nextInt(),n_linea.nextInt());
                
            }
            lista.add(grafo);
        }
        return lista;
    }
    
}
