//tomado de https://java2blog.com/depth-first-search-in-java/
import java.util.List;
import java.util.Stack;

class DFS
{
    	public  void dfsUsingStack(Node node)
	{
		Stack<Node> stack=new  Stack<Node>();
		stack.add(node);
		node.visited=true;
		while (!stack.isEmpty())
		{
			Node element=stack.pop();
			System.out.print(element.data + " ");
 
			List<Node> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					stack.add(n);
					n.visited=true;
 
				}
			}
		}
	}
}

