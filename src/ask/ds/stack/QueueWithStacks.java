package ask.ds.stack;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;



// Generic : T(Type), E(Element), K(Key), V(Value)
// https://stackoverflow.com/questions/6008241/java-generics-e-and-t-what-is-the-difference


// 1 2 3 4 5 to 5 4 3 2 1

class MyQueue<T>
{
	Stack<T> stackOrg, stackByReverseOrder;
	
	public MyQueue()
	{
		stackOrg = new Stack<T>();
		stackByReverseOrder = new Stack<T>();
	}
	
//	public int size()
//	{
//		return stackOrg.size() + stackByReverseOrder.size();
//	}
	
	public void add(T value)
	{
		stackOrg.push(value);
	}
	
	
	// stackA to stackB
	private void moveStacks()
	{
		if(stackByReverseOrder.isEmpty())  // if this condition doesn't exist, the remains are overwritten in stackB.
		{
			while(!stackOrg.isEmpty())
			{
				stackByReverseOrder.push(stackOrg.pop());
			}
		}
	}
	
	public T peek()
	{
		moveStacks();
		
		return stackByReverseOrder.peek();
	}
	
	public T remove()
	{
		moveStacks();
		
		return stackByReverseOrder.pop();
	}
	
}





public class QueueWithStacks
{
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}	
	
	public static void main(String[] args)
	{
		int sizeOfElement = 5;
		
		MyQueue<Integer> my_queue = new MyQueue<Integer>();	
		Queue<Integer> test_queue = new LinkedList<Integer>();
		
		for (int i = 1; i < sizeOfElement; i++) 
		{
			my_queue.add(i);
			System.out.println("Enqueued " + i);
			
			
			
//			int choice = randomIntInRange(0, 10);
//			
//			if (choice <= 5) 
//			{ // enqueue
//				int element = randomIntInRange(1, 10);
//				test_queue.add(element);
//				my_queue.add(element);
//				System.out.println("Enqueued " + element);
//			}
//			else if (test_queue.size() > 0) 
//			{
//				int top1 = test_queue.remove();
//				int top2 = my_queue.remove();
//				
//				if (top1 != top2)
//				{ // Check for error
//					System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
//				} 
//				System.out.println("Dequeued " + top1);
//			}
//			
//			
//			
//			if (test_queue.size() == my_queue.size()) 
//			{
//				if (test_queue.size() > 0 && test_queue.peek() != my_queue.peek()) 
//				{
//					System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.peek() + " ******");
//				}
//			}
//			else 
//			{
//				System.out.println("******* FAILURE - DIFFERENT SIZES ******");
//			}
		}
		
		
//		for (int i = 1; i < sizeOfElement -1; i++) 
//		{
//			System.out.println("Dequeued " + my_queue.peek());
//			my_queue.remove();
//		
//		}
				


		
		System.out.println("Peek " + my_queue.peek());
		
		for (int i = 5; i < sizeOfElement+5; i++) 
		{
			my_queue.add(i);
			System.out.println("Enqueued " + i);
		}		
		
		
		System.out.println("Dequeued " + my_queue.peek());
		my_queue.remove();
		
		System.out.println("Peek " + my_queue.peek());
		//my_queue.remove();
	}
}


////Stack : by Java
//
//import java.util.Stack;
//
///*
//step 1.Queue add 1, 2, 3, 4, 5
//step 2.Queue peek  // event OK
//-> peek returns 1
//step 3. Queue add 6, 7
//step 4. Queue peek  // event X
//peek is needed to return 1
//
//Bot <- 1 2 3 4 5 -> Top
//SA : 6, 7
//SB : 5, 4, 3, 2, 1  
//
////A : 1 2 3 4 5
////B : 5 4 3 2 1
//*/
//
//class MyQueue<Integer>
//{
// Stack<Integer> stackA, stackB;
// 
// public MyQueue()
// {
//     stackA = new Stack<Integer>();
//     stackB = new Stack<Integer>();    
// }
//
// public void add(Integer inputValue)
// {
//     stackA.push(inputValue);
// }
//
// private void move();
// {
//     if(stackB.IsEmpty())
//     {
//         while(!stackA.IsEmpty())
//         {
//             stackB.push(stackA.pop());  ///////
//         }
//      }
// }
//
//
// public Integer peek()
// {
//     move();
//     
//     return stackB.peek();
// }
// 
// public Integer delete()
// {
//     move();
// 
//     return stackB.pop();
// }  
//
//}