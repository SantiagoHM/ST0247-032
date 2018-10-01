import java.util.Stack;

public class TSP
{
  public void tsp(int adjacencyMatrix[][]) {
      Stack<Integer> stack = new Stack<Integer>();
      int numberOfNodes = adjacencyMatrix[1].length - 1;
      int[] visited = new int[numberOfNodes + 1];
      visited[1] = 1;
      stack.push(1);
      int element, dst = 0, i;
      int min = Integer.MAX_VALUE;
      boolean minFlag = false;
      System.out.print(1 + "\t");
      while (!stack.isEmpty()) {
       element = stack.peek();
       i = 1;
       min = Integer.MAX_VALUE;
       while (i <= numberOfNodes) {
             if (adjacencyMatrix[element][i] > 0 && visited[i] == 0) {
                if (min > adjacencyMatrix[element][i]) {
                    min = adjacencyMatrix[element][i];
                    dst = i;
                    minFlag = true;
                }
             }
             i++;
       }
       if (minFlag) {
         visited[dst] = 1;
         stack.push(dst);
         System.out.print(dst + "\t");
         minFlag = false;
         continue;
         }
       stack.pop();
    }
  }
}