package ask.ds.tree;


// n : current node
// q : parent 


/*
      4
   2       6
1   3   5   7

In Order :  1, 2, 3, 4, 5, 6, 7
Pre Order : 4, 2, 1, 3, 6, 5, 7
Post Order : 1, 3, 2, 5, 7, 6, 4 


 In Order Successor
 = The 1st Right Child's the most left child.
 
 If I don't have right child, check parents that I'm from its left child.
 
 Worst : O(n^2)
 
  NODE * GetNextNode(Node *pNode)
 {
     IF pNode->RightChild == NULL {
        NODE *pParent = NULL;
        while(pNode->pParent != NULL) {
           pParent = pNode->pParent;
           if(pParent->pLeftChild != pNode)
             pNode = pParent;
           else
             break;
        }       
        return pNode->pParent;
     }
        
     ELSE {
        pNode = pNode->RightChild;
        while(pNode->pLeftChild != NULL)
           pNode = pNode->pLeftChild;
        return pNode;
     }
 }
 
 
*/

public class FindSuccessor
{

	public static TreeNode leftMostChild(TreeNode n) 
	{
		if (n == null)
			return null;
		
		while (n.left != null) {
			n = n.left; 
		}
		return n; 
	}
	
	// L N R
	public static TreeNode inorderSucc(TreeNode n) 
	{ 
		if (n == null) 
			return null;
		
		// R
		// Found right children -> return left most node of right subtree
		if (n.parent == null || n.right != null) 
		{ 
			return leftMostChild(n.right); 
		}
		
		// L
		// Found left children -> go to parent
		else 
		{ 
			TreeNode q = n;
			TreeNode x = q.parent;
			
			// Go up until we are on left instead of right
			
			// left one exists
			while (x != null && x.left != q) 
			{
				q = x;
				x = x.parent;
			}
			return x;
		}  
	} 

	public static void main(String[] args) 
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		TreeNode root = TreeNode.createMinimalBST(array); // Binary S. Tree
		
		for (int i = 0; i < array.length; i++) 
		{
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
