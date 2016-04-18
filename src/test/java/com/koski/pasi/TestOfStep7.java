package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep7 {

	@Test
	public void testMultiCharDelimiterWithSpecialCharacters() throws Exception {
		assertEquals(6, new StringAccumulator().add("//***\n1***2***3"));
	}
	
	@Test
	public void testMultiCharDelimiterWithSpecialCharactersAndNonDynamicDelimiters() throws Exception {
		assertEquals(11, new StringAccumulator().add("//+++\n1+++2,3\n5"));
	}

}
