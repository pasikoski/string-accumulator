package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep8 {
	
	@Test
	public void testTwoDynamicDelimitersWithSpecialCharacter() throws Exception {
		assertEquals(11, new StringAccumulator().add("//;|%\n1;2%3\n5"));
	}
	
	@Test
	public void testTwoDynamicDelimitersWithTwoSpecialCharacters() throws Exception {
		assertEquals(11, new StringAccumulator().add("//*|%\n1*2%3\n5"));
	}
	
	@Test
	public void testMultipleDynamicDelimitersWithSpecialCharactersAndBothBuiltInDelimiters() throws Exception {
		assertEquals(2024, new StringAccumulator().add("//*|%|-|;\n1*2%3\n5-6;7,1000\n1000"));
	}

}
