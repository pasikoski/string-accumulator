package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep4 {

	@Test
	public void testDynamicDelimiter1() {
		assertEquals(55, new StringAccumulator().add("//;\n1,2;3,4;5,6\n7,8,9\n10"));
	}

	@Test
	public void testInvalidDynamicDelimiter1() {
		//will not use ; as delimiter, because newline is missing
		//1,2,3,4,5 and 8,9 aren't counted for -> result 6+7+10=23
		assertEquals(23, new StringAccumulator().add("//;1,2;3,4;5,6,7,8;9,10"));
	}

}
