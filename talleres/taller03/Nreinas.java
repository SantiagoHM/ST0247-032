/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

/**
 *
 * @author Labrador
 */
public class Nreinas {
//    
    public static void main(String [] args){
        nReinas(4);
    }

    private static boolean puedoPonerReina(int fila, int columna, int[] tablero) {
        boolean retorno = true;
        
        for(int i = 0; i<tablero.length;i++){
            for(int j= 0; j<tablero.length; j++){
                if(tablero[i] == tablero[j] && i !=j && tablero[i]!= -1){                    
                    return false;
                }
            }
            
            
            int diag = tablero[i] + i;
            int diag2 = Math.abs(i-tablero[i]);
            
            boolean art = columna == i && tablero[i]!= -1;
            if(art){continue;}
            
            if((Math.abs(fila - columna) == diag2 || columna + fila == diag)){
                return false;                 
            }else{                
                return true;
            }
            
            
        }
//            imprimirTablero(tablero);
//            System.out.print(retorno + "  ");
            return retorno;
	}
	
	public static int nReinas(int n) {
		int [] tablero = new int [n];
                for(int i = 0; i<tablero.length;i++){
                    tablero[i]= -1;
                }
                return nReinas(0, n, tablero);                
	}
        
        public static int [] llenar(int [] tablero){
            for(int i = 1; i<tablero.length;i++){
                    tablero[i]= -1;
                }
            return tablero;
        }
	
	private static int nReinas(int columna, int reinas, int[] tablero) {
            imprimirTablero(tablero);
            int soluciones= 0;
            if(tablero[0]== reinas-1 ){return 0;}   
            if(columna >= reinas){return 0;}
            tablero[columna] = tablero[columna]+1;
            if(columna == 3){tablero[columna] = 2;imprimirTablero(tablero);return 0;}
            boolean pr = puedoPonerReina(tablero[columna], columna, tablero);
            
            if(pr){
                
                if(columna != reinas-1){                          
                    soluciones = nReinas(columna+1, reinas, tablero);
                }else{
                    soluciones = 1 + nReinas(columna+1,reinas,tablero);
                }
            }else{
                
                if(columna != reinas-1){
                    soluciones = nReinas(columna, reinas, tablero);
                }else{
                    if(tablero[reinas-1]==reinas-1){
                        tablero[0]= tablero[0]+1;
                        llenar(tablero);
                        nReinas(1, reinas, tablero);
                    }else{                        
                        soluciones = nReinas(columna, reinas, tablero);
                    }
                }
            }
            return soluciones;
	}
	
        public static void imprimirTablero(int[] tablero) {
//            for(int i = 0; i<tablero.length; i++){
//                System.out.print(tablero[i]);
//            }System.out.print("|||||||");
            
            
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[j] == i ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}
}
