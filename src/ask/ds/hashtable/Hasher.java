package ask.ds.hashtable;

import java.util.ArrayList;


class Dummy 
{
	private String name;
	private int age;
	
	public Dummy(String n, int a) {
		name = n;
		age = a;
	}
	
	@Override 
	public String toString() {
		return "(" + name + ", " + age + ")";
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}

// LL
class LinkedListNode<K, V> 
{
	public LinkedListNode<K, V> next;
	public LinkedListNode<K, V> prev;
	public K key;
	public V value;
	
	public LinkedListNode(K k, V v) {
		key = k;
		value = v;
	}
	
	public String printForward() 
	{
		String data = "(" + key + "," + value + ")";
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return data;
		}
	}
}	


// Hasher method
public class Hasher<K, V> 
{

	// Array with LL
	private ArrayList<LinkedListNode<K, V>> bucketArray;
		
	// Create HashTable array : a series of LL
	public Hasher(int capacity) 
	{
		/* Create list of linked lists. */
		bucketArray = new ArrayList<LinkedListNode<K, V>>();
		bucketArray.ensureCapacity(capacity);
		
		// init
		for (int i = 0; i < capacity; i++) {
			bucketArray.add(null);
		}
	}
	
	/* Insert key and value into hash table. */
	public V put(K key, V value) 
	{
		// check the node(dup)
		LinkedListNode<K, V> node = getNodeForKey(key); 
		
		// if old one exists, just update the value.  // collision handling
		if (node != null) {
			V oldValue = node.value;
			node.value = value; 
			
			return oldValue;
		}
		
		// if not, create new
		node = new LinkedListNode<K, V>(key, value);
		
		// index by key
		int index = getIndexForKey(key);  
		System.out.printf("index = %d\n", index);
		
		if (bucketArray.get(index) != null) {
			node.next = bucketArray.get(index);
			node.next.prev = node;  // pre of current node
		}
		bucketArray.set(index, node);
		
		return null;
	}
	
	/* Remove node for key. */
	public V remove(K key) 
	{
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node == null) {
			return null;
		}
		
		if (node.prev != null) {
			node.prev.next = node.next;
		} 
		else {
			/* Removing head - update. */
			int hashKey = getIndexForKey(key);
			bucketArray.set(hashKey, node.next);
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		return node.value;
	}
	
	/* Get value for key. */
	public V get(K key) 
	{
		if (key == null) 
			return null;
		
		LinkedListNode<K, V> node = getNodeForKey(key);
		
		return node == null ? null : node.value;
	}
	
	/* Get linked list node associated with a given key. */
	private LinkedListNode<K, V> getNodeForKey(K key) 
	{
		int index = getIndexForKey(key); // 0, 1, 2
		LinkedListNode<K, V> current = bucketArray.get(index); // find the bucket
		
		while (current != null) 
		{
			if (current.key == key) {
				return current;
			}
			current = current.next;
		}
		return null;		
	}
	
	// Get Index
	public int getIndexForKey(K key) /* Really stupid function to map a key to an index. */
	{
//		System.out.printf("key.hashCode() : %d\n", key.hashCode());
//		System.out.printf("bucketArray.size() : %d\n", bucketArray.size());
		return Math.abs(key.hashCode() % bucketArray.size());  
	}
	
	
	
	public void printTable() 
	{
		for (int i = 0; i < bucketArray.size(); i++) {
			String s = bucketArray.get(i) == null ? "" : bucketArray.get(i).printForward();
			System.out.println(i + ": " + s);
		}
	}


	
	// Testing
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Dummy bob = new Dummy("Bob", 20);
		Dummy jim = new Dummy("Jim", 25);
		Dummy alex = new Dummy("Alex", 30);
		Dummy tim = new Dummy("Tim", 35);
		Dummy maxwell = new Dummy("Maxwell", 40);
		Dummy john = new Dummy("John", 45);
		Dummy julie = new Dummy("Julie", 50);
		Dummy christy = new Dummy("Christy", 55);
		Dummy tim2 = new Dummy("Tim", 100); // This should replace the first "tim"
		
		Dummy[] dummies = {bob, jim, alex, tim, maxwell, john, julie, christy, tim2};
		
		// create(3 buckets - a bunch of slots per a bucket)
		Hasher<String, Dummy> hash = new Hasher<String, Dummy>(3);
		
		// insert
		System.out.println("-- Put them HashTable ---");
		for (Dummy d : dummies) 
		{
			System.out.printf("dummy name(Key) = %s \n", d.getName());
			System.out.println(hash.put(d.getName(), d));  // when push the same name, the logic of collision handling occurs
		}
		
		// print
		System.out.println("-- Print HashTable ---");
		hash.printTable();
		
		/* Test: Recall */
//		System.out.println("-- Test: Recall ---");
//		for (Dummy d : dummies) 
//		{
//			String name = d.getName();
//			
//			Dummy dummy = hash.get(name);			
//			if (dummy == null) {
//				System.out.println("Dummy named " + name + ": null");
//			} else {
//				System.out.println("Dummy named " + name + ": " + dummy.toString());
//			}
//			
//			Dummy d2 = hash.remove(name);
//			if (d2 == null) {
//				System.out.println("Dummy removed named " + name + ": " + "null");
//			} else {
//				System.out.println("Dummy removed named " + name + ": " + d2.toString());
//			}
//		}
	}
}





