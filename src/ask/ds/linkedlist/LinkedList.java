package ask.ds.linkedlist;

public class LinkedList
{
	Node head;
	
	// Add new value to last position
	public void append(int data)
	{
		if(head == null)
		{
			head = new Node(data);
			return;
		}
			
		Node current = head;
		
		while(current.next != null)
		{
			current = current.next; // find the position of last node == null 
		}
		
		current.next = new Node(data); // add new node
	}
	
	// Add new value to first position
	public void prepend(int data)
	{
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	// Delete
	public void delete(int data)
	{
		if(head == null)
			return;
		
		// delete in 1st element(head)
		if(head.data == data)
		{
			head = head.next;
			return;
		}
		
		Node current = head;
		
		while(current.next != null)
		{
			if(current.next.data == data) // current -> current.next(data) -> current.next.next
			{
				current.next = current.next.next;
				return;
			}
			
			current = current.next; // position of pointer
		}
		
		
	}
}
