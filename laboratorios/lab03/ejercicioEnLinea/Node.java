//tomado de https://java2blog.com/depth-first-search-in-java/
import java.util.List;
import java.util.ArrayList;
public class Node
	{
		int data;
		boolean visited;
		List<Node> neighbours;
 
		Node(int data)
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}
		public List getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List neighbours) {
			this.neighbours = neighbours;
		}
	}