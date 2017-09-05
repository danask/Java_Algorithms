package ask.ctci.intermediate;


// 1. input : +, + / -, + / -, -
// 2. - : unit = -1 -> loop
// 3. * : ++, / : ++(-)

// a + b, a - b, a*b, a/b
public class minusMultiplyDivide 
{
	
	private static int makeOppositeSign(int input)
	{
		int returnValue = 0;
		int unit = 1;
		
		if(input > 0)  // 3 -> -3
		{
			unit = -1;
						
			for(int i = 1; i <= input; i++)
			{
				returnValue += unit;
			}
		}
		else  // -3 -> +3
		{		
			for(int i = input; i < 0; i++)
			{
				returnValue += unit;
			}
		}
		
//		System.out.println(returnValue);
		
		return returnValue;
	}
	
	private static int abs(int input)
	{
		if(input < 0)
		{
			return makeOppositeSign(input);
		}

		return input;
	}

	

	// a + (-b) + (-b) (n times)
	// 9/2 = 9 - 2 - 2 - 2 - 2
	private static int divide(int inputA, int inputB) throws java.lang.ArithmeticException
	{
		if(inputB == 0)
		{
			throw new java.lang.ArithmeticException("ERROR");
		}
		
		int count = 0;
		boolean negative = false;
		
		if((inputA > 0 && inputB < 0) || (inputA < 0 && inputB > 0))  
		{
			negative = true;
		}
				
		if(inputB > 0)
		{
			inputB = makeOppositeSign(inputB);
		}
		
		while(inputA >= abs(inputB))
		{
			inputA += inputB;
			
			count++;				
		}
		
		
		if(negative)  
		{			
			return makeOppositeSign(count);
		}

		return count;
	}	
	

	// a + a + a (b times)
	// 3*2 = 3 + 3 
	private static int multiply(int inputA, int inputB)
	{
		int returnValue = 0;

		if(inputA < inputB)
		{
			return multiply(inputB, inputA);
		}
		
		if(inputB < 0)
		{						
			for(int i = inputB; i < 0; i++)
			{
				returnValue += inputA;
			}
			
			return makeOppositeSign(returnValue);
		}
		else
		{
			for(int i = 1; i <= inputB; i++)
			{
				returnValue += inputA;
			}
			
			return returnValue;
		}
	}	
	
	
	// a + (-b)
	private static int minus(int inputA, int inputB)
	{
//		int returnValue = inputA;
//
//		if(inputB > 0)
//		{
//			int unit = -1;
//						
//			for(int i = 1; i <= inputB; i++)
//			{
//				returnValue += unit;
//			}
//		}
//		else
//		{
//			returnValue = inputA + inputB;
//		}
//		
		
//		if(inputB > 0)
		{
			return inputA + makeOppositeSign(inputB);
		}
		
	}	
	
	public static void main(String args[])
	{
		System.out.println("=== Plus Multiply Divide without minus ===");
		
		int inputA = 9;
		int inputB = 2;
		
		System.out.printf("minus : %d - %d = %d\n", inputA, inputB, minus(inputA, inputB));
		
		System.out.printf("multiply : %d * %d = %d\n", inputA, inputB, multiply(inputA, inputB));
		
		System.out.printf("divide : %d * %d = %d\n", inputA, inputB, divide(inputA, inputB));
	}
	
}
