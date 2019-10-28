package ie.home.markov_text_generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MarkovImplChars implements TextGenerator {
	private List<Word> wordList;
	private final int nGram = 3;

	private Random randomGenerator;

	public MarkovImplChars(Random generator) {
		this.wordList = new LinkedList<Word>();
		this.randomGenerator = generator;
	}

	@Override
	public void train(String sourceText) {
		String[] allWords = new String[sourceText.length() - nGram];
		System.out.println(sourceText.length());
		for (int i = 0; i < sourceText.length() - nGram; i++) {
			allWords[i] = sourceText.substring(i, i + nGram);
		}

		for (int i = 0; i < allWords.length; i++) {
			String wordString = allWords[i];

			String nextWord = null;

			if (i != allWords.length - 1) {
				nextWord = allWords[i + 1];
			}

			Word word = getWord(wordString);
			if (word == null) {
				word = new Word(wordString);
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
		if (numWords < 0)
			return null;

		StringBuilder builder = new StringBuilder();
		builder.append("");

		Word word = wordList.get(0);
		builder.append(word.getWord());

		for (int i = 0; i < numWords; i++) {
			String randomWord = word.getRandomNextWord(randomGenerator);
			Word nextWord = getWord(randomWord);
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
		// TODO Auto-generated method stub

	}

}
