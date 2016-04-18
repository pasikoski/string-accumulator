package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep6 {

	@Test
	public void testNumbersUpTo1000AreAdded() throws Exception {
		assertEquals(2055, new StringAccumulator().add("//;\n1,2;3,4;1000,5,6\n7,8,9\n10,1000"));
	}
	
	@Test
	public void testNumbersOver1000AreSkipped() throws Exception {
		assertEquals(55, new StringAccumulator().add("//;\n1,2;3,4;5,1001,6\n7,8,9\n10,1001"));
	}

}
