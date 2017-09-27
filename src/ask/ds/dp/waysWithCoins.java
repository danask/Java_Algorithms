package ask.ds.dp;

public class waysWithCoins 
{
	// Basic
	public static int makeChange(int target, int[] types, int index) 
	{
		if (index >= types.length - 1) 
			return 1; // one denom remaining -> one way to do it
		
		int coin = types[index];
		int ways = 0;
		
		
		for (int i = 0; i * coin <= target; i++)   // 1, 2,... n coins of a type
		{
			int targetRemaining = target - i * coin;
			
			ways += makeChange(targetRemaining, types, index + 1); // as each type : 4 ea
		}
		
		return ways;
	}
	
	// remaing - i*coin or if(target > sum) return... 
	
	
	// Memorization
	public static int makeChange2(int target, int[] types, int index, int[][] map) 
	{
		// retrieve value
		if (map[target][index] > 0) 
		{ 
			return map[target][index];
		}
		
//		if (index >= types.length - 1) 
//			return 1; // one denom remaining -> one way to do it
//		
//		int coin = types[index];
		int ways = 0;
//		
//		for (int i = 0; i * coin <= target; i++) 
//		{
//			int targetRemaining = target - i * coin;
		
//			ways += makeChange2(targetRemaining, types, index + 1, map);
//		}
		
		// Save the cases
		map[target][index] = ways;
		
		return ways;
	}	
	
	public static int makeChange2(int n, int[] types) 
	{
		// init
		int[][] map = new int[n + 1][types.length];
		
		return makeChange2(n, types, 0, map);
	}
	
	
	
	public static void main(String[] args) 
	{
		int[] types = {25, 10, 5, 1};
//		int ways = makeChange(100, types);
//		int ways2 = makeChange2(100000, types);
		System.out.println(makeChange(1000, types, 0));
		System.out.println(makeChange2(1000, types));
	}	
	
	
	// Basic
//	public static int makeChange3(int target, int[] types, int index, int map[][]) 
//	{
////		if (index >= types.length - 1) 
////			return 1; // one denom remaining -> one way to do it
//		
//		int coin = types[index];
//		int ways = 0;
//		
//		for(int j = 0; j < 4; j++)
//		{
//			for (int i = 0; i * types[j] <= target; i++)   // 1, 2,... n coins of a type
//			{
//				int sum = i * types[j];
//				
//				ways += makeChange(sum, types, index + 1, map); // as each type : 4 ea
//			}
//		}
//
//		map[target][index] = ways;
//		
//		return ways;
//	}
//		
	
	
//	public static void main(String[] args) 
	{
//		for (int i = 0; i < 200; i++) 
//		{
//			int[] types = {25, 10, 5, 1};
//			int waysA = Question.makeChange(i, types);
//			int waysB = QuestionB.makeChange(i, types);
//			if (waysA != waysB) {
//				System.out.println("Error: " + i + " : " + waysA + ", " + waysB);
//			}
//		}
	}

}
