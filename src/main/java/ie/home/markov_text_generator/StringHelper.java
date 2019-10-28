package ie.home.markov_text_generator;

public class StringHelper {

	public static String trimSidesFromPunctuation(String word) {
		String trimmedWord = new String(word);
		int wordLength = trimmedWord.length();
		
		while (!Character.isLetter(trimmedWord.charAt(0))) {
			trimmedWord = trimmedWord.substring(1, wordLength);
			wordLength--;
		}
		
		while (!Character.isLetter(trimmedWord.charAt(wordLength-1))) {
			trimmedWord = trimmedWord.substring(0, wordLength-1);
			wordLength--;
		}
		
		return trimmedWord;
	}
}
