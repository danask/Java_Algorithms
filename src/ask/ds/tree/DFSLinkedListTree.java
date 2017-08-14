package ask.ds.tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
(Pre-order : D L R) 
 
LV 0 :          1
LV 1 :      2        3
LV 2 :   4    5    6  7

>> 1, 2 4 5 / 3 6 7 

 */

public class DFSLinkedListTree
{

	public static void main(String[] args) 
	{
		// INIT & INPUT
		int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = createTreeFromArray(nodes);

		// Logic
		
		// 1) DFS
		// TreeNode == node(root)
		ArrayList<LinkedList<TreeNode>> arrayList = createLevelLinkedList(root);
		
		// Result
		printResult(arrayList);
		
		
		// 2) BFS
		ArrayList<LinkedList<TreeNode>> arrayListBFS = createLevelLinkedListBFS(root);
		
		// Result
		printResult(arrayListBFS);
		
		
	}
	
	
	public static TreeNode createTreeFromArray(int[] array) 
	{
		if (array.length > 0) 
		{
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			
			while (!done) 
			{
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}

	
	// DFS -> Left fist
	public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> arrayList, int level) 
	{
		if (root == null) 
			return;
		
		LinkedList<TreeNode> linkedList = null;

		// D L R
		
		 // Level not contained in list(0 == 0), in order to create new array
		if (arrayList.size() == level)  
		{
			System.out.printf("arrayList.size() %d == level %d\n", arrayList.size(), level);			
			linkedList = new LinkedList<TreeNode>();

			arrayList.add(linkedList);  
		}
		else 
		{
			System.out.printf("arrayList.size() %d != level %d\n", arrayList.size(), level);
			linkedList = arrayList.get(level);
		}

		linkedList.add(root);

		// sequentially executed(like interrupt function) - no multi-threading
		createLevelLinkedList(root.left, arrayList, level + 1);  // node : 2,  lv : 1, arrayList.size() : 1
		createLevelLinkedList(root.right, arrayList, level + 1); // node : 3, lv : 1, arrayList.size() : 2(due to array by root.left)
	}
	
	
	// to avoid the additional memory
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) 
	{
		ArrayList<LinkedList<TreeNode>> resultArrayList = new ArrayList<LinkedList<TreeNode>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		
		// 1st trial
		if (root != null) 
			current.add(root);
		
		while (current.size() > 0) // while(!queue.isEmpty()) 
		{
			// Dequeue to result
			resultArrayList.add(current); // Add previous level
			
			LinkedList<TreeNode> parents = current; // Go to next level
			current = new LinkedList<TreeNode>(); 
					
			// Enqueue
			for (TreeNode parent : parents) 
			{
				/* Visit the children */
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return resultArrayList;
	}
		
	
	
	// 1st trial : initialize arrayList
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) 
	{
		// Create Arraylists to contain the elements of LinkedList
		ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<LinkedList<TreeNode>>();
		
		// (starting node, arrayList, level)
		createLevelLinkedList(root, arrayList, 0);
		
		return arrayList;
	}	
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result)
	{
		int depth = 0;
		
		for(LinkedList<TreeNode> entry : result) 
		{
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
		
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	


}