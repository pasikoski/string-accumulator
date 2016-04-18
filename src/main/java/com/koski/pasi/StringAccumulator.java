package com.koski.pasi;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
	 * 
	 * Input may also declare a dynamic delimiter by specifying the delimiter
	 * with //<delim>\n at the start of the input. 
	 * Example:
	 * '//;\n5;7 -> returns 12
	 * 
	 * Negative numbers are not allowed. An exception is thrown.
	 * 
	 * Non-numbers, empty values, or numbers greater than 1000 are skipped.
	 * 
	 * @param input
	 * @return
	 */
	public int add(String input) throws Exception {
		int result = 0;

		if (input != null && !input.isEmpty()) {
			ArrayList<String> delimiters = new ArrayList<String>();
			delimiters.add(",");
			delimiters.add("\n");
			if (input.startsWith("//") && input.indexOf("\n") > 0) {
				String dynamicDelimiter = input.substring(2, input.indexOf("\n"));
				input = input.substring(input.indexOf("\n"));
				delimiters.add(dynamicDelimiter);
			}
			result = parseAndAddNumbers(delimiters.get(0), replaceAll(input, delimiters, delimiters.get(0)));
		}
		
		return result;
	}
	
	
	
	/**
	 * Parse String input which contains integer numbers to be added to the
	 * resulting sum. Numbers are separated by delimiter.
	 * 
	 * Negative numbers aren't allowed. An Exception is thrown if negative
	 * numbers are found.
	 * 
	 * Example 
	 * delimiter="," and input="5,7" -> returns 12
	 * 
	 * Non-numbers, empty values, or numbers greater than 1000 are skipped, no Exception is thrown.
	 * Example
	 * delimiter="," and input="5,A,B,C,7" -> returns 12
	 * delimiter="," and input="5,A,,,C,7" -> returns 12
	 * delimiter="," and input="5,A,1001,C,7" -> returns 12
	 * 
	 * @param delimiter
	 * @param input
	 * @return
	 */
	private int parseAndAddNumbers(String delimiter, final String input) throws Exception {
		int result = 0;
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		if (input != null && !input.isEmpty()) {
			String[] items = input.split(delimiter);
			for (int i = 0; i < items.length; i++) {
				try {
					int value = Integer.parseInt(items[i]);
					if (value < 0) {
						negativeNumbers.add(value);
					}
					else if (value < 1001) {
						result += value;
					}
				}
				catch (NumberFormatException nfe) {
					//Do nothing -> invalid number is ignored
				}
			}
		}
		
		if (negativeNumbers.size() > 0) {
			throw new Exception("Negatives not allowed: " + negativeNumbers.toString());
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
	private String replaceAll(final String input, final ArrayList<String> stringsToReplace, final String replaceWithString) {
		
		String inputWithReducedDelimiters = input;
		for (String stringToReplace : stringsToReplace) {
			inputWithReducedDelimiters = inputWithReducedDelimiters.replaceAll(escapeRegex(stringToReplace), replaceWithString);
			
		}
		return inputWithReducedDelimiters;
	}
	
	
	private String escapeRegex(String regex) {
		Pattern SPECIAL_REGEX_CHARS = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");
		return SPECIAL_REGEX_CHARS.matcher(regex).replaceAll("\\\\$0");
	}
}
