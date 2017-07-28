package ask.ds.linkedlist;

public class DataStructure 
{
	/*
	
	public static void printNodeList(Node list)
	{
		Node nodeList = list;
		
		while(nodeList !=null)
		{
			System.out.println(nodeList);
			nodeList = nodeList.next; // node++
		}
		System.out.println();
	}

	// APPEND for Node
	public static void appendNode(Node list, Node newNode)
	{
		Node nodeList = list;
		
		while(nodeList !=null)
		{
			if(nodeList.next == null)
			{
				nodeList.next = newNode;
				break;
			}
			nodeList = nodeList.next;
		}
	}

	// APPEND for number
	public static void appendNode(Node list, int newNumber)
	{
		Node nodeList = list;
		Node newNode = new Node(newNumber, null);
		
		while(nodeList !=null)
		{
			if(nodeList.next == null)
			{
				nodeList.next = newNode;
				break;
			}
			nodeList = nodeList.next;
		}
	}	
	
	
	public static void deleteNode(Node list, int number)
	{
		Node nodeList = list;
		
		while(nodeList !=null)
		{
			if(nodeList.next.cargo == number)
			{
				nodeList.next = nodeList.next.next; // current.next(2) -> next.next(4)
				nodeList.next.next = null;  // next.next(null)
				break;
			}
			nodeList = nodeList.next;
		}		
	}
	
	
	
	public static void main(String[] args) 
	{
		System.out.println("--------- DS : Linked List ----------");	
		
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, null);

		node1.next = node2;
		
		Node node3 = new Node(3, null);

		
		// Print
		printNodeList(node1);
		
		// Append
		System.out.println("--------- Append ----------");			
		appendNode(node1, node3);
		appendNode(node1, 4);
		
		// Print
		printNodeList(node1);

		// Remove
		System.out.println("--------- Remove ----------");		
		deleteNode(node1, 3);
		printNodeList(node1);
		
		
	}
	*/
}
