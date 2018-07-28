
package taller2;

  import java.util.ArrayList;

public class Taller2 {

        //Punto 1
	public static ArrayList<String> combinations(String s) {
		ArrayList<String> lista = new ArrayList<String>();
                
                combinations(" ", s, lista);
                return lista;
	}

	// Punto 1
	private static void combinations(String pre, String pos, ArrayList<String> lista) {
		//Llamado recursivo
                if(pos.length()==0)
                    lista.add(pre);
                else
                combinations(pre+pos.charAt(0), pos.substring(1), lista);
                combinations(pre, pos.substring(1), lista);
	}

        /*
            if(hijo.length()==0){
                System.out.println(papa);
            }else{
                Punto2(papa+hijo.charAt(0), hijo.substring(1));
             Punto2(papa,hijo.substring(1));
            }
     
        }
        
        
        */
        //Punto 2
	public static ArrayList<String> permutations(String s) {
		ArrayList<String> mix = new ArrayList <String> ();
                permutations(s, "", mix);
                return mix;
	}

	//Punto 2
	private static void permutations(String pre, String pos, ArrayList<String> lista) {
		if(pos.length() ==0){
                    lista.add(pre);
                }
                else{
                    for (int k = 1; k < pos.length()-1; k++) {
                        permutations( pos.charAt(1) + pre, pos.substring(0,k)+pos.substring(1+k),lista);
                    }
                }
	}

	public static void imprimirTablero(int[] tablero) {
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[i] == j ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}

        /*
	public static boolean esValido(int[] tablero) {
		// complete...
	}

	public static int queens(int n) {
		// complete...
	}
*/
        //Main Method
        public static void main(String args[]){
            ArrayList<String> lista = permutations("Prueba"); 
        }

}
    

