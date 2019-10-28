package ie.home.tree.tries;

import java.util.Map;

public class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}
	
	// inserts a word into the trie
	public void insert(String word) {
		Map<Character, TrieNode> children = root.getChildren();
		
		// add/update children map by character
		for (int i = 0; i < word.length(); i++) {
			char c = word.toLowerCase().charAt(i);
			
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			
			children = t.getChildren();
			
			//when word iteration is finished, set it to be leaf, to know it is a word.
			if (i == word.length()-1) {
				t.setLeaf(true);
			}
		}
	}
	
	public TrieNode searchNode(String chars) {
		Map<Character, TrieNode> children = root.getChildren();
		
		TrieNode t = null;
		for (int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
			
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.getChildren();
			} else {
				return null;
			}
		}
		
		return t;
	}
	
	// check if the word exist in the trie
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		
		if (t != null && t.isLeaf()) {
			return true;
		} else {
			return false;
		}
	}
}
