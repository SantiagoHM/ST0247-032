public class TALLER6 {
    public static int[] devueltauelta(int n, int []tiposM){
        int[] devuelta = new int[tiposM.length];
        for(int i = 0; i < tiposM.length; i++){
            if(n-tiposM[i] >= 0){
                n = n-tiposM[i];
                devuelta[i]+=1;
                i=-1;
            }
        }
        for(int i=0;i<devuelta.length;i++) {
        System.out.println(devuelta[i] + "  monedas de " +tiposM[i]);}
        return devuelta;
    
}
}
    