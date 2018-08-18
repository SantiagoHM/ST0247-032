/*Base codigo para Buscar y Tablero tomado de blog apuntes y algoritms de programacion 2010
 * 
 * 
 * 
 */
import java.util.Random;
import java.util.Scanner;
public class PUNTO1 {
    static Scanner entrada = new Scanner(System.in);
    final int Reinas;
    int[]   tablero;
    int     puestas=0;
 
    public PUNTO1(int R) {
        Reinas    = R;
        tablero     = new int[R];
        for(int i=0; i<tablero.length; i++) tablero[i]=-1;
    }
    //CREA TABLERO
    public void Tablero() {
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero.length; j++) {
                if(tablero[i]==j) System.out.printf("  %2d  |", tablero[i]+1);
                else System.out.printf("      |");
            }
            System.out.println();
            for(int j=0; j<tablero.length; j++) System.out.print("------+");
            System.out.println();
        }
        System.out.println();
    }
    //COLOCA
    public boolean Poner(int fila, int columna) {
        //Tablero();
        tablero[fila]=columna;
        puestas++;
        if(puestas==Reinas) return true;
        int[] posibles = Buscar(fila+1);
        for(int c: posibles) {
            if(Poner(siguienteFila(), c)) return true;
        }
        tablero[fila]=-1;
        puestas--;
        return false;
    }
    
    public int siguienteFila() {
        for(int i=0; i<tablero.length; i++) if(tablero[i]==-1) return i;
        return -1;
    }
    //BUSCA POSIBLES UBICACIONES
    int[] Buscar(int num) {
        int[] resp = new int[Reinas];
        int pos=Reinas;
        for(int i=0; i<resp.length; i++) resp[i]=i;
        for(int i=0; i<Reinas; i++) {
            if(tablero[i]!=-1) {
                resp[tablero[i]]=-1;
                pos--;
            }
        }
        for(int i=0; i<resp.length; i++) {
            if(resp[i]==-1) continue;
            for(int j=0; j<num; j++) {
                double fabs = Math.abs((num-j)*1.0/(resp[i]-tablero[j]));
                if(fabs==1.0 && resp[i]!=-1) {
                    resp[i]=-1;
                    pos--;
                    break;
                }
            }
        }
        int[] tmp = new int[pos];
        int i=0;
        for(int x: resp) if(x!=-1) tmp[i++] = x;
        return tmp;
    }
 
    public static void main(String[] args) {
        System.out.print("numero de reinas: ");
        int Reinas =entrada.nextInt();
        System.out.println();
        PUNTO1 pr = new PUNTO1(Reinas);
        pr.Poner(0,0);
        pr.Tablero();
   }
}