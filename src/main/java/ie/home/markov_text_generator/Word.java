package ie.home.markov_text_generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Word {

	private String word;
	private List<String> nextWords;
	
	public Word(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getRandomNextWord(Random randomGenerator) {
		if (nextWords.isEmpty()) return null;
		
		if (nextWords.size() == 1) return nextWords.get(0);
		
		return nextWords.get(randomGenerator.nextInt(nextWords.size()));
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<String> getNextWords() {
		return nextWords;
	}

	public void addNextWords(String nextWord) {
		this.nextWords.add(nextWord);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
	
}
