package ask.ctci.intermediate;

public class KthMagicNumber 
{
	private static void printArray(int[] array)
	{
		for(int i : array)
		{
			System.out.println(i);
		}
	}
	
	private static void getKthMagicNumber(int kthNumber)
	{
		
	}
	
	private static int powerComputation(int a, int b) // 2^3
	{
		int retVal = 1;
		int i = 1;
		
		while(i <= b)
		{
			retVal *= a;
			i++;
		}
		
		return retVal;
	}
	
	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void bubbleSort(int[] array)
	{
		int size = array.length;
		
		for (int i = 0; i < size - 1; i++)
		{
			for (int j = 0; j < size - 1 - i; j++)
			{
				if (array[j] > array[j + 1])
				{
					swap(array, j, j+1);
				}
			}
		}		
	}
	
	public static void main(String[] args)
	{
		// Input 
		int inputNumber = 10;
		
		// Init
		// until 100th
		int three = 3;
		int five = 5;
		int seven = 7;
		int[] array = {0};
		int count = 0;
		
		for(int i = 0; i <= 5; i++)
		{
			long result = 0;
			
			for(int j = 0; j <= 5; j++)
			{
				for(int k = 0; k <= 5; k++)
				{
					result = powerComputation(three, i) * 
							powerComputation(five, j) * 
							powerComputation(seven, k);
					
//					array[count++] = result;
					
					
					System.out.println(i + " " + j + " "+ k + " " + count + " : "+ result);
				}
			}
			

		}
		
		
		// test
//		int[] test = {3,7,1,8,9,22};
//		bubbleSort(test);
//		printArray(test);
		
//		System.out.println(powerComputation(3,0));
		
		
		// Logic
		getKthMagicNumber(inputNumber);
		// Output
	}
}
