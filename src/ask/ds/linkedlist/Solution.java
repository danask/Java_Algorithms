package ask.ds.linkedlist;

import java.util.Scanner;


class ListNode 
{
	int data;
	ListNode prev;
	ListNode next;
	static int size;
	
	public ListNode()
	{
		data = 0;
		prev = this;
		next = this;
	}

	public static ListNode appendListNode(ListNode head, int data)
	{
		ListNode node = new ListNode();
		node.data = data;
		
		size++;
		
		if (head == null)
		{
			head = node;
		}
		else 
		{
			ListNode last = head.prev;
			last.next = node;
			head.prev = node;
			node.prev = last;
			node.next = head;
		}
		return head;
	}
	
	public static ListNode removeListNode(ListNode head, ListNode node)
	{
		size--;		
		
		if (head == head.next)
		{
			return null;
		}
		else 
		{
			ListNode prevNode = node.prev;
			ListNode nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			return (head == node) ? nextNode : head;
		}
		
	}
	
	public static ListNode printListNode(ListNode head, ListNode node)
	{
		if (head == head.next)
		{
			return null;
		}
		else 
		{
			ListNode prevNode = node.prev;
			ListNode nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			return (head == node) ? nextNode : head;
		}
		
	}
	
	public static int getSize()
	{
		return size;
	}
}


//////////////////////////////////////

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 1;//sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			ListNode head = null;
			int N = 5; //sc.nextInt();
						
			
			for (int i = 1; i <= N; i++)
			{
				int data = i; //sc.nextInt();
				
				// append
				head = ListNode.appendListNode(head, data);
			}
			ListNode node = head;
			
			// LOGIC

			// get List
			for(int i = 1; i <= ListNode.getSize(); i++)  // temp !!!!!!!!!!!!!!!!!!
			{
				System.out.printf("%d\n", node.data);
				
				node = node.next;
			}
//			System.out.printf("%d ", ListNode.printListNode(head, node));
//			System.out.println("");

			
			// remove data
			
			while(head != head.next)
			{
				ListNode nextNode = node.next;
				head = ListNode.removeListNode(head, node);
				node = nextNode.next.next;
			}

			
			
			
			// delete with 2 intervals
//			ListNode node = head;
//			while(head != head.next)
//			{
//				ListNode nextNode = node.next;
//				head = ListNode.removeListNode(head, node);
//				node = nextNode.next.next;
//			}
			
			System.out.printf("#%d %d\n", test_case, head.data);
			
			
		}
		sc.close();
	}
}