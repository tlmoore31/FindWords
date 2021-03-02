package com.thomas.maven.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Dictionary {
	
	//This is a mock class that will return true for all English words defined in the file "EnglishWords.txt" in the resources directory.
	
	private ArrayList<String> englishWords;
	
	public Dictionary()
	{
		englishWords = new ArrayList<String>();
		
		InputStream is = getClass().getClassLoader().getResourceAsStream("EnglishWords.txt");
		try
		{
			InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
	        BufferedReader reader = new BufferedReader(isr);
			String line;
			while((line = reader.readLine()) != null)
			{
				englishWords.add(line);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean isEnglishWord(String word) throws IOException
	{
		
		if(englishWords.contains(word))
			return true;
		
		return false;
	}
	
}
