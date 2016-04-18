package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep9 {

	@Test
	public void testTwoDynamicDelimiters() throws Exception {
		assertEquals(6, new StringAccumulator().add("//delim1|delim2\n1delim12delim23"));
	}
	
	@Test
	public void testMultipleDynamicDelimitersWithTwoSpecialCharacters() throws Exception {
		assertEquals(24, new StringAccumulator().add("//*|%|delim|aaa\n1*2%3\n5delim6aaa7"));
	}

}
