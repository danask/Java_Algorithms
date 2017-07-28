package ask.ctci.hard;



public class QuickSort 
{
	public static void main(String[] args) 
	{
		int[] intArray = new int[] { 3, 4, 3, 2, 5, 6, 8, 2, 2, 2, 4, 55, 67, 43, 4, 1, 0, 1, 43 };
		QuickSort sort = new QuickSort();
		
		// sorting
		sort.quickSort(intArray, 0, intArray.length-1);
		
		// output
		sort.printArray(intArray);
	}

	private void quickSort(int[] array, int left, int right) 
	{
		int index = partition(array, left, right);
		
		if(left < index -1)  //  divide & conquer
		{
			quickSort(array, left, index-1);
		}
		if(index < right) //  divide & conquer
		{
			quickSort(array, index, right);
		}

	}

	private int partition(int[] array, int left, int right) 
	{
		int pivot = array[left];   //[(left + right)/2];

		while( left <= right) 
		{
			// keep searching value(s) less than pivot 
			while(array[left] < pivot) {
				left++;
			}
			// keep searching value(s) more than pivot
			while(array[right] > pivot) {
				right--;
			}
			
			// swap
			if(left <= right)
			{
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				
				// next item
				left++;
				right--;
			}
		}
		return left;  // left > right // the conflict(crossed) position from left and right  
	}


	private void printArray(int[] array) 
	{
		for(int i : array) 
			System.out.println(i);
	}
}



/*
class Swap
{
	public int x, y;
	
	public static void swap(Swap object)
	{
		int temp = object.x;
		object.x = object.y;
		object.y = temp;
	}
}



public class QuickSort
{
	public static int partition(int l, int r, int array[])
	{
		Swap swp = new Swap();
		
		int pivot = array[l];
		
		while(l < r)
		{
			while(array[l] < pivot) l++;
			while(array[r] >= pivot) r++;
			
			if(l >= r)
				continue;
			else
			{
				swp.x = l;
				swp.y = r;
				
				Swap.swap(swp);
			}
				
			
		}
		return r;
	}
	
	
	
	public static void quickSort(int left, int right, int  array[])
	{
		int index  = partition(left, right, array);
		
		if(left < index)
			quickSort(index, right, array);
		
		if(index - 1 <= right)
			quickSort(left, index - 1, array);
	}
	
	
	public static void main(String arg[])
	{
		int array[] = {3, 4, 6, 1, 9, 11, 2, 0};
		
		int l = 0, r = 0;
		
		quickSort(l, r, array);
		
		for(int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
}
*/