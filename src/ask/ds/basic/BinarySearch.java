package ask.ds.basic;

public class BinarySearch 
{
	// Range : 0, 10
	private static void search(int value, int startPosition, int endPosition, int[] array, int count)
	{
		int arrayLength = endPosition - startPosition; // 10-0 = 10  // 10-5 = 5, 5-0 = 5
		int midPosition = startPosition + arrayLength/2; // 0+10/2 = 5 // 5+5/2 = 7, 0+5/2 = 2
		int midValue = array[midPosition]; // a[5] // a[7], a[2]
		
		if(value == midValue)
		{
			System.out.printf("Found!! " + value + " : "+midValue + " : " + count);
			return;
		}
		else
		{
			count++;
			
			if(value >= midValue)  // 9 >= 5
			{
				search(value, midValue, endPosition, array, count); // 5, 10
			}
			else
			{
				search(value, startPosition, midValue - 1, array, count); // 0, 4
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("=== Binary Search ===");
		
		// INPUT
		int[] array = {0, 1,2,3,4,5,6,7,8,9,10};
		int searchingValue = 3;
		int arrayLength = array.length;
		
		// INIT
//		System.out.printf("%d", 5/2);
		
		// LOGIC
//		sorting
		
		search(searchingValue, 0, arrayLength, array, 0);
		
		// OUTPUT
	}

}
