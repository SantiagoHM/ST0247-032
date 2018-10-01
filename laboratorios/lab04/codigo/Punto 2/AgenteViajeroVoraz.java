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
public class AgenteViajeroVoraz {

    public static int AVvoraz(int n, int d, int r, int [] dia, int [] noche){
        int minimoPagar= 0;
        for(int i=0;i<n;i++){
            int aux = dia[i] + noche[i];
            int horasExtra = aux - d;
            minimoPagar = minimoPagar + (horasExtra *r);
        }
        return minimoPagar;
    }
    
}
