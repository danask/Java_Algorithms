package ask.ds.stack;




// 1 -> 2 -> 3
// top: 3

public class Stack
{
	public LinkedListNode top;

	// PEEK
	public Object peek()
	{
		return top.data;
	}

	// PUSH
	public void push(int item)
	{
		LinkedListNode newItem = new LinkedListNode(item);
		newItem.next = top;  // last node's next become top 
		top = newItem;
	}
	
	// POP
	public Object pop()
	{
		if(top != null)
		{
			Object item = top.data;
			top = top.next;
			
			return item;
		}
		return null;
	}
	
	
	
	
}
