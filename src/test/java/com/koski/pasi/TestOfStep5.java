package com.koski.pasi;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestOfStep5 {

	@Rule
	public final ExpectedException exceptionTestNegatives = ExpectedException.none();
	
	@Test(expected=Exception.class)
	public void testNegativesExceptionThrown() throws Exception {
		assertEquals(55, new StringAccumulator().add("//;\n1,2;-3,4;5,6\n7,8,9\n10"));
	}
	
	@Test
	public void testNegativesOneNegative() throws Exception {
		exceptionTestNegatives.expect(Exception.class);
		exceptionTestNegatives.expectMessage("Negatives not allowed: [-3]");
		assertEquals(55, new StringAccumulator().add("//;\n1,2;-3,4;5,6\n7,8,9\n10"));
	}

	@Test
	public void testNegativesMultipleNegatives() throws Exception {
		exceptionTestNegatives.expect(Exception.class);
		exceptionTestNegatives.expectMessage("Negatives not allowed: [-3, -6]");
		assertEquals(55, new StringAccumulator().add("//;\n1,2;-3,4;5,-6\n7,8,9\n10"));
	}

}
