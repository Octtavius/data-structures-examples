package ie.home.markov_text_generator;

import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
		String text = "Hello. Hello there. How are you. Their message was Hello world. Jim, Hi. Hello world.";
//		MarkovImplWholeWord textGenerator = new MarkovImplWholeWord(new Random());
//		
//		
//		textGenerator.train(text);
////		textGenerator.printTrainedInfo();
//		
////		Word word = textGenerator.getWord("Hello");
//		
////		System.out.println(word.getRandomNextWord(new Random()));
//		
//		for (int i = 0; i < 500; i++) {
//			System.out.println(textGenerator.generateText(2));
//		}
		
		MarkovImplChars markovChars = new MarkovImplChars(new Random());
		markovChars.train(text);
		
		System.out.println(markovChars.generateText(10));
	}
}
