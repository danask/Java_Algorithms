package ask.ds.linkedlist;



class LinkedListNodes
{
	public LinkedListNodes next;
	public LinkedListNodes prev;
	public LinkedListNodes last;
	public int data;
	
	
	public LinkedListNodes(int d, LinkedListNodes n, LinkedListNodes p) 
	{
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNodes(int d) 
	{
		data = d;
	}	
	
	public void setNext(LinkedListNodes n) 
	{
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNodes p) 
	{
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
}


public class ReturnKth
{
	// 1st
	public static int printKth(LinkedListNodes node, int k) 
	{
		if (node == null)
			return 0;
		
		int index = printKth(node.next, k) + 1;
		
		if (index == k) 
			System.out.println(k + "th node is " + node.data);
		
		return index;
	}
	
	
	// 4th
	public static LinkedListNodes nthToLast(LinkedListNodes node, int k) 
	{
		LinkedListNodes p1 = node;
		LinkedListNodes p2 = node;
		
		/* Move p1 k nodes into the list.*/
		for (int i = 0; i < k - 1; i++) 
		{
			if (p2 == null) 
				return null; // Out of bounds
			
			p2 = p2.next;
		}
		
		if(p2 == null)
			return null;
		
		
		/* Move them at the same pace. When p2 hits the end, 
		 * p1 will be at the right element. */
		
		while (p2.next != null) 
		{
			p1 = p1.next;
			p2 = p2.next;
	  	}
		
	  	return p1;
	}
		

	// default
	public static LinkedListNodes createLinkedListFromArray(int[] vals) 
	{
		// init
		LinkedListNodes node = new LinkedListNodes(vals[0], null, null);
		
		LinkedListNodes current = node;
	
		// save current data with previous data
		for (int i = 1; i < vals.length; i++) 
		{
			current = new LinkedListNodes(vals[i], null, current);
		}
		return node;
	}	
	
	
	public static void main(String[] args) 
	{
		int[] array = {1, 2, 3, 4, 5, 6};
		
		LinkedListNodes arrayNode = createLinkedListFromArray(array);
												
		//AssortedMethods.createLinkedListFromArray(array);
		
		for (int i = 0; i <= array.length; i++) 
		{
			printKth(arrayNode, i);
			
			
			LinkedListNodes node = nthToLast(arrayNode, i);
			
			if(node != null)
				System.out.println(i + ": " + node.data);
			
//			LinkedListNode node = nthToLast0(head, i);
//			String nodeValue = node == null ? "null" : "" + node.data;
//			System.out.println(i + ": " + nodeValue);			
		}
	}
}




//public static LinkedListNode nthToLast(LinkedListNode head, int k) 
//{
//	LinkedListNode p1 = head;
//	LinkedListNode p2 = head;
//	
//	/* Move p1 k nodes into the list.*/
//	for (int i = 0; i < k; i++) {
//		if (p1 == null) return null; // Out of bounds
//		p1 = p1.next;
//	}
//	
//	/* Move them at the same pace. When p1 hits the end, 
//	 * p2 will be at the right element. */
//	while (p1 != null) {
//		p1 = p1.next;
//		p2 = p2.next;
//  	}
//  	return p2;
//}	
//



/*
 // 0, 1, 2, 3, 4 (index)

// 1-> 2 ->3 ->4 ->5...

// 5, 4, 3, 2, 1st(k)

//   P1 <---> P2    last one

//Class name must be "Main"

class Main 
{
 public static int search(LinkedList node, int k)
 {
     // 1st approach
     int index = search(node.next, k) + 1;
     
     // 1th is 5, 2th is 4...
     if(index == k)
         System.out.println(k + "th is " + node.data);
     
     return index;
     
     
     // 2nd approach
     LinkedList firstPointer = node;
     LinkedList secondPointer = node;     
     
     
     // move k times
     for(int i = 0; i < k - 1; i++)
     {
         if(secondPointer == null)
             return;
         
         secondPointer = secondPointer.next;
     }
     
     while(second.next != null)
     {
          firstPointer = firstPointer.next;   
          secondPointer = secondPointer.next;
     }
     
     return first;
 }
 
 
 
     
  public static void main(String[] args) 
  {
      int[] array = {1,2,3,4,5};
      
      
      // set the given array to LinkedList
      LinkedList arrayNode = createLinkedList(array);
      
      
      
      for(int i = 0; i <= array.length; i++)
      {
          // 1st : search recursively
          search(arrayNode, i);
          
          
          // 2nd : iteratively
          //LinkedList node = search(arrayNode, i);
          
          System.out.println(i + ": "+ search(arrayNode, i).data);
         
      }
 
  }
}
*/