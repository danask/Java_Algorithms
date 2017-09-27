package ask.ds.recursive;

public class ReverseString 
{
	private static void swap(int posA, int posB, char[] array)
	{
		char temp = array[posA];
		
		array[posA] = array[posB];
		array[posB] = temp;
	}
	
	// If we know the size of string, then simply implement with for-loop	
	private static void reverseString(char[] inputString)
	{
		for(int i = 0; i < inputString.length/2; i++)
		{
			swap(i, inputString.length - i - 1, inputString);  
		}
		
		int i = 0;
//		while(inputString[i] != '\0')  //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
		while(i < inputString.length) 
		{
			System.out.printf("%c ", inputString[i]);
			i++;
		}		
	}
	
	// recursively swapping
	private static void reverseStringWithRecursiveLogic(char[] inputString, int size)
	{
		if(size == 0)
		{
			return;
		}
		else
		{
			System.out.printf("%c ", inputString[size-1]); // LIFO
			reverseStringWithRecursiveLogic(inputString, size-- -1 );
		}
	}

	
//	private static void reverseStringWithRecursiveLogic2(char[] inputString, int first, int last)
//	{
//		if(first > last)
//		{
//			return;
//		}
//		else
//		{
//			System.out.printf("%c ", inputString[first]); // LIFO
//			reverseStringWithRecursiveLogic2(inputString, first++, last);
//		}
//	}	
	
	public static void main(String[] args) 
	{
		// Input
		char[] inputString = {'a', 'b', 'c', 'd', 'e'};
		
		// Init
//		System.out.println(inputString.length);  // 5 / 2 = 2
		
		// Logic
		reverseString(inputString);
		System.out.println("");	
		reverseStringWithRecursiveLogic(inputString, inputString.length);	
		System.out.println("");			
//		reverseStringWithRecursiveLogic2(inputString, 0, inputString.length - 1);	
		
		// Result

	}

}
