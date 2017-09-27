package ask.ds.sorting;

public class QuickSort 
{

	private static void swap(int posA, int posB, int[] array)
	{
		int temp = array[posA];
		
		array[posA] = array[posB];
		array[posB] = temp;
	}
		
	
	private static void quickSort(int[] array, int leftPosition, int rightPosition)
	{
//		int[] processArray = {0};
//		int arrayLength = array.length;
		
//		int pivot = array.length - 1;  // position
//		leftPosition = 0;
//		rightPosition = pivot -1;
			
		int pivot = rightPosition;
		
		while (leftPosition < rightPosition)
		{
			for(int i = leftPosition ; i < pivot; i++)
			{
				if(array[i] >= array[pivot])
				{
					leftPosition = i;
					break;
				}
			}
			
			for(int i = rightPosition ; i >= 0; i--)
			{
				if(array[i] < array[pivot])
				{
					rightPosition = i;
					break;
				}
			}	
			
			if(leftPosition > rightPosition)
				break;
			
			System.out.printf("[%d]%d : [%d]%d\n", leftPosition, array[leftPosition], rightPosition, array[rightPosition]);
			swap(leftPosition, rightPosition, array);
			
			
		}
		
		swap(leftPosition, pivot, array);
		
		// rest of sorting
		quickSort(array, leftPosition, pivot-1);
//		quickSort(array, leftPosition+ 1, pivot);
		
	}
	
	private static void printArray(int[] array)
	{
		for(int i : array)
		{
			System.out.printf("%d ", i);
		}
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("=== QuickSort ===");
		
		// INPUT
//		int[] array = {0,9,2,4,6,5,3,7,8,1,10};
		int[] array = {5, 3, 7, 6, 2, 1, 4};
		
		// INIT
		
		// LOGIC
		quickSort(array, 0, array.length - 1);
		
				
		// OUTPUT
		printArray(array);
	}
}
