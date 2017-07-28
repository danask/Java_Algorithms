package ask.algorithm.array;

public class Algorithm 
{

	static int[] returnValue = new int[3];
	static int[] returnPlusValue = new int[3];
	static int count = 0;
	
	public static void calculate(int a, int b)
	{
		int posValue = 0;
		int carry = 0;		
		
		
		posValue = a + b; 
		
		if(posValue >= 10)
		{
			carry = (int)posValue/10;
			posValue = posValue%10; // - carry*10;
		}

		returnValue[count] = posValue;
		System.out.println(returnValue[count]);
		
		returnPlusValue[count] = carry;
		System.out.println(returnPlusValue[count]);
		count++;
		
	}	
	
	
	
	
	static int coins[] = {10, 20, 30, 40};
	static int numberOfCoins = 0;
	static int saveIndex[] = new int[100]; 
	static int cnt = 0;
	
	// goal, sum, index
	public static int countCoins(int goal, int sum, int index)
	{
		//if(index == 4)
			//return -1;
		
		if(sum > goal)
			return 0;
		
		if(sum == goal)
		{
//			for(int i = 0; i < cnt ; i++)
//			{
//				System.out.println("[CoinsPrint] " + (coins[saveIndex[i]]));
//			}
			
			numberOfCoins++;
			System.out.println("[Coins++] " + numberOfCoins);
		}
		
//		saveIndex[cnt++] = index;
		
		for(int i = 0; i < coins.length; i++)
			countCoins(goal, sum + coins[i], index + 1);
		
		return numberOfCoins;
	}	

	
	// Binary Search
	
/*
	int mid = (s + e)/2;
	
	if( s > e)
		return -1;
	
	if(x == a[mid])
		return mid;	
	else if( x < a[mid])
		L search
	else if( x > a[mid])
		R search
*/
	
	public static int search(int a[], int left, int right, int x)
	{
		System.out.println("B. Search");
		
		int mid = (left + right) / 2;
		
		if(x == a[mid])
			return mid;
		
		if(right < left)
			return -1;
		
		// need to find which side is sorted
		
		// left is sorted
		// 3 < 7 , x = 5
		if(a[left] < a[mid])
		{
			// 3 <= 5 <= 7
			if(a[left] <= x && x <= a[mid])
				return search(a, left, mid - 1, x); // L search
			else
				return search(a, mid + 1, right, x); // R search
		}
		
		// right is sorted
		// 9 > 6, x = 8
		else if(a[left] > a[mid])
		{
			// 6 <= 8 <= 9
			if(a[mid] <= x && x <= a[right])
				return search(a, mid + 1, right, x); // R search
			else
				return search(a, left, mid - 1, x); // L search
		}
		
		
		// exceptional case
		// same values in left
		// 2 2 2 3 4 2
		
		else if(a[left] == a[mid])
		{
			// right is different
			if(a[mid] != a[right])
				return search(a, mid + 1, right, x); // R search
			
			// both search
			else
			{
				int result = search(a, left, mid - 1, x); // L search
				
				if(result == -1)
					return search(a, mid + 1, right, x); // R search
				else
					return result;
			}
		}
		
		return -1;
		
	}


	
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("--------- Algorithms ----------");
		System.out.println("--------- USE Array ----------");		
		
//		
//		//String testInput = "I love you     "; // Cannot use string due to immutable type of String
//		
//		// INPUT
//		char testInput[] = new char[]{'I', ' ', 'l', 'o', 'v', 'e', ' ', 'y', 'o', 'u', ' ', ' ', ' ', ' ', ' '};
//		int array[] = new int[10];
//		int countA = 0, countB = 0;
//		int flagA = 0, flagB = 1;
//		int blank = 0;
//		int move = 0;
//		
//		
//		// Check # of blank and last pos.
//		for(int x = testInput.length -1  ; x >0; x--)
//		{
//			
//			if(flagB == 1 && testInput[x] != ' ')
//			{
//				countB = x;
//				flagB = 0;
//				flagA = 1;
//			}
//			
//			if(flagA == 1 && testInput[x] == ' ')
//				array[countA++] = x;
//		}
//		
//
//		// Move to right
//		for(int x = countB ; x >0; x--)
//		{	
//			move = x + countA*2  - blank;
//			
//			if(testInput[x] != ' ')
//			{
//				testInput[move] = testInput[x];
//			}
//			else
//			{
//				testInput[move] = '0'; 
//				testInput[move - 1] = '2'; 
//				testInput[move - 2] = '%'; 
//				blank = 2;
//			}
//		}	
//		
//		// RESULT
//		System.out.println("output : ");
//		for(int x = 0; x < testInput.length; x++)
//		{
//			System.out.print(testInput[x]);
//		}
//			
//
//		
//		System.out.println("\n--------- BigINT using array ----------");
//		
//		// input :(7->1->6) + (5->9->2)        //617 + 592
//		// output : (2->1->9)                        //912
//		
//		int[] inputA = new int[]{7, 1, 6};
//		int[] inputB = new int[]{5, 9, 2};
//
//		int[] outputAB = new int[inputA.length];
//		int plus = 0;
//		
//		
//		for(int i = 0; i < inputA.length; i++)
//		{
//			calculate(inputA[i], inputB[i]);
//			
//			// 1st up
//			if(plus > 0)
//			{
//				// 2nd up
//				if(returnValue[i] + plus >= 10)
//				{
//					outputAB[i] = (returnValue[i] + plus)%10;// - 10;
//					plus = returnValue[i] + plus;
//				}
//				else
//				{
//					outputAB[i] = returnValue[i] + plus;
//					plus = 0;
//				}
//				
//			}
//			else
//				outputAB[i] = returnValue[i];
//			
//			if(returnPlusValue[i]> 0)
//				plus = returnPlusValue[i] + plus;
//		}
//
//		System.out.println("\n--------- Output ----------");
//		
////		for(int i = outputAB.length-1 ; i >=0 ; i--)
//		for(int i = 0; i < inputA.length; i++)
//		{
//			System.out.println(outputAB[i]);
//		}
//		
		
		
		//////////////////////////////////////////////
		

//		countCoins(50, 0, 0);		
		
		int a[] = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		System.out.println(search(a, 0, a.length - 1, 5));
		
		
	}

}
