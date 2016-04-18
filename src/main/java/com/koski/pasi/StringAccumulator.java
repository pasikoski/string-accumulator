package com.koski.pasi;

/**
 * StringAccumulator is a calculator operating on String input.
 * @author koskipas
 *
 */
public class StringAccumulator {

	/**
	 * Parse String input which contains integer numbers to be added to the
	 * resulting sum.
	 * Example input "5,7" -> returns 12
	 * @param input
	 * @return
	 */
	public int add(String input) {
		int result = 0;

		if (input != null && !input.isEmpty()) {
			result = parseAndAddNumbers(",", input);
		}
		
		return result;
	}
	
	/**
	 * Parse String input which contains integer numbers to be added to the
	 * resulting sum. Numbers are separated by delimiter.
	 * Example delimiter="," and input="5,7" -> returns 12
	 * @param delimiter
	 * @param input
	 * @return
	 */
	private int parseAndAddNumbers(String delimiter, String input) {
		int result = 0;
		if (input != null && !input.isEmpty()) {
			String[] items = input.split(delimiter);
			for (int i = 0; i < items.length; i++) {
				try {
					result += Integer.parseInt(items[i]);
				}
				catch (NumberFormatException nfe) {
					//Do nothing -> invalid number is ignored
				}
			}
		}
		return result;
	}
}
