/**
 * Clase en la cual se implementan los metodos del Taller de Clase #8
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller8 {

public static int [] mergesort(int[] a) {
                int [] left,right;
                int mitad =0;
            
                if(a.length <=1){return a;}
                
                if(a.length%2==0){
                    mitad = a.length/2;
                    left = new int [mitad];
                    right = new int [mitad];
                }else{
                    mitad = (a.length + 1)/2;
                    left = new int [mitad];
                    right = new int [mitad-1];
                }
                
		
		
		for(int i = 0; i<left.length;i++){
			left[i]= a[i];                        
                }
                for(int i = 0; i<right.length;i++){
                    right[i]=a[mitad+i];
                }
                int [] aux = mergesort(left);
		int [] aux2 = mergesort(right);

                
                
                return merge(aux, aux2);
		
	}
	public static int [] merge(int [] a, int [] b){
		int [] result = new int [a.length + b.length];
		for(int i = 0; i<result.length-1; i++){
			if(a[i]<b[i+1]){
				result[i]=a[i];
				result[i+1] = b[i+1];
			}else{
				result[i+1]=a[i];
				result[i] = b[i+1];
			}
		}
		return result;
	}

	public static void quicksort(int[] a) {
		// complete...
	}

}
