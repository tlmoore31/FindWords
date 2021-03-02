/**
 * 
 */
package com.thomas.maven.eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class FindWordsTest {

	@Test
	public void testTrimPublic() throws Throwable {
		// When
		ArrayList<String> words = new ArrayList<String>();

		words.add("e");
		words.add("d");
		words.add("c");
		words.add("a");
		words.add("e");

		assertFalse(words.lastIndexOf("e") == 0);

		ArrayList<String> result = FindWords.trimPublic(words);

		// Then
		assertNotNull(result);
		assertTrue(result.lastIndexOf("e") == 0);
	}

	@Test
	public void testFindWords() throws Throwable {
		// When
		String input = "super"; // UTA: default value
		ArrayList<String> result = FindWords.findWords(input);
		
		// Then
		assertNotNull(result);
		assertEquals(6, result.size());		
		assertTrue(result.contains("sup"));
		assertTrue(result.contains("per"));
		assertTrue(result.contains("up"));
		assertTrue(result.contains("us"));
		assertTrue(result.contains("use"));
		assertTrue(result.contains("super"));
		assertFalse(result.contains("apple"));
	}
}