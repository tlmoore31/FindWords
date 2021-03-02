package com.thomas.maven.eclipse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindWords 
{	
	private static ArrayList<String> permutations;
	
	public static ArrayList<String> findWords(String input) throws IOException
	{
		permutations = new ArrayList<String>();
		
		char[] toSort = input.toCharArray();
		Arrays.sort(toSort);
		getPermutations("", new String(toSort));
				
		ArrayList<String> words = new ArrayList<String>();
		permutations = trim(permutations);
		
		Dictionary dict = new Dictionary();
		for(String word : permutations)
		{
			if(dict.isEnglishWord(word))
			{
				words.add(word);
			}
		}
		
		return words;
	}
	
	public static ArrayList<String> trimPublic(ArrayList<String> words)// For unit testing
	{
    	return trim(words); 
    }
	
	private static ArrayList<String> trim(ArrayList<String> words)
    {
    	Set<String> set = new LinkedHashSet<String>();
    	set.addAll(words);
    	words.clear();
    	words.addAll(set);
    	words.trimToSize();
    	return words;
    }

	private static void getPermutations(String prefix, String input)
	{
		//Recursive method to get all permutations of input
		int l = input.length();
		if (l == 0) 
		{
			//If no input, prefix is max size. Add to the list.
			permutations.add(prefix);
		}
		else
		{
			//If there is input, call again while adding the newest character to the prefix
			//While excluding that character from all recursive calls
			//Additionally, add the prefix to the list of words (we will trim it later to remove all duplicates)
			for(int i=0; i < l; i++)
			{
				permutations.add(prefix);
				getPermutations(prefix + input.charAt(i), input.substring(0, i) + input.substring(i+1, l));
			}
		}
	}

}
