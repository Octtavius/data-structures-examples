package ie.home.tree.tries.enhancement;



public class TrieEnhanced {
	
	TrieNode root;
	
	public TrieEnhanced() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		int level;
		int wordLength = word.length();
		int charIndex;
		
		TrieNode currentNode = root;
		
		for (level = 0; level < wordLength; level++) {
			charIndex = word.charAt(level) - 'a';
			
			if (currentNode.getChildren()[charIndex] == null) {
				currentNode.getChildren()[charIndex] = new TrieNode();
			}			
			currentNode = currentNode.getChildren()[charIndex];
		}
		
		currentNode.setLeaf(true);
	}
	
//	public boolean isWord(String key) {
//		
//	}
}
