package ask.ctci.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordTransformer 
{
	
	// change char (from start word to end)
	public static ArrayList<String> wordsOneAway(String word) 
	{
		ArrayList<String> wordList = new ArrayList<String>();
		
		for (int i = 0; i < word.length(); i++) 
		{
			for (char c = 'a'; c <= 'z'; c++) 
			{
				String w = word.substring(0, i) + c + word.substring(i + 1);
				//System.out.println(w);
				wordList.add(w);
			}
		}		
		return wordList;
	}
	
	
	// Brute Force
	
	// Set : unique value, no key, no order, no dup
	
	public static LinkedList<String> transform(
		HashSet<String> visited, String startWord, String stopWord, Set<String> dictionary) 
	{
		// branch cut condition(flat == flat)
		if (startWord.equals(stopWord)) 
		{
			LinkedList<String> path = new LinkedList<String>();
			path.add(startWord);
			
			System.out.println("final : " + startWord);
			
			return path;
		} 
		else if (visited.contains(startWord) || !dictionary.contains(startWord)) 
		{
			return null;
		}

		
		// visited check
		visited.add(startWord);
				
		
		// change char (from start-word to end-word)
		ArrayList<String> wordList = wordsOneAway(startWord); // aree ~ trez 
		
		
		// recursively
		for (String word : wordList) 
		{
			LinkedList<String> path = transform(visited, word, stopWord, dictionary);
		
			if (path != null) 
			{
				path.addFirst(startWord); // stack_push
				
				System.out.println("stack_push : " + startWord);
				
				return path;
			}
		}
		
		return null;
	}

	
	// register words to dic
	public static HashSet<String> setupDictionary(String[] words) 
	{
		HashSet<String> hash = new HashSet<String>();
		for (String word : words) 
		{
			//System.out.println(word);
			hash.add(word.toLowerCase());
		}
		return hash;
	}
		
	
	// used in main
	public static LinkedList<String> transform(String start, String stop, String[] words) 
	{
		HashSet<String> dict = setupDictionary(words);
		HashSet<String> visited = new HashSet<String>();
		
		System.out.println(start + " - " + stop );
		
		return transform(visited, start, stop, dict);
	}
	

	// main
	public static void main(String[] args) 
	{
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", 
					"pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		
		// BFS
		LinkedList<String> list = transform("tree", "flat", words);
		
		if (list == null) 
		{
			System.out.println("No path.");
		} 
		else 
		{
			System.out.println(list.toString());
		}
	}

}


/*
	tree - flat
	final : flat
	stack_push : frat
	stack_push : fret
	stack_push : pret
	stack_push : pree
	stack_push : tree
	[tree, pree, pret, fret, frat, flat]
*/

