/**
 * 
 */
package com.thomas.maven.eclipse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;


public class DictionaryTest {

	@Test
	public void testIsEnglishWord() throws Throwable {
		// Given
		Dictionary underTest = new Dictionary();

		// When
		String word = "apple";
		boolean result = underTest.isEnglishWord(word);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsEnglishWord2() throws Throwable {
		// Given
		Dictionary underTest = new Dictionary();

		// When
		String word = "super";
		boolean result = underTest.isEnglishWord(word);
		
		// Then
		assertTrue(result);
	}
	
	@Test
	public void testIsEnglishWord3() throws Throwable {
		// Given
		Dictionary underTest = new Dictionary();

		// When
		String word = "badValue";
		boolean result = underTest.isEnglishWord(word);
		
		// Then
		assertFalse(result);
	}
}