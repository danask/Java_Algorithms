package ask.ds.recursive;

public class Factorial 
{
	private static int factorial(int inputValue, int returnVal, int depth)
	{
		if(inputValue == 1)
		{
//			System.out.printf("Result %d\n", returnVal);   // it is just a last snapshot(the split is finished), not result
			return 1;  // or may be skipped, then computation starts with 2
		}
		else
		{
			depth ++;
			returnVal = inputValue *factorial((inputValue - 1), returnVal, depth); // 5 * fact(4)  // calc. as LIFO(Stack)
			System.out.printf("sub-return : %d %d\n", returnVal, depth);
		}
		return returnVal;
	}
		
	public static void main(String[] args) 
	{
		System.out.println("=== Factorial ===");
		
		// INPUT
		int targetValue = 4;  // 5, 4, 3, 2, 1 = 60
		
		// INIT
		
		// LOGIC
		
		System.out.printf("Factorial(%d) : %d ", targetValue, factorial(targetValue, 1, 1));
		
		// OUTPUT
		
	}
}
