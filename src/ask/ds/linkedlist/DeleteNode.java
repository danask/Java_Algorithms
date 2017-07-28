package ask.ds.linkedlist;

import java.util.HashSet;

public class DeleteNode
{
	// HashSet: O(n)
	// 1   2   1   2   3
	// ok ok ng ng ok
	
	public static void deleteDuplicatesWithHashSet(LinkedListNode node)
	{
		HashSet<Integer> set = new HashSet<Integer>(); 
		// do not allow same data and order  cf. HashMap
		
		LinkedListNode previous = null;
		
		while (node != null)
		{
			if (set.contains(node.data))
			{
				previous.next = node.next;
			} 
			else
			{
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}

	
	// Two Pointers: O(n^2)
	// 1  2  1  2  3
	// 1  2      2  3 (1st)
	// 1  2          3 (2nd)
	
	public static void deleteDuplicatesWithPointers(LinkedListNode node)
	{

		if(node == null) return;
				
		LinkedListNode current = node;
		
		while (current != null)
		{
			LinkedListNode checkNode = current;			
			
			while(checkNode.next != null)
			{
				if(current.data == checkNode.next.data)
				{
					checkNode.next = checkNode.next.next; // skipped(remove): 1 2 () 2 
				}
				else
				{
					checkNode = checkNode.next; // normal case: ...2 3
				}
			}
			current = current.next;
		}	
	}
	
	
	// deleteInDesignatedNode
	public static boolean deleteInDesignatedNode(LinkedListNode node)
	{
		if(node == null || node.next == null) 
			return false;
		
		LinkedListNode next = node.next;
		
		node.data = next.data;
		node.next = next.next;
		
		return true;
	}
	
	
	// MAIN
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(0, null, null); 
		// AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = node;
		LinkedListNode second = node;

		for (int i = 1; i < 8; i++)
		{
			second = new LinkedListNode(i % 2, null, null);
			node.setNext(second);
			second.setPrevious(node);
			node = second;
		}

		System.out.println(head.printForward());
		
		deleteDuplicatesWithHashSet(head);
		System.out.println(head.printForward());
		
		deleteDuplicatesWithPointers(head);
		System.out.println(head.printForward());
	}
}


/**

자료구조 (Collection)
- 다수의 데이터를 쉽게 추가, 삭제, 검색 등의 작업을 할 수 있도록 표준화된 방법을 제공하는 클래스들, 클래스들의 모임
- 고정적이며 불변인 크기를 갖는 배열과는 달리 유동적이며 가변적인 크기를 갖음
- 데이터 수가 일정치 않을 경우 사용하면 편리하다. 단 성능적인 측면에서는 배열이 효율적
 
 
JCF(Java Collection Framework)
- 여러개의 데이터를 저장하고 관리할 수 있는 자료구조
- 데이터 저장/관리 방식에 따라 List/ Set/ Map구조로 나뉨
 
1. Set 계열
- 저장되는 데이터의 순서를 유지하지 않음
- 동일한 내용을 갖는 객체의 중복저장을 허용하지 않음
- HashSet
 
2. List 계열
- 저장되는 데이터의 순서를 유지함
- index로 관리
- 동일한 내용을 갖는 객체의 중복저장을 허용함
- Vector, ArrayList
 
3. Map 계열
- 저장되는 데이터의 순서를 유지하지 않음
- key로 관리-> key와 value가 합쳐져서 한개의 데이터를 이루게 된다. (key, value)
- 동일한 내용을 갖는 객체의 중복저장을 허용함(value), 단 key는 중복 불가
- HashMap, HashTable

**/