package ask.ds.recursive;


// 1, 1, 2, 3, 5, 8...

public class Fibo 
{
	private static void fibo(int first, int second, int count)
	{
		if(count >= 10)
		{
			return;
		}
		else
		{
			System.out.printf("%d [%d]\n", first, count++);

			fibo(second, first + second, count);
		}
		
	}
	
	public static void main(String[] args) 
	{
		// Input
		int first = 1;
		int second = 1;
		int sum = 0;
		
		// Init
		
		// Logic
		fibo(first, second, 1);
		
		// Result

	}
}
