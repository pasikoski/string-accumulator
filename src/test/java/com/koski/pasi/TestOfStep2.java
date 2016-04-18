package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep2 {

	@Test
	public void testMultipleNumbers() throws Exception {
		assertEquals(55, new StringAccumulator().add("1,2,3,4,5,6,7,8,9,10"));
	}
	
	@Test
	public void invalidInput() throws Exception {
		assertEquals(110, new StringAccumulator().add("1,2,3,4,5,6,7,8,9,10,A,1,2,3,4,5,6,7,8,9,10"));
	}

}
