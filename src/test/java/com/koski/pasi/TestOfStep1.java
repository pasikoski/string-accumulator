package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep1 {

	@Test
	public void testEmptyString() {
		assertEquals(0, new StringAccumulator().add(""));
		assertEquals(0, new StringAccumulator().add(null));
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(2, new StringAccumulator().add("2"));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(5, new StringAccumulator().add("2,3"));
	}
	
	@Test
	public void invalidInput() {
		assertEquals(5, new StringAccumulator().add("2,3,A"));
	}

}
