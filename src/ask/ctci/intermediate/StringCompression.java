package ask.ctci.intermediate;


public class StringCompression
{
	private static void makeCompression(String input)
	{
		
		char[] character = new char[input.length()];
		int[] count = new int [input.length()];
		StringBuilder ans = new StringBuilder();
		
		int compCount = 0;
		char temp = '-';
		
		
		// counting
		for(int i = 0; i < input.length(); i++)
		{
			if(temp == '-')
			{
				temp = input.charAt(i);
				character[compCount]= temp;
			}
			else if(temp != '-' && temp != input.charAt(i))
			{
				compCount++;
				temp = input.charAt(i);
				character[compCount]= temp;
			}

			count[compCount]++;			
		}
		
		
		// compare
		if(compCount <= input.length())
		{
			for(int i = 0; i <= compCount; i++)
			{
				// merge !!!
				ans.append(""+character[i]+count[i]);
//				System.out.printf("" + character[i]+count[i]);
			}
			
			System.out.println(ans);			
		}
		else
		{
			System.out.println(input);
		}
		
	}
	
	
	public static void main(String[] args)
	{
		String input = "aabbcccddaaa";
		
		
		makeCompression(input);

	}
}

//
////input : a to z, limited size of string (1000)
////input is "aaaabbbbcc"
//
//public void makeCompression(String input)
//{
// int inputLength = input.length();
// 
// if(inputLength > 0)
// {
//     // storing result
//     char[] character = new char[inputLength];
//     int[] count = new int[inputLength];
//     int index = 0;  
//     char temp = '-';
//     StringBuilder ans = new StringBuilder();
// 
// 
//     // initial stage(only once)
//     if(temp == '-')
//     {
//          temp = input.charAt(i);
//          character[index] = temp;
//          count[index] = 0;
//     }
//         
//     // counting
//     for(int i = 1 ; i < inputLength; i++)
//     {
//         if(temp != '-' && temp != input.charAt(i))
//         {
//              index++;
//              temp = input.charAt(i);
//              character[index] = temp;
//              
//              count[index] = 0;
//         }
//         count[index]++;
//     }
//     
//     
//     // compare the length of the compressed string with the original string
//     // result : [0] : a, 2 [1] : b, 4....
// 
//     for(int i = 0; i <= index; i++)
//     {
//         ans.append(character[i]+count[i]);  // ans <- result 1 + result 2....
//     }
// } 
//    
//
// if(index <= inputLength)    // <-- index*2 <=inputlength
//     System.out.println(ans); // a4b4c3
// else
//     System.out.println(input);   
// 
//
//}
//
//
//public static void main(String[] args)
//{
//
// try
// {
//     makeCompression("adfaasdf");
// }
// catch(exception)
// {
//     System.out.println("error");
// }
//     
//}




//public class StringCompression
//{
//	private static void makeCompression(char[] input)
//	{
//		
//		char[] character = new char[input.length];
//		int[] count = new int [input.length];
//		StringBuilder ans = new StringBuilder();
//		
//		int compCount = 0;
//		char temp = '-';
//		
//		for(int i = 0; i < input.length; i++)
//		{
//			if(temp == '-')
//			{
//				temp = input[i];
//				character[compCount]= temp;
//			}
//			else if(temp != '-' && temp != input[i])
//			{
//				compCount++;
//				temp = input[i];
//				character[compCount]= temp;
//			}
//
//			count[compCount]++;			
//		}
//		
//		
//		// compare
//		if(compCount <= input.length)
//		{
//			for(int i = 0; i <= compCount; i++)
//			{
//				// merge !!!
//				ans.append(""+character[i]+count[i]);
////				System.out.printf("" + character[i]+count[i]);
//			}
//			
//			System.out.println(ans);			
//		}
//		else
//		{
//			for(char text :input)
//				System.out.print(text);
//		}
//		
//	}
//	
//	
//	public static void main(String[] args)
//	{
//		char input[] = {'a','a','b','c','c','c','c','c','a','a','a'};
//		
//		
//		makeCompression(input);
//		
//
//	}
//}



//package ask.ctci.intermediate;
//
//public class StringCompression
//{
//	private static void makeCompression(char[] input)
//	{
//		
//		char[] character = new char[input.length];
//		int[] count = new int [input.length];
//		StringBuilder ans = new StringBuilder();
//		
//		int compCount = 0;
//		char temp = '-';
//		
//		for(int i = 0; i < input.length; i++)
//		{
//			if(temp != '-' && temp != input[i])
//			{
//				compCount++;
//			}
//
//			character[compCount]= input[i];
//			count[compCount]++;			
//		}
//		
//		
//		// compare
//		if(compCount <= input.length)
//		{
//			for(int i = 0; i <= compCount; i++)
//			{
//				ans.append(""+character[i]+count[i]);
////				System.out.printf("" + character[i]+count[i]);
//			}
//			
//			System.out.println(ans);			
//		}
//		else
//		{
//			for(char text :input)
//				System.out.print(text);
//		}
//		
//	}
//	
//	
//	public static void main(String[] args)
//	{
//		char input[] = {'a','a','b','c','c','c','c','c','a','a','a'};
//		
//		
//		makeCompression(input);
//		
//
//	}
//}



//package ask.ctci.intermediate;
//
//public class StringCompression
//{
// 	public class Compression
//	{
//		char character = '0';
//		int count = 0;
//		
//		public Compression(char initChar, int count)
//		{
//			this.character = initChar;
//			this.count = count;
//		}
//	}
//	
//	private static void makeCompression(char[] input)
//	{
////		Compression test = new Compression('a', 0); 		
////		Compression[] compressedStore = new Compression[input.length]; 
////		compressedStore[0].character = 'a';		
//		
//		
//		char[] character = new char[input.length];
//		int[] count = new int [input.length];
//		
//		
//		int compCount = 0;
//		char temp = '0';
//		
//		for(int i = 0; i < input.length; i++)
//		{
//			if(temp == '0')
//			{
//				temp = input[i];
////				compressedStore[compCount].character = temp;
//				
//				character[compCount]= temp;
//			}
//			else if(temp != '0' && temp != input[i])
//			{
//				compCount++;
//
//				temp = input[i];
////				compressedStore[compCount].character = temp;
//				
//				character[compCount]= temp;
//
//			}
//
//			count[compCount]++;			
//			
////			compressedStore[compCount].count++;
//			
////			System.out.println(i + ":" + compressedStore[compCount].character + compressedStore[compCount].count);
//
////			System.out.println(i + ":" + character[compCount]+count[compCount]);
//		}
//		
//		if(compCount < input.length)
//		{
//			for(int i = 0; i <= compCount; i++)
//			{
//				System.out.printf("" + character[i]+count[i]);
//			}
//		}
//		else
//		{
//			for(char text :input)
//				System.out.print(text);
//		}
//		
//	}
//	
//	
//	public static void main(String[] args)
//	{
//		char input[] = {'a','a','b','c','c','c','c','c','a','a','a'};
//		
//		
//		makeCompression(input);
//		
//
//	}
//}

