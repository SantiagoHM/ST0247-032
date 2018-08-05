import java.util.ArrayList;
//codigo tomado de fjaram18
public class DigraphAM extends Digraph {
    
    private int [][] Matriz_AD;
    
    public DigraphAM(int size){
        super(size);
        this.Matriz_AD = new int [size][size]; 
    }
    
    
    /**
     * 
     * @param origen
     * @param destino 
     * @param peso
     */
    public void addArc(int origen, int destino, int peso){
        this.Matriz_AD[origen][destino] = peso;
    }
    
    /**
     * 
     * @param origen
     * @param destino
     * @return peso del arco entre el vertice origen y el vertice destino
     */
    public int getWeight(int origen, int destino){
        return this.Matriz_AD[origen][destino];
    }
    
    /**
     * 
     * @param vertice
     * @return vertices que tienen conexion o arista con el vertice parametro
     */
    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> sucesors = new ArrayList<>();
        
        for(int i = 0; i < this.Matriz_AD.length; i++){
            if(this.Matriz_AD[vertice][i] != 0){
            sucesors.add(i);
            }
        }
        return sucesors;
    }
}
