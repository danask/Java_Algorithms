package ask.ds.tree;

import java.util.LinkedList;
import java.util.Queue;


enum State
{
	Unvisited, Visited, Visiting
}



class Graph 
{
	public static int MAX_VERTICES = 6;
	private GNode vertices[];
	public int count;
	
	public Graph() 
	{
		vertices = new GNode[MAX_VERTICES];
		count = 0;
	}
	
	public void addNode(GNode x) 
	{
		if (count < vertices.length) 
		{
			vertices[count] = x;
			count++;
		} 
		else 
		{
			System.out.print("Graph is full");
		}
	}
    
	public GNode[] getNodes() {
		return vertices;
	}
}


class GNode 
{
	    private GNode adjacent[];
	    public int adjacentCount;
	    private String vertex;
	    public State state;

	    public GNode(String vertex, int adjacentLength) 
	    {
	        this.vertex = vertex;                
	        adjacentCount = 0;        
	        adjacent = new GNode[adjacentLength];
	    }
	    
	    public void addAdjacent(GNode x) 
	    {
	        if (adjacentCount < adjacent.length) 
	        {
	            this.adjacent[adjacentCount] = x;
	            adjacentCount++;
	        } 
	        else 
	        {
	            System.out.print("No more adjacent can be added");
	        }
	    }
	    public GNode[] getAdjacent() {
	        return adjacent;
	    }
	    public String getVertex() {
	        return vertex;
	    }
	}




public class CheckGraphRoute
{
	public static boolean checkGraph(Graph g, GNode start, GNode end)
	{
		// queue as a LinkedList
		LinkedList<GNode> queue = new LinkedList<GNode>();
		
		// INIT
		for(GNode u : g.getNodes())  // vertex
		{
			u.state = State.Unvisited;
		}
				
		// Start!		
		start.state = State.Visiting;
		queue.add(start);
		
		GNode gNode;
		
		while(!queue.isEmpty())
		{
			gNode = queue.removeFirst(); // dequeue
			
			if(gNode != null)
			{
				for(GNode v : gNode.getAdjacent())
				{
					if(v.state == State .Unvisited)
					{
						if(v == end)
							return true;
						else
						{
							v.state = State.Visiting;
							queue.addLast(v);          // enqueue
						}
					}
				}
				
				gNode.state = State.Visited;
			}
		}
		
		return false;
	}
	
	
	
	// a -> b, c, d -> e -> f
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		GNode[] temp = new GNode[6];

		temp[0] = new GNode("a", 3);
		temp[1] = new GNode("b", 0);
		temp[2] = new GNode("c", 0);
		temp[3] = new GNode("d", 1);
		temp[4] = new GNode("e", 1);
		temp[5] = new GNode("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}	
	
	public static void main(String[] args)
	{
		Graph g = createNewGraph();
		GNode[] n = g.getNodes();
		
		GNode start = n[3];
		GNode end = n[5];
		
		// d to f
		System.out.println("start - end : "+ start.getVertex() +" - " + end.getVertex() + " ? " + checkGraph(g, start, end));
		
		// f to a
		System.out.println("start - end : "+ n[5].getVertex() +" - " + n[0].getVertex() + " ? " + checkGraph(g, n[5], n[0]));
		
		// a to f
		System.out.println("start - end : "+ n[0].getVertex() +" - " + n[5].getVertex() + " ? " + checkGraph(g, n[0], n[5]));
		
		
	}

}


//void search(Node root)
//{
//	Queue<E> queue = new Queue();
//	root.visited = true;
//	visit(root);
//	queue.enqueue(root);
//	
//	while(!queue.isEmpty())
//	{
//		Node r = queue.dequeue();
//		foreach(Node n in r.adjacent)
//		{
//			if(n.visited == false)
//			{
//				visit(n);
//				n.visited = true;
//				queue.enqueue(n);
//			}
//		}
//	}
//	
//	
//	
//}

