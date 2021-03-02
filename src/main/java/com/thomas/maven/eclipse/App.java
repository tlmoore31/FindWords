package com.thomas.maven.eclipse;

import java.io.IOException;
import java.util.ArrayList;

public class App 
{
	
    public static void main( String[] args ) throws IOException 
    {
        ArrayList<String> words = new ArrayList<String>();
        //Assuming no input is given, we will find all English words defined in 
        //EnglishWords.txt in the string "working" as per the example given
        try
        {
        	@SuppressWarnings("unused")
			String s = args[0];
        	
        	for(String input : args)
         	{
         		words = FindWords.findWords(input);
             	System.out.println("All words in: " + input);
             	for(String word : words) {
             		System.out.println(word);
             	}
         	}
        } 
        catch(Exception e)
        {
           	String input = "working";
	       	words = FindWords.findWords(input);
	       	System.out.println("All words in: " + input);
	       	for(String word : words) 
        	{
        		System.out.println(word);
        	}	
        }
    }
}
