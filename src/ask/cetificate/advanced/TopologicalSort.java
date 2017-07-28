package ask.cetificate.advanced;

import java.io.FileInputStream;
import java.util.Scanner;



//A Java program to print topological sorting of a DAG
//import java.io.*;
//import java.util.*;

//This class represents a directed graph using adjacency
//list representation
public class TopologicalSort
//public class Solution
{
	         class LinkedList {
		         // 첫번째 노드를 가리키는 필드
		         private Node head;
		         private Node tail;
		         private int size = 0;
		         private class Node{
		             // 데이터가 저장될 필드
		             private Object data;
		             // 다음 노드를 가리키는 필드
		             private Node next;
		             public Node(Object input) {
		                 this.data = input;
		                 this.next = null;
		             }
		             // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		             public String toString(){
		                 return String.valueOf(this.data);
		             }
		         }
		         public void addFirst(Object input){
		             // 노드를 생성합니다.
		             Node newNode = new Node(input);
		             // 새로운 노드의 다음 노드로 해드를 지정합니다.
		             newNode.next = head;
		             // 헤드로 새로운 노드를 지정합니다.
		             head = newNode;
		             size++;
		             if(head.next == null){
		                 tail = head;
		             }
		         }
		         public void addLast(Object input){
		             // 노드를 생성합니다.
		             Node newNode = new Node(input);
		             // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
		             if(size == 0){
		                 addFirst(input);
		             } else {
		                 // 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
		                 tail.next = newNode;
		                 // 마지막 노드를 갱신합니다.
		                 tail = newNode;
		                 // 엘리먼트의 개수를 1 증가 시킵니다.
		                 size++;
		             }
		         }
		         Node node(int index) {
		             Node x = head;
		             for (int i = 0; i < index; i++)
		                 x = x.next;
		             return x;
		         }
		         public void add(int k, Object input){
		             // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
		            // if(k == 0){
		             //    addFirst(input);
		            // } else {
		                 Node temp1 = node(k-1);
		                 // k 번째 노드를 temp2로 지정합니다.
		                 Node temp2 = temp1.next;
		                 // 새로운 노드를 생성합니다.
		                 Node newNode = new Node(input);
		                 // temp1의 다음 노드로 새로운 노드를 지정합니다.
		                 temp1.next = newNode;
		                 // 새로운 노드의 다음 노드로 temp2를 지정합니다.
		                 newNode.next = temp2;
		                 size++;
		                 // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
		                 if(newNode.next == null){
		                     tail = newNode;
		                 }
		       //      }
		         }
		         public String toString() {
		             // 노드가 없다면 []를 리턴합니다.
		             if(head == null){
		                 return "[]";
		             }       
		             // 탐색을 시작합니다.
		             Node temp = head;
		             String str = "[";
		             // 다음 노드가 없을 때까지 반복문을 실행합니다.
		             // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
		             while(temp.next != null){
		                 str += temp.data + ",";
		                 temp = temp.next;
		             }
		             // 마지막 노드를 출력결과에 포함시킵니다.
		             str += temp.data;
		             return str+"]";
		         }
		         public Object removeFirst(){
		             // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
		             Node temp = head;
		             head = temp.next;
		             // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다. 
		             Object returnData = temp.data;
		             temp = null;
		             size--;
		             return returnData;
		         }
		         public Object remove(int k){
		             if(k == 0)
		                 return removeFirst();
		             // k-1번째 노드를 temp의 값으로 지정합니다.
		             Node temp = node(k-1);
		             // 삭제 노드를 todoDeleted에 기록해 둡니다. 
		             // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.  
		             Node todoDeleted = temp.next;
		             // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
		             temp.next = temp.next.next;
		             // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
		             Object returnData = todoDeleted.data; 
		             if(todoDeleted == tail){
		                 tail = temp;
		             }
		             // cur.next를 삭제 합니다.
		             todoDeleted = null; 
		             size--;
		             return returnData;
		         }
		         public Object removeLast(){
		             return remove(size-1);
		         }
		         public int size(){
		             return size;
		         }
		         public Object get(int k){
		             Node temp = node(k);
		             return temp.data;
		         }
		         public int indexOf(Object data){
		             // 탐색 대상이 되는 노드를 temp로 지정합니다.
		             Node temp = head;
		             // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
		             int index = 0;
		             // 탐색 값과 탐색 대상의 값을 비교합니다. 
		             while(temp.data != data){
		                 temp = temp.next;
		                 index++;
		                 // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
		                 if(temp == null)
		                     return -1;
		             }
		             // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
		             return index;
		         }
		      
		         // 반복자를 생성해서 리턴해줍니다.
		         public ListIterator listIterator() {
		             return new ListIterator();
		         }
		          
		         class ListIterator{
		             private Node lastReturned;
		             private Node next;
		             private int nextIndex;
		              
		             ListIterator(){
		                 next = head;
		                 nextIndex = 0;
		             }
		              
		             // 본 메소드를 호출하면 next의 참조값이 기존 next.next로 변경됩니다. 
		             public Object next() {
		                 lastReturned = next;
		                 next = next.next;
		                 nextIndex++;
		                 return lastReturned.data;
		             }
		              
		             public boolean hasNext() {
		                 return nextIndex < size();
		             }
		              
		             public void add(Object input){
		                 Node newNode = new Node(input);
		                 if(lastReturned == null){
		                     head= newNode;
		                     newNode.next = next;
		                 } else {
		                     lastReturned.next = newNode;
		                     newNode.next = next;
		                 }
		                 lastReturned = newNode;
		                 nextIndex++;
		                 size++;
		             }
		              
		             public void remove(){
		                 if(nextIndex == 0){
		                     throw new IllegalStateException();
		                 }
		                 LinkedList.this.remove(nextIndex-1);
		                 nextIndex--;
		             }
		              
		         }
		      
		     }         
	         	
	
	
	 private int V;   // No. of vertices
	 private LinkedList adj[]; // Adjacency List
	
	 //Constructor
	 TopologicalSort(int v)
	 {
	     V = v;
	     adj = new LinkedList[v];
	     for (int i=0; i<v; ++i)
	         adj[i] = new LinkedList();
	 }
	
//	 // Function to add an edge into the graph
//	 void addEdge(int v,int w)
//	 { 
//		 adj[v].add(w); 
//	 }
//	
//	 // A recursive function used by topologicalSort
//	 void topologicalSortUtil(int v, boolean visited[],  Stack stack)
//	 {
//	     // Mark the current node as visited.
//	     visited[v] = true;
//	     Integer i;
//	
//	     // Recur for all the vertices adjacent to this
//	     // vertex
//	     Iterator<Integer> it = adj[v].iterator();
//	     while (it.hasNext())
//	     {
//	         i = it.next();
//	         if (!visited[i])
//	             topologicalSortUtil(i, visited, stack);
//	     }
//	
//	     // Push current vertex to stack which stores result
//	     stack.push(new Integer(v));
//	 }
//	
//	 // The function to do Topological Sort. It uses
//	 // recursive topologicalSortUtil()
//	 void topologicalSort()
//	 {
//	     Stack stack = new Stack();
	
//	     // Mark all the vertices as not visited
//	     boolean visited[] = new boolean[V];
//	     for (int i = 0; i < V; i++)
//	         visited[i] = false;
//	
//	     // Call the recursive helper function to store
//	     // Topological Sort starting from all vertices
//	     // one by one
//	     for (int i = 0; i < V; i++)
//	     {
//	         if (visited[i] == false)
//	             topologicalSortUtil(i, visited, stack);
//	     }
//	     
//	     // Print contents of stack
//	     while (stack.empty()==false)
//	     {
//	         System.out.print(stack.pop() + " ");
//	     }
//	 }

	 
	 // Driver method
//         public static void main(String[] args)throws Exception 
//         {
//	         int T, N;
//	         long answer;
//	
// 	         //System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/topological_input.txt"));
//
//	         Scanner sc = new Scanner(System.in);
//	        
//	         T = sc.nextInt();
//	         
//	         for (int test_case = 1; test_case <= T; test_case++) 
//	         {
//	                  N = sc.nextInt();
//	                  int[] a = new int[N];
//	                  
//	                  for(int i=0; i < N; i++)
//	                  {
//	                          a[i] = sc.nextInt();
//	                  }
//	                 
//
//	                  
//			TopologicalSort g = new TopologicalSort(6);
//			
//			
//			
//			g.addEdge(5, 2);
//			g.addEdge(5, 0);
//			g.addEdge(4, 0);
//			g.addEdge(4, 1);
//			g.addEdge(2, 3);
//			g.addEdge(3, 1);
//				
//
//	                  // RESULT
//	                  System.out.println("#"+test_case+" ");
//	                  
//	                  g.topologicalSort();
//	         }
//         }	 
         
	 
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		TopologicalSort g = new TopologicalSort(6);
		
		// first time
//		g.addEdge(5, 2);
//		
//		
//		g.addEdge(5, 0);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 1);
//			
//		System.out.println("Following is a Topological " +  "sort of the given graph");
//		g.topologicalSort();
	}
         
         

}





//public class TopologicalSort
////public class Solution
//{     
//         public static void main(String[] args)throws Exception {
//                  int T, N;
//                  long answer;
// 
//                 System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/inversion_input.txt"));
// 
//                  Scanner sc = new Scanner(System.in);
//                 
//                  long t1,t2;
//                  T = sc.nextInt();
//                  
//                  for (int test_case = 1; test_case <= T; test_case++) 
//                  {
//                           N = sc.nextInt();
//                           int[] a = new int[N];
//                           for(int i=0;i<N;i++){
//                                   a[i] = sc.nextInt();
//                           }
//                          
////                           t1 = System.currentTimeMillis();
//                           answer = countingInversions(a);
////                           t2 = System.currentTimeMillis();
//                           System.out.println("#"+test_case+" "+answer);// +" ("+(t2-t1)+" milliseconds)");
//                  }
//         }
// 
//         private static long countingInversions(int[] a) 
//         {
//                  int n = a.length;
//                  int[] buf = new int[n];           
//                  long cnt = count(a,0,n-1,buf);
//                 
//                  return cnt;
//         }
//        
//         private static long count(int[] a, int s, int e, int[] buf)
//         {
//                  if((e-s)<1) {
//                           return 0;
//                  }       
//                 
//                  int m = (s+e) / 2;
//                  long leftCount = count(a,s,m,buf);
//                  long rightCount = count(a,m+1,e,buf);
//                  long mergeCount = merge(a,s,m,e,buf);
//                  
//                  System.arraycopy(buf, s, a, s, (e-s)+1);
//                 
//                  return leftCount + rightCount + mergeCount;
//         }
//        
//         private static long merge(int[]a,int s, int m, int e, int[] buf)
//         {
//                  //System.out.println("merge("+s+" "+e+")");
//                  int left=s;
//                  int right=m+1;
//                  long count=0;
//                  
//                  for(int k=s;k<=e;k++){
//                           if(left<=m && ( (right>e) || (a[left] <= a[right]) ) ){
//                                   buf[k] = a[left++];                                 
//                           }else{
//                                   buf[k] = a[right++];
//                                   count = count + (m-left+1);
//                           }
//                  }
//                  return count;
//         }
//        
//        
//}