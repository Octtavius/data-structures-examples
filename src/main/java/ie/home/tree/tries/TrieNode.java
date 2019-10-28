package ie.home.tree.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	char c;
	private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	private boolean isLeaf;
	
    public TrieNode() {}
    
    public TrieNode(char c){
        this.c = c;
        
    }

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public char getC() {
		return c;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
