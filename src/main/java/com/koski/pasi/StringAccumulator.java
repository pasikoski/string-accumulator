package com.koski.pasi;

/**
 * StringAccumulator is a calculator operating on String input.
 * @author koskipas
 *
 */
public class StringAccumulator {

	/**
	 * Parse String input which contains integer numbers to be added to the
	 * resulting sum. Numbers may be separated by either comma or newline.
	 * Examples 
	 * input "5,7" -> returns 12
	 * input "5\n7,5" -> returns 17
	 * @param input
	 * @return
	 */
	public int add(String input) {
		int result = 0;

		if (input != null && !input.isEmpty()) {
			String[] delimiters = {",", "\n"};
			result = parseAndAddNumbers(delimiters[0], replaceAll(input, delimiters, delimiters[0]));
		}
		
		return result;
	}
	
	/**
	 * Parse String input which contains integer numbers to be added to the
	 * resulting sum. Numbers are separated by delimiter.
	 * 
	 * Example 
	 * delimiter="," and input="5,7" -> returns 12
	 * 
	 * Any non-numbers or empty values are skipped, no Exception is thrown.
	 * Example
	 * delimiter="," and input="5,A,B,C,7" -> returns 12
	 * delimiter="," and input="5,A,,,C,7" -> returns 12
	 * 
	 * @param delimiter
	 * @param input
	 * @return
	 */
	private int parseAndAddNumbers(String delimiter, final String input) {
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
	
	/**
	 * Given an array of stringsToReplace and an input string,
	 * this method returns a string in which all stringsToReplace
	 * have been replaced with replaceWithString.
	 * @param delimiters
	 * @param input
	 * @return
	 */
	private String replaceAll(final String input, final String[] stringToReplace, final String replaceWithString) {
		
		String inputWithReducedDelimiters = input;
		for (int i = 1; i < stringToReplace.length; i++) {
			inputWithReducedDelimiters = inputWithReducedDelimiters.replaceAll(stringToReplace[i], replaceWithString);
			
		}
		return inputWithReducedDelimiters;
	}
}
