package ie.home.markov_text_generator;

public interface TextGenerator {

	public void train(String sourceText);
	
	// generate next random word
	public String generateText(int numWords);
	
	public void retrain(String sourceText);
	
	public void printTrainedInfo();
}
