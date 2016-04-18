package com.koski.pasi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfStep3 {

	@Test
	public void testMultipleNumbers() throws Exception {
		assertEquals(55, new StringAccumulator().add("1\n2,3,4,5,6,7,8,9,10"));
	}
	
	@Test
	public void invalidInput() throws Exception {
		assertEquals(110, new StringAccumulator().add("1,2,3,4,5\n6,7,8,9,10,A,1,2,3,4,5\n6,7,8,9,10"));
	}
	
	@Test
	public void invalidInput2() throws Exception {
		//will not add "2:3", because ":" is not an allowed delimiter
		assertEquals(105, new StringAccumulator().add("1,2:3,4,5\n6,7,8,9,10,A,1,2,3,4,5\n6,7,8,9,10"));
	}
	
	@Test
	public void invalidInput3WithDuplicateDelimiters() throws Exception{
		//will add 2 and 3 into the final sum, because "\n," is read as two delimiters with an
		//emtpy value between them
		//TODO: Was this what was meant by 3b? This was a bit confilicting with 1a (empty string is 0)
		assertEquals(110, new StringAccumulator().add("1,2\n,3,4,5\n6,7,8,9,10,A,1,2,3,4,5\n6,7,8,9,10"));
	}
	
	@Test
	public void emptyAndNonNumberAdditionalTests() throws Exception {
		assertEquals(12, new StringAccumulator().add("5,A,B,C\n7"));
		assertEquals(12, new StringAccumulator().add("5,A,,,C\n7"));
		assertEquals(12, new StringAccumulator().add("5,A,\n,C\n7"));
	}
	

}
