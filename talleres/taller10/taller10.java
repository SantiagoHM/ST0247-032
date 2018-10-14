import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/*
Codigo base tomado de lawebdelprogramador.com analizado y modificado para retornar subsecancia comun mas larga y su longitud
*/
 
class taller10 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
		String cadena;
		while ((cadena = in.readLine()) != null) {
 
			String array[] = cadena.split(" ");
			int n = array[0].length() > array[1].length() ? array[0].length() : array[1].length();
 
			// Llenar la matriz según las letras comunes
			int[][] matrix = new int[n][n];
			for (int i = 0; i < array[0].length(); i++)
				for (int j = 0; j < array[1].length(); j++)
					if (array[0].charAt(i) == array[1].charAt(j))
						matrix[i][j]++;
 
			// Encontrar la subsecuencia común más larga
			String Repetida = "";
			for (int i = 0; i < matrix.length >> 1; i++) {
				String nuevo = "";
				for (int j = i, restriccion = -1; j < matrix.length; j++)
					for (int k = 0; k < matrix.length; k++)
						if (matrix[j][k] == 1 && restriccion < k) {
							nuevo += array[0].charAt(j);
							restriccion = k;
							break;
						}
				if (Repetida.length() < nuevo.length())
					Repetida = nuevo;
			}
 
			System.out.println(Repetida + "," + Repetida.length());
		}
	}
 
}