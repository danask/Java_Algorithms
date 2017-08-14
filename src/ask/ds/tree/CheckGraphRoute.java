package ask.ds.tree;

import java.util.LinkedList;
import java.util.Queue;


enum State
{
	Unvisited, Visited, Visiting
}



// Adjacency list per a vertex

class GNode 
{
	    private GNode adjacent[];
	    public int adjacentCount;
	    private String vertex;
	    public State state;

	    // Constructor
	    public GNode(String vertex, int adjacentLength) // a, 3
	    {
	        this.vertex = vertex;                
	        adjacentCount = 0;        
	        adjacent = new GNode[adjacentLength];
	    }
	    
	    //  OP
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
	    
	    public GNode[] getAdjacent() 
	    {
	        return adjacent;
	    }
	    
	    public String getVertex() 
	    {
	        return vertex;
	    }
}


// Overall GNodes -> Graph

class Graph 
{
	public static int MAX_VERTICES = 6;
	
	private GNode vertices[];  // associated property
	public int count;
	
	// Constructor
	public Graph() 
	{
		vertices = new GNode[MAX_VERTICES];
		count = 0;
	}
	
	//  OP	
	public void addNode(GNode x) 
	{
		if (count < vertices.length) // 6
		{
			vertices[count] = x;
			count++;
		} 
		else 
		{
			System.out.print("Graph is full");
		}
	}
    
	 // associated op : intersection
	public GNode[] getNodes() 
	{
		return vertices; // the list of nodes 
	}
}




public class CheckGraphRoute
{
	
	// Check
	public static boolean checkGraph(Graph g, GNode start, GNode end)
	{
		
		// 1. INIT
		// Create queue as a LinkedList(by Java class)
		LinkedList<GNode> queue = new LinkedList<GNode>();
		
		// initialize for the whole nodes
		for(GNode x : g.getNodes())  // GNode <- Graph  // put vertex in Graph into node(Class(array)) 
		{
			x.state = State.Unvisited;  
		}

	
		// 2. enqueue 1st value		
		start.state = State.Visiting;
		queue.add(start);
		
		
		// 3. dequeue & enq. with next
		GNode gNode;
		
		while(!queue.isEmpty())
		{
			gNode = queue.removeFirst(); // dequeue : 'a'
			
			if(gNode == null)
				return false;
				
			for(GNode y : gNode.getAdjacent())  // array of adjacent[a]
			{
				if(y.state == State .Unvisited) // b, c, d
				{
					if(y == end)
						return true;
					
					y.state = State.Visiting;
					queue.addLast(y);          // enqueue
				}
			}
			
			gNode.state = State.Visited;
		}
		
		return false;
	}
	// a(v'ed) - b(v'ing), c(v'ing), d(v'ing)
	
	
	
	
	// a[0] -> b, c, d[3] -> e[4] -> f[5]
	
	public static Graph createNewGraph()
	{
		int MAX_VERTICES = 6;
		
		Graph g = new Graph();        
		GNode[] temp = new GNode[MAX_VERTICES];

		// Create several GNodes
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
		
		
		// Make graph with GNodes
		for (int i = 0; i < MAX_VERTICES; i++) 
		{
			g.addNode(temp[i]);
		}
		
		return g;
	}	
	
	
	
	public static void main(String[] args)
	{
		// Create Graph
		Graph g = createNewGraph();
		
		// TempArray for vertexes
		GNode[] n = g.getNodes();
		
		
		// Check
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


/*
// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
// Use BFS for finding out route like the shortest path...

// a -> b
//   -> c -> d

// Graph, Node

enum State {Visited, Unvisted, Visiting}

class Node{
    public String vertex;
    public State state;

    // set/get
    add/getAdjacentElement()

}

class Graph
{
    //list of nodes
    getNodes();

}


// boolean : true, false

public boolean checkRoute(Graph graph, Node firstNode, Node lastNode)
{
    LinkedList<Node> queue = new LinkedList<Node>();

    // enqueue
    queue.add(firstNode);
    firstNode.state = State.Visited;
    
    
    // dequeue
    
    Node tempNode ;
    
    while(!queue.isEmpty())
    {
        tempNode = queue.removeFirst();
    
        if(tempNode == null) return false;
        
        for(Node x : tempNode.getAdjacentElement())
        {
            if(x.state == State.Visited)
                continue;
                
                
            if(x == lastNode)
                return true;;
                
            if(x.state == State.UnVisited)
            {
                x.state = State.Visiting;
                
                queue.addList(x);
            }
        }
             tempNode.state = State.Visited;
    }
    return false;
}


public void main()
{
    // initialize
    createNode and Graph;
    
    
    for(Node node : g.getNodes)
    {
        node.state = State.Unvisited;
    }

    checkRoute(graph, firstNode, lastNode);

}
 
  
 */

