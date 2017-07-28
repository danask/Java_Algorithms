package ask.ds.tree;


class Node {

	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	public String toString() {

		return name + " has the key " + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}

	public void contains()
	{
		
	}
	
}


public class TreeNode_Pseudo
{
	
	
	Node left, right;
	int data;
	
	public Node(int data)
	{
		this.data = data;
	}
	
//	public void insert(int value)
//	{
//		if(value <= data)
//		{
//			if(left == null)
//			{
//				left = new Node(value);										}
//			}
//			else
//			{
//				left.insert(value);
//			}
//		}
//		else	
//		{
//			if(right == null)
//			{
//				right = new Node(value);										}
//			}
//			else
//			{
//				right.insert(value);
//			}				
//		}	
//	}

	public boolean contains(int value)
	{
		if(value == data)
		{
			return true;
		}
		else if(value < data)
		{
			if(left == null)
			{
				return false;
			}
			else
			{
				return left.contains(value);
			}
		}
		else
		{
			if(right == null)
			{
				return false;
			}
			else
			{
				return right.contains(value);
			}			
		}
		
	}
	
	// L M R
	public void printInOrder()
	{
		// 1
		if(left != null)
		{
			left.printInOrder();
		}
		
		// 2
		System.out.println(data);
		
		// 3
		if(right !=null)
		{
			right.printInOrder();
		}
	}
	
	// M L R
	public void printPreOrder()
	{
		System.out.println(data);		

		if(left != null)
		{
			left.printPreOrder();
		}

		if(right !=null)
		{
			right.printPreOrder();
		}
	}	

	// L R  M 
	public void printPostOrder()
	{

		if(left != null)
		{
			left.printPostOrder();
		}

		if(right !=null)
		{
			right.printPostOrder();
		}
		
		System.out.println(data);			
	}	
	
}
	

