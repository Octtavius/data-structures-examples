package ie.home.markov_text_generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MarkovImplWholeWord implements TextGenerator {

	private List<Word> wordList;
	
	private Random randomGenerator;
	
	public MarkovImplWholeWord(Random generator) {
		this.wordList = new LinkedList<Word>();
		this.randomGenerator = generator;
	}

	@Override
	public void train(String sourceText) {
		String[] allWords = sourceText.split("[ ]+");
		
		for (int i = 0; i < allWords.length; i++) {
			String wordString = allWords[i];
			String trimmedWord = StringHelper.trimSidesFromPunctuation(wordString);
			String nextWord = null;
			
			if (i != allWords.length-1) {				
				nextWord = allWords[i+1];
			}
			
			Word word = getWord(trimmedWord);
			if (word == null) {
				word = new Word(trimmedWord);
				word.addNextWords(nextWord);
				wordList.add(word);
			} else {
				word.addNextWords(nextWord);
			}
		}
	}
	
	public Word getWord(String wordString) {
		
		for (Word word : wordList) {
			if (word.getWord().equalsIgnoreCase(wordString)) {
				return word;
			}
		}
		return null;
	}

	@Override
	public String generateText(int numWords) {
		if (numWords < 0) return null;
		
		StringBuilder builder = new StringBuilder();
		builder.append("");
		
		Word word = wordList.get(0);
		builder.append(word.getWord() + " ");
		
		for (int i = 0; i < numWords; i++) {
			String randomWord = word.getRandomNextWord(randomGenerator);
			Word nextWord = getWord(StringHelper.trimSidesFromPunctuation(randomWord));
			builder.append(nextWord.getWord() + " ");
			word = nextWord;
		}
		return builder.toString();
	}

	@Override
	public void retrain(String sourceText) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTrainedInfo() {

		for (Word word : wordList) {
			System.out.println(word.getWord());
			for (String wordString : word.getNextWords()) {
				System.out.print(wordString + " ");
			}
			System.out.println();
			System.out.println(" ----- ");
		}
		
	}

}
